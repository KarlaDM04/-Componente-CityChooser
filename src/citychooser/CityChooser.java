package citychooser;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Cuevas Santiago Jennifer | Delgado Molina Karla Rocío
 */
public class CityChooser extends JPanel {
    private Map<String, List<String>> estadosMunicipios = new HashMap<>();
    private JComboBox<String> comboEstados;
    private JComboBox<String> comboMunicipios;
    private JLabel labelNumeroEstado;
    private JLabel labelNumeroMunicipio;

    public CityChooser() {
        initComponents();   
        leerCSV("C:\\Users\\Lenovo\\OneDrive\\Documentos\\Ciudades.csv");
        llenarComboEstados();
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel ("Seleccione su Estado y Municipio");
        lblTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setIcon(new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documentos\\CityChooser\\src\\citychooser\\estado.png"));
        lblEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        JLabel lblMunicipio = new JLabel("Municipio:");
        lblMunicipio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        lblMunicipio.setIcon(new ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documentos\\CityChooser\\src\\citychooser\\municipio.png"));
        labelNumeroEstado = new JLabel();
        labelNumeroEstado.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
        labelNumeroMunicipio = new JLabel();
        labelNumeroMunicipio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));

        comboEstados = new JComboBox<>();
        comboMunicipios = new JComboBox<>();
        setLayout(new GridLayout(4, 2)); 

        add(lblTitulo);
        add(new JLabel(""));

        add(lblEstado);
        add(comboEstados);

        add(lblMunicipio);
        add(comboMunicipios);

        add(labelNumeroEstado);
        add(labelNumeroMunicipio);
        
        comboEstados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String estadoSeleccionado = (String) comboEstados.getSelectedItem();
                if (estadoSeleccionado != null) {
                    List<String> municipios = estadosMunicipios.get(estadoSeleccionado);
                    if (municipios != null && !municipios.isEmpty()) {
                        // Limpiamos y llenamos el comboMunicipios
                        comboMunicipios.removeAllItems();
                        for (String municipio : municipios) {
                            comboMunicipios.addItem(municipio);
                        }
                    }
                }
            }
        });
        comboMunicipios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String estadoSeleccionado = (String) comboEstados.getSelectedItem();
                String municipioSeleccionado = (String) comboMunicipios.getSelectedItem();
                if (estadoSeleccionado != null && municipioSeleccionado != null) {
                    labelNumeroEstado.setText("Estado: " + getNumeroEstado(estadoSeleccionado)+". "+estadoSeleccionado);
                    labelNumeroMunicipio.setText("Municipio: " + getNumeroMunicipio(estadoSeleccionado, municipioSeleccionado)+". "+municipioSeleccionado);
                
                }
            }
        });

        }
    public void llenarComboEstados() {
        List<String> estadosOrdenados = new ArrayList<>(estadosMunicipios.keySet());
        Collections.sort(estadosOrdenados);
        for (String estado : estadosOrdenados) {
            comboEstados.addItem(estado);
        }
    }

    public void leerCSV(String fileName) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"ISO-8859-1")))  {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 2) {
                    String estado = datos[0].trim();
                    String municipio = datos[1].trim();

                    estadosMunicipios.computeIfAbsent(estado, k -> new ArrayList<>()).add(municipio);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(450,150); 
    }
    public String getInfo(){
        return " "+labelNumeroEstado.getText()+" "+labelNumeroMunicipio.getText();
    }
    public int getNumeroEstado(String estado) {
        List<String> estadosOrdenados = new ArrayList<>(estadosMunicipios.keySet());
        Collections.sort(estadosOrdenados);
        return estadosOrdenados.indexOf(estado) + 1; 
    }
    
    public int getNumeroMunicipio(String estado, String municipio) {
        List<String> municipios = estadosMunicipios.get(estado);
        if (municipios != null) {
            return municipios.indexOf(municipio) + 1; 
        } else {
            return -1; 
        }
     }   
}
