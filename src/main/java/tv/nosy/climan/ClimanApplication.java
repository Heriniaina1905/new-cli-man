package tv.nosy.climan;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tv.nosy.climan.dao.ClientRepository;
import tv.nosy.climan.entities.Client;

@SpringBootApplication
public class ClimanApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClimanApplication.class, args);
		ClientRepository clirep = context.getBean(ClientRepository.class);
		// clirep.save(new Client("Jean", "+261 34 00 000 00", "jean@jean.jean", "101 000 000 000"));
		// clirep.save(new Client("Jeanne", "+261 34 00 000 01", "jeanne@jean.jean", "101 000 000 001"));
		// clirep.save(new Client("Jeannette", "+261 34 00 000 02", "jeannette@jean.jean", "101 000 000 002"));
		// clirep.save(new Client("Jeannot", "+261 34 00 000 03", "jeannot@jean.jean", "101 000 000 003"));

		List<Client> clients = clirep.findAll();

		clients.forEach(c->System.out.println(c.getNom()));
	}

}
