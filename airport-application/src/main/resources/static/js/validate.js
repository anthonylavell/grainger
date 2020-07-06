$( "#informBtn" ).click(function() {
    var airportCode = $("#airportCode").val();
    if(airportCode.length < 3){
        alert("Please check Airport code");
        event.preventDefault();
    }
});
