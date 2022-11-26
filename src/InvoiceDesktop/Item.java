package InvoiceDesktop;

import java.util.ArrayList;

public class Item   {

    ReadWrite RW = new ReadWrite();
    public static ArrayList<Item> invoiceItems = new ArrayList<>();
    public static ArrayList<ArrayList<Item>> invoiceItemsLists = new ArrayList<>();

    public static ArrayList<Invoice> invoices = new ArrayList<>();



    private String itemName;
    private int itemCount;
    private double itemPrice;
    private Invoice invoice;
    public Item() {

    }
    public Item(String itemName,  double itemPrice,int itemCount, Invoice invoice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.invoice = invoice;
    }



    public String getItemName() {
        return itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCount(int itemNum) {
        this.itemCount = itemNum;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public double calTotalItemPrice(){
        return this.itemPrice*this.itemCount;
    }

    private String getItemData() {
        return invoice.getInvoiceNO() + "," + this.itemName + "," + this.itemPrice + "," + this.itemCount;
    }

    public void saveItemsToFile(ArrayList<Item>item) {
        invoiceItems=item;
        RW.clearTheFile(invoice.getInLine());

        for (Item invoiceItem : invoiceItems) {
            RW.write(invoiceItem.getItemData(), invoice.getInLine());
        }
    }

    @Override
    public String toString() {
        return "Item_Name "+ itemName +  " Count=" + itemCount + " Item_Price=" + itemPrice + "  Total_Price:" + calTotalItemPrice() +"\n" ;
    }

}