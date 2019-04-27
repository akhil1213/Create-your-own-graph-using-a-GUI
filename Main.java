import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class Main {
	public static void main(String [] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(ClassNotFoundException| InstantiationException | IllegalAccessException|UnsupportedLookAndFeelException e) {
		}
		GraphsGui obj = new GraphsGui();
	}
}
