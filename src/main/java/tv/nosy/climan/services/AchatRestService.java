package tv.nosy.climan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.AchatRepository;
import tv.nosy.climan.entities.Achat;

@RestController
@RequestMapping(value = "/achat")
public class AchatRestService {
    
    @Autowired
    private AchatRepository achatRepository;

    @RequestMapping(value = "list-all")
    public List<Achat> getAll(){
        return achatRepository.findAll();
    }

    @RequestMapping(value = "detail")
    public Achat findById(@RequestParam Long id){
        return achatRepository.getOne(id);
    }

    @RequestMapping(value = "client")
    public Achat findByClient(@RequestParam Long refCli){
        return achatRepository.findByClient(refCli);
    }

    // @RequestMapping(value = "box")
    // public Achat findByBox(@RequestParam String ref){
    //     return achatRepository.findByBox(ref);
    // }
}
