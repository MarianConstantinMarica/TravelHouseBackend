package marian.constantin.marica.travelhousebackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Boolean approved;

    @Column(nullable = false)
    private Boolean cancelBooking;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User tourist;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Offer offer;
}
