package md.proiect.entity;

public class Angajati {
    private  String idnp;
    private  String nume;
    private  String prenume;
    private  String strada;
    private  int salariul;
    private  int telefon;
    private  int magazinId;

    public Angajati(String idnp,String nume,String prenume,String strada,int salariul,int telefon,int magazinId){
        this.idnp = idnp;
        this.nume = nume;
        this.prenume = prenume;
        this.strada = strada;
        this.salariul = salariul;
        this.telefon = telefon;
        this.magazinId = magazinId;
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

    public int getSalariul() {
        return salariul;
    }

    public void setSalariul(int salariul) {
        this.salariul = salariul;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getMagazinId() {
        return magazinId;
    }

    public void setMagazinId(int magazinId) {
        this.magazinId = magazinId;
    }

    @Override
    public String toString(){
        return "Angajati{" +
                " idnp='" + idnp + '\'' +
                " nume='" + nume+ '\'' +
                " prenume='" + prenume + '\'' +
                " strada='" + strada + '\'' +
                " salariul=" + salariul +
                " telefon=" + telefon +
                " magazinId=" + magazinId +
                '}';
    }
}


