package JSP05_MDL;

public class generosMDL {
    private int gen_id;
    private String gen_genero;

    public generosMDL(int gen_id, String gen_genero) {
        this.gen_id = gen_id;
        this.gen_genero = gen_genero;
    }

    public int getGen_id() {
        return gen_id;
    }

    public void setGen_id(int gen_id) {
        this.gen_id = gen_id;
    }

    public String getGen_genero() {
        return gen_genero;
    }

    public void setGen_genero(String gen_genero) {
        this.gen_genero = gen_genero;
    }
    
    
}
