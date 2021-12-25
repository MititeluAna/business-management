package md.proiect.entity;

public class Clienti {
    private  String idnp;
    private  String nume;
    private  String prenume;
    private  String strada;
    private  boolean permanenti;
    private  char genul;
    private  int varsta;
    private  int telefon;

    public Clienti(String idnp,String nume,String prenume,String strada,boolean permanenti,char genul,int varsta,int telefon){
        this.idnp = idnp;
        this.nume = nume;
        this.prenume = prenume;
        this.strada = strada;
        this.permanenti = permanenti;
        this.genul = genul;
        this.varsta = varsta;
        this.telefon = telefon;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public boolean isPermanenti() {
        return permanenti;
    }

    public void setPermanenti(boolean permanenti) {
        this.permanenti = permanenti;
    }

    public char getGenul() {
        return genul;
    }

    public void setGenul(char genul) {
        this.genul = genul;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString(){
        return "Angajati{" +
                " idnp='" + idnp + '\'' +
                " nume='" + nume+ '\'' +
                " prenume='" + prenume + '\'' +
                " strada='" + strada + '\'' +
                " permanenti=" + permanenti +
                " genul=" + genul +
                " varsta=" + varsta +
                " telefon=" + telefon +
                '}';
    }
}

