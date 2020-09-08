package Trabajos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Graficador2 extends JFrame {

    private JPanel contentPane;

      


   
    public Graficador2(DefaultTableModel tabla,DefaultTableModel tablaSimbolos) {
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnGenerarTabla = new JButton("Generar Tabla");
        btnGenerarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Graficador g = new Graficador ();
                g.table.setModel(tabla);
                g.setVisible(true);
            }
        });
        btnGenerarTabla.setBounds(125, 49, 185, 47);
        contentPane.add(btnGenerarTabla);
        
        JButton btnNewButton = new JButton("Mostrar tabla de simbolos");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 Graficador3 g = new Graficador3 ();
                 g.table.setModel(tablaSimbolos);
                 g.setVisible(true);
        		
        	}
        });
        btnNewButton.setBounds(125, 144, 185, 55);
        contentPane.add(btnNewButton);
    }
}
