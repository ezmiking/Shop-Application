package dataBase;

import java.io.Serializable;

public class Good implements Serializable {
    private int codeGood;
    private int priceGood;
    private String nameGood;
    private String companyName;
    private int inventoryGood;
    private int discountGood;
    private int pointGood;
    private String imageAddressGood;

    public Good(String nameGood,int priceGood, String companyName, int inventoryGood, int discountGood, int pointGood, String imageAddressGood){
        setNameGood(nameGood);
        setCompanyName(companyName);
        setPriceGood(priceGood);
        setInventoryGood(inventoryGood);
        setDiscountGood(discountGood);
        setPointGood(pointGood);
        setImageAddressGood(imageAddressGood);
    }

    public Good(String nameGood){
        setNameGood(nameGood);
    }

    public void setCodeGood(int codeGood){
        this.codeGood=codeGood;
    }
    public int getCodeGood(){
        return codeGood;
    }

    public int getPointGood() {
        return pointGood;
    }

    public void setPointGood(int pointGood) {
        this.pointGood = pointGood;
    }

    public int getPriceGood() {
        return priceGood;
    }

    public void setPriceGood(int priceGood) {
        this.priceGood = priceGood;
    }

    public String getNameGood() {
        return nameGood;
    }

    public void setNameGood(String nameGood) {
        this.nameGood = nameGood;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getInventoryGood() {
        return inventoryGood;
    }

    public void setInventoryGood(int inventoryGood) {
        this.inventoryGood = inventoryGood;
    }

    public int getDiscountGood() {
        return discountGood;
    }

    public void setDiscountGood(int discountGood) {
        this.discountGood = discountGood;
    }

    public String getImageAddressGood() {
        return imageAddressGood;
    }

    public void setImageAddressGood(String imageAddressGood) {
        this.imageAddressGood = imageAddressGood;
    }

    @Override
    public boolean equals(Object obj){
        Good other =(Good) obj;
        return this.getNameGood().equals(other.getNameGood());
    }

}

