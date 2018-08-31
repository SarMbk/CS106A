import acm.graphics.GMath;
import acm.gui.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;




public class Temperature extends Program {
	
	public void init(){
		
		setLayout(new TableLayout(2,3));
		
		farenField = new IntField(32);
		farenField.setActionCommand("F -> C");
		farenField.addActionListener(this);
		
		
		celsField = new IntField(32);
		celsField.setActionCommand("C -> F");
		celsField.addActionListener(this);
		
		add(new JLabel("Degrees Farenheit:"));
		add(farenField);
		add(new JButton("F -> C"));
		
		add(new JLabel("Degrees Celcius:"));
		add(celsField);
		add(new JButton("C -> F"));	
		
		addActionListeners();
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("F -> C")){
			int f = farenField.getValue();
			int c = GMath.round((5.0/9.0)*(f-32));
			celsField.setValue(c);
		}
		
		if(cmd.equals("C -> F")){
			int c = celsField.getValue();
			int f = GMath.round((9.0/5.0)*c + 32);
			farenField.setValue(f);
		}
		
		
	}
	
	
	private IntField farenField;
	private IntField celsField;

}
