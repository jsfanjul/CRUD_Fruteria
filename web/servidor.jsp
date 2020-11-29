<%@page import="JSP05_CTR.productosCTR"%>
<%@page import="JSP05_CTR.generosCTR"%>
<%
    if(request.getParameter("operacion") == null){
        response.sendRedirect("index.jsp");
    }
    if(request.getParameter("operacion").equals("cargar_generos")){
        out.println(generosCTR.Mostrar_Catalogo());
    }
    if(request.getParameter("operacion").equals("cargar_productos")){
        out.println(productosCTR.Mostrar_Catalogo());
    }
    if(request.getParameter("operacion").equals("carga_frm_generos")){

    }
    if(request.getParameter("operacion").equals("carga_frm_productos")){
    
    }
%>