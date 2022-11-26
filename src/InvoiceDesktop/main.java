
package InvoiceDesktop;

import java.util.ArrayList;
import InvoiceGui.InvoiceFrame;

public class main {
	public static void main(String[] args) {

		String Header = System.getProperty("user.dir") + "\\src\\csv\\InvoiceHeader.csv";
		String Line = System.getProperty("user.dir") + "\\src\\csv\\InvoiceLine.csv";
		/// String invoice;

		ArrayList<Item> items = new ArrayList<>();
		ArrayList<Invoice> Invoices = new ArrayList<>();

		Invoice in = new Invoice();
		in.setInvoiceItems(items);
		in.setInHeader(Header);
		in.setInLine(Line);

		Invoices = in.returnAllInvoices();
		for (Invoice i : Invoices) {
			// invoice = i.toString();
			// String[] splited = invoice.split("\\\\s+");
			System.out.println(i.toString());

			items = i.getInvoiceItems();
			for (Item item : items) {
				System.out.println(/* "item name  " + */ item);

			}
			System.out.println("***************************************" + "****************************************"
					+ "*************************************");
		}

		InvoiceFrame JF = new InvoiceFrame();
		JF.LaunchJFrame();

	}

}
