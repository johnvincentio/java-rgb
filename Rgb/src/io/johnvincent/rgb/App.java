
package io.johnvincent.rgb;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

import java.io.File;

public class App extends JFrame {
	private static final long serialVersionUID = 1;
	private Apprgb m_apprgb;
	private AppSlider m_appSliderRed, m_appSliderGreen, m_appSliderBlue;
	private AppHex m_appHex;
	private HexConverter m_converter = new HexConverter();

	private static Logger debug = Logger.getRootLogger();
	
	static {
		init();
	}
	
	/**
	 * method to init log4j configurations
	 */
	private static void init() {
		String log4jConfPath = System.getProperty("user.dir")+File.separator+"log4j.xml";
		System.out.println("log4jConfPath "+log4jConfPath);
		DOMConfigurator.configure(log4jConfPath);
	}
	
	public App(String msg) {
		super(msg);
		setContentPane(makeMyContentPane());
		setSize(500,900);
		pack();
		setVisible(true);
	}
	public static void main (String args[]) {
		JFrame frame = new App ("RGB Color Helper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private Container makeMyContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());

		JPanel topPane = new JPanel();	// top Pane
		topPane.setLayout(new GridLayout(3, 1, 0, 0));

		m_appSliderRed = new AppSlider (this, "Red", 1);
		topPane.add(m_appSliderRed.makeContentPane());
		m_appSliderGreen = new AppSlider (this, "Green", 2);
		topPane.add(m_appSliderGreen.makeContentPane());
		m_appSliderBlue = new AppSlider (this, "Blue", 3);
		topPane.add(m_appSliderBlue.makeContentPane());

		JPanel midPane = new JPanel();	// Hex Pane
		midPane.setLayout(new GridLayout(2, 1, 0, 0));
		m_appHex = new AppHex (this, "Hex");
		midPane.add(m_appHex.makeContentPane());

		JPanel lowPane = new JPanel();	// panel for a color area
		m_apprgb = new Apprgb (0,0,0);
		lowPane.add(m_apprgb);

		pane.add(topPane,BorderLayout.NORTH);	// put it together
		pane.add(midPane,BorderLayout.CENTER);
		pane.add(lowPane,BorderLayout.SOUTH);
		return (pane);
	}
	public void setMyRGB () {
		debug.info(">>>App::setMyRGB");
		m_apprgb.setMyRGB (m_appSliderRed.getSliderValue(),
				m_appSliderGreen.getSliderValue(),
				m_appSliderBlue.getSliderValue());
		debug.info("<<<App::setMyRGB");
	}
	public void setMyHex () {		// set hex value
		debug.info(">>>App::setMyHex");
		m_appHex.setHexValue (m_converter.getHexValue (
					m_appSliderRed.getSliderValue(), 
					m_appSliderGreen.getSliderValue(),
					m_appSliderBlue.getSliderValue()));
		debug.info("<<<App::setMyHex");
	}
	public void setMySlider (String strValue) {
		debug.info(">>>App::setMySlider; strValue :"+strValue+":");
		int[] rgb = new int[3];
		m_converter.getRGBValues (strValue, rgb);
		m_appSliderRed.setSliderValue (rgb[0]);	// set slider
		m_appSliderGreen.setSliderValue (rgb[1]);
		m_appSliderBlue.setSliderValue (rgb[2]);
		debug.info("<<<App::setMySlider");
	}
}

