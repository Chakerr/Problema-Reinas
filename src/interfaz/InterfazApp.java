/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import controlador.Controlador;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import mundo.Logica;


/**
 *
 * @author nicolas
 */
public class InterfazApp extends JFrame {

    private JPanel pnl1;
    private static final String blanco = "data/blanco.jpg";
    private static final String negro = "data/negro.jpg";
    private static final String reina = "data/reinita.png";
    private JLabel lblDado[][];
    private ImageIcon imgblanco;
    private ImageIcon imgnegro;
    private ImageIcon imgreina;
    private Controlador ctrl;

    public InterfazApp(Controlador ctrl) {
        //ctrl
        this.ctrl = ctrl;
        //titulo
        setTitle("Interfaz Gráfica");
        // panel1
        pnl1 = new JPanel();
        pnl1.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Tablero")));
        pnl1.setBounds(10, 10, 470, 470);
        pnl1.setLayout(new GridLayout(8, 8));

        lblDado = new JLabel[8][8];
        imgblanco = new ImageIcon(blanco);
        imgnegro = new ImageIcon(negro);
        imgreina = new ImageIcon(reina);

        // Agrega los atributos al panel  
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    lblDado[i][j] = new JLabel("");
                    lblDado[i][j].setIcon(imgblanco);
                    lblDado[i][j].setHorizontalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVerticalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVisible(true);
                    pnl1.add(lblDado[i][j]);

                } else {
                    lblDado[i][j] = new JLabel("");
                    lblDado[i][j].setIcon(imgnegro);
                    lblDado[i][j].setHorizontalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVerticalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVisible(true);
                    pnl1.add(lblDado[i][j]);
                }

            }
        }
        
//         Agregar las reinas al panel
                 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ctrl.getMatriz()[i][j].equals("Q")) {
                    lblDado[i][j].setIcon(imgreina);
                    lblDado[i][j].setHorizontalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVerticalAlignment(JLabel.CENTER);
                    lblDado[i][j].setVisible(true);
                }
            }
        }
        
        getContentPane().add(pnl1);
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        String texto;
        int columna;
        boolean comprobante = true;
        do{
            texto = JOptionPane.showInputDialog("Introduce la columna: ");
            columna = Integer.parseInt(texto);
            if (columna > 0 && columna < 9) {
                comprobante = false;
            }
        }while(comprobante);
        
        Controlador ctrl = new Controlador(columna-1);
        InterfazApp inter = new InterfazApp(ctrl);
        inter.setVisible(true);
       
        
       
        
    }

}
