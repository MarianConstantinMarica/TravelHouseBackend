package marian.constantin.marica.travelhousebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 8)
    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "user")
    private Set<OfferReview> offerReviews;

    @OneToMany(mappedBy = "owner")
    private Set<TouristReview> touristReviewsOwner;

    @OneToMany(mappedBy = "tourist")
    private Set<TouristReview> touristReviewsTourist;
}
