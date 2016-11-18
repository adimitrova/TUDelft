/**
 * Created by Ani on 17-Nov-16.
 */
function changeColor() {
    d3.select("#small")
        .attr("fill", "yellow");
}

function changeRadius() {
    d3.selectAll(".big")
        .attr("r", 45);
}