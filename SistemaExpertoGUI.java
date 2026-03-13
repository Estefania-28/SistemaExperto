import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaExpertoGUI {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Sistema Experto Industrial");
        ventana.setSize(400,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JLabel titulo = new JLabel("Diagnóstico de Maquinaria");
        titulo.setBounds(120,10,200,30);
        ventana.add(titulo);

        JLabel tempLabel = new JLabel("Temperatura (°C):");
        tempLabel.setBounds(30,60,120,25);
        ventana.add(tempLabel);

        JTextField tempField = new JTextField();
        tempField.setBounds(160,60,150,25);
        ventana.add(tempField);

        JLabel vibLabel = new JLabel("Vibración (mm/s):");
        vibLabel.setBounds(30,100,120,25);
        ventana.add(vibLabel);

        JTextField vibField = new JTextField();
        vibField.setBounds(160,100,150,25);
        ventana.add(vibField);

        JLabel ruidoLabel = new JLabel("Ruido (dB):");
        ruidoLabel.setBounds(30,140,120,25);
        ventana.add(ruidoLabel);

        JTextField ruidoField = new JTextField();
        ruidoField.setBounds(160,140,150,25);
        ventana.add(ruidoField);

        JButton boton = new JButton("Diagnosticar");
        boton.setBounds(120,180,140,30);
        ventana.add(boton);

        JLabel resultado = new JLabel("");
        resultado.setBounds(40,220,320,30);
        ventana.add(resultado);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double temperatura = Double.parseDouble(tempField.getText());
                double vibracion = Double.parseDouble(vibField.getText());
                double ruido = Double.parseDouble(ruidoField.getText());

                String diagnostico;

                if (temperatura > 90 && vibracion > 7) {
                    diagnostico = "PELIGRO: Falla crítica en motor";
                }

                else if (vibracion > 7 && ruido > 85) {
                    diagnostico = "ALERTA: Falla en eje o rodamientos";
                }

                else if (temperatura > 90) {
                    diagnostico = "ALERTA: Sobrecalentamiento";
                }

                else if (vibracion > 7) {
                    diagnostico = "ALERTA: Desbalance mecánico";
                }

                else if (ruido > 85) {
                    diagnostico = "ALERTA: Desgaste en rodamientos";
                }

                else {
                    diagnostico = "OK: Funcionamiento adecuado";
                }

                resultado.setText(diagnostico);
            }
        });

        ventana.setVisible(true);
    }
}