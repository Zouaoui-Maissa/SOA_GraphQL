package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.naming.spi.Resolver;
import java.util.Date;
import java.util.List;

public class Mutations implements GraphQLRootResolver {
    public RendezVousRepository rendezVousRepository;
    public LogementRepository logementRepository;

    public Mutations(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }
        public boolean addRDV(int id, String date, String heure, int refLog, String num){
        Logement L = logementRepository.getLogementsByReference(refLog);
        RendezVous Rdv = new RendezVous(id,date,heure,L,num);
        return rendezVousRepository.addRendezVous(Rdv);
    }

    public boolean updateRDV(int id, String date, String heure,int refLog ,String num){
        Logement L=logementRepository.getLogementsByReference(id);
        RendezVous Rdv = new RendezVous(id,date,heure,L,num);
        return rendezVousRepository.updateRendezVous(Rdv);
    }
    public boolean deleteRDV(int id){
        return rendezVousRepository.deleteRendezVous(id);
    }

}
