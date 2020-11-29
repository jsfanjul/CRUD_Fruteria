package JSP05_CTR;

import JSP05_MDL.generosMDL;
import java.sql.*;
import java.util.ArrayList;

public class generosCTR {
    public static ArrayList<generosMDL> Recupera_Todos(String filtro){
        ArrayList<generosMDL> lista = new ArrayList<generosMDL>();
        String sql = "SELECT * FROM generos WHERE gen_genero LIKE ? ORDER BY gen_genero";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1,"%"+filtro+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                generosMDL mdl = new generosMDL(rs.getInt("gen_id"), rs.getString("gen_genero"));
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
    
    public static generosMDL Recupera_ID(int id){
        generosMDL mdl = null;
        String sql = "SELECT * FROM generos WHERE gen_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mdl = new generosMDL(rs.getInt("gen_id"), rs.getString("gen_genero"));
            }
            rs.close();
            cnx.close();
            return mdl;
        } catch (Exception s) {
            s.printStackTrace();
            return null;
        }
    }
    
    public static int Insertar(generosMDL mdl){
        String sql = "INSERT INTO generos SET gen_id=?, gen_genero=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mdl.getGen_id());
            ps.setString(2, mdl.getGen_genero());
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
    
    public static int Modificar(generosMDL mdl){
        String sql = "UPDATE generos SET gen_genero=? WHERE gen_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(2, mdl.getGen_id());
            ps.setString(1, mdl.getGen_genero());
            int n = ps.executeUpdate();
            cnx.close();
            return n;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }
    
    public static int Borrar(String id){
        String sql = "DELETE FROM generos WHERE gen_id=?";
        try {
            Connection cnx = Conexion.Conectar();
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, id);
            int n = ps.executeUpdate();
            cnx.close();
            return n;
        } catch (Exception s) {
            s.printStackTrace();
            return 0;
        }
    }
    
    public static String Mostrar_Tabla(String filtro){
        ArrayList<generosMDL> lista = Recupera_Todos(filtro);
        String s = "";
        s += "<table>";
        s += "<tr><th>Genero</th><th>Accion</th></tr>";
        for(generosMDL g : lista){
            s += "<tr ref='"+g.getGen_id()+"' vienede='generos'>";
            s +=    "<td>"+g.getGen_genero()+"</td>";
            s +=    "<td><span class = 'fa fa-trash'></span>&nbsp;&nbsp;&nbsp;&nbsp;";
            s +=    "<span class = 'fa fa-pencil'></span></td>";
            s += "</tr>";
        }
        s += "</table>";
        return s;
    }
    
    public static String Mostrar_Menu(){
        ArrayList<generosMDL> lista = Recupera_Todos("");
        String s = "";
        s += "<ul>";
        for(generosMDL g : lista){
            s += "<li ref='"+g.getGen_id()+"'>"+g.getGen_genero()+"</li>";
        }
        s += "</ul>";
        return s;
    }
    
    public static String Mostrar_Select(int seleccionado){
        ArrayList<generosMDL> lista = Recupera_Todos("");
        String s = "";
        s += "<select name='prod_gen_id'>";
        String SELECTED = "";
        for(generosMDL g : lista){
            if(seleccionado == g.getGen_id()){
                SELECTED = " selected ";
            }else{
                SELECTED = "";
            }
            s += "<option value='"+g.getGen_id()+"' "+SELECTED+">"+g.getGen_genero()+"</option>";
        }
        s += "</select>";
        return s;
    }
    
    public static String Mostrar_Catalogo(){
        ArrayList<generosMDL> lista = Recupera_Todos("");
        String s = "";
        s += "<ul><li><span origen='generos' class='fa fa-plus'></span></li></ul><br>";
        s += "<ul>";
        for(generosMDL g : lista){
            s += "<li ref='"+g.getGen_id()+"'>"+g.getGen_genero()+""
                    + "<span origen='generos' class='fa fa-trash'></span>"
                    + "<span origen='generos' class='fa fa-pencil'></span></li>";
        }
        s += "</ul>";
        return s;
    }
    
    public static void main(String[] args) {
        /*
        ArrayList<generosMDL> lista = Recupera_Todos("ru");
        for(generosMDL g : lista){
            System.out.println(g.getGen_id()+" - "+g.getGen_genero());
        }
        generosMDL m = Recupera_ID(1);
        System.out.println(m.getGen_id()+" - "+m.getGen_genero());
        generosMDL m = new generosMDL(0,"Ropa");
        int id = Insertar(m);
        if(id == 0){
            System.out.println("No insertado");
        }else{
            System.out.println("El id vale "+id);
        }
        generosMDL m = new generosMDL(3,"Conservas");
        int n = Modificar(m);
        if(n == 0){
            System.out.println("No actualizado");
        }else{
            System.out.println("Actualizado");
        }
        int n = Borrar(3);
        if(n==0){
            System.out.println("Error al borrar");
        }else{
            System.out.println("Borrado con exito");
        }
        */
    }       
}
