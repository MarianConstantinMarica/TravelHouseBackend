package marian.constantin.marica.travelhousebackend.service.offer;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.request.offer.DeleteOfferRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdateDescriptionRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdatePriceRequest;
import marian.constantin.marica.travelhousebackend.request.offer.UpdateTitleRequest;

import java.util.List;

public interface OfferService {
    List<Offer> getOffers();

    void createOffer(Offer offer);

    boolean updateOfferByTitle(UpdateTitleRequest request);

    boolean updateOfferByPrice(UpdatePriceRequest request);

    boolean updateOfferByDescription(UpdateDescriptionRequest request);

    boolean deleteOffer(DeleteOfferRequest request);
}
