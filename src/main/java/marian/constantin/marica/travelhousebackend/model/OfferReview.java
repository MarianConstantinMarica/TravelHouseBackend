package marian.constantin.marica.travelhousebackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Rating rating;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Offer offer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
