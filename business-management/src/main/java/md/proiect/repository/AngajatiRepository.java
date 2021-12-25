package md.proiect.repository;

import md.proiect.entity.Angajati;
import md.proiect.entity.AngajatiDetaliat;
import md.proiect.entity.AngajatiList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AngajatiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Angajati> findAll(){
      List<Angajati> angajatiList = jdbcTemplate.query("SELECT * FROM angajati",
              (response, rowNumber) -> {
          return new Angajati(
                  response.getString("idnp"),
                  response.getString("nume"),
                  response.getString("prenume"),
                  response.getString("strada"),
                  response.getInt("salariul"),
                  response.getInt("telefon"),
                  response.getInt("magazin_id"));
      });
      return angajatiList;
    }


    public AngajatiDetaliat findByIdnp(String idnp){
        AngajatiDetaliat angajati = jdbcTemplate.queryForObject("select * from angajati inner join magazin on angajati.magazin_id = magazin.id where idnp = ?", new Object[]{idnp},
                (response, rowNumber) -> {
                    return new AngajatiDetaliat(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"),
                            response.getString("strada"),
                            response.getInt("salariul"),
                            response.getInt("telefon"),
                            response.getInt("magazin_id"),
                            response.getString("nume"),
                            response.getString("oras"),
                            response.getInt("nr_magazine_secundare"),
                            response.getBoolean("rangul_inalt"));
                });
        return angajati;
    }

   /* public List<AngajatiList> findAll(){
        List<AngajatiList> angajatiList = jdbcTemplate.query("SELECT idnp, nume, prenume FROM angajati",
                (response, rowNumber) -> {
                    return new AngajatiList(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"));
                });
        return angajatiList;
    }
*/
    public Angajati findByPrenume(String prenume){
        Angajati angajati = jdbcTemplate.queryForObject("SELECT * FROM angajati WHERE prenume = ?", new Object[]{prenume},
                (response, rowNumber) -> {
                    return new Angajati(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"),
                            response.getString("strada"),
                            response.getInt("salariul"),
                            response.getInt("telefon"),
                            response.getInt("magazin_id"));
                });
        return angajati;
    }

    public List<AngajatiList> findByMagazinNume(String nume){
        List<AngajatiList> angajatiListByMagazinNume =
                jdbcTemplate.query("select angajati.idnp,angajati.nume,angajati.prenume from angajati" +
                        " inner join magazin on magazin.id = angajati.magazin_id" +
                        " where magazin.nume = ?",new Object[]{nume},
                (response, rowNumber) -> {
                    return new AngajatiList(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"));
                });
        return angajatiListByMagazinNume;
    }

    public List<Angajati> findBetweenSalariu(int minSalariu, int maxSalariu){
        List<Angajati> angajatiList =
                jdbcTemplate.query("select * from angajati where salariul between ? AND ?",new Object[]{minSalariu, maxSalariu},
                        (response, rowNumber) -> {
                            return new Angajati(
                                    response.getString("idnp"),
                                    response.getString("nume"),
                                    response.getString("prenume"),
                                    response.getString("strada"),
                                    response.getInt("salariul"),
                                    response.getInt("telefon"),
                                    response.getInt("magazin_id"));
                        });
        return angajatiList;
    }

    public void save(Angajati angajati){
        jdbcTemplate.update(
                "insert into angajati(idnp, nume, prenume, strada, salariul, telefon,magazin_id)values(?,?,?,?,?,?,?)",
                        angajati.getIdnp(),angajati.getNume(), angajati.getPrenume(),angajati.getStrada(),angajati.getSalariul(),angajati.getTelefon(),angajati.getMagazinId());
    }

    public void update(String idnp, Angajati angajati){
        jdbcTemplate.update(
                "UPDATE angajati SET nume = ?, prenume = ?, strada = ?, salariul = ?, telefon = ?,magazin_id = ? WHERE idnp = ?",
               angajati.getNume(), angajati.getPrenume(),angajati.getStrada(),angajati.getSalariul(),angajati.getTelefon(),angajati.getMagazinId(), idnp);
    }

    public void delete(String idnp){
        jdbcTemplate.update(
                "DELETE FROM angajati WHERE idnp = ?", idnp);
    }
}
