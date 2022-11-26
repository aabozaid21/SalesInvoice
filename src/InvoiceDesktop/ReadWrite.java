package InvoiceDesktop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {

    public boolean write(String data, String filePath) {

        File file = new File(filePath);


        try {
            if (!file.exists())
                file.createNewFile();
            BufferedWriter  csvWriter = new BufferedWriter(new FileWriter(filePath, true) );
            csvWriter.write(data);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return false;
    }

    public void clearTheFile(String filePath)  {
        try{ BufferedWriter pwOb = new BufferedWriter(new FileWriter(filePath, false));
            pwOb.flush();
            pwOb.close();}
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    public ArrayList<Invoice> read(String header ,String line) {

        try {
            ArrayList<Invoice> invoices = new ArrayList<>();


            Scanner  csvReader = new Scanner(new File(header));


            while (csvReader.hasNext() ) {
                Invoice invoice =null;

                invoice = new Invoice();
                String Line = csvReader.nextLine();
                String[] seprated = Line.split(",");
                invoice.setInvoiceNO(Integer.parseInt(seprated[0]));

                invoice.setDate(seprated[1]);
                invoice.setClientName(seprated[2]);
                Scanner  reader = new Scanner(new File(line));

                ArrayList<Item> items =new ArrayList<>();

                while (reader.hasNext()){

                    Item item = null;

                    item =new Item();
                    String itemLine = reader.nextLine();
                    String[] separator = itemLine.split(",");
                    if(seprated[0].equals(separator[0])){

                        item.setItemName(separator[1]);
                        item.setItemPrice(Double.parseDouble(separator[2]));
                        item.setItemCount(Integer.parseInt(separator[3]));
                        item.setInvoice(invoice);
                        items.add(item);
                    }
                }
                reader.close();
                invoice.setInvoiceItems(items);
                invoices.add(invoice);
            }
            csvReader.close();
            return  invoices;


        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}