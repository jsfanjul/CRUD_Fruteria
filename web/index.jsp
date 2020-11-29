
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"/>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            #div_cab {
                height: 50px;
                background-color: lightblue;
                line-height: 50px;
                text-align: center;
            }

            #div_pie {
                height: 30px;
                background-color: lightsalmon;
                line-height: 30px;
            }

            #div_principal {
                width: 90%;
                margin: 0 auto;
                background-color: orangered;
            }

            #div_menu {
                height: 40px;
                background-color: yellowgreen;
                line-height: 40px;
            }

            #div_menu ul {
                list-style: none;
                margin: 0 auto;
                width: 50%;
            }

            #div_menu li {
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                font-size: 18px;
                padding: 5px 30px;
                margin: 50px;
                border-radius: 30px;
                border: groove 2px grey;
                cursor: pointer;
                background-color: darkcyan;
                color: white;
                display: inline;
                border: 1px solid darkcyan;
            }

            #div_menu li:hover {
                background-color: white;
                color: darkcyan;
                box-shadow: 2px 2px grey;
                border: 1px solid green;
            }

            #div_cuerpo {
                padding-top: 30px;
            }

            #div_cuerpo ul {
                list-style: none;

            }

            #div_cuerpo li {
                border-radius: 10px 0;
                padding: 10px;
                margin: 10px;
                color: orange;
                font-size: 15px;
                background-color: brown;
                width: 200px;
                display: inline;
                text-shadow: 1px 1px black;
            }

            .fa {
                margin: 10px;
            }

            .fa-pencil {
                color: black;
                cursor: pointer;
            }

            .fa-trash {
                color: red;
                cursor: pointer;
                text-shadow: 1px 1px black;
            }

            .fa-plus {
                color: black;
                cursor: pointer;
                text-shadow: 1px 1px greenyellow;
            }

            .div_ext {
                width: 20%;
                float: left;
                height: 225px;
            }

            .div_int {
                width: 95%;
                text-align: center;
                background-color: orangered;
                border: 1px solid black;
                margin: 0 auto;
            }

            .div_clear {
                clear: both;
            }

            .genero {
                font-size: 16px;
            }

            .nombre {
                font-size: 20px;
                text-decoration: double;
            }

            .precio {
                font-size: 16px;
            }
        </style>
        <script type="text/javascript" src="JQuery_3_4_1.js"></script>
        <script>
            $(document).ready(function(){
                REDIMENSIONAR();
                
                $('#li_generos').on('click', function(){
                    $('#operacion').val('cargar_generos');
                    var datos = $('#frm_op').serialize();
                    $.post('servidor.jsp', datos, function(resp){
                        $('#div_cuerpo').html(resp);
                        REDIMENSIONAR();
                    }).fail(function(){
                        $('#div_cuerpo').html('Error de conexión');
                    });
                });
                
                $('#li_productos').on('click', function(){
                    $('#operacion').val('cargar_productos');
                    var datos = $('#frm_op').serialize();
                    $.post('servidor.jsp', datos, function(resp){
                        $('#div_cuerpo').html(resp);
                        REDIMENSIONAR();
                    }).fail(function(){
                        $('#div_cuerpo').html('Error de conexión');
                    });
                });
                
                $('#div_cuerpo').on('click', '.fa-plus', function(){
                    if($(this).attr('origen') == "generos"){
                        $('#frm_op').attr('action', 'formulario_generos.jsp');
                    }else{
                        $('#frm_op').attr('action', 'formulario_productos.jsp');
                    }
                    $('#paraque').val('i');
                    $('#id').val('0');
                    $('#frm_op').submit();
                });
                
                $('#div_cuerpo').on('click', '.fa-pencil', function(){
                    if($(this).attr('origen') == "generos"){
                        $('#frm_op').attr('action', 'formulario_generos.jsp');
                    }else{
                        $('#frm_op').attr('action', 'formulario_productos.jsp');
                    }
                    $('#paraque').val('m');
                    var id = $(this).parent().attr('ref');
                    $('#id').val(id);
                    $('#frm_op').submit();
                });
                
                $('#div_cuerpo').on('click', '.fa-trash', function(){
                    if($(this).attr('origen') == "generos"){
                        $('#frm_op').attr('action', 'formulario_generos.jsp');
                    }else{
                        $('#frm_op').attr('action', 'formulario_productos.jsp');
                    }
                    $('#paraque').val('b');
                    var id = $(this).parent().attr('ref');
                    $('#id').val(id);
                    $('#frm_op').submit();
                });
            });
            
            function REDIMENSIONAR(){
                var alto = $(document).height() - $("#div_cab").height() - $("#div_pie").height() - $("#div_menu").height();
                $('#div_cuerpo').css('height', alto);
            }
        </script>
    </head>
    <body>
        <form id="frm_op" action="" method="post">
            <input type="hidden" id="operacion" name="operacion"/>
            <input type="hidden" id="paraque" name="paraque"/>
            <input type="hidden" id="id" name="id"/>
        </form>
        <div id="div_principal">
            <div id="div_cab">
                <h1>Frutería</h1>
            </div>
            <div id="div_menu">
                <ul>
                    <li id="li_generos">Generos</li>
                    <li id="li_productos">Productos</li>
                </ul>
            </div>
            <div id="div_cuerpo"></div>
            <div id="div_pie">
                &copy;JSF - 2020
            </div>
        </div>
    </body>
</html>
