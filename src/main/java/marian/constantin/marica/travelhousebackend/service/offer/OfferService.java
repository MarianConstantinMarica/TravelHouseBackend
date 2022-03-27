package marian.constantin.marica.travelhousebackend.service.offer;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.request.offer.*;

import java.util.List;

public interface OfferService {
    List<Offer> getOffers();

    void createOffer(CreateOfferRequest offer);

    boolean updateOfferByTitle(UpdateTitleRequest request);

    boolean updateOfferByPrice(UpdatePriceRequest request);

    boolean updateOfferByDescription(UpdateDescriptionRequest request);

    boolean updateOfferByType(UpdateOfferTypeRequest request);

    boolean deleteOffer(DeleteOfferRequest request);
}
