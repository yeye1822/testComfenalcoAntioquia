
function findAll(){
    console.log("hola mundo");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clientes",
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
                +response[i].fechaNacimiento+'</td><td>'
                +response[i].createAt
                +'</td><td class="text-center"><i class="fa fa-trash-o mr-3" aria-hidden="true" onclick="deleteId('
                +response[i].id+')" style="cursor:pointer;"></i><i class="fa fa-pencil" aria-hidden="true" onclick="updateId('
                +response[i].id+')" style="cursor:pointer;" data-toggle="modal" data-target="#staticBackdrop1"></i></td></tr>';
        // console.log(response[i].nombre);
    }

     table.innerHTML = tableResponse;
}

function saveClient(){
    var tipo = document.getElementById("txtTipo");
    var documento = document.getElementById("txtDocumento");
    var nombre = document.getElementById("txtNombre");
    var apellido = document.getElementById("txtApellido");
    var email = document.getElementById("txtEmail");
    var fechaNac = document.getElementById("txtFechaNac");

    if(tipo.value == "" || documento.value == "" || nombre.value == "" || apellido.value == "" || email.value == "" || fechaNac.value == ""){
        alert("Todos los campos son requeridos");
        return;
    }

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clientesbydoc/"+documento.value,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            console.log(response);
           if (response!=null){
            alert("El cliente con documento "+ documento.value + " ya existe");
            return;
           }else{
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/api/clientes",
                data: '{ "tipo":"'+tipo.value+'", "documento":"'+ documento.value+'", "nombre":"'+ nombre.value +'", "apellido":"'+ apellido.value+'", "email":"'+ email.value+'", "fechanacimiento":"'+ fechaNac.value+'" }',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (response) {            
                    alert("Datos Guardados Exitosamente!");
                    tipo.value="";
                    documento.value="";
                    nombre.value = "";
                    apellido.value = "";
                    email.value = "";
                    fechaNac.value="";
        
                    findAll();
                },
                error: function (r) {
                    console.log(r.responseText);
                },
                failure: function (r) {
                    console.log(r.responseText);
                }
            });
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


function deleteId(id){
    var tienepremio = "0";
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/ganadoresbyid/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            console.log(response);
           if (response!=null){
            alert("El cliente no puede ser eliminado. Tiene premio Asignado");
            tienepremio="1";
            console.log("cambio tienepremio a ::"+tienepremio + "id:::" + id);
           }else{
            deleteCliente(id);
           }
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
           
        }
    });
   
}

function deleteCliente(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/clientes/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            console.log(response);
            findAll();
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function updateId(id){
    var tipo = document.getElementById("txtTipoA");
    var documento = document.getElementById("txtDocumentoA");
    var nombre = document.getElementById("txtNombreA");
    var apellido = document.getElementById("txtApellidoA");
    var email = document.getElementById("txtEmailA");
    var fechaNac = document.getElementById("txtFechaNacA");
    var idold = document.getElementById("txtId");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clientes/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            console.log(response);
            tipo.value=response.tipo;
            documento.value=response.documento;
            nombre.value = response.nombre;
            apellido.value = response.apellido;
            email.value = response.email;
            fechaNac.value=response.fechaNacimiento;
            idold.value = response.id;
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function updateClient(){
    var tipo = document.getElementById("txtTipoA");
    var documento = document.getElementById("txtDocumentoA");
    var nombre = document.getElementById("txtNombreA");
    var apellido = document.getElementById("txtApellidoA");
    var email = document.getElementById("txtEmailA");
    var fechaNac = document.getElementById("txtFechaNacA");
    var id = document.getElementById("txtId");

     if(nombre.value == "" || apellido.value == "" || email.value == ""){
        alert("Los campos nombre, apellido y correo son requeridos");
        return;
    }

     $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/clientes/"+id.value,
        data: '{ "tipo":"'+tipo.value+'", "documento":"'+ documento.value+'", "nombre":"'+ nombre.value +'", "apellido":"'+ apellido.value+'", "email":"'+ email.value+'", "fechanacimiento":"'+ fechaNac.value+'" }',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {            
            alert("Datos Actualizados Exitosamente!");

            nombre.value = "";
            apellido.value = "";
            email.value = "";

            location.reload();
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function enviarPremiacion(){
    window.location.href="premiacion.html";
    
}