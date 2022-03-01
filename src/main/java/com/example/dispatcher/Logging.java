package com.example.dispatcher;

import com.example.dispatcher.models.DroneLog;
import com.example.dispatcher.models.Drones;
import com.example.dispatcher.repository.DroneLogRepository;
import com.example.dispatcher.repository.DronesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Component
public class Logging {

    private static final Logger log = LoggerFactory.getLogger(Logging.class);

    @Autowired
    private ApplicationContext context;

    @Scheduled(fixedRate = 10000)
    public void logBatteryLevels() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String dateTime = simpleDateFormat.format(date);

        DronesRepository dronesRepository = context.getBean(DronesRepository.class);
        DroneLogRepository droneLogRepository = context.getBean(DroneLogRepository.class);
        Iterable<Drones> dronesIterable = dronesRepository.findAll();
        Iterator<Drones> dronesIterator = dronesIterable.iterator();
        while (dronesIterator.hasNext()) {
            Drones drone = dronesIterator.next();
            String log = "Battery Level for " + drone.getDroneSerial() + " at " + drone.getDroneBatteryCapacity() + "%";
            String meta = "";
            DroneLog droneLog = new DroneLog(dateTime, drone.getId(), drone.getDroneSerial(), drone.getDroneModel(), drone.getDroneBatteryCapacity(), log, meta);
            droneLogRepository.save(droneLog);
        }
    }

}
