import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class Prob103 {
    private static String labelPrefix = "New String: ";
    private JLabel label;
    private JButton button;
    private JTextField textField;
  
    class ButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText(labelPrefix + textField.getText());
        }
    }
  
    public Component createComponents() {
        label = new JLabel(labelPrefix + "XXX    ");
        textField = new JTextField("bbb");
        button = new JButton("Move!");
    
        ButtonAction buttonListener = new ButtonAction();
        button.addActionListener( buttonListener );
    
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder( 30, 30, 10, 30 ));
        pane.setLayout(new GridLayout(0, 1));
        pane.add(textField);
        pane.add(button);
        pane.add(label);
    
        return pane;
    }
  
    public static void main(String[] args) {
        JFrame frame = new JFrame("TestButton");  // frame, title
        Prob103 app = new Prob103();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // fin.
        frame.pack();
        frame.setVisible(true);
    }    
}
