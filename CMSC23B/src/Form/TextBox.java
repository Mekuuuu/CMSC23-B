package CMSC23B;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextBox  implements ActionListener{
	private JTextField field, outputs; 
	
	public TextBox() {
		JFrame frame = new JFrame("String Sorter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JLabel instruction = new JLabel("Enter Text:");
		JLabel label  = new JLabel("Sorted Text"+ "\n");
		
		field = new JTextField(20);
		field.addActionListener(this);
		
		outputs = new JTextField(20);
		outputs.setEditable(false);
	    
		frame.add(instruction);
		frame.add(field);
		frame.add(label);
		frame.add(outputs);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String inp = field.getText();
		inp = sort(inp);
		field.selectAll();
		outputs.setText(inp +"\n");
		
	}
	protected String sort(String inp) {
		int i, j;
		char[] str = inp.toCharArray();
		char temp;
		for(j=1; j < inp.length();j++) {
			temp = str[j];
			i=j-1;
			while(i>=0 && str[i]>temp) {
				if(str[i]==32) {
					i++;
				}else {
				str[i+1] = str[i];
				i--;
				}
			}
			str[i+1]=temp;
		}
		
		String sorted = new String(str);
		return sorted;
	}

	public static void main(String[] args) {
		new TextBox();

	}

}
