package md.proiect.controller;

import md.proiect.entity.Angajati;
import md.proiect.entity.Magazin;
import md.proiect.repository.MagazinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magazin")
public class MagazinController {

    @Autowired
    private MagazinRepository magazinRepository;

    @GetMapping
    public List<Magazin> magazinList(){
        return magazinRepository.findAll();
    }

    @GetMapping("/{id}")
    public Magazin magazinById(@PathVariable("id") Integer id){
        return magazinRepository.findById(id);
    }

    @GetMapping("/")
    public List<Magazin> findBetweenNrMagazineSecundare(@RequestParam("minNrMagazineSecundare") int minNrMagazineSecundare, @RequestParam("maxNrMagazineSecundare") int maxNrMagazineSecundare){
        return magazinRepository.findBetweenNrMagazineSecundare(minNrMagazineSecundare, maxNrMagazineSecundare);
    }

    @PostMapping
    public void save(@RequestBody Magazin magazin){
        magazinRepository.save(magazin);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Magazin magazin){
        magazinRepository.update(id,magazin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        magazinRepository.delete(id);
    }
}
