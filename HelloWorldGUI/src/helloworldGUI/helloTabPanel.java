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
import javax.swing.JTextArea;


public class helloTabPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public helloTabPanel(MontoyaApi api) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHello, BorderLayout.NORTH);
		
		JSplitPane splitPane_west = new JSplitPane();
		splitPane_west.setResizeWeight(0.5);
		splitPane_west.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_west, BorderLayout.WEST);
		
		JLabel lblEnabledisableHello = new JLabel("Enable/Disable Hello");
		splitPane_west.setLeftComponent(lblEnabledisableHello);
		
		JLabel lblDummy = new JLabel("dummy");
		lblDummy.setHorizontalAlignment(SwingConstants.CENTER);
		splitPane_west.setRightComponent(lblDummy);
		
		JSplitPane splitPane_center = new JSplitPane();
		splitPane_center.setResizeWeight(0.5);
		splitPane_center.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane_center, BorderLayout.CENTER);
		
		JToggleButton tglbtnDisabled = new JToggleButton("Disabled");
		splitPane_center.setLeftComponent(tglbtnDisabled);
		
		JTextArea txtrDummyTextArea = new JTextArea();
		txtrDummyTextArea.setEditable(false);
		txtrDummyTextArea.setEnabled(false);
		txtrDummyTextArea.setWrapStyleWord(true);
		txtrDummyTextArea.setTabSize(6);
		txtrDummyTextArea.setText("dummy text area");
		splitPane_center.setRightComponent(txtrDummyTextArea);
		tglbtnDisabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logging logging = api.logging();
				if(tglbtnDisabled.isSelected()) {
					tglbtnDisabled.setText("Enabled");
					logging.logToOutput("Hello Enabled");
				}
				else {
					logging.logToOutput("Hello Disabled");
					tglbtnDisabled.setText("Disabled");
				}
			}
		});

	}

}
