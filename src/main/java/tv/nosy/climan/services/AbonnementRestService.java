package tv.nosy.climan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.AbonnementRepository;
import tv.nosy.climan.entities.Abonnement;


@RestController
public class AbonnementRestService {
    @Autowired
    private AbonnementRepository abonnementRepository;

    @RequestMapping(value="/save-abnm", method=RequestMethod.POST)
    public Abonnement requestMethodName(@RequestBody Abonnement param) {
        return abonnementRepository.save(param);
    }

    @RequestMapping(value = "/list-abnm")
    public List<Abonnement> findAll(){
        return abonnementRepository.findAll();
    }

    @RequestMapping(value = "/info-abonnement")
    public Abonnement findOne(@RequestParam String ref){
        Optional<Abonnement> abn = abonnementRepository.findById(ref);
        return abn.get();
    }

    @RequestMapping(value = "/delete-abonnement", method = RequestMethod.POST)
    public void delete(@RequestBody Abonnement abn){
        abonnementRepository.delete(abn);
    }

    @RequestMapping(value = "/delete-abonnement", method = RequestMethod.GET)
    public void delete(String ref){
        abonnementRepository.deleteById(ref);
    }
    
}
