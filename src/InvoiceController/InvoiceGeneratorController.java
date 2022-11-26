
package InvoiceController;

import java.io.File;
import java.util.ArrayList;

import InvoiceDesktop.Item;
import InvoiceDesktop.Invoice;

public class InvoiceGeneratorController {
	Invoice in = new Invoice();
	Item item = new Item();
	File Header = new File("/");
	File Line = new File("/");
	ArrayList<Invoice> Invoices = new ArrayList<>();
	ArrayList<ArrayList<Item>> Items = new ArrayList<>();

	public Object[][] showInvoices(String header, String line) {

		try {

			in.setInHeader(header);
			in.setInLine(line);
			Invoices = in.returnAllInvoices();
			for (Invoice x : Invoices) {
				Items.add(x.getInvoiceItems());
			}
			Object[][] arr = new Object[Invoices.size()][4];

			System.out.println(Invoices.size());

			for (int i = 0; i < Invoices.size(); i++) {

				arr[i][0] = String.valueOf(Invoices.get(i).getInvoiceNO());

				arr[i][1] = String.valueOf(Invoices.get(i).getDate());
				arr[i][2] = String.valueOf(Invoices.get(i).getClientName());
				arr[i][3] = String.valueOf(Invoices.get(i).getItemsTotalPrice());

			}
			return arr;
		} catch (Exception e) {
			System.out.println("some invoices has no items yet");
			System.out.println(e.getMessage());

		}
		return null;
	}

	public Object[][] selectedInvoiceItems(int index) {

		try {
			Object[][] rowData = new Object[Items.get(index).size()][4];
			for (int i = 0; i < Items.get(index).size(); i++) {
				rowData[i][0] = String.valueOf(Items.get(index).get(i).getItemName());
				rowData[i][1] = String.valueOf(Items.get(index).get(i).getItemPrice());
				rowData[i][2] = String.valueOf(Items.get(index).get(i).getItemCount());
				rowData[i][3] = String.valueOf(Items.get(index).get(i).calTotalItemPrice());

			}
			return rowData;
		} catch (Exception e) {
			System.out.println("invoice has no added items yet");
		}
		return null;
	}

	public Object[] createInvoice(String date, String clientName) {
		ArrayList<Item> items = new ArrayList<>();
		int size = Invoices.size() + 1;
		Invoice In = new Invoice(size, date, clientName);
		In.setInvoiceItems(items);
		Invoices.add(In);
		Items.add(items);

		Object[] rowData = new Object[4];

		rowData[0] = String.valueOf(In.getInvoiceNO());
		rowData[1] = String.valueOf(In.getDate());
		rowData[2] = String.valueOf(In.getClientName());
		rowData[3] = String.valueOf(In.getItemsTotalPrice());

		return rowData;
	}

	public Object[] createInvoiceItem(int index, String itemName, String itemPrice, String itemCount) {
		int count = Integer.parseInt(itemCount);
		double price = Double.parseDouble(itemPrice);
		Item it = new Item(itemName, price, count, Invoices.get(index));
		Items.get(index).add(it);

		Object[] rowData = new Object[4];

		rowData[0] = String.valueOf(it.getItemName());
		rowData[1] = String.valueOf(it.getItemPrice());
		rowData[2] = String.valueOf(it.getItemCount());
		rowData[3] = String.valueOf(it.calTotalItemPrice());

		return rowData;
	}

	public String updateInvoicePrice(int index) {
		String pr = String.valueOf(Invoices.get(index).getItemsTotalPrice());
		return pr;
	}

	public void deleteInvoice(int index) {

		Invoices.remove(index);
		Items.remove(index);
	}

	public void deleteInvoiceItem(int index1, int index2) {
		Items.get(index1).remove(index2);
	}

	public void saveFile() {
		item.setInvoice(in);
		in.saveInvoiceToFile(Invoices);
		ArrayList<Item> items = new ArrayList<>();
		for (ArrayList<Item> item : Items) {
			for (Item x : item) {
				items.add(x);
			}
		}
		item.saveItemsToFile(items);
	}

}
