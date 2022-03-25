package marian.constantin.marica.travelhousebackend.service.offer;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.repository.OfferImageRepository;
import marian.constantin.marica.travelhousebackend.repository.OfferRepository;
import marian.constantin.marica.travelhousebackend.request.offer.DeleteOfferRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdateDescriptionRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdatePriceRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdateTitleRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OfferImageRepository offerImageRepository;

    public OfferServiceImpl(OfferRepository offerRepository, OfferImageRepository offerImageRepository) {
        this.offerRepository = offerRepository;
        this.offerImageRepository = offerImageRepository;
    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    @Override
    public void createOffer(Offer offer) {
        offerRepository.save(offer);
    }

    @Transactional
    @Override
    public boolean updateOfferByTitle(UpdateTitleRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerRepository.updateTitle(
                request.getOfferId(),
                request.getTitle()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean updateOfferByPrice(UpdatePriceRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerRepository.updatePrice(
                request.getOfferId(),
                request.getPrice()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean updateOfferByDescription(UpdateDescriptionRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerRepository.updateDescription(
                request.getOfferId(),
                request.getDescription()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean deleteOffer(DeleteOfferRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerRepository.deleteOfferById(request.getOfferId());
        return true;
    }
}
