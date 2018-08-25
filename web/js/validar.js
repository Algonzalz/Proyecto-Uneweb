function validar() {
    var usuario, password1, password2;

    usuario = document.getElementById("txtusuario").value;
    password1 = document.getElementById("txtpassword1").value;
    password2 = document.getElementById("txtpassword2").value;

    if (usuario.length > 14) {
        alert(" EL USUARIO SUPERA EL LIMITE DE CARACTERES");
        document.getElementById("txtusuario").focus();
        return false;
    } else if (password1 != password2) {
        alert("LAS CONTRASEÑAS NO COINCIDEN");
        return false;
    }
}

function validarc() {
    var id;

    id = document.getElementById("txtid").value;

    if (isNaN(id)) {
        alert(" ID INCORRECTO,INGRESE SOLAMENTE NÚMEROS");
        document.getElementById("txtid").focus();
        return false;
    }
}
