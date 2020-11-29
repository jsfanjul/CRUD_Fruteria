
<%@page import="JSP05_CTR.generosCTR"%>
<%
    String prod_id = "";
    String prod_nombre = "";
    String prod_precio = "";
    String prod_foto = "";
    String prod_gen_id = "0";
    
    if(request.getParameter("paraque") == null){
        response.sendRedirect("index.jsp");
    }else{
        out.println(request.getParameter("paraque")+request.getParameter("id"));
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="JQuery_3_4_1.js"></script>
        <script>
            $(document).ready(function(){
                
            });
            function Validacion(){
                //Buscar por campos
                if($('#prod_nombre').val().trim() == ""){
                    $('#tderror').html('Campo nombre obligatorio');
                    $('#prod_nombre').focus();
                    return false;
                }
                if($('#prod_precio').val().trim() == ""){
                    $('#tderror').html('Campo precio obligatorio');
                    $('#prod_precio').focus();
                    return false;
                }
                if(isNaN($('#prod_precio').val())){
                    $('#tderror').html('Campo precio tiene que ser numerico');
                    $('#prod_precio').focus();
                    return false;
                }
                if($('#prod_foto').val().trim() == ""){
                    $('#tderror').html('Campo foto obligatorio');
                    $('#prod_foto').focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <form id="frm" action="" method="post">
            <input type="hidden" name="operacion" id="operacion" />
            <input type="hidden" name="prod_id" id="prod_id" value="<%=prod_id%>"/>
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" id="prod_nombre" name="prod_nombre" value="<%=prod_nombre%>"</td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" id="prod_precio" name="prod_precio" value="<%=prod_precio%>"</td>
                </tr>
                <tr>
                    <td>Foto</td>
                    <td><input type="text" id="prod_foto" name="prod_foto" value="<%=prod_foto%>"</td>
                </tr>
                <tr>
                    <td>Genero</td>
                    <td>
                        <%
                            out.println(generosCTR.Mostrar_Select(Integer.parseInt(prod_gen_id)));
                        %>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" id="tderror"></td>
                </tr>
                <tr>
                    <td>
                        <%
                            if(request.getParameter("operacion").equals("b")){
                                out.println("<input type='button' id='btnBorrar' value='Borrar'/>");
                            }
                            if(request.getParameter("operacion").equals("m")){
                                out.println("<input type='button' id='btnModificar' value='Modificar'/>");
                            }
                            if(request.getParameter("operacion").equals("i")){
                                out.println("<input type='button' id='btnGrabar' value='Grabar'/>");
                            }
                        %>
                    </td>
                </tr>
            </table>
            <input type="button" id="btnCancelar" value="Volver"/>
        </form>
    </body>
</html>
