package marian.constantin.marica.travelhousebackend.service.offer;

import marian.constantin.marica.travelhousebackend.repository.OfferImageRepository;
import marian.constantin.marica.travelhousebackend.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OfferImageRepository offerImageRepository;

    public OfferServiceImpl(OfferRepository offerRepository, OfferImageRepository offerImageRepository) {
        this.offerRepository = offerRepository;
        this.offerImageRepository = offerImageRepository;
    }
}
