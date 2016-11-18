/**
 * Created by Ani Dimitrova on 17 Nov 2016.
 */

function first_attempt(){
var size = 50;

var svg = d3.select("body").append("svg");
svg.attr("width",size)
    .attr("height",size);

svg.append("circle")
    .attr("cx", size/2)
    .attr("cy",size/2)
    .attr("r",size/2)
    .style("fill","green");
}

function create_circle() {
    d3.select("body")
    .append("svg")
    .attr("width", 150)
    .attr("height", 150)
    .append("circle")
    .attr("cx", 50)
    .attr("cy", 50)
    .attr("r", 50)
    .style("fill", 'pink');
}

function changeColor(){
    d3.select("#green")
        .style("fill", "yellow");

    d3.selectAll(".pink")
        .attr("r",10);
}