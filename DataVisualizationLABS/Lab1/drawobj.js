/**
 * Created by Ani on 17-Nov-16.
 */
function drawCircle() {
    //Make an SVG Container
    var svgContainer = d3.select("#drawhere").append("svg")
        .attr("width", 100)
        .attr("height", 100);

    //Draw the Circle
    var circle;
    circle = svgContainer.append("circle")
        .attr("cx", 50)
        .attr("cy", 50)
        .attr("r", 50)
        .attr("fill","purple");
}


function drawRectangle(){
    var rectContainer = d3.select("#drawhere").append("svg")
        .attr("width",100)
        .attr("height",100);

    var rectangle;
    rectangle = rectContainer.append("rect")
        .attr("x",0)
        .attr("y",0)
        .attr("width", 80)
        .attr("height", 90)
        .attr("fill","green");
}

function drawTriangle(){
    var triangleContainer = d3.select("#drawhere").append("svg")
        .attr("width", 300)
        .attr("height",300);

    var triangle;
    triangle = triangleContainer.append("polygon")
        .attr("x",0)
        .attr("y",0)
        .attr("z",0)
        .attr("points","150,110 250,100 160,200")
        .attr("fill","lime")
        .attr("stroke","purple")
        .attr("stroke-width",2);
}