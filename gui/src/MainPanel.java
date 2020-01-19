import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel {
    private JFrame frame;
    private JFileChooser fc;
    private JButton button;
    private MyFileReader reader;
    private JLabel label;

    void init() {
        initFrame();
        initFileChooser();
        initButton();
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        reader = new MyFileReader();
    }

   private void initFrame() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void initFileChooser() {
        fc = new JFileChooser();
        fc.addActionListener(new FilePicker());
        fc.setDialogTitle("Choose a file!");

    }
    private void initButton() {
        button = new JButton();
        button.setText("Choose File");
        button.setSize(30,30);
        button.addActionListener(new ButtonListener());
    }
    private void initLabel(String text) {
        label = new JLabel();
        label.setText(text);
    }
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fc.showOpenDialog(frame);
        }
    }
    class FilePicker implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile = fc.getSelectedFile();
            initLabel("You chose: " + selectedFile.getName());
            frame.getContentPane().add(BorderLayout.NORTH, label);
            reader.readFile(selectedFile);
        }
    }
}
