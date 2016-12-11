function simpleData(){
var dataset = [ 250, 70, 50, 260, 110, 80, 250, 140, 230, 190,
		140, 110, 220, 290, 110, 130, 120, 170, 180, 100,
		240, 180, 250, 90, 30, 250, 90, 330];

		var height = 300;
		var width = 800;
				
		//var barWidth = 20;
		//var barOffset = 4;   // space between the bars
		
		var yScale = d3.scale.linear()
			.domain([0, d3.max(dataset)])
			.range([0, height]);
		
		var xScale = d3.scale.ordinal()
			.domain(d3.range(0, dataset.length))
			.rangeBands([0, width])
		
		var colors = d3.scale.linear()
			.domain([0, dataset.length])
			.range(['#a3d900','#ff0000'])
		
		d3.select('.dataviz').append('svg')
					.attr("width",width)
					.attr("height",height)
					.style("background",'#f4f4f4')
					.selectAll("rect")
						.data(dataset)
						.enter()
						.append('rect')
							.style('fill',function(d, i){
								return colors(i);
							})
							.attr('width', xScale.rangeBand())
							.attr('height',function(d){		// set height of bars to whatever the data value is
								return yScale(d);
								})
							.attr('x', function(d, i){		// set the x position of the bar 
								return xScale(i);
							})
							.attr('y', function(d){
								return height - yScale(d);
							})
							.style;
}


/* Draw a canvas for the object */
function drawCanvas(){
	//Make an SVG Container
    var svgContainer = d3.select(".dataviz")
        .append("svg")
        .attr("width",100)  //svg must be twice as big as the circle values
        .attr("height",100)
		.style("margin-right", 10);   /** add space between the svg objects we create */
		
	return svgContainer;
}


	
function drawCircle(){
		
	/* IT ALWAYS STARTS DRAWING FROM TOP LEFT CORNER */
	/** Now we create the shapes
	* Note that we start with the previous variable canvas, not with d3 
	* Circle is called "circle" and needs the following attributes:
	@cx		horizontal position
	@cy		vertical position
	@r 		radius
	@fill	color to fill the shape with
	@ all the rest
	*/	
	
	var canvasCircle = drawCanvas();
	
    //Draw the Circle
    var circle = canvasCircle.append("circle")
        .attr("cx",50)
        .attr("cy",50)
        .attr("r",50)
        .attr("fill","yellow");
}


function drawRectangle(){
	/** Rectangle is called "rect" and needs the following attributes:
	@width		width
	@heigth		heigth
	-- Optional --
	@fill	color to fill the shape with
	@ all the rest
	*/	
	var canvasRect = drawCanvas();
	
	var rectangle = canvasRect.append("rect")
		.attr("width", 150)
		.attr("height", 40)
		.attr("fill","pink");
}


function drawLine(){			
/** Lines is called "line" and need the following attributes:
@x1			1st horizontal point
@y1			1st vertical point
@x2 		2nd horizontal point
@y2			2nd vertical point
@stroke		color make the line visible
--- optional ---
@stroke-width	makeing the line really visible
@ all the rest
*/				
var canvasLine = d3.select(".dataviz")
        .append("svg")
        .attr("width",150)  //svg must be twice as big as the circle values
        .attr("height",200)
		.style("margin-right", 10);   /** add space between the svg objects we create */

var line = canvasLine.append("line")
			.attr("x1", 0)
			.attr("y1", 100)
			.attr("x2", 200)
			.attr("y2", 200)
			.attr("stroke", "green")
			.attr("stroke-width",10);
}


