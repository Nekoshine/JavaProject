import javax.swing.JFrame;
import java.awt.*;

public class View extends JFrame{
  private static final long serialVersionUID = 42L;
  public View(){
    super("Voitovion");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
    this.setMinimumSize(new Dimension(500, 312));
		this.setLocationRelativeTo(null);
    this.getContentPane().setBackground(Color.WHITE);
    this.setVisible(true);
  }
}
