package tasklist;

import javax.swing.*;
import java.awt.event.*;

public class TextArea extends JFrame implements ActionListener{  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton submit, clear;
	static JLabel instruction, label;
	static JFrame frame;
	private JTextArea area, output;

    public TextArea(){  
        frame = new JFrame("Text Area");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        instruction = new JLabel("Enter Text:");
        instruction.setBounds(10, 10, 100, 10);
        
        area = new JTextArea();  
        area.setBounds(10,30,250,200); 
             
        output = new JTextArea();  
        output.setBounds(10, 250, 250, 20);
        output.setEditable(false);

        label = new JLabel("Output");
        label.setBounds(10, 230, 200, 20);
        
        submit = new JButton("Submit");
        submit.setBounds(90, 280, 100, 25);
        
        clear = new JButton("Clear");
        clear.setBounds(90, 310, 100, 25);
        
        frame.add(instruction);
        frame.add(area); 
        frame.add(label);
        frame.add(output);
        frame.add(submit);
        frame.add(clear);
        frame.setSize(285,380);
        frame.setLayout(null); 
        frame.setVisible(true); 
        
        submit.addActionListener(this);
        clear.addActionListener(this);
     }  
    public void actionPerformed(ActionEvent e) {
    	String s = e.getActionCommand();
        if (s.equals("Submit")) {
        	output.setText("");
        	//put class to be used after pressing submit example: new ValidatorInt(area.getText());
        	//output in a form of string
            output.append("output here");
        	
        }
        else
        if(s.equals("Clear")) {
        	area.setText("");
        	output.setText("");
        }
    }

    public static void main(String args[]) {  
    	new TextArea();  
    }
} 
