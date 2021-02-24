function initialAlgoritmo(initial){
    if(initial != 1){
        var opcion = confirm("Esta seguro de continuar con el proceso de la premiación?");
    }
    
    if (opcion == true || initial == 1) {
      
       $.ajax({
           type: "GET",
           url: "http://localhost:8080/api/showPrize",
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           success: function (response) {
               if(response === null){
                    alert('No hay inventario de premios, termina proceso de premiación');
                    showAllPrize();
                    return;
               }else{
                    searchPerson(response);
               }
           },error: function (r) {
               console.log(r.responseText);
           },failure: function (r) {
               console.log(r.responseText);
           }
       });
       
	} 
}

function searchPerson(showPrize){
    var idPrize = showPrize;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/showPerson",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                 alert('Error consultando a los usuarios');
                 return;
            }else{
                 savePrize(response.id, idPrize);
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function savePrize(idPerson, idPrize){
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/award",
        data: '{ "idPersons":"'+idPerson+'", "idPrize":"'+idPrize.id+'", "amount": "1" }',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                 alert('Error almacenando los premios');
                 return;
            }else{
                updatePrize(idPrize);
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function updatePrize(idPrize){
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/prize/"+idPrize.id,
        data: '{ "description":"'+idPrize.description+'", "amount":"'+(idPrize.amount - 1)+'"}',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                 alert('Error actualizando los premios');
                 return;
            }else{
                initialAlgoritmo(1);
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function back(){
    window.location.href="index.html";   
}

function showAllPrize(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/awardWinner",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            prizeId(response, 1);
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function prizeId(prize, id){

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/prize",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                 alert('Error consultando premios');
                 return;
            }else{
                if(id == 1){
                    personsPrize(prize, response);
                }else{
                    updateInventory(prize, response)
                }
                
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });

}

function personsPrize(prize, inventory){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/persons",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {     
            if(response === null){
                alert("Error consultado las personas");
            }else{
                showPrizes(prize, inventory, response);
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function showPrizes(prize, inventory, persons){

    var table = document.getElementById("findPrize");
    var tableResponse = "";

    for (var i = 0; i < prize.length; i++) {

        const descriptionPrize = inventory.find(namePrize => namePrize.id === prize[i].idPrize);
        const dataPerson = persons.find(data => data.id === prize[i].idPersons);

        tableResponse = tableResponse + '<tr><th scope="row">'+dataPerson.documentType+'</th><td>'
                +dataPerson.documentNumber+'</td><td>'
                +dataPerson.name+'</td><td>'
                +dataPerson.lastName+'</td><td>'
                +descriptionPrize.description+'</td><td>'
                +prize[i].amount+'</td></tr>';
    }

    table.innerHTML = tableResponse;
}

function cleanAward(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/awardPrize",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                 alert('Error consultando premios');
                 return;
            }else{
                prizeId(response, 0);
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function updateInventory(prize, inventory){

    for (var i = 0; i < prize.length; i++) {
        const dataInventory = inventory.find(data => data.id === prize[i].idPrize);

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/prize/"+dataInventory.id,
            data: '{ "id":"'+dataInventory.id+'", "description":"'+dataInventory.description+'", "amount": '+prize[i].amount+' }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (response) {
                if(response === null){
                     alert('Error actualizando la tabla de premios');
                     return;
                }else{
                    console.log('se actualizo correctamente');
                }
            },error: function (r) {
                console.log(r.responseText);
            },failure: function (r) {
                console.log(r.responseText);
            }
        }); 
    }
    deletePrizeAward();
}

function deletePrizeAward(){

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/awardDeleteAll",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            alert('Se restablece los premios para continuar con el siguiente sorteo'); 
            sendPrize();
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    }); 

}
