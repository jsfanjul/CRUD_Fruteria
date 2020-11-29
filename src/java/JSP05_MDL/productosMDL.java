package JSP05_MDL;

public class productosMDL {
    private int prod_id;
    private String prod_nombre;
    private double prod_precio;
    private String prod_foto;
    private int prod_gen_id;
    
    private String gen_genero;

    public productosMDL(int prod_id, String prod_nombre, double prod_precio, String prod_foto, int prod_gen_id) {
        this.prod_id = prod_id;
        this.prod_nombre = prod_nombre;
        this.prod_precio = prod_precio;
        this.prod_foto = prod_foto;
        this.prod_gen_id = prod_gen_id;
    }

    public productosMDL(int prod_id, String prod_nombre, double prod_precio, String prod_foto, int prod_gen_id, String gen_genero) {
        this.prod_id = prod_id;
        this.prod_nombre = prod_nombre;
        this.prod_precio = prod_precio;
        this.prod_foto = prod_foto;
        this.prod_gen_id = prod_gen_id;
        this.gen_genero = gen_genero;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public double getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(double prod_precio) {
        this.prod_precio = prod_precio;
    }

    public String getProd_foto() {
        return prod_foto;
    }

    public void setProd_foto(String prod_foto) {
        this.prod_foto = prod_foto;
    }

    public int getProd_gen_id() {
        return prod_gen_id;
    }

    public void setProd_gen_id(int prod_gen_id) {
        this.prod_gen_id = prod_gen_id;
    }

    public String getGen_genero() {
        return gen_genero;
    }

    public void setGen_genero(String gen_genero) {
        this.gen_genero = gen_genero;
    }
    
    
}
