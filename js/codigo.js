(function(document, JSON) {
    'use strict';

    function $(nombre) {
        return document.getElementById(nombre);
    }

    var btnCrearUsuario = $('btnCrearUsuario');
    var formulario = $('frmCrear');

    btnCrearUsuario.addEventListener('click', crearRegistro, false);

    function crearRegistro() {
        var url = 'crearRegistro',
            method = 'post',
            data = {
                nombre: $('nombre').value,
                apellido: $('apellido').value
            },
            callback = function(datos) {
                muestraPersonas(JSON.parse(datos));
            };
        ajax(url, method, JSON.stringify(data), callback);
    }

    function muestraPersonas(data) {
        var personas = data,
            vista = $('vista'),
            template = $('template'),
            clon = template.content.cloneNode(true),
            nombre = clon.querySelector('.nombre'),
            apellido = clon.querySelector('.apellido'),
            procesado = clon.querySelector('.procesado');
        vista.innerHTML = '';

        nombre.value = personas.nombre;
        apellido.value = personas.apellido;
        procesado.value = personas.procesado;

        vista.appendChild(clon);
    }

    function muestraPersonas(data) {
        var i = 0,
            max = data.length,
            vista = $('vista'),
            template = $('template'),
            fragmento = document.createDocumentFragment(),
            personas = {},
            clon, nombre, apellido, procesado;


        vista.innerHTML = '';
        for (; i < max; i + 1) {
            articulo = data[i];
            clon = template.content.cloneNode(true);
            nombre = clon.querySelector('.nombre');
            apellido = clon.querySelector('.apellido');
            procesado = clon.querySelector('.procesado');

            nombre.value = personas.nombre;
            apellido.value = personas.apellido;
            procesado.value = personas.procesado;

            fragmento.appendChild(clone);
        }
        vista.appendChild(fragmento);

    }

    function ajax(url, method, data, callback) {
        var xhr = new XMLHttpRequest(),
            uri = '/formulario' + url;
        xhr.open(method, uri, true);
        xhr.addEventListener('load', function() {

            callback(this.responseText);
        }, false);
        if (method === 'get') {
            xhr.send();
        } else if (method === 'post') {
            xhr.setRequestHeader('Content-type', 'application/json; charset = "utf-8"');
            xhr.send(data);
        }
    }
})(document, JSON)