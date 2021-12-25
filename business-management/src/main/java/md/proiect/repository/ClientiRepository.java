package md.proiect.repository;

import md.proiect.entity.Angajati;
import md.proiect.entity.Clienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Clienti> findAll(){
        List<Clienti> clientiList = jdbcTemplate.query("SELECT * FROM clienti",
                (response, rowNumber) -> {
                    return new Clienti(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"),
                            response.getString("strada"),
                            response.getBoolean("permanenti"),
                            response.getString("genul").charAt(0),
                            response.getInt("varsta"),
                            response.getInt("telefon"));
                });
        return clientiList;
    }

    public Clienti findByIdnp(String idnp){
        Clienti clienti = jdbcTemplate.queryForObject("SELECT * FROM clienti WHERE idnp = ?", new Object[]{idnp},
                (response, rowNumber) -> {
                    return new Clienti(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"),
                            response.getString("strada"),
                            response.getBoolean("permanenti"),
                            response.getString("genul").charAt(0),
                            response.getInt("varsta"),
                            response.getInt("telefon"));
                });
        return clienti;
    }

    public Clienti findByPrenume(String prenume){
        Clienti clienti = jdbcTemplate.queryForObject("SELECT * FROM clienti WHERE prenume = ?", new Object[]{prenume},
                (response, rowNumber) -> {
                    return new Clienti(
                            response.getString("idnp"),
                            response.getString("nume"),
                            response.getString("prenume"),
                            response.getString("strada"),
                            response.getBoolean("permanenti"),
                            response.getString("genul").charAt(0),
                            response.getInt("varsta"),
                            response.getInt("telefon"));
                });
        return clienti;
    }

    public List<Clienti> findBetweenVarsta(int minVarsta, int maxVarsta){
        List<Clienti> clientiList =
                jdbcTemplate.query("select * from clienti where varsta between ? AND ?",new Object[]{minVarsta, maxVarsta},
                        (response, rowNumber) -> {
                            return new Clienti(
                                    response.getString("idnp"),
                                    response.getString("nume"),
                                    response.getString("prenume"),
                                    response.getString("strada"),
                                    response.getBoolean("permanenti"),
                                    response.getString("genul").charAt(0),
                                    response.getInt("varsta"),
                                    response.getInt("telefon"));
                        });
        return clientiList;
    }

    public void save(Clienti clienti){
        jdbcTemplate.update(
                "insert into clienti(idnp, nume, prenume, strada, permanenti, genul, varsta, telefon)values(?,?,?,?,?,?,?,?)",
                clienti.getIdnp(),clienti.getNume(), clienti.getPrenume(),clienti.getStrada(),clienti.isPermanenti(),clienti.getGenul(),clienti.getVarsta(),clienti.getTelefon());
    }

    public void update(String idnp, Clienti clienti){
        jdbcTemplate.update(
                "UPDATE clienti SET nume = ?, prenume = ?, strada = ?, permanenti = ?, genul = ?,varsta = ?,telefon = ? WHERE idnp = ?",
                clienti.getNume(), clienti.getPrenume(),clienti.getStrada(),clienti.isPermanenti(),clienti.getGenul(),clienti.getVarsta(),clienti.getTelefon(), idnp);
    }

    public void delete(String idnp){
        jdbcTemplate.update(
                "DELETE FROM clienti WHERE idnp = ?", idnp);
    }


}
