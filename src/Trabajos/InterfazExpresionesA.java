package Trabajos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class InterfazExpresionesA extends JFrame {

	   private JPanel contentPane;
	    JTable table;
	    private JScrollPane scrollPane;
	    private JButton btnSalir;

	public InterfazExpresionesA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 87, 849, 315);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblNewLabel = new JLabel("Tabla de Expresiones Aritmeticas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(207, 11, 499, 63);
		contentPane.add(lblNewLabel);
		
		btnSalir = new JButton("Atras");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(12, 401, 133, 33);
		contentPane.add(btnSalir);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cadena = "";				
				for(int i=0;i<table.getRowCount();i++) {				
					if(isSelected(i,2,table)) {
						cadena = table.getValueAt(i, 0).toString();
						AnalizadorSintacticoDeExpresionesAritmeticas a = new AnalizadorSintacticoDeExpresionesAritmeticas(cadena);
						try {
							a.Analizar();
							a.seLeyoTodaLaCadena();
							JOptionPane.showMessageDialog(
							        null, "Cadena "+cadena+" aceptada.", "OK", JOptionPane.INFORMATION_MESSAGE);
						} catch (ErrorEnLaSintaxis e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(
							        null, e1.getMessage()+" de la cadena "+cadena, "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				for(int j=0;j<table.getRowCount();j++) {
					table.setValueAt(null, j, 2);
				}
			}
		});
		btnAnalizar.setBounds(728, 401, 133, 33);
		contentPane.add(btnAnalizar);
	}
	
	public void addCheckBox(int column, JTable table) {
		TableColumn tc = table.getColumnModel().getColumn(column);
		tc.setCellEditor(table.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
		
	}

	public boolean isSelected(int row, int column, JTable table) {
		return table.getValueAt(row, column) !=null;
	}
}

/*class RadioButtonRenderer implements TableCellRenderer {
	  public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    if (value == null)
	      return null;
	    return (Component) value;
	  }
	}

class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
	  private JRadioButton button;

	  public RadioButtonEditor(JCheckBox checkBox) {
	    super(checkBox);
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
	    if (value == null)
	      return null;
	    button = (JRadioButton) value;
	    button.addItemListener(this);
	    return (Component) value;
	  }

	  public Object getCellEditorValue() {
	    button.removeItemListener(this);
	    return button;
	  }

	  public void itemStateChanged(ItemEvent e) {
	    super.fireEditingStopped();
	  }
	}*/
