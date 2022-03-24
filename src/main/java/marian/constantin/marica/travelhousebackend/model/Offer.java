package marian.constantin.marica.travelhousebackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double pricePerNight;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private OfferType offerType;

    @OneToMany(mappedBy = "offer")
    private Set<OfferImage> images;
}
