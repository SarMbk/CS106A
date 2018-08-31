import acm.graphics.*;
import acm.graphics.GMath;
import acm.gui.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TextAndGraphics extends ConsoleProgram {
	
	public void init(){
		setLayout(new GridLayout(1,3));
		
		// Note console is always the leftmost element of our layout. We can't change that
		
		
		leftCanvas = new GCanvas();
		rightCanvas = new GCanvas();
		
		
		add(leftCanvas);
		add(rightCanvas);
		
		
		textField = new JTextField(10);
		add(new JLabel("Some Text"), SOUTH);
		add(textField, SOUTH);
		textField.addActionListener(this);
		
		
		add(new JButton("Draw Left"), SOUTH);
		add(new JButton("Draw Right"), SOUTH);
		
		addActionListeners();	
	}
	
	
	
	private GRect createFilledRect(){
		GRect rect = new GRect(50,20);
		rect.setFilled(true);
		return rect;
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==textField){
			println("You typed: " + textField.getText());
		}
		
		String cmd = e.getActionCommand();
		
		if(cmd.equals("Draw Left")){
			leftCanvas.add(createFilledRect(), 20, leftY);
			leftY+=SPACER;
		}
		
		if(cmd.equals("Draw Right")){
			rightCanvas.add(createFilledRect(), 20, rightY);
			rightY+=SPACER;
		}
	}
	
	
	
	private static double SPACER = 30;
	
	
	
	private GCanvas leftCanvas;
	private GCanvas rightCanvas;
	private JTextField textField;
	
	private double leftY = 10;
	private double rightY = 10;
	
	
	

}
