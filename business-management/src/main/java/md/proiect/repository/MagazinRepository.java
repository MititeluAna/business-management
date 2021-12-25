package md.proiect.repository;

import md.proiect.entity.Clienti;
import md.proiect.entity.Magazin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MagazinRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Magazin> findAll(){
        List<Magazin> magazinList = jdbcTemplate.query("SELECT * FROM magazin",
                (response, rowNumber) -> {
                    return new Magazin(
                            response.getInt("id"),
                            response.getString("nume"),
                            response.getString("oras"),
                            response.getInt("nr_magazine_secundare"),
                            response.getBoolean("rangul_inalt"));
                });
        return magazinList;
    }

    public Magazin findById(Integer id){
        Magazin magazin = jdbcTemplate.queryForObject("SELECT * FROM magazin WHERE id = ?", new Object[]{id},
                (response, rowNumber) -> {
                    return new Magazin(
                            response.getInt("id"),
                            response.getString("nume"),
                            response.getString("oras"),
                            response.getInt("nr_magazine_secundare"),
                            response.getBoolean("rangul_inalt"));
                });
        return magazin;
    }

    public List<Magazin> findBetweenNrMagazineSecundare(int minNrMagazineSecundare, int maxNrMagazineSecundare){
        List<Magazin> magazinList =
                jdbcTemplate.query("select * from magazin where nr_magazine_secundare between ? AND ?",new Object[]{minNrMagazineSecundare, maxNrMagazineSecundare},
                        (response, rowNumber) -> {
                            return new Magazin(
                                    response.getInt("id"),
                                    response.getString("nume"),
                                    response.getString("oras"),
                                    response.getInt("nr_magazine_secundare"),
                                    response.getBoolean("rangul_inalt"));
                        });
        return magazinList;
    }

    public void save(Magazin magazin){
        jdbcTemplate.update(
                "insert into magazin(id, nume, oras, nr_magazine_secundare, rangul_inalt) values (?,?,?,?,?)",
                magazin.getId(),magazin.getNume(), magazin.getOras(),magazin.getNrMagazineSecundare(),magazin.isRangInalt());
    }

    public void update(Integer id, Magazin magazin){
        jdbcTemplate.update(
                "UPDATE magazin SET nume = ?, oras = ?, nr_magazine_secundare = ?,rangul_inalt = ? WHERE id = ?",
                magazin.getNume(), magazin.getOras(),magazin.getNrMagazineSecundare(),magazin.isRangInalt(), id);
    }

    public void delete(Integer id){
        jdbcTemplate.update(
                "DELETE FROM magazin WHERE id = ?", id);
    }

}
