package helloworldGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import burp.api.montoya.MontoyaApi;

public class GUI extends JPanel {

	private static final long serialVersionUID = 1L;

	public GUI(MontoyaApi api) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHelloWorldGui = new JLabel("Hello World GUI");
		lblHelloWorldGui.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHelloWorldGui, BorderLayout.NORTH);
		
		JTabbedPane tabMain = new JTabbedPane(JTabbedPane.TOP);
		add(tabMain, BorderLayout.CENTER);
		
		//Create the first tab with the label "Hello"
        tabMain.addTab("Hello Tab", null, new helloTabPanel(api), null);

        // Create the second tab with the label "World"
        tabMain.addTab("World Tab", null, new worldTabPanel(api), null);

	}

}
