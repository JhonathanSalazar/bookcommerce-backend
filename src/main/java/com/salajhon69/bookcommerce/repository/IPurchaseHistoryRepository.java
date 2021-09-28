package com.salajhon69.bookcommerce.repository;

import com.salajhon69.bookcommerce.model.PurchaseHistory;
import com.salajhon69.bookcommerce.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select " +
            "b.title as title, ph.price as price, ph.purchaseTime as purchaseTime " +
            "from PurchaseHistory ph left join Book b on b.id = ph.bookId " +
            "where ph.userId = :userId ")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
