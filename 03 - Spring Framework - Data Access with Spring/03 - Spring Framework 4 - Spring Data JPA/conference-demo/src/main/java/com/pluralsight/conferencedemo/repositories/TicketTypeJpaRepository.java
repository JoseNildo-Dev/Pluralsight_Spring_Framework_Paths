package com.pluralsight.conferencedemo.repositories;

import com.pluralsight.conferencedemo.models.TicketPrice;
import com.pluralsight.conferencedemo.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, Long> {

    @Query("select tp from TicketPrice tp where tp.basePrice > ?1" + "and tp.ticketType.includesWorkshop = true")
    List<TicketType> findByIncludesWorkshopTrue(BigDecimal maxPrice);

    List<TicketPrice> nameFindTicketsByPricingCategoryName(@Param("name") String name);

    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}












