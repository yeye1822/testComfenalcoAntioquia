
function findAll(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/persons",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
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
    var table = document.getElementById("findAll");
    var tableResponse = "";
    typeDocument();
   
    for (var i = 0; i < response.length; i++) {
        tableResponse = tableResponse + '<tr><th scope="row">'+response[i].id+'</th><td>'
                +response[i].documentType+'</td><td>'
                +response[i].documentNumber+'</td><td>'
                +response[i].name+'</td><td>'
                +response[i].lastName+'</td><td>'
                +response[i].birthDate+'</td>'
                +'<td class="text-center"><i onclick="deleteId('+response[i].id+')" style="cursor:pointer;">Eliminar</i>'
                +'<span style="margin:10px">|</span>'
                +'<i onclick="selectId('+response[i].id+')" style="cursor:pointer;" data-toggle="modal" data-target="#staticBackdrop1">Modificar</i></td></tr>';
    }

     table.innerHTML = tableResponse;
}

function typeDocument(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/typeDocument",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            var option = document.getElementById("typeDocument");
            var optionSelect = "<option value=''>- Seleccione una opción -</option>";

            for (var i = 0; i < response.length; i++) {
                optionSelect = optionSelect + '<option value="'+response[i]+'">'+response[i]+'</option>';
            }

            option.innerHTML = optionSelect;
        },
        error: function (r) {
            console.log(r.responseText);
        },
        failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function checkDocumentNumber(){
    var documento = document.getElementById("txtDocumento");

   $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/personByDocument/"+documento.value,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                createPerson();
            }else{
                alert('El usuario ya existe en base de datos, intentar con otro numero de documento');
                return; 
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

function createPerson(){
    var tipo = document.getElementById("typeDocument");
    var documento = document.getElementById("txtDocumento");
    var nombre = document.getElementById("txtNombre");
    var apellido = document.getElementById("txtApellido");
    var email = document.getElementById("txtEmail");
    var fechaNac = document.getElementById("txtFechaNac");

    if(tipo.value == "" || documento.value == "" || nombre.value == "" || apellido.value == "" || fechaNac.value == ""){
        alert("Todos los campos son requeridos");
        return;
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/persons",
        data: '{ "documentType":"'+tipo.value+'", "documentNumber":"'+ documento.value+'", "name":"'+ nombre.value +'", "lastName":"'+ apellido.value+'", "birthDate":"'+ fechaNac.value+'" }',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {     
            if(response === null){
                alert("Error Almacenando el registro!");
            }else{
                alert("Datos Almacenados Exitosamente!");
                tipo.value="";
                documento.value="";
                nombre.value = "";
                apellido.value = "";
                fechaNac.value="";
            }

            findAll();
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function selectId(id){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/persons/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                alert('Error al consultar el usuario a modificar');
            }else{
                document.getElementById("txtTipoA").value = response.documentType;
                document.getElementById("txtDocumentoA").value = response.documentNumber;
                document.getElementById("txtNombreA").value = response.name;
                document.getElementById("txtApellidoA").value = response.lastName;
                document.getElementById("txtFechaNacA").value = response.birthDate;
                document.getElementById("txtId").value = response.id;
            }
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}

function updateClient(){
    var tipo = document.getElementById("txtTipoA");
    var documento = document.getElementById("txtDocumentoA");
    var nombre = document.getElementById("txtNombreA");
    var apellido = document.getElementById("txtApellidoA");
    var fechaNac = document.getElementById("txtFechaNacA");
    var id = document.getElementById("txtId");

     if(nombre.value == "" || apellido.value == "" || fechaNac.value == ""){
        alert("Los campos nombre, apellido y fecha de nacimiento son requeridos");
        return;
    }

     $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/persons/"+id.value,
        data: '{ "documentType":"'+tipo.value+'", "documentNumber":"'+ documento.value+'", "name":"'+ nombre.value +'", "lastName":"'+ apellido.value+'", "birthDate":"'+ fechaNac.value+'" }',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {          
            if(response === null){
                alert('Error al Actualizar!');
                return;
            }else{
                alert("Datos Actualizados Exitosamente!");
                window.location.href="index.html";
            }  
            
        },error: function (r) {
            console.log(r.responseText);
        },failure: function (r) {
            console.log(r.responseText);
        }
    });
}


function deleteId(id){
    var tienepremio = "0";
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/award/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
           if(response === null){
                deletePerson(id);
           }else{
                alert("la persona no puede ser eliminado. Tiene premio Asignado");
                return;
           }
        },error: function (r) {
        },failure: function (r) {}
    });
   
}

function deletePerson(id){
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/persons/"+id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            if(response === null){
                alert('Error eliminando el registro!');
            }else{
                alert(response.message);
                findAll();       
            }
        }, error: function (r) {
            console.log(r.responseText);
        },failure: function (response) {
            console.log(response.responseText);
        }
    });
}

function sendPrize(){
    window.location.href="prize.html";
    
}

