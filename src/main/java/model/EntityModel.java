package model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class EntityModel implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private Long id;

    @Version
    @Column(name = "C_VERSION")
    private Long version;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }
}
