
package InvoiceGui;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import InvoiceController.InvoiceGeneratorController;

class MyCustomFilter extends javax.swing.filechooser.FileFilter {
	@Override
	public boolean accept(File file) {
		return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
	}

	@Override
	public String getDescription() {

		return "csv files (*.csv)";
	}
}

public class InvoiceFrame extends javax.swing.JFrame {
	File headerFile = new File("/");
	File headerLine = new File("/");

	InvoiceGeneratorController cr = new InvoiceGeneratorController();

	DefaultTableModel invoiceModel;
	DefaultTableModel invoiceItemModel;

	public InvoiceFrame() {
		initComponents();

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		fileChooser = new JFileChooser();
		addInvoiceDialog = new javax.swing.JDialog();
		addInvoieHeadLabel = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		submitAddingInvoice = new javax.swing.JButton();
		cancelAddInvoice = new javax.swing.JButton();
		setClientName = new javax.swing.JFormattedTextField();
		setInvoiceDate = new javax.swing.JFormattedTextField();
		addItemDialog = new javax.swing.JDialog();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		addingItem = new javax.swing.JButton();
		canelAddItem = new javax.swing.JButton();
		setItemName = new javax.swing.JTextField();
		setItemPrice = new javax.swing.JTextField();
		setItemCount = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		invoicesTable = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		invoiceItemsTable = new javax.swing.JTable();
		invoiceNumberLabel = new javax.swing.JLabel();
		invoiceDateLabel = new javax.swing.JLabel();
		customerNameLabel = new javax.swing.JLabel();
		invoiceTotalLabel = new javax.swing.JLabel();
		customerName = new javax.swing.JTextField();
		createInvoiceButton = new javax.swing.JButton();
		deleteInvoiceButton = new javax.swing.JButton();
		addItemButton = new javax.swing.JButton();
		deleteItemButton = new javax.swing.JButton();
		invoiceNumber = new javax.swing.JTextField();
		invoiceTotalPrice = new javax.swing.JTextField();
		invoiceDate = new javax.swing.JFormattedTextField();
		jMenuBar1 = new javax.swing.JMenuBar();
		loadFile = new javax.swing.JMenu();
		load = new javax.swing.JMenuItem();
		saveFile = new javax.swing.JMenuItem();

		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "\\src\\csv\\"));
		fileChooser.setDialogTitle("enter specified  csv files");
		fileChooser.setFileFilter(new MyCustomFilter());

		addInvoiceDialog.setBounds(new java.awt.Rectangle(0, 0, 300, 300));
		addInvoiceDialog.setSize(new java.awt.Dimension(500, 400));

		addInvoieHeadLabel.setText("enter data for the new invoice");

		jLabel2.setText("enter invoice date (d/m/yyyy)");

		jLabel3.setText("enter client name");

		submitAddingInvoice.setText("submit");
		submitAddingInvoice.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitAddingInvoiceActionPerformed(evt);
			}
		});

		cancelAddInvoice.setText("cancel");
		cancelAddInvoice.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelAddInvoiceActionPerformed(evt);
			}
		});

		try {
			setClientName.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
					new javax.swing.text.MaskFormatter("****************************")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		setClientName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				setClientNameKeyPressed(evt);
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				setClientNameKeyReleased(evt);
			}

			@Override
			public void keyTyped(KeyEvent evt) {
				setClientNameKeyTyped(evt);
			}
		});

		setInvoiceDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yyyy"))));
		setInvoiceDate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setInvoiceDateActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout addInvoiceDialogLayout = new javax.swing.GroupLayout(addInvoiceDialog.getContentPane());
		addInvoiceDialog.getContentPane().setLayout(addInvoiceDialogLayout);
		addInvoiceDialogLayout.setHorizontalGroup(
				addInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(addInvoiceDialogLayout.createSequentialGroup().addGap(74, 74, 74)
								.addGroup(addInvoiceDialogLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(addInvoiceDialogLayout.createSequentialGroup()
												.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(78, 78, 78))
										.addGroup(addInvoiceDialogLayout.createSequentialGroup()
												.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(18, 18, 18)))
								.addGroup(addInvoiceDialogLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(setClientName, javax.swing.GroupLayout.DEFAULT_SIZE, 156,
												Short.MAX_VALUE)
										.addComponent(setInvoiceDate))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								addInvoiceDialogLayout
										.createSequentialGroup().addGap(97, 97, 97).addComponent(submitAddingInvoice)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cancelAddInvoice).addGap(109, 109, 109))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								addInvoiceDialogLayout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(addInvoieHeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(140, 140, 140)));
		addInvoiceDialogLayout.setVerticalGroup(addInvoiceDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(addInvoiceDialogLayout.createSequentialGroup().addContainerGap()
						.addComponent(addInvoieHeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(addInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(setInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addGroup(addInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3)
								.addComponent(setClientName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(61, 61, 61)
						.addGroup(addInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submitAddingInvoice).addComponent(cancelAddInvoice))
						.addContainerGap(124, Short.MAX_VALUE)));

		addItemDialog.setSize(new java.awt.Dimension(370, 350));

		jLabel4.setText("enter item name");

		jLabel5.setText("enter item price");

		jLabel6.setText("enter item count");

		addingItem.setText("create item");
		addingItem.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addingItemActionPerformed(evt);
			}
		});

		canelAddItem.setText("cancel");
		canelAddItem.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				canelAddItemActionPerformed(evt);
			}
		});

		setItemName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				setItemNameKeyTyped(evt);
			}
		});

		setItemPrice.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				setItemPriceActionPerformed(evt);
			}
		});
		setItemPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				setItemPriceKeyTyped(evt);
			}
		});

		setItemCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				setItemCountKeyTyped(evt);
			}
		});

		javax.swing.GroupLayout addItemDialogLayout = new javax.swing.GroupLayout(addItemDialog.getContentPane());
		addItemDialog.getContentPane().setLayout(addItemDialogLayout);
		addItemDialogLayout.setHorizontalGroup(addItemDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(addItemDialogLayout.createSequentialGroup().addGroup(addItemDialogLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(addItemDialogLayout.createSequentialGroup().addGap(43, 43, 43)
								.addGroup(addItemDialogLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(55, 55, 55)
								.addGroup(addItemDialogLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(setItemPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 155,
												Short.MAX_VALUE)
										.addComponent(setItemName).addComponent(setItemCount)))
						.addGroup(addItemDialogLayout.createSequentialGroup().addGap(90, 90, 90)
								.addComponent(addingItem).addGap(40, 40, 40).addComponent(canelAddItem)))
						.addContainerGap(59, Short.MAX_VALUE)));
		addItemDialogLayout.setVerticalGroup(addItemDialogLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(addItemDialogLayout.createSequentialGroup().addGap(64, 64, 64)
						.addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel4).addComponent(setItemName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5)
								.addComponent(setItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(35, 35, 35)
						.addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel6).addComponent(setItemCount,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
						.addGroup(addItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addingItem).addComponent(canelAddItem))
						.addGap(30, 30, 30)));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		invoicesTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "invoice number", "invoice date", "customer name", "total price" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				invoicesTableMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(invoicesTable);

		invoiceItemsTable.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "item name", "item price", "item count", "total price" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jScrollPane2.setViewportView(invoiceItemsTable);

		invoiceNumberLabel.setText("invoice number");

		invoiceDateLabel.setText("invoice date (dd/mm/yyyy)");

		customerNameLabel.setText("customer name");

		invoiceTotalLabel.setText("invoice total");

		customerName.setEditable(false);
		customerName.setBackground(new Color(204, 204, 204));
		customerName.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				customerNameMouseReleased(evt);
			}
		});
		customerName.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				customerNameActionPerformed(evt);
			}
		});
		customerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				customerNameKeyReleased(evt);
			}
		});

		createInvoiceButton.setText("create invoice");
		createInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				createInvoiceButtonActionPerformed(evt);
			}
		});

		deleteInvoiceButton.setText("delete invoice");
		deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteInvoiceButtonActionPerformed(evt);
			}
		});

		addItemButton.setText("create item");
		addItemButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addItemButtonActionPerformed(evt);
			}
		});

		deleteItemButton.setText("delete item");
		deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteItemButtonActionPerformed(evt);
			}
		});
		deleteItemButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				deleteItemButtonKeyReleased(evt);
			}
		});

		invoiceNumber.setEditable(false);
		invoiceNumber.setBackground(new Color(204, 204, 204));
		invoiceNumber.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				invoiceNumberActionPerformed(evt);
			}
		});

		invoiceTotalPrice.setEditable(false);
		invoiceTotalPrice.setBackground(new Color(204, 204, 204));

		invoiceDate.setEditable(false);
		invoiceDate.setBackground(new Color(204, 204, 204));
		invoiceDate.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				invoiceDateMouseReleased(evt);
			}
		});
		invoiceDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				invoiceDateKeyReleased(evt);
			}
		});

		loadFile.setText("File");
		loadFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadFileActionPerformed(evt);
			}
		});

		load.setText("load file");
		load.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadActionPerformed(evt);
			}
		});
		loadFile.add(load);

		saveFile.setText("save file");
		saveFile.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveFileActionPerformed(evt);
			}
		});
		loadFile.add(saveFile);

		jMenuBar1.add(loadFile);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(invoiceTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(customerNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(invoiceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(invoiceNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
														.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(invoiceTotalPrice,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(invoiceNumber,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(layout.createSequentialGroup().addGap(42, 42, 42)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(customerName,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(invoiceDate,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(63, 63, 63))))
				.addGroup(layout.createSequentialGroup().addGap(38, 38, 38).addComponent(createInvoiceButton)
						.addGap(71, 71, 71).addComponent(deleteInvoiceButton).addGap(129, 129, 129)
						.addComponent(addItemButton).addGap(83, 83, 83).addComponent(deleteItemButton)
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(invoiceNumberLabel).addComponent(invoiceNumber,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(invoiceDateLabel).addComponent(invoiceDate,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(customerName))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(invoiceTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(invoiceTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(createInvoiceButton)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(deleteInvoiceButton).addComponent(addItemButton)
								.addComponent(deleteItemButton)))
				.addContainerGap(93, Short.MAX_VALUE)));

		pack();
	}

	void loadFile() {
		JOptionPane.showMessageDialog(null, "select the  invoice header file", "Alert", JOptionPane.QUESTION_MESSAGE);

		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			headerFile = fileChooser.getSelectedFile();

			if (headerFile.getAbsolutePath().contains("InvoiceHeader")) {

				JOptionPane.showMessageDialog(null, "select the  invoice items file", "Alert",
						JOptionPane.QUESTION_MESSAGE);

				int returnVa = fileChooser.showOpenDialog(this);
				if (returnVa == JFileChooser.APPROVE_OPTION) {
					headerLine = fileChooser.getSelectedFile();

					if (headerLine.getAbsolutePath().contains("InvoiceLine")) {
						invoiceModel = (DefaultTableModel) invoicesTable.getModel();

						Object[][] arr = cr.showInvoices(headerFile.getAbsolutePath(), headerLine.getAbsolutePath());
						for (Object[] element : arr) {

							invoiceModel.addRow(element);
						}

						load.setEnabled(false);

					} else {
						JOptionPane.showMessageDialog(null, "must  select invoice line file", "Alert",
								JOptionPane.ERROR_MESSAGE);

					}
				}
			}

			else {
				JOptionPane.showMessageDialog(null, "must select the invoice header file", "Alert",
						JOptionPane.ERROR_MESSAGE);

			}
		} else {
			JOptionPane.showMessageDialog(null, "no file was chosen", "Alert", JOptionPane.QUESTION_MESSAGE);
		}

	}

	private void loadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loadActionPerformed
		// TODO add your handling code here:

		loadFile();
	}// GEN-LAST:event_loadActionPerformed

	void saveToFile() {

		cr.saveFile();
		JOptionPane.showMessageDialog(null, "saved to file successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);

	}

	private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveFileActionPerformed
		// TODO add your handling code here:
		saveToFile();

	}// GEN-LAST:event_saveFileActionPerformed

	private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loadFileActionPerformed

	}// GEN-LAST:event_loadFileActionPerformed

	private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_invoicesTableMouseClicked
		// TODO add your handling code here:
		invoiceDate.setEditable(true);

		invoiceDate.setBackground(Color.WHITE);
		customerName.setEditable(true);
		customerName.setBackground(Color.WHITE);

		int index = invoicesTable.getSelectedRow();
		TableModel model = invoicesTable.getModel();
		String inNum = model.getValueAt(index, 0).toString();

		String date = model.getValueAt(index, 1).toString();

		String clientName = model.getValueAt(index, 2).toString();
		String total = model.getValueAt(index, 3).toString();
		invoiceNumber.setText(inNum);
		invoiceDate.setText(date);
		customerName.setText(clientName);
		invoiceTotalPrice.setText(total);
		invoiceItemModel = (DefaultTableModel) invoiceItemsTable.getModel();
		invoiceItemModel.setRowCount(0);
		Object[][] arr = cr.selectedInvoiceItems(index);
		for (Object[] element : arr) {

			invoiceItemModel.addRow(element);
		}

	}// GEN-LAST:event_invoicesTableMouseClicked

	private void invoiceNumberActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_invoiceNumberActionPerformed
		// TODO add your handling code here:
	}

	private void createInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (!headerFile.isFile() || !headerLine.isFile()) {
			JOptionPane.showMessageDialog(null, "<please upload files first>", "Alert", JOptionPane.QUESTION_MESSAGE);

		} else if (!headerFile.isFile() && !headerLine.isFile()) {
			JOptionPane.showMessageDialog(null, "<please upload files first>", "Alert", JOptionPane.QUESTION_MESSAGE);

		}

		else {
			addInvoiceDialog.setVisible(true);
		}

	}// GEN-LAST:event_createInvoiceButtonActionPerformed

	void creatingInvoice(String date, String clientName) {
		invoiceModel = (DefaultTableModel) invoicesTable.getModel();

		if (date.equals("") || clientName.equals("")) {
			JOptionPane.showMessageDialog(null, "you must enter values for date and name", "Alert",
					JOptionPane.QUESTION_MESSAGE);
			setInvoiceDate.setText("");
			setClientName.setText("");
		} else if (date.equals("") && clientName.equals("")) {
			JOptionPane.showMessageDialog(null, "you must enter values for date and name", "Alert",
					JOptionPane.QUESTION_MESSAGE);
			setInvoiceDate.setText("");
			setClientName.setText("");
		} else if (!date.equals("") && !clientName.equals("")) {

			Object[] rowData = cr.createInvoice(date, clientName);

			invoiceModel.addRow(rowData);
			addInvoiceDialog.setVisible(false);

			setInvoiceDate.setText("");
			setClientName.setText("");

		}
	}

	private void submitAddingInvoiceActionPerformed(java.awt.event.ActionEvent evt) {
		String clientName, date = "";

		clientName = setClientName.getText();
		date = setInvoiceDate.getText();
		creatingInvoice(date, clientName);

	}

	void addItemToInvoice(String itemName, String itemPrice, String itemCount) {
		invoiceItemModel = (DefaultTableModel) invoiceItemsTable.getModel();
		invoiceModel = (DefaultTableModel) invoicesTable.getModel();

		if (itemName.equals("") || itemPrice.equals("") || itemCount.equals("")) {
			JOptionPane.showMessageDialog(null, "you must enter values for date and name", "Alert",
					JOptionPane.QUESTION_MESSAGE);
		} else if (itemName.equals("") && itemPrice.equals("") && itemCount.equals("")) {
			JOptionPane.showMessageDialog(null, "you must enter values for date and name", "Alert",
					JOptionPane.QUESTION_MESSAGE);
		} else if (!itemName.equals("") && !itemPrice.equals("") && !itemCount.equals("")) {
			int index = invoicesTable.getSelectedRow();

			try {

				Object[] rowData = cr.createInvoiceItem(index, itemName, itemPrice, itemCount);

				invoiceItemModel.addRow(rowData);
				String pr = cr.updateInvoicePrice(index);
				invoiceTotalPrice.setText(pr);
				invoiceModel.setValueAt(pr, index, 3);
				addItemDialog.setVisible(false);
				setItemName.setText("");
				setItemCount.setText("");
				setItemPrice.setText("");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "enter the right values for price and count", "Alert",
						JOptionPane.ERROR_MESSAGE);
				System.out.print(e.getMessage());
			}

		}

	}

	private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addItemButtonActionPerformed

		if (invoicesTable.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "must select invoice first", "Alert", JOptionPane.QUESTION_MESSAGE);
		} else
			addItemDialog.setVisible(true);

	}

	private void addingItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addingItemActionPerformed

		String itemName, itemCount, itemPrice;
		itemName = setItemName.getText();
		itemCount = setItemCount.getText();
		itemPrice = setItemPrice.getText();

		addItemToInvoice(itemName, itemPrice, itemCount);

	}

	private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteInvoiceButtonActionPerformed
		invoiceModel = (DefaultTableModel) invoicesTable.getModel();
		invoiceItemModel = (DefaultTableModel) invoiceItemsTable.getModel();

		if (invoicesTable.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "must select invoice first", "Alert", JOptionPane.QUESTION_MESSAGE);
		} else {
			int index = invoicesTable.getSelectedRow();

			invoiceModel.removeRow(index);
			cr.deleteInvoice(index);
			invoiceItemModel.setRowCount(0);
			invoiceNumber.setText("");
			invoiceDate.setText("");
			customerName.setText("");
			invoiceTotalPrice.setText("");

		}
	}

	private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteItemButtonActionPerformed

		invoiceItemModel = (DefaultTableModel) invoiceItemsTable.getModel();
		invoiceModel = (DefaultTableModel) invoicesTable.getModel();

		if (invoiceItemsTable.getSelectionModel().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "must select invoice first", "Alert", JOptionPane.QUESTION_MESSAGE);
		} else {
			int indexx = invoicesTable.getSelectedRow();

			int index = invoiceItemsTable.getSelectedRow();

			invoiceItemModel.removeRow(index);

			cr.deleteInvoiceItem(indexx, index);
			String pr = cr.updateInvoicePrice(indexx);

			invoiceTotalPrice.setText(pr);
			invoiceModel.setValueAt(pr, indexx, 3);

		}

	}

	private void canelAddItemActionPerformed(java.awt.event.ActionEvent evt) {
		addItemDialog.setVisible(false);
		setItemName.setText("");
		setItemPrice.setText("");
		setItemCount.setText("");

	}

	private void cancelAddInvoiceActionPerformed(java.awt.event.ActionEvent evt) {

		addInvoiceDialog.setVisible(false);
		setClientName.setText("");
		setInvoiceDate.setText("");

	}

	private void setClientNameKeyPressed(KeyEvent evt) {
	}

	private void setClientNameKeyReleased(KeyEvent evt) {// GEN-FIRST:event_setClientNameKeyReleased

	}

	private void setClientNameKeyTyped(KeyEvent evt) {// GEN-FIRST:event_setClientNameKeyTyped
		// TODO add your handling code here:
		setClientName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					e.consume(); // ignore the event if it's not an alphabet
				}
			}
		});

	}// GEN-LAST:event_setClientNameKeyTyped

	private void setItemPriceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_setItemPriceActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_setItemPriceActionPerformed

	private void setItemNameKeyTyped(KeyEvent evt) {// GEN-FIRST:event_setItemNameKeyTyped
		// TODO add your handling code here:
		setItemName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					e.consume(); // ignore the event if it's not an alphabet
				}
			}
		});
	}// GEN-LAST:event_setItemNameKeyTyped

	private void setItemCountKeyTyped(KeyEvent evt) {// GEN-FIRST:event_setItemCountKeyTyped
		// TODO add your handling code here:
		setItemCount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
	}// GEN-LAST:event_setItemCountKeyTyped

	private void setItemPriceKeyTyped(KeyEvent evt) {// GEN-FIRST:event_setItemPriceKeyTyped
		// TODO add your handling code here:
		setItemPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)
						|| c == KeyEvent.VK_DECIMAL || c == KeyEvent.VK_PERIOD)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
	}// GEN-LAST:event_setItemPriceKeyTyped

	private void deleteItemButtonKeyReleased(KeyEvent evt) {// GEN-FIRST:event_deleteItemButtonKeyReleased
		// TODO add your handling code here:
	}// GEN-LAST:event_deleteItemButtonKeyReleased

	private void customerNameMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_customerNameMouseReleased
		// TODO add your handling code here:

	}// GEN-LAST:event_customerNameMouseReleased

	private void customerNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_customerNameActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_customerNameActionPerformed

	private void invoiceDateMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_invoiceDateMouseReleased
		// TODO add your handling code here:

	}// GEN-LAST:event_invoiceDateMouseReleased

	private void invoiceDateKeyReleased(KeyEvent evt) {// GEN-FIRST:event_invoiceDateKeyReleased

	}

	private void customerNameKeyReleased(KeyEvent evt) {// GEN-FIRST:event_customerNameKeyReleased

	}// GEN-LAST:event_customerNameKeyReleased

	private void setInvoiceDateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_setInvoiceDateActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_setInvoiceDateActionPerformed

	/**
	 * @param args the command line arguments
	 */

	public void LaunchJFrame() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new InvoiceFrame().setVisible(true);

			}
		});

	}

	private javax.swing.JDialog addInvoiceDialog;
	private javax.swing.JLabel addInvoieHeadLabel;
	private javax.swing.JButton addItemButton;
	private javax.swing.JDialog addItemDialog;
	private javax.swing.JButton addingItem;
	private javax.swing.JButton cancelAddInvoice;
	private javax.swing.JButton canelAddItem;
	private javax.swing.JButton createInvoiceButton;
	private javax.swing.JTextField customerName;
	private javax.swing.JLabel customerNameLabel;
	private javax.swing.JButton deleteInvoiceButton;
	private javax.swing.JButton deleteItemButton;
	private JFileChooser fileChooser;
	private javax.swing.JFormattedTextField invoiceDate;
	private javax.swing.JLabel invoiceDateLabel;
	private javax.swing.JTable invoiceItemsTable;
	private javax.swing.JTextField invoiceNumber;
	private javax.swing.JLabel invoiceNumberLabel;
	private javax.swing.JLabel invoiceTotalLabel;
	private javax.swing.JTextField invoiceTotalPrice;
	private javax.swing.JTable invoicesTable;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JMenuItem load;
	private javax.swing.JMenu loadFile;
	private javax.swing.JMenuItem saveFile;
	private javax.swing.JFormattedTextField setClientName;
	private javax.swing.JFormattedTextField setInvoiceDate;
	private javax.swing.JTextField setItemCount;
	private javax.swing.JTextField setItemName;
	private javax.swing.JTextField setItemPrice;
	private javax.swing.JButton submitAddingInvoice;

}
