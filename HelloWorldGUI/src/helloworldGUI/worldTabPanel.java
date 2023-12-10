package helloworldGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class worldTabPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtDummyText;


	public worldTabPanel(MontoyaApi api) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHello = new JLabel("World");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHello, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.WEST);
		
		JLabel lblEnabledisableWorld = new JLabel("Enable/Disable World");
		splitPane.setLeftComponent(lblEnabledisableWorld);
		
		JLabel lblDummy = new JLabel("dummy");
		lblDummy.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane.setRightComponent(lblDummy);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_1, BorderLayout.CENTER);
		
		JToggleButton tglbtnDisabled = new JToggleButton("Disabled");
		splitPane_1.setLeftComponent(tglbtnDisabled);
		
		txtDummyText = new JTextField();
		txtDummyText.setEditable(false);
		txtDummyText.setEnabled(false);
		txtDummyText.setText("dummy text");
		splitPane_1.setRightComponent(txtDummyText);
		txtDummyText.setColumns(10);
		tglbtnDisabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logging logging = api.logging();
				if(tglbtnDisabled.isSelected()) {
					tglbtnDisabled.setText("Enabled");
					logging.logToOutput("World Enabled");
				}
				else {
					logging.logToOutput("World Disabled");
					tglbtnDisabled.setText("Disabled");
				}
			}
		});
		

	}

}
