package md.proiect.controller;

import md.proiect.entity.Angajati;
import md.proiect.entity.Clienti;
import md.proiect.repository.ClientiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clienti")
public class ClientiController {

    @Autowired
    private ClientiRepository clientiRepository;

    @GetMapping
    public List<Clienti> clientiList(){
        return clientiRepository.findAll();
    }

    @GetMapping("/{idnp}")
    public Clienti clientiByIdnp(@PathVariable("idnp") String idnp){
        return clientiRepository.findByIdnp(idnp);
    }

    @GetMapping("/prenume/{prenume}")
    public Clienti clientiByPrenume(@PathVariable("prenume") String prenume){
        return clientiRepository.findByPrenume(prenume);
    }

    @GetMapping("/varsta")
    public List<Clienti> findBetweenVarsta(@RequestParam("minVarsta") int minVarsta, @RequestParam("maxVarsta") int maxVarsta){
        return clientiRepository.findBetweenVarsta(minVarsta, maxVarsta);
    }

    @PostMapping
    public void save(@RequestBody Clienti clienti){
        clientiRepository.save(clienti);
    }

    @PutMapping("/{idnp}")
    public void update(@PathVariable("idnp") String idnp, @RequestBody Clienti clienti){
        clientiRepository.update(idnp,clienti);
    }

    @DeleteMapping("/{idnp}")
    public void delete(@PathVariable("idnp") String idnp){
        clientiRepository.delete(idnp);
    }

}
