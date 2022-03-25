package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.OfferImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferImageRepository extends JpaRepository<OfferImage, UUID> {
}
