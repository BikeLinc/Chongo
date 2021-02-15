package engineTester;

import java.awt.*;
import javax.swing.*;


	//============
	// Window
	// ============
public class GuiEditor extends JFrame { // Window

	private static final long serialVersionUID = 1L;
	
	public GuiEditor(int width, int height) {
		this.setSize(width, height);
		this.setTitle("GuiEditor - ChongoEngine");
		this.add(new Canvas());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	// ============
	// Canvas
	// ============
	public class Canvas extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		JLabel entityLabelX = new JLabel("Entity X");
		JButton entityXUp = new JButton("+");
		JButton entityXDown = new JButton("-");
		JLabel entityLabelY = new JLabel("Entity Y");
		JButton entityYUp = new JButton("+");
		JButton entityYDown = new JButton("-");
		
		public Canvas() {
			this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			this.setLayout(new GridLayout(0,3));
			this.add(entityLabelX);
			this.add(entityXUp);
			this.add(entityXDown);
			this.add(entityLabelY);
			this.add(entityYUp);
			this.add(entityYDown);
		}
	}
}
