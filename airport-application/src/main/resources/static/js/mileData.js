$( "#milesBtn" ).click(function() {
    if(!$("#departure").val() || !$("#arrival").val()){
        alert("Please check Airports codes");
    }else{
        let url = window.location.protocol+"//";
        var host = new URL(document.URL).host;
        url = url+ host+"/api/airports/distance/"+$("#departure").val()+"/"+$
        ("#arrival").val
        ();
        console.log("url " + url);

            $.getJSON(url, function(data) {
                        console.log(data);
                        $("#miles").val(data.miles);

                    }).error(function() {
                        alert("Error!! Please check Airports codes");
                        $( "#resetBtn" ).click();
                    });


    }
});