import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JPanel {
    private double[] value;
    private String[] languages;
    private String title;

    public Main(double[] val, String[] lang, String t) {
        languages = lang;
        value = val;
        title = t;
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (value == null || value.length == 0)
            return;
        double minValue = 0;
        double maxValue = 0;
        for (int i = 0; i < value.length; i++) {
            if (minValue > value[i])
                minValue = value[i];
            if (maxValue < value[i])
                maxValue = value[i];
        }
        Dimension dim = getSize();
        int clientWidth = dim.width;
        int clientHeight = dim.height;
        int barWidth = clientWidth / value.length;
        Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
        FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
        Font labelFont = new Font("Book Antiqua", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
        int titleWidth = titleFontMetrics.stringWidth(title);
        int q = titleFontMetrics.getAscent();
        int p = (clientWidth - titleWidth) / 2;
        graphics.setFont(titleFont);
        graphics.drawString(title, p, q);
        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue)
            return;
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        q = clientHeight - labelFontMetrics.getDescent();
        graphics.setFont(labelFont);
        for (int j = 0; j < value.length; j++) {
            int valueP = j * barWidth + 1;
            int valueQ = top;
            int height = (int) (value[j] * scale);
            if (value[j] >= 0)
                valueQ += (int) ((maxValue - value[j]) * scale);
            else {
                valueQ += (int) (maxValue * scale);
                height = -height;
            }
            graphics.setColor(Color.blue);
            graphics.fillRect(valueP, valueQ, barWidth - 2, height);
            graphics.setColor(Color.black);
            graphics.drawRect(valueP, valueQ, barWidth - 2, height);
            int labelWidth = labelFontMetrics.stringWidth(languages[j]);
            p = j * barWidth + (barWidth - labelWidth) / 2;
            graphics.drawString(languages[j], p, q);
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(350, 300);
        double[] msg_length = new double[5];
        String[] client_names = new String[5];

        msg_length[0] = 10;
        client_names[0] = "client1";

        msg_length[1] = 25;
        client_names[1] = "client2";

        msg_length[2] = 5;
        client_names[2] = "client3";

        msg_length[3] = 50;
        client_names[3] = "client4";

        msg_length[4] = 12;
        client_names[4] = "client5";

        frame.getContentPane().add(new Main(msg_length, client_names,
                "Client Messages length"));

        WindowListener winListener = new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        };
        frame.addWindowListener(winListener);
        frame.setVisible(true);
    }
}
