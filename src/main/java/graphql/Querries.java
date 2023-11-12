package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {

    public RendezVousRepository rendezVousRepository;
    public LogementRepository logementRepository;

    public Querries(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public List<RendezVous> getRdvList(){
        return rendezVousRepository.getListeRendezVous();
    }


    public List<Logement> getLogement(){return logementRepository.getAllLogements();}
    public RendezVous getRendezVousById(int id){
        return rendezVousRepository.getRdvById(id);
    }


}
