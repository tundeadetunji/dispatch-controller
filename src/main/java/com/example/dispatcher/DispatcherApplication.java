package com.example.dispatcher;

import com.example.dispatcher.models.AvailableDrones;
import com.example.dispatcher.models.Medication;
import com.example.dispatcher.repository.AvailableDronesRepository;
import com.example.dispatcher.repository.DronesRepository;
import com.example.dispatcher.repository.MedicationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.dispatcher.models.Drones;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DispatcherApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(DispatcherApplication.class, args);

		//insert records
		DronesRepository dronesRepository = configurableApplicationContext.getBean(DronesRepository.class);
		Drones Drones1 = new Drones("DRONE01", "Lightweight", 100, "IDLE");
		dronesRepository.save(Drones1);
		Drones Drones2 = new Drones("DRONE02", "Lightweight", 100, "IDLE");
		dronesRepository.save(Drones2);
		Drones Drones3 = new Drones("DRONE03", "Lightweight", 100, "IDLE");
		dronesRepository.save(Drones3);
		Drones Drones4 = new Drones("DRONE04", "Middleweight", 100, "IDLE");
		dronesRepository.save(Drones4);
		Drones Drones5 = new Drones("DRONE05", "Middleweight", 100, "IDLE");
		dronesRepository.save(Drones5);
		Drones Drones6 = new Drones("DRONE06", "Middleweight",100, "IDLE");
		dronesRepository.save(Drones6);
		Drones Drones7 = new Drones("DRONE07", "Cruiserweight",  100, "IDLE");
		dronesRepository.save(Drones7);
		Drones Drones8 = new Drones("DRONE08", "Cruiserweight",  100, "IDLE");
		dronesRepository.save(Drones8);
		Drones Drones9 = new Drones("DRONE09", "Heavyweight",  100, "IDLE");
		dronesRepository.save(Drones9);
		Drones Drones10 = new Drones("DRONE10", "Heavyweight",  100, "IDLE");
		dronesRepository.save(Drones10);

		AvailableDronesRepository availableDronesRepository = configurableApplicationContext.getBean(AvailableDronesRepository.class);
		AvailableDrones availableDrones1 = new AvailableDrones("DRONE01", "Lightweight");
		availableDronesRepository.save(availableDrones1);
		AvailableDrones availableDrones2 = new AvailableDrones("DRONE02", "Lightweight");
		availableDronesRepository.save(availableDrones2);
		AvailableDrones availableDrones3 = new AvailableDrones("DRONE03", "Lightweight");
		availableDronesRepository.save(availableDrones3);
		AvailableDrones availableDrones4 = new AvailableDrones("DRONE04", "Middleweight");
		availableDronesRepository.save(availableDrones4);
		AvailableDrones availableDrones5 = new AvailableDrones("DRONE05", "Middleweight");
		availableDronesRepository.save(availableDrones5);
		AvailableDrones availableDrones6 = new AvailableDrones("DRONE06", "Middleweight");
		availableDronesRepository.save(availableDrones6);
		AvailableDrones availableDrones7 = new AvailableDrones("DRONE07", "Cruiserweight");
		availableDronesRepository.save(availableDrones7);
		AvailableDrones availableDrones8 = new AvailableDrones("DRONE08", "Cruiserweight");
		availableDronesRepository.save(availableDrones8);
		AvailableDrones availableDrones9 = new AvailableDrones("DRONE09", "Heavyweight");
		availableDronesRepository.save(availableDrones9);
		AvailableDrones availableDrones10 = new AvailableDrones("DRONE10", "Heavyweight");
		availableDronesRepository.save(availableDrones10);

		MedicationRepository medicationRepository = configurableApplicationContext.getBean(MedicationRepository.class);
		Medication medication1 = new Medication("MED01", "Med01", 500, "https://domain.com/path-to-resource-1");
		medicationRepository.save(medication1);
		Medication medication2 = new Medication("MED02", "Med02", 100, "https://domain.com/path-to-resource-2");
		medicationRepository.save(medication2);
		Medication medication3 = new Medication("MED03", "Med03", 100, "https://domain.com/path-to-resource-3");
		medicationRepository.save(medication3);
		Medication medication4 = new Medication("MED04", "Med04", 100, "https://domain.com/path-to-resource-4");
		medicationRepository.save(medication4);
		Medication medication5 = new Medication("MED05", "Med05", 100, "https://domain.com/path-to-resource-5");
		medicationRepository.save(medication5);

	}

}
