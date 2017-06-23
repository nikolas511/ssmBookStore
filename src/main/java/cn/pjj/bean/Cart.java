package cn.pjj.bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Cart {
    private HashMap<String,CartItem> map = new LinkedHashMap<String,CartItem>();
    private double totalprice;
    public void add(Book book){
        CartItem cartItem = map.get(book.getId());
        if(cartItem==null){
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setNumber(1);
            cartItem.setPrice(Double.parseDouble(book.getPrice()));
            map.put(book.getId(),cartItem);
        }else{
            cartItem.setNumber(cartItem.getNumber()+1);
        }
    }

    public HashMap<String, CartItem> getMap() {
        return map;
    }

    public void setMap(HashMap<String, CartItem> map) {
        this.map = map;
    }

    public double getTotalprice() {
        double temp = 0;
        for (Map.Entry<String, CartItem> cartItemEntry : map.entrySet()) {
            CartItem item = cartItemEntry.getValue();
            temp = temp + item.getNumber() * item.getPrice();
        }
        this.totalprice = temp;
        return totalprice;
    }
}
