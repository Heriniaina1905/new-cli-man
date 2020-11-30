package tv.nosy.climan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.HistoryAbonnementRepository;
import tv.nosy.climan.entities.HistoryAbonnement;

@RestController
@RequestMapping(value = "/history")
public class HistoryAbonnementRestServices {
    
    @Autowired
    private HistoryAbonnementRepository historyAbonnementRepository;

    @GetMapping(value = "save-history")
    public HistoryAbonnement save(HistoryAbonnement ha){
        return historyAbonnementRepository.save(ha);
    }

    @GetMapping(value = "delete-all")
    public void deleteAll(){
        historyAbonnementRepository.deleteAll();
    }

    @PostMapping(value = "delete")
    public void delete(@RequestBody Long ref){
        historyAbonnementRepository.deleteById(ref);
    }
}
