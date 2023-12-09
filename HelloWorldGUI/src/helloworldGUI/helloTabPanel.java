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


public class helloTabPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public helloTabPanel(MontoyaApi api) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblHello, BorderLayout.NORTH);
		
		JLabel lblEnabledisableHello = new JLabel("Enable/Disable Hello");
		add(lblEnabledisableHello, BorderLayout.WEST);
		
		JToggleButton tglbtnEnable = new JToggleButton("Disabled");
		tglbtnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logging logging = api.logging();
				if(tglbtnEnable.isSelected()) {
					tglbtnEnable.setText("Enabled");
					logging.logToOutput("Hello Enabled");
				}
				else {
					logging.logToOutput("Hello Disabled");
					tglbtnEnable.setText("Disabled");
				}
			}
		});
		add(tglbtnEnable, BorderLayout.CENTER);

	}

}
