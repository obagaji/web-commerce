package com.items.ecommerce.itemService;


import com.items.ecommerce.ItemException.ItemNotFound;
import com.items.ecommerce.modelItem.Carts;
import com.items.ecommerce.modelItem.Item;
import com.items.ecommerce.repositItem.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final RestClient restClient;
    private final Logger LOG = LoggerFactory.getLogger(ItemService.class);

    public Item saveItem(Item items)
    {
        CompletableFuture<Item> saveitems = new CompletableFuture<>();
        saveitems.completeAsync(()->{
         return    itemRepository.save(items);
        });
        return saveitems.join();
    }
    public Item getItem(Long itemId)
    {
        CompletableFuture<Item>getItems= new CompletableFuture<>();
        getItems.completeAsync(()->{
            return itemRepository.findById(itemId).orElseThrow(ItemNotFound::new);
        });
        return getItems.join();
    }
    public void updateItem(Long itemId, double price)
    {
        Optional<Item> newItem = itemRepository.findById(itemId);
        if(newItem.isPresent())
        {
            Item item = newItem.get();
            item.setPrice(price);
            itemRepository.save(item);
        }
    }
    public void addItemToCart(Long itemId, int qty)
    {
        Item item = getItem(itemId);
        Carts carts = new Carts(item.getItemId(),item.getPrice(), qty);
      //  restClient.post().

    }


}
