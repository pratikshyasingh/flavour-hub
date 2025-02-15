package edu.rims.flavour_hub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag extends Auditable {

    @Id
    @Column(name = "tag_id", length = 255, nullable = false)
    private String tagId;

    @Column(name = "tag_name", length = 100, nullable = false)
    private String tagName;

    @Column(name = "tag_description", columnDefinition = "TEXT")
    private String tagDescription;
}
