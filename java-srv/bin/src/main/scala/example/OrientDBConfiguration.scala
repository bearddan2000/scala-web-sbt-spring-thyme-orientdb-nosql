package example;

import com.orientechnologies.orient.core.db._;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Basic OrientDB configuration class
 * To configure and provide the bean to inject later for database interactions
 * @author dassiorleando
 */
@Configuration
class OrientDBConfiguration {
    @Bean
    def orientDBfactory(): ODatabaseDocumentTx = {
      val orient = new OrientDB("plocal:db", OrientDBConfig.defaultConfig());
      orient.create("animal", ODatabaseType.PLOCAL);
      orient.close();
        return new ODatabaseDocumentTx("plocal:db/animal")
                .open("admin", "admin");
    }

}
