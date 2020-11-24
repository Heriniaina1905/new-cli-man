package tv.nosy.climan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tv.nosy.climan.dao.ClientRepository;
import tv.nosy.climan.entities.Client;

@RestController
public class ClientRestService {
    @Autowired
    private ClientRepository clirep;

    @RequestMapping(value = "/save-client", method = RequestMethod.GET)
    public Client save(Client c){
        return clirep.save(c);
    }

    @RequestMapping(value = "/liste-client", method = RequestMethod.GET)
    public Page<Client> listClient(int page, int size){
        return clirep.findAll(PageRequest.of(page, size));
    }
}
