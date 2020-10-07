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
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InterfazHome extends JFrame {

    private JPanel contentPane;
	private final JFileChooser selector = new JFileChooser();
    File archivo;
   
    public InterfazHome() {
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 430, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnInsertarArchivo = new JButton("Insertar Codigo");
        btnInsertarArchivo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Compilador c = new Compilador ();
        		char [][] matrizPrincipal = null;
        		   try {
        			matrizPrincipal = c.leerArchivo();
        			
        		   }
        		   
        		   catch (IOException e1)  {
        			System.out.println("Excepcion, no se pudo leer el archivo");
        		   }	
        		 //Cramos las tablas necesarias y activamos las interfaces gráficas creadas
        		   ArrayList <Elemento> tablaDeSimbolos = c.creacionTabla();   
        		   ArrayList <Elemento> tablaFinal = c.analisisLexico(matrizPrincipal, tablaDeSimbolos);
        		   InterfazGrafica ig = new InterfazGrafica ();
        		   DefaultTableModel tabla = new DefaultTableModel();
        		   DefaultTableModel tablaSimbolos = new DefaultTableModel();
        		   tablaSimbolos = ig.generarModeloTablaSimbolos(tablaDeSimbolos);
        		   tabla = ig.generarModeloTabla(tablaFinal);
        		   InterfazGeneradora ventanaGeneradora = new InterfazGeneradora (tabla,tablaSimbolos);
        		   dispose();
        		   ventanaGeneradora.setVisible(true);
        	}
        });
        btnInsertarArchivo.setBounds(12, 119, 185, 55);
        contentPane.add(btnInsertarArchivo);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        btnSalir.setBounds(211, 118, 185, 57);
        contentPane.add(btnSalir);
        
        JLabel lblNewLabel = new JLabel("Analizador Lexicografico");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(12, 13, 384, 69);
        contentPane.add(lblNewLabel);
    }
    
    
}
