package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the cart info from dto
        Cart cart = purchase.getCart();

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // generate tracking number if cart is not empty
        String orderTrackingNumber = null;

        if (cartItems.isEmpty()) {
            orderTrackingNumber = "Cart Is Empty - No Purchase Made";
        }
        else if (cart.getParty_size() < 1) {
            orderTrackingNumber = "Party Size Must Be Positive - No Purchase Made";
        }
        else {
            orderTrackingNumber = generateOrderTrackingNumber();
        }
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with customer
        cart.setCustomer(purchase.getCustomer());

        //change cart status to ordered
        cart.setStatus(StatusType.ordered);

        //save to database
        cartRepository.save(cart);

        //return response
            return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
