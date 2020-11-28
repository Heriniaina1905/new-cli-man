package tv.nosy.climan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.BoxRepository;
import tv.nosy.climan.entities.Box;


@RestController
public class BoxRestService {
    @Autowired
    private BoxRepository boxRepository;

    @RequestMapping(value = "/list-box")
    public List<Box> findAll(){
        return boxRepository.findAll();
    }

    @RequestMapping(value = "/save-box", method = RequestMethod.POST)
    public Box save(@RequestBody Box b){
        return boxRepository.save(b);
    }

    public Box info(String ref){
        Box res = boxRepository.getOne(ref);
        return res;
    }

    @RequestMapping(value="/delete-box", method=RequestMethod.GET)
    public void delete(String ref) {
        boxRepository.deleteById(ref);
    }
    
    @RequestMapping(value="/delete-box", method=RequestMethod.POST)
    public void delete(@RequestBody Box param) {
        boxRepository.delete(param);
    }
}
