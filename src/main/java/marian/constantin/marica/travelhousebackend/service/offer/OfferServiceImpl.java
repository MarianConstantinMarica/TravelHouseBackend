package marian.constantin.marica.travelhousebackend.service.offer;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.model.OfferType;
import marian.constantin.marica.travelhousebackend.repository.OfferImageRepository;
import marian.constantin.marica.travelhousebackend.repository.OfferRepository;
import marian.constantin.marica.travelhousebackend.request.offer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final OfferImageRepository offerImageRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, OfferImageRepository offerImageRepository) {
        this.offerRepository = offerRepository;
        this.offerImageRepository = offerImageRepository;
    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    @Override
    public void createOffer(CreateOfferRequest request) {
        request.getOffer().setOfferType(OfferType.Copper);
        offerRepository.save(request.getOffer());
        request.getOfferImages()
                .forEach(offerImage -> offerImage.setOffer(request.getOffer()));
        offerImageRepository.saveAll(request.getOfferImages());
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
    public boolean updateOfferByType(UpdateOfferTypeRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerRepository.updateOfferType(
                request.getOfferId(),
                request.getOfferType()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean deleteOffer(DeleteOfferRequest request) {
        if (!offerRepository.existsById(request.getOfferId())) {
            return false;
        }
        offerImageRepository.deleteAllByOfferId(request.getOfferId());
        offerRepository.deleteOfferById(request.getOfferId());
        return true;
    }
}
