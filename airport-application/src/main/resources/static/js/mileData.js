$( "#milesBtn" ).click(function() {
    let departure = $("#departure").val();
    let arrival = $("#arrival").val();
    if(departure.length < 3 || arrival.length < 3){
        alert("Please check Airports codes");
    }else{
        let url = window.location.protocol+"//";
        let host = new URL(document.URL).host;
        url = url+ host+"/api/airports/distance/"+departure+"/"+arrival;
       // console.log("url " + url);

            $.getJSON(url, function(data) {
                        //console.log(data);
                        $("#miles").val(data.miles);

                    }).error(function() {
                        alert("Error!! Please check Airports codes");
                        $( "#resetBtn" ).click();
                    });


    }
});