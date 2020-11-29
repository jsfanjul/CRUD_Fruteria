package JSP05_CTR;

import JSP05_MDL.productosMDL;
import java.sql.*;
import java.util.ArrayList;

public class productosCTR {
    public static ArrayList<productosMDL> Recupera_Todos(String filtro){
       ArrayList<productosMDL> lista = new ArrayList<productosMDL>();
       String sql = "SELECT p.*, g.gen_genero "
               + "FROM productos as p INNER JOIN generos as g "
               + "ON p.prod_gen_id = g.gen_id "
               + "WHERE p.prod_nombre LIKE ? OR g.gen_genero LIKE ? "
               + "ORDER BY g.gen_genero, p.prod_nombre";
       System.out.println(sql);
       try {
           Connection cnx = Conexion.Conectar();
           PreparedStatement ps = cnx.prepareStatement(sql);
           ps.setString(1, "%"+filtro+"%");
           ps.setString(2, "%"+filtro+"%");
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               productosMDL mdl = new productosMDL(
                       rs.getInt("prod_id"), 
                       rs.getString("prod_nombre"), 
                       rs.getDouble("prod_precio"), 
                       rs.getString("prod_foto"), 
                       rs.getInt("prod_gen_id"), 
                       rs.getString("gen_genero"));
               lista.add(mdl);
           }
           rs.close();
           cnx.close();
           return lista;
       } catch (Exception s) {
           s.printStackTrace();
           return null;
       }
    } 
    public static productosMDL Recupera_ID(int id){
        productosMDL mdl = null;
        String sql = "SELECT * FROM productos WHERE prod_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mdl = new productosMDL(
                       rs.getInt("prod_id"), 
                       rs.getString("prod_nombre"), 
                       rs.getDouble("prod_precio"), 
                       rs.getString("prod_foto"), 
                       rs.getInt("prod_gen_id"));
            }
            rs.close();
            cnx.close();
            return mdl;
        } catch (Exception s) {
            s.printStackTrace();
            return null;
        }
    }
    public static int Insertar(productosMDL mdl){
        String sql = "INSERT INTO productos "
                + "SET prod_id=?, prod_nombre=?, prod_precio=?, prod_foto=?, prod_gen_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mdl.getProd_id());
            ps.setString(2, mdl.getProd_nombre());
            ps.setDouble(3, mdl.getProd_precio());
            ps.setString(4, mdl.getProd_foto());
            ps.setInt(5, mdl.getProd_gen_id());
            int n = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                n = rs.getInt(1);
            }
            rs.close();
            cnx.close();
            return n;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }
    public static int Modificar(productosMDL mdl){
        String sql = "UPDATE productos SET prod_nombre=?, prod_precio=?, prod_foto=?, prod_gen_id=? "
                + "WHERE prod_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(5, mdl.getProd_id());
            ps.setString(1, mdl.getProd_nombre());
            ps.setDouble(2, mdl.getProd_precio());
            ps.setString(3, mdl.getProd_foto());
            ps.setInt(4, mdl.getProd_gen_id());
            int n = ps.executeUpdate();
            cnx.close();
            return n;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }
    public static int Borrar(int id){
        String sql = "DELETE FROM productos WHERE prod_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            cnx.close();
            return n;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }
    public static String Mostrar_Tabla(String filtro){
        ArrayList<productosMDL> lista = Recupera_Todos(filtro);
        String s = "";
        s += "<table>";
        s += "<tr><th>Genero</th><th>Nombre</th><th>Precio</th><th>Foto</th><th>Acción</th></tr>";
        for(productosMDL p : lista){
            s += "<tr ref='"+p.getProd_id()+"' vienede='productos'>";
            s +=    "<td>"+p.getGen_genero()+"</td>";
            s +=    "<td>"+p.getProd_nombre()+"</td>";
            s +=    "<td>"+p.getProd_precio()+"</td>";
            s +=    "<td><img src='Frutas/"+p.getProd_foto()+"' style='width:40px'></td>";
            s +=    "<td><span class = 'fa fa-trash'></span>&nbsp;&nbsp;&nbsp;&nbsp;";
            s +=    "<span class = 'fa fa-pencil'></span></td>";
            s += "</tr>";
        }
        s += "</table>";
        return s;
    }
    
    public static String Mostrar_Catalogo(){
        ArrayList<productosMDL> lista = Recupera_Todos("");
        String s = "<span class='fa fa-plus' origen='productos'></span><br>";
        for (productosMDL p : lista) {
            s += "<div class='div_ext'>";
            s += "    <div ref='" + p.getProd_id() + "' class='div_int'>";
            s += "        <img src='Fotos/" + p.getProd_foto() + "' style='width:80px; min-width:80px'>";
            s += "        <p class='genero'>" + p.getGen_genero() + "</p>";
            s += "        <p class='nombre'>" + p.getProd_nombre() + "</p>";
            s += "        <p class='precio'>" + p.getProd_precio() + " € </p>";
            s += "        <p><span class='fa fa-pencil' origen='productos'></span> &nbsp;&nbsp;&nbsp;&nbsp;";
            s += "          <span class='fa fa-trash' origen='productos'></span></p>";
            s += "    </div>";
            s += "</div>";
        }
        s += "<div class='clear'></div>";
        return s;
    }
}
