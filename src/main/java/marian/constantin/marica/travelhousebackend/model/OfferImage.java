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
public class OfferImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Lob
    @Column(nullable = false, columnDefinition = "BLOB")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Offer offer;
}
