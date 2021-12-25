package md.proiect.controller;

import md.proiect.entity.Angajati;
import md.proiect.entity.AngajatiDetaliat;
import md.proiect.entity.AngajatiList;
import md.proiect.repository.AngajatiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/angajati")
public class AngajatiController {

    @Autowired
    private AngajatiRepository angajatiRepository;

    /*
CRUD

GET/angajati(lista de angajati) afiseaza
GET/angajati/{idnp}
GET/angajati/prenume/{prenume}
POST/angajati  creaza
PUT/angajati/{idnp} modifica un angajat dupa key
DELETE/angajati/{idnp} sterge

     */


    @GetMapping
    public List<Angajati> angajatiList(){
           return angajatiRepository.findAll();
    }


    @GetMapping("/test")
    public String test(@RequestParam("nume")String nume,@RequestParam("prenume")String prenume){
        return nume + "---" + prenume;
    }

   /* @GetMapping
    public List<AngajatiList> findAll(){
        return angajatiRepository.findAll();
    }
  */
   @GetMapping("/magazin/{nume}")
    public List<AngajatiList> findByMagazinNume(@PathVariable("nume") String nume){
        return angajatiRepository.findByMagazinNume(nume);
    }

    @GetMapping("/salariu")
    public List<Angajati> findBetweenSalariu(@RequestParam("minSalariu") int minSalariu, @RequestParam("maxSalariu") int maxSalariu){
        return angajatiRepository.findBetweenSalariu(minSalariu, maxSalariu);
    }

    @GetMapping("/{idnp}")
    public AngajatiDetaliat findByIdnp(@PathVariable("idnp") String idnp){
       return angajatiRepository.findByIdnp(idnp);
    }

    @GetMapping("/prenume/{prenume}")
    public Angajati findByPrenume(@PathVariable("prenume") String prenume){
        return angajatiRepository.findByPrenume(prenume);
    }

    @PostMapping
    public void save(@RequestBody Angajati angajati){
        angajatiRepository.save(angajati);
    }

    @PutMapping("/{idnp}")
    public void update(@PathVariable("idnp") String idnp, @RequestBody Angajati angajati){
        angajatiRepository.update(idnp,angajati);
    }

    @DeleteMapping("/{idnp}")
    public void delete(@PathVariable("idnp") String idnp){
        angajatiRepository.delete(idnp);
    }
}
