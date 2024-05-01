package products;

import discount.FreeDiscountable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements FreeDiscountable {
    private int promoQuantity;
    private int freeQuantity;
    public FreeDiscountProduct(String name, int price, int promoQ, int freeQ) {
        super(name, price);
        setPromoQuantity(promoQ);
        setFreeQuantity(freeQ);
    }

    public int calcFreeDiscountPieces(int totalQuantityBought) {
        return ShopUtil.calculateFreeDiscountPieces(getFreeQuantity(), getPromoQuantity(), totalQuantityBought);
    }

    @Override
    public int calculateDiscount(int quantity) {;
        int discount = calcFreeDiscountPieces(quantity) * getPrice();
        return discount;
    }

    @Override
    public String toString() {
        return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
    }

    public int getPromoQuantity() {
        return promoQuantity;
    }

    public void setPromoQuantity(int promoQuantity) {
        if (promoQuantity < 1) promoQuantity = 1;
        this.promoQuantity = promoQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(int freeQuantity) {
        if (freeQuantity < 1) freeQuantity = 1;
        this.freeQuantity = freeQuantity;
    }
}
