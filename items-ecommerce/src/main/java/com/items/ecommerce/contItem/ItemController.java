package com.items.ecommerce.contItem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping("/hello")
    public String getGreeting()
    {
        return " hello obagaji";
    }
}
