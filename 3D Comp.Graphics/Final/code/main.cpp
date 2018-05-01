
#include <cstdlib>			// standard definitions
#include <iostream>			// C++ I/O
#include <cstdio>			// C I/O (for sprintf)
#include <cmath>			// standard definitions
#include <GL/GLUT.h>
#include <stdlib.h>
#include <math.h>
#include <assert.h>
#include <string.h>
#include <new>
#include <string>
#include "mesh.h"
#include <dirent.h>
#include "imageloader.h"
#include "traqueboule.h"
#include <SDL2/SDL.h> //"SDL.h"
#include <SDL/SDL.h>
#undef main 
//#include "D:/Program Files (x86)/Microsoft Visual Studio 11.0/VC/include/SDL/sdl.h"
//#pragma (lib, "blah.lib")


using namespace std;			// make std accessible
#define PI 3.14159265
#define HERO_SIZE 10

//****define variables****//

///////background//////////

GLuint background_texture;
float backgroundX;

///////objects////////////

std::vector<Mesh> heros;
Mesh hero;
Mesh hero_d;
Mesh bird;
Mesh boss;
Mesh boss_d;
Mesh axe;
Mesh bullet;
Mesh horse;
Mesh *bossss = new Mesh[100];
Mesh test2;

DIR *dir;
struct dirent *ent;
vector<string> hero_names;
string path = "animation/";
int file_no = 1;
int hero_n = 1;
Mesh hero2;
Mesh *heross = new Mesh[100];
Mesh test;

DIR *dir2;
struct dirent *ent2;
int file_no2 = 1;
int boss_n = 1;
vector<string> boss_names;
string path2 = "boss_animation/";

///////lighting////////

float lpos[] = { 1, 0.8, 1, 0 };
std::vector<Vec3Df> lighting;
std::vector<Vec3Df> LightPos;
std::vector<Vec3Df> LightColor;
Vec3Df CamPos = Vec3Df(0.0f,0.0f,4.0f);
std::vector<Vec3Df> LightPos_sun;
std::vector<Vec3Df> lighting_sun;

///////texture///////

GLuint _textureId1;
GLuint _textureId2;
GLuint _textureId3;
GLuint _textureId4;
GLuint _textureId5;
GLuint texture;
GLUquadric *quad;

///////move control///////

float x=0;
float bird_up=0;
float bird_on=3;
float boss_on=3;
float r;
float count_number=0;
float boss_lose=0;
int lose=1;
int head_angle=0;
bool up=true;
bool down=false;
bool bird1 = true;
bool bird2 = true;
bool bird3 = true;
bool boss_stop = false;
bool new_bullet = false;
bool boss_survive = true;
bool head_up=true;
bool head_down=false;
double direction = 50;

////////parameters for terrain////////
std::vector< std::vector<float> > heights;
float terrain_X;
float terrain_Y;
GLuint terrain_texture;


//////****load bmp [background]****//////
GLuint bmp_texture_load(const char *filename, int width, int height)
{
    GLuint texture;
    unsigned char * data;
    FILE * file;
    file = fopen( filename, "rb" );
    if ( file == NULL )
    {
        std::cout<<"File not found";
        return 0;
    }
    data = (unsigned char *)malloc( width * height * 3 );
    //int size = fseek(file,);
    fread( data, width * height * 3, 1, file );
    fclose( file );
    for(int i = 0; i < width * height ; ++i)
    {
        int index = i*3;
        unsigned char B,R;
        B = data[index];
        R = data[index+2];
        
        data[index] = R;
        data[index+2] = B;
    }
    glGenTextures( 1, &texture );
    glBindTexture( GL_TEXTURE_2D, texture );
    glTexEnvf( GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE,GL_MODULATE );
    glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER,GL_LINEAR_MIPMAP_NEAREST );
    glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER,GL_LINEAR );
    glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_WRAP_S,GL_REPEAT );
    glTexParameterf( GL_TEXTURE_2D, GL_TEXTURE_WRAP_T,GL_REPEAT );
    gluBuild2DMipmaps( GL_TEXTURE_2D, 3, width, height,GL_RGB, GL_UNSIGNED_BYTE, data );
    free( data );
    std::cout<<"Texture ID: "<<texture;
    return texture;
}

//////****terrain staff****/////
unsigned char* readBMP(char* filename)
{
    int i;
    FILE* f = fopen(filename, "rb");
    unsigned char info[54];
    fread(info, sizeof(unsigned char), 54, f); // read the 54-byte header
    
    // extract image height and width from header
    int width = *(int*)&info[18];
    int height = *(int*)&info[22];
    
    int size = 3 * width * height;
    unsigned char* data = new unsigned char[size]; // allocate 3 bytes per pixel
    fread(data, sizeof(unsigned char), size, f); // read the rest of the data at once
    fclose(f);
    
    for(i = 0; i < size; i += 3)
    {
        unsigned char tmp = data[i];
        data[i] = data[i+2];
        data[i+2] = tmp;
    }
    
    return data;
}

void loadHeightmap(char* name)
{
    unsigned char* image = readBMP(name);
    
    SDL_Surface* img = SDL_LoadBMP(name);
    if(!img)
    {
        std::cout << "image is not loaded" << std::endl;
        return;
    }
    std::vector<float> tmp;
    for(int i = 0; i < img->h; i++)
    {
        tmp.clear();
        for(int j = 0; j < img->w; j++)
        {
            tmp.push_back((float)image[(i * img->h + j)*3]/255.0);
        }
        
        heights.push_back(tmp);
    }
}

void renderHeightmap(float size, float h)
{
    float tile_size = 0.1;
    //    glClear(GL_COLOR_BUFFER_BIT);
    glDisable(GL_LIGHTING);
    glBindTexture(GL_TEXTURE_2D, terrain_texture);
    glEnable(GL_TEXTURE_2D);
    glBegin(GL_QUADS);
    
    for(int i = 0; i < heights.size()-1; i++)
    {
        for(int j = 0; j < heights[0].size()-1; j++)
        {
            glTexCoord2f(i*tile_size, (j+1)*tile_size);
            glVertex3f(terrain_X + i*size, heights[i][j+1]*h - 0.9,(j+1)*size + 0.5);
            glTexCoord2f((i+1)*tile_size, (j+1)*tile_size);
            glVertex3f(terrain_X+ (i+1)*size, heights[i+1][j+1]*h- 0.9, (j+1)*size + 0.5);
            glTexCoord2f((i+1)*tile_size, j*tile_size);
            glVertex3f(terrain_X+ (i+1)*size, heights[i+1][j]*h- 0.9, j*size + 0.5);
            glTexCoord2f(i*tile_size, j*tile_size);
            glVertex3f(terrain_X+ i*size, heights[i][j]*h- 0.9, j*size + 0.5);
        }
    }
    
    for(int i = 0; i < heights.size()-1; i++)
    {
        for(int j = heights[0].size(); j >=1 ; j--)
        {
            glTexCoord2f(i*tile_size, (j+1)*tile_size);
            glVertex3f((heights[0].size()-2)*size + terrain_Y + i*size, heights[i][j]*h - 0.9,j*size + 0.5);
            glTexCoord2f((i+1)*tile_size, (j+1)*tile_size);
            glVertex3f((heights[0].size()-2)*size + terrain_Y+ (i+1)*size, heights[i+1][j]*h- 0.9, j*size + 0.5);
            glTexCoord2f((i+1)*tile_size, j*tile_size);
            glVertex3f((heights[0].size()-2)*size + terrain_Y+ (i+1)*size, heights[i+1][j-1]*h- 0.9, (j-1)*size + 0.5);
            glTexCoord2f(i*tile_size, j*tile_size);
            glVertex3f((heights[0].size()-2)*size + terrain_Y+ i*size, heights[i][j-1]*h-0.9, (j-1)*size + 0.5);
        }
    }
    
    glDisable(GL_TEXTURE_2D);
    glEnable(GL_LIGHTING);
    glEnd();
    
    terrain_X -= 0.01;
    terrain_Y -= 0.01;
    
    float tmpFloat = 0.0 - (heights[0].size()-1) *size*1.5;
    
    if(terrain_X <= tmpFloat)
    {
        terrain_X = (heights[0].size()-2)*size * 2 + terrain_Y;
    }
    
    tmpFloat = 0.0 - (heights[0].size()-1)*size*2.5;
    
    if(terrain_Y <= tmpFloat)
    {
        terrain_Y = terrain_X;
    }
}

//******compute lighting*******//
//******compute lighting - big boss******//
Vec3Df computeLighting(Vec3Df & vertexPos, Vec3Df & normal, unsigned int light, unsigned int index)
{
    
    Vec3Df lightv = LightPos[0] - vertexPos;
    lightv.normalize();
    
    Vec3Df V = getCameraPosition() - vertexPos;
    V.normalize();
    Vec3Df H = (V + lightv) / 2;
    H.normalize();
    float dLighting = Vec3Df::dotProduct(normal, lightv);
    float sLighting = Vec3Df::dotProduct(H, normal);
    sLighting = pow(sLighting, 3);
    
    return Vec3Df(dLighting+sLighting,dLighting+sLighting,dLighting+sLighting);
}
void computeLighting(Mesh mesh_c)
{
    std::vector<Vec3Df> *result=&lighting;
    for (unsigned int i=0; i<mesh_c.vertices.size();++i)
    {
        (*result)[i]=Vec3Df();
        for (int l=0; l<LightPos.size();++l)
            (*result)[i]+=computeLighting(mesh_c.vertices[i].p, mesh_c.vertices[i].n, l, i);
    }
}

//*******compute lighting - sun??**********//
Vec3Df computeLighting_sun(Vec3Df & vertexPos, Vec3Df & normal, unsigned int light, unsigned int index)
{
    Vec3Df lightv = LightPos_sun[0] - vertexPos;
    lightv.normalize();
    
    Vec3Df V = getCameraPosition() - vertexPos;
    V.normalize();
    Vec3Df H = (V + lightv) / 2;
    H.normalize();
    float dLighting = Vec3Df::dotProduct(normal, lightv);
    float sLighting = Vec3Df::dotProduct(H, normal);
    sLighting = pow(sLighting, 3);
    
    return Vec3Df(dLighting+sLighting,dLighting+sLighting,dLighting+sLighting);
    
}
void computeLighting_sun(Mesh mesh_c)
{
    std::vector<Vec3Df> *result1=&lighting_sun;
    for (unsigned int i=0; i<mesh_c.vertices.size();++i)
    {
        (*result1)[i]=Vec3Df();
        for (int l=0; l<LightPos_sun.size();++l)
            (*result1)[i]+=computeLighting_sun(mesh_c.vertices[i].p, mesh_c.vertices[i].n, l, i);
    }
}



/////////////////////////////////////
//******0-load background********///
/////////////////////////////////////
void init_background()
{
    terrain_X = -10;
    terrain_Y = -10;
    loadHeightmap("terrain_heightmap.bmp");
    terrain_texture = bmp_texture_load("terrain_tile.bmp", 1300, 1300);
    background_texture = bmp_texture_load("background.bmp", 960, 540);
    backgroundX = 0.0;
}

/////////////////////////////////////
//******1-load hero****************///
/////////////////////////////////////
void init_hero(){
    if((dir = opendir("animation"))!=NULL){
        while ((ent = readdir (dir)) != NULL) {
            if(file_no>3){
                string hero_name = path + ent->d_name;
                hero_names.push_back(hero_name);
                hero.loadMesh(hero_name.c_str());
                //                test.loadMesh("hero.obj");
            }
            file_no+=1;
        }
        closedir (dir);
    }
    for (hero_n=1;hero_n<=hero_names.size();hero_n++){
        heross[hero_n].loadMesh(hero_names[hero_n].c_str());
        heross[hero_n]=heross[hero_n];
    }
}
void init_bullet(const char * fileName){
    bullet.loadMesh(fileName);
}
void init_horse(const char * fileName){
    horse.loadMesh(fileName);
}
/////////////////////////////////////
//******2-load bird****************///
/////////////////////////////////////
void init_bird(const char * fileName){
    bird.loadMesh(fileName);
    lighting_sun.resize(bird.vertices.size());
    LightPos_sun.push_back(Vec3Df(1,1,1));
    computeLighting_sun(bird);
}

/////////////////////////////////////
//******3-load boss****************///
/////////////////////////////////////
void init_boss(){
    if((dir2=opendir("boss_animation"))!=NULL){
        while((ent2 = readdir(dir2)) !=NULL) {
            if(file_no2>3){
                string boss_name = path2 + ent2->d_name;
                boss_names.push_back(boss_name);
                boss.loadMesh(boss_name.c_str());
            }
            file_no2+=1;
        }
        closedir(dir2);
    }
    for(boss_n=1;boss_n<=boss_names.size();boss_n++){
        test2.loadMesh(boss_names[boss_n].c_str());
        bossss[boss_n].loadMesh(boss_names[boss_n].c_str());
        bossss[boss_n]=bossss[boss_n];
    }
    lighting.resize(boss.vertices.size());
    LightPos.push_back(Vec3Df(3,3,3));
    computeLighting(boss);
}

/////////////////////////////////////
//******4-load axe****************///
/////////////////////////////////////
void init_axe(const char * fileName){
    axe.loadMesh(fileName);
}

/////////////////////////////////////
//******5-load textures************///
/////////////////////////////////////

GLuint loadTexture(Image* image) {
    GLuint textureId;
    glGenTextures(1, &textureId); //Make room for our texture
    glBindTexture(GL_TEXTURE_2D, textureId); //Tell OpenGL which texture to edit
    //Map the image to the texture
    glTexImage2D(GL_TEXTURE_2D,                //Always GL_TEXTURE_2D
                 0,                            //0 for now
                 GL_RGB,                       //Format OpenGL uses for image
                 image->width, image->height,  //Width and height
                 0,                            //The border of the image
                 GL_RGB, //GL_RGB, because pixels are stored in RGB format
                 GL_UNSIGNED_BYTE, //GL_UNSIGNED_BYTE, because pixels are stored
                 //as unsigned numbers
                 image->pixels);               //The actual pixel data
    return textureId; //Returns the id of the texture
}
void textures_loading(){
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_NORMALIZE);
    glEnable(GL_COLOR_MATERIAL);
    
    quad = gluNewQuadric();
    Image* image1 = loadBMP("texture1.bmp"); //grey
    Image* image2 = loadBMP("texture2.bmp"); //red
    Image* image3 = loadBMP("hero.bmp"); //hero
    Image* image4 = loadBMP("bird.bmp");//bird
    Image* image5 = loadBMP("boss.bmp");//boss
    _textureId1 = loadTexture(image1);  //grey
    _textureId2 = loadTexture(image2);  //red
    _textureId3 = loadTexture(image3); //hero
    _textureId4 = loadTexture(image4); //bird
    _textureId5 = loadTexture(image5); //boss
    delete image1;
    delete image2;
    delete image3;
    delete image4;
    delete image5;
}

/////////////////////////////////////
//******6-update staff************///
/////////////////////////////////////
void update(int value)
{
    
    //read hero animation
    if(hero_n<40){
        hero_n+=1;
    }
    else{
        hero_n=1;
    }
    
    if(hero_n==34){
        new_bullet = true;
        x=0;
    }

    //bullet keep rotating
    r+=2.0f;
    if(r>360.f)
    {
        r-=360;
    }
    
    //bullet keep moving forward
    x+=0.2f;
    
    //bullet change texture
    if(texture != _textureId1)
    {
        texture = _textureId1;
    }
    else
    {
        texture = _textureId2;
    }
    
    //backgfround keep moving
    backgroundX += 0.0015;
    
    //bird keep moving up and down
    if(up && !down)
    {
        bird_up+=0.02;
        if(bird_up>1){
            up=false;
            down=true;
        }
    }
    else if (!up && down)
    {
        bird_up-=0.02;
        if(bird_up<-1){
            up=true;
            down=false;
        }
    }
    
    //bird show up and moving forward
    if(count_number>10){
        bird_on-=0.02;
        if(bird_on<0){
            bird_on=0;
        }
    }
    
    //bird disapper
    double bullet_angle = tan ( direction * PI / 180.0 );
    if(bird_up/1.6-bullet_angle<0.07 && bird_up/1.6-bullet_angle>-0.07){
        bird1=false;
    }
    else if(bird_up/2.6-bullet_angle<0.07 && bird_up/2.6-bullet_angle>-0.07){
        bird2=false;
    }
    else if(bird_up/3.6-bullet_angle<0.07 && bird_up/3.6-bullet_angle>-0.07){
        bird3=false;
    }
    
    //boss show up
    if(!bird1 && !bird2 && !bird3){
        if(!boss_stop){
            boss_on-=0.02;
                if(boss_on<1.6){
                    boss_on=1.6;
                    boss_stop=true;
            }
        }
        else if(boss_stop){
            boss_lose+=1;
            
            if(head_up && !head_down)
            {
                head_angle-=2;
                if(head_angle<-60){
                    head_up=false;
                    head_down=true;
                }
            }
            else if(!head_up && head_down)
            {
                head_angle+=2;
                if(head_angle>60){
                    head_up=true;
                    head_down=false;
                }
            }
            
            
            if(boss_lose>200 && boss_lose<400){
                lose = 2;
            }
            else if(boss_lose>400 && boss_lose<500){
                lose=3;
            }
            else if(boss_lose>600){
                boss_survive=false;
            }
        }
        
        if(boss_n<5){
            boss_n+=1;
        }
        else{
            boss_n=1;
        }
    }

    count_number+=1;
    glutPostRedisplay();
    glutTimerFunc(30,update,0);
}


/////////////////////////////////////
//******7-display function************///
/////////////////////////////////////
void light_setting(){
    glEnable( GL_LIGHTING );
    glEnable( GL_LIGHT0 );
    glEnable(GL_COLOR_MATERIAL);
    int LightPos[4] = {0,0,3,1};
    int MatSpec [4] = {1,1,1,1};
    glLightiv(GL_LIGHT0,GL_POSITION,LightPos);
    glMaterialiv(GL_FRONT_AND_BACK,GL_SPECULAR,MatSpec);
    glMateriali(GL_FRONT_AND_BACK,GL_SHININESS,10);
    glEnable(GL_NORMALIZE);
}

//*******7.1-load bullet********//
void load_bullet(){
    if(new_bullet){
        glPushMatrix();
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, texture);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTranslated(-1.5, 0.3, -1);
            glRotated(direction,0,0,1);
            glTranslatef(x,0,0);
            glRotatef(90, 0, 1, 0);
            glScaled(0.1f, 0.1f, 0.1f);
            bullet.drawSmooth();
        glPopMatrix();
            glDisable(GL_TEXTURE_2D);
    }

}
void load_horse(){
    glPushAttrib(GL_ALL_ATTRIB_BITS);
    glPushMatrix();
    glDisable(GL_TEXTURE_2D);
    glColor3f(0.36, 0.25, 0.20);
    glTranslated(-1.6, -0.5,0);
    glRotatef(90, 0, 1, 0);
    glRotatef(-90, 1, 0, 0);
    glRotatef(180, 0, 0, 1);
    glScaled(0.5, 0.5, 0.5);
//    glRotatef(90, 0, 1, 0);
    
    horse.drawSmooth();
    glPopMatrix();
    glPopAttrib();
}

//*******7.2-load hero********//
void load_hero(){
    glPushMatrix();
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, _textureId3);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        //glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_MIRRORED_REPEAT);
        //glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_MIRRORED_REPEAT);
        glTranslated(-1.6,0,0.2);
        glRotated(100, 0, 1, 0);
        hero_d = heross[hero_n];
//    test2 = heross[0];
        hero_d.drawSmooth();
    glPopMatrix();
}

//*******7.3-load enemies********//
void load_bird(){
    GLfloat mat_specular[] = {1,1,1,1};
    GLfloat mat_shininess[] = {30.0};
    glShadeModel (GL_SMOOTH);
    glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular);
    glMaterialfv(GL_FRONT, GL_SHININESS, mat_shininess);
    
    if(bird1){
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glPushMatrix();
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, _textureId4);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_REPEAT);
            glTranslated(bird_on,bird_up,0);
            glRotatef(270,0.0f,1.0f,0.0f);
            glScaled(0.4, 0.4, 0.4);
            bird.drawWithColors(lighting_sun, 1);
        glPopMatrix();
        glPopAttrib();
    }
    if(bird2){
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glPushMatrix();
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, _textureId4);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTranslated(bird_on+1,bird_up-0.5,0);
            glRotatef(270,0.0f,1.0f,0.0f);
            glScaled(0.4, 0.4, 0.4);
        bird.drawWithColors(lighting_sun, 1);
        glPopMatrix();
        glPopAttrib();
    }
    if(bird3){
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glPushMatrix();
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, _textureId4);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTranslated(bird_on+1.5,bird_up+0.5,0);
            glRotatef(270,0.0f,1.0f,0.0f);
            glScaled(0.4, 0.4, 0.4);
            bird.drawWithColors(lighting_sun,1);
        glPopMatrix();
        glPopAttrib();
    }
}

//*******7.4-load big boss********//
void load_boss(){
    if(!bird1 && !bird2 && !bird3){
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glPushMatrix();
        glDisable(GL_LIGHTING);
            glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, _textureId5);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glScaled(1.8, 1.8, 1.8);
            glTranslated(boss_on-1.2, 0, 0);
            glRotated(-90, 0, 1, 0);
        test = bossss[1];
        boss_d = bossss[boss_n];
        glEnable(GL_LIGHTING);
        boss_d.drawWithColors(lighting, lose);
        glPopMatrix();
        glPopAttrib();
    }
}

//*******7.4-load axes********//
void load_axe(){
    if(!bird1 && !bird2 && !bird3){
        glPushMatrix();
        glEnable(GL_TEXTURE_2D);
            glBindTexture(GL_TEXTURE_2D, _textureId4);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
            glTranslated(boss_on-1.2,0.7,-0.5);
            glRotatef(-90, 0, 1, 0);
            glRotatef(head_angle, 1, 0, 0);
            glScaled(0.3, 0.3, 0.3);
            bird.drawWithColors(lighting_sun, lose);
        
            glTranslated(0, 0, -0.7);
            glRotatef(head_angle-10, 1, 0, 0);
            bird.drawWithColors(lighting_sun, lose);

            glTranslated(0, 0, -0.7);
            glRotatef(head_angle-10, 1, 0, 0);
            bird.drawWithColors(lighting_sun, lose);

        
            glTranslated(0, 0, -0.7);
            glRotatef(head_angle-10, 1, 0, 0);
            bird.drawWithColors(lighting_sun, lose);

            glTranslated(0, 0, -0.7);
            glRotatef(head_angle-10, 1, 0, 0);
            bird.drawWithColors(lighting_sun, lose);
        glPopMatrix();
        
        glPushMatrix();
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, _textureId4);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTranslated(boss_on-1.2,-0.7,-0.5);
        glRotatef(-90, 0, 1, 0);
        glRotatef(head_angle, 1, 0, 0);
        glScaled(0.3, 0.3, 0.3);
        bird.drawWithColors(lighting_sun, lose);
        
        glTranslated(0, 0, -0.7);
        glRotatef(head_angle-10, 1, 0, 0);
        bird.drawWithColors(lighting_sun, lose);
        
        glTranslated(0, 0, -0.7);
        glRotatef(head_angle-10, 1, 0, 0);
        bird.drawWithColors(lighting_sun, lose);
        
        glTranslated(0, 0, -0.7);
        glRotatef(head_angle-10, 1, 0, 0);
        bird.drawWithColors(lighting_sun, lose);
        
        glTranslated(0, 0, -0.7);
        glRotatef(head_angle-10, 1, 0, 0);
        bird.drawWithColors(lighting_sun, lose);
        glPopMatrix();
    }
}

//*******7.5-load background********//
void load_background()
{
    glMatrixMode(GL_PROJECTION);
    glPushMatrix();
    glLoadIdentity();
    gluOrtho2D(-1.0, 1.0, -1.0, 1.0);
    glMatrixMode(GL_MODELVIEW);
    glPushMatrix();
        glLoadIdentity();
        glDisable(GL_LIGHTING);
        glColor3f(1,1,1);
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, background_texture);

    // Draw a textured quad
    glBegin(GL_QUADS);
    glTexCoord2d(backgroundX, 0); glVertex2f(-1.0,-1.0);
    glTexCoord2d(backgroundX + 1, 0); glVertex2f(1.0,-1.0);
    glTexCoord2d(backgroundX + 1, 1); glVertex2f(1.0, 1.0);
    glTexCoord2d(backgroundX, 1); glVertex2f(-1.0, 1.0);
    glEnd();
    
    glDisable(GL_TEXTURE_2D);
    glPopMatrix();
    glMatrixMode(GL_PROJECTION);
    glPopMatrix();
    glMatrixMode(GL_MODELVIEW);
    
}
void drawScene() {
    
    glDisable(GL_DEPTH_TEST);
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);

    load_background();
    renderHeightmap(0.1, 0.6);
    glEnable(GL_DEPTH_TEST);

    light_setting();

    load_hero();
    load_horse();
    load_bullet();
    
    if(count_number>10){
        load_bird();
    }

    if(boss_survive){
        load_boss();
        load_axe();
    }

    
    glFlush();
    glutSwapBuffers();
}

/////////////////////////////////////
//******8-keyboard function********///
/////////////////////////////////////
void keyboard(unsigned char k, int x, int y)
{
    switch (k)
    {
        case 'a':
            direction += 5;
            break;
        case 'w':
            direction -= 5;
            break;
        case 'q':
            exit(0);
    }
    glutPostRedisplay();
}

/////////////////////////////////////
//******9-reshape function********///
/////////////////////////////////////
void handleResize(int w, int h) {
    glViewport(0, 0, w, h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(40, (float)w / (float)h, 0.5, 20.0);
}

/////////////////////////////////////
//******10-initlization********///
/////////////////////////////////////
void init()
{
    glClearColor(0, 0, 0, 0);		// background color
    glClearDepth(1.0);			// background depth value
    
    glMatrixMode(GL_PROJECTION);
//    glLoadIdentity();
    gluPerspective(60, 1, 1, 100);	// setup a perspective projection
    
    glMatrixMode(GL_MODELVIEW);  //tricky!!!!!!
//    glLoadIdentity();
    
    gluLookAt(				// set up the camera
              0.0, 0.0, 4.0,		// eye position
              0.0, 0.0, 0.0,		// lookat position
              0.0, 1.0, 0.0);		// up direction
    
    glEnable(GL_DEPTH_TEST);		// enable hidden surface removal

}

int main(int argc, char * argv[])
{
    
    glutInit(&argc,argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(1200,800);
    glutInitWindowPosition(20, 20);
    glutCreateWindow(argv[0]);
    
    //0-load background
    init_background();
    
    //1-load hero
    init_hero();
    init_bullet(argc == 2 ? argv[1] : "bullet.obj");
    init_horse(argc == 2 ? argv[1] : "horse.obj");

    //2-load bird
    init_bird(argc == 2 ? argv[1] : "bird.obj");
    
    //3-load boss
    init_boss();
    
    //4-load axe
    init_axe(argc == 2 ? argv[1] : "axe.obj");
    
    //5-load textures
    textures_loading();
    
    //6-update staff
    glutTimerFunc(30,update,0);
    
    //7-display function
    glutDisplayFunc(drawScene);
    
    //8-keyboard function
    glutKeyboardFunc(keyboard);
    
    //9-reshape function
    glutReshapeFunc(handleResize);
    glutIdleFunc(drawScene);
    
    //10-intialization
    init();
    
    //    glutIdleFunc(bul_move);
    
    glutMainLoop();
    return 0; 
}