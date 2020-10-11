package Trabajos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class InterfazGeneradora extends JFrame {

    private JPanel contentPane;

   
    public InterfazGeneradora(DefaultTableModel tabla,DefaultTableModel tablaSimbolos, DefaultTableModel tablaTokens) {
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 364);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnGenerarTabla = new JButton("Generar Tabla de Simbolos Final");
        btnGenerarTabla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazTablaFinal g = new InterfazTablaFinal ();
                g.table.setModel(tabla);
                g.setVisible(true);
            }
        });
        btnGenerarTabla.setBounds(12, 71, 230, 54);
        contentPane.add(btnGenerarTabla);
        
        JButton btnNewButton = new JButton("Mostrar tabla de simbolos base");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 InterfazTablaBase g = new InterfazTablaBase ();
                 g.table.setModel(tablaSimbolos);
                 g.setVisible(true);
        		
        	}
        });
        
        btnNewButton.setBounds(278, 71, 211, 55);
        contentPane.add(btnNewButton);
        
        //VERIFICAR
        JButton btnNewButton_2 = new JButton("Generar Tabla de Tokens");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 InterfazTablaToken g = new InterfazTablaToken ();
                 g.table.setModel(tablaTokens);
                 g.setVisible(true);
        		
        	}
        });
        
        btnNewButton_2.setBounds(10, 149, 232, 54);
        contentPane.add(btnNewButton_2);
        
        
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        btnSalir.setBounds(278, 238, 211, 45);
        contentPane.add(btnSalir);
        
        JButton btnNewButton_1 = new JButton("Atras");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		InterfazHome a = new InterfazHome();
        		a.setVisible(true);
        		
        	}
        });
        btnNewButton_1.setBounds(12, 238, 230, 45);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("Analizador Lexicografico");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setBounds(94, 13, 320, 45);
        contentPane.add(lblNewLabel);
        
        
    }
}
