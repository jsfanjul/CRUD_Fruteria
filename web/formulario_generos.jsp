<%
    String gen_id = "";
    String gen_genero = "";
    if(request.getParameter("paraque") == null){
        response.sendRedirect("index.jsp");
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
                //Buscar por gen_genero
                if($('#gen_genero').val().trim() == ""){
                    $('#tderror').html('Campo género obligatorio');
                    $('#gen_genero').focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        
        <form id="frm" action="" method="post">
            <input type="hidden" name="operacion" id="operacion" />
            <input type="hidden" name="gen_id" id="gen_id" value="<%=gen_id%>"/>
            <table>
                <tr>
                    <td>Genero</td>
                    <td><input type="text" id="gen_genero" name="gen_genero" value="<%=gen_genero%>"</td>
                </tr>
                <tr>
                    <td colspan="2" id="tderror"></td>
                </tr>
                <tr>
                    <td >
                        <%
                            if(request.getParameter("paraque").equals("b")){
                                out.println("<input type='button' id='btnBorrar' value='Borrar'/>");
                            }
                            if(request.getParameter("paraque").equals("m")){
                                out.println("<input type='button' id='btnModificar' value='Modificar'/>");
                            }
                            if(request.getParameter("paraque").equals("i")){
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
