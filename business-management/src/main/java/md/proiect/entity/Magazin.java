package md.proiect.entity;

public class Magazin {
    private int id;
    private String nume;
    private String oras;
    private int nrMagazineSecundare;
    private boolean rangInalt;

    public Magazin(int id,String nume,String oras,int nrMagazineSecundare,boolean rangInalt ){
        this.id = id;
        this.nume = nume;
        this.oras = oras;
        this.nrMagazineSecundare = nrMagazineSecundare;
        this.rangInalt = rangInalt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public int getNrMagazineSecundare() {
        return nrMagazineSecundare;
    }

    public void setNrMagazineSecundare(int nrMagazineSecundare) {
        this.nrMagazineSecundare = nrMagazineSecundare;
    }

    public boolean isRangInalt() {
        return rangInalt;
    }

    public void setRangInalt(boolean rangInalt) {
        this.rangInalt = rangInalt;
    }

    @Override
    public String toString(){
        return "Angajati{" +
                " id='" + id+ '\'' +
                " nume='" + nume+ '\'' +
                " oras='" + oras + '\'' +
                " nrMagazineSecundare='" + nrMagazineSecundare + '\'' +
                " rangInalt=" + rangInalt +
                '}';
    }
}

