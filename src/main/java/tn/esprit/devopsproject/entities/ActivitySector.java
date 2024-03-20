package tn.esprit.devopsproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivitySector  implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idSecteurActivite;
        String codeSecteurActivite;
        String libelleSecteurActivite;
        @ManyToMany(mappedBy="activitySectors")
        @JsonIgnore
        private Set<Supplier> suppliers;


        // Constructor with id and name
        public ActivitySector(Long idSecteurActivite, String libelleSecteurActivite) {
                this.idSecteurActivite = idSecteurActivite;
                this.libelleSecteurActivite = libelleSecteurActivite;
        }

        // Constructor with all fields except id
        public ActivitySector(String codeSecteurActivite, String libelleSecteurActivite, Set<Supplier> suppliers) {
                this.codeSecteurActivite = codeSecteurActivite;
                this.libelleSecteurActivite = libelleSecteurActivite;
                this.suppliers = suppliers;
        }


}
