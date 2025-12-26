package com.items.ecommerce.repositItem;

import com.items.ecommerce.modelItem.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    //@Query("select i from item where i.itemId=: itemName")
    Optional<Item> findByItemName(String itemName);
    @Query("select i from item i where i.currentLocation=: currentLocation")
    List<Item> findAllItemWithLocation(@Param("currentLocation")String currentLocation);
    @Query("select SUM(price)from item")
    Double getMaximumTotal();

}
