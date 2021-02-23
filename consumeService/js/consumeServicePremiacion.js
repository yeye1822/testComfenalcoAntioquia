
function findAll(){
    //console.log("hola mundo de Premiacion");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/ganadores",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            // console.log(response);
            showAll(response);

        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function showAll(response){
    var table = document.getElementById("findall");
    var tableResponse = "";
   
    for (var i = 0; i < response.length; i++) {
        tableResponse = tableResponse + '<tr><th scope="row">'+response[i].id+'</th><td>'
                +response[i].tipo+'</td><td>'
                +response[i].documento+'</td><td>'
                +response[i].nombre+'</td><td>'
                +response[i].apellido+'</td><td>'
                +response[i].email+'</td><td>'
                +response[i].premio+'</td><td>'
                +response[i].createAt;
        // console.log(response[i].nombre);
    }

     table.innerHTML = tableResponse;
}

function runAlgoritmo(){
    var opcion = confirm("Esta seguro de continuar con el proceso de premiación?");
    if (opcion == true) {
       //console.log("continua el proceso de premiacion");
       //console.log("1.- Ubico todos los clientes");

       $.ajax({
           type: "GET",
           url: "http://localhost:8080/api/clientes",
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           success: function (responseclientes) {
               //console.log("2.- Para cada cliente le asigno un premio");
               
               for (var i = 0; i < responseclientes.length; i++) {

                //console.log("2.1- Se toman los datos del nuevo cliente");
                validaPremios(responseclientes[i]);
                findAll();

               }
           },
           error: function (r) {
               console.log(r.responseText);
           },
           failure: function (r) {
               console.log(r.responseText);
           }
       });
       
	} else {
        //console.log("Se detiene el proceso de premiacion");
	}
}


function validaPremios(response){
   // console.log("validaPremios parametro response::>>" + response);
    var idcliente=response.id;
    var tipo=response.tipo;
    var documento=response.documento;
    var nombre=response.nombre;
    var apellido=response.apellido;
    var email=response.email;
    var cantidad=0;

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/premioAsignar",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (responsePremios) {
           // console.log("responsePremios::"+responsePremios);
           if (responsePremios!=null){
            var idpremio=responsePremios.id;
            var descripcion=responsePremios.descripcion;
            cantidad= responsePremios.cantidad;
            var jsonGanador='{ "idganador":"'+idcliente+'","idpremio":"'+idpremio+'","tipo":"'+tipo+'", "documento":"'+ documento+'","nombre":"'+ nombre +'", "apellido":"'+ apellido+'", "email":"'+ email+'", "premio":"'+ descripcion+'" }';

                console.log("entro a guardar ganador");
                guardarGanador(jsonGanador,idpremio, descripcion, cantidad);
           }else{
            console.log("entro a else");
            alert("No hay suficientes premios para asignar, se procederá a anular la premiación");
            limpiarPremiacion();
              }
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function guardarGanador(jsonGanador,idpremio, descripcion, cantidad){
    var can=0;
    //console.log("guardarGanador Parametros::");
    //console.log("jsonGanador:::>>"+jsonGanador);
   // console.log("idpremio::>>"+idpremio);
    //console.log("descripcion::>>"+descripcion);
    can=can+(cantidad-1);
    var jsonActualizarInventarioPremios ='{ "descripcion":"'+descripcion+'", "cantidad":"'+ can+'" }';
          // console.log("En guardarGanador jsonActualizarInventarioPremios:::"+jsonActualizarInventarioPremios);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/ganadores",
        data: jsonGanador,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {            
           // console.log("2.4.- Se insertan los datos del ganador ");
           // console.log("jsonActualizarInventarioPremios:::>>"+jsonActualizarInventarioPremios);
            actualizarInventarioPremios(jsonActualizarInventarioPremios,idpremio);
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });   
 
}

function actualizarInventarioPremios(jsonActualizarInventarioPremios,idpremio){
    console.log("actualizarInventarioPremios parametros jsonActualizarInventarioPremios ::>"+ jsonActualizarInventarioPremios + " idpremio "+ idpremio);
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/premios/"+idpremio,
        data: jsonActualizarInventarioPremios,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
                     
            //console.log("2.5.- Se actualiza la existencia del premio ::>");
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function limpiarPremiacion(){

       console.log("continua el proceso de borrar tabla de premiacion");
       console.log("1.- Ubico todos los clientes");

       $.ajax({
           type: "GET",
           url: "http://localhost:8080/api/ganadores",
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           success: function (responseganador) {
               for (var i = 0; i < responseganador.length; i++) {
                deleteGanador(responseganador[i].id);
                findAll();
               }
           },
           error: function (r) {
               console.log(r.responseText);
           },
           failure: function (r) {
               console.log(r.responseText);
           }
       });
}

function deleteGanador(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/ganadores/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            console.log(response);
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}
function regresar(){
    window.location.href="index.html";
    
}