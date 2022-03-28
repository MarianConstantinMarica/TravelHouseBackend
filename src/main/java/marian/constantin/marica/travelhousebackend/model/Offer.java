package marian.constantin.marica.travelhousebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @JsonIgnore
    @Column(nullable = false)
    private OfferType offerType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @OneToMany(mappedBy = "offer")
    private Set<OfferImage> images;

    @OneToMany(mappedBy = "offer")
    private Set<OfferReview> reviews;

    @OneToMany(mappedBy = "offer")
    private Set<Booking> bookings;
}
