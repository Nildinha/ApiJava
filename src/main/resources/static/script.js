document.getElementById("spotform").addEventListener("submit", function(event){
    event.preventDefault();

    var thumbsnail = document.getElementById("thumbs").value;
    var company = document.getElementById("company").value;
    var price = document.getElementById("price").value;
    var techs = document.getElementById("techs").value;

    var spotData = {

        thumbnail: thumbsnail,
        company:  company,
        price: parseFloat(price),
        techs: techs

    }

    //console.log("Json requerido", JSON.stringify(spotData))

    fetch('/Spot/send',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(spotData)
    }).then(function(response){
        console.log("resposta beckend", response)
    }).catch(function(error){
        console.log("erro", error)
    })
});

 