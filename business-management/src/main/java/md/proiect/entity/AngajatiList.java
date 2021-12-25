package md.proiect.entity;

public class AngajatiList {
    private  String idnp;
    private  String nume;
    private  String prenume;

    public AngajatiList(String idnp,String nume,String prenume){
        this.idnp = idnp;
        this.nume = nume;
        this.prenume = prenume;
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

    @Override
    public String toString(){
        return "Angajati{" +
                " idnp='" + idnp + '\'' +
                " nume='" + nume+ '\'' +
                " prenume='" + prenume + '\'' +
                '}';
    }
}
