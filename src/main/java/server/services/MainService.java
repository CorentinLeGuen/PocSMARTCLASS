package server.services;

import server.entities.IotEntity;
import server.manager.IotManager;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.Timestamp;
import java.util.Calendar;

// Service de poc : stockage d'informations en provenance d'un iot
@WebService
public class MainService {

    @WebMethod
    public String saveIotInformations(int reference, int value) {
        // Génération du timestamp coté serveur
        Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        // Génération de l'entity coté serveur
        IotEntity entity = new IotEntity();
        entity.setDate(timestamp);
        entity.setReference(reference);
        entity.setValue(value);

        // Tentative de persistence de l'info
        try {

            IotManager.saveIotEntity(entity);

        } catch (Exception e) {

            return e.getMessage();
        }

        return "L'objet (" + reference + ") a sauvegardé la valeur " + value + "." ;
    }
}
