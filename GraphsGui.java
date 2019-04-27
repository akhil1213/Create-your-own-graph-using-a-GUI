import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

public class GraphsGui extends JFrame{
	
	public GraphsGui() {
		setTitle("Gui for graph vertices");
		setResizable(true);
		setLocationRelativeTo(null);
		setSize(800,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		JPanel rightSide = new JPanel();
		//JLabel blankArea = new JLabel();
		//blankArea.setBackground(Color.WHITE);
        //blankArea.setOpaque(true);
		//Edge obj = new Edge();
		//add(obj, BorderLayout.EAST);
		RadioButtonListener rButtonListener = new RadioButtonListener(this);
		//Vertex vertex = new Vertex(rButtonListener,this);
		PanelMouseListener pml = new PanelMouseListener(this,rButtonListener/*,obj*/);
        pml.addMouseListener(pml);
        pml.setPreferredSize(new Dimension(400, 500));
        //blankArea.setBorder(BorderFacto ry.createLineBorder(Color.black));
		rightSide.add(pml);
		JPanel menuForTheSide = new JPanel();
		add(menuForTheSide);
		add(rightSide);
		menuForTheSide.setAlignmentX(LEFT_ALIGNMENT);
		menuForTheSide.setLayout(new GridLayout(9,1));
		ButtonGroup b = new ButtonGroup();
		JRadioButton rB1 = new JRadioButton("Click to add a vertex");
		b.add(rB1);
		rB1.addActionListener(rButtonListener);
		menuForTheSide.add(rB1);
		JRadioButton rB2 = new JRadioButton("Click to add an edge");
		rB2.addActionListener(rButtonListener);
		b.add(rB2);
		menuForTheSide.add(rB2);
		JRadioButton rB3 = new JRadioButton("Click to move a vertex");
		b.add(rB3);
		rB3.addActionListener(rButtonListener);
		menuForTheSide.add(rB3);
		JRadioButton rB4 = new JRadioButton("Shortest Path");
		b.add(rB4);
		rB4.addActionListener(rButtonListener);
		menuForTheSide.add(rB4);
		JPanel wPanel = new JPanel();
		wPanel.setLayout(new GridLayout(1,2));
		JRadioButton rB5 = new JRadioButton("Change weight to:");
		b.add(rB5);
		rB5.addActionListener(rButtonListener);
		wPanel.add(rB5);
		JTextField wInput = new JTextField(3);
		wPanel.add(wInput);
		menuForTheSide.add(wPanel);
		JButton addTheEdges = new JButton("Add all edges");
		//ButtonListener bListener = new ButtonListener();//too add all edges
		//addTheEdges.addActionListener(bListener);
		menuForTheSide.add(addTheEdges);
		JButton randomWeights = new JButton("Random weights");
		//randomWeights.addActionListener(bListener);
		menuForTheSide.add(randomWeights);
		JButton spanning =  new JButton("Minimal tree spanning");
		menuForTheSide.add(spanning);
		JButton help = new JButton("Help");
		menuForTheSide.add(help);
		setVisible(true);
		//add(rButtonListener);
		//GraphCanvas gc = new GraphCanvas(this); 
		//gc.setAlignmentX(RIGHT_ALIGNMENT);
		//add(canvas);
	}
	
}
