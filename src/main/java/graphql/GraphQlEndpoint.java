package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet("/GraphQl") //Pour dire que l'app se pose sur un servelet
//Classe de config du projet
public class GraphQlEndpoint extends SimpleGraphQLServlet {


        public GraphQlEndpoint(){
            super(buildSchema());
        }

        private static GraphQLSchema buildSchema() {
            RendezVousRepository r = new RendezVousRepository();
            LogementRepository l = new LogementRepository();
            return SchemaParser.newParser()
                    .file("scheme.graphql")
                    .resolvers( new Querries(r,l),(new Mutations(r,l)))
                    .build()
                    .makeExecutableSchema();
        }
}

