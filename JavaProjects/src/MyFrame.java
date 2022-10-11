import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat; // SimpleDateFormat is a concrete class for formatting and parsing dates in a locale-sensitive manner
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel; // JLabel is a class of java Swing, it is used to display a short string or an image icon
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame(){ // This constructor is used to create the template for each instance
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MY DIGITAL CLOCK PROGRAM");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(true);

        timeFormat = new SimpleDateFormat("hh:mm:ss a"); // this concrete class sets a pattern for the information you want to display
        dayFormat = new SimpleDateFormat("E");
        dateFormat = new SimpleDateFormat("Y:M:d");

        timeLabel = new JLabel(); // this is a label for JFrame

        dayLabel = new JLabel();

        dateLabel = new JLabel();

        this.add(timeLabel); // this adds the label to the JFrame everytime you create an instance
        this.add(dayLabel);
        this.add(dateLabel);

        this.setVisible(true);

        setTime(); // this is a method that performs one function in the JFrame

    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime()); // This string gets the relevant data from the Calendar
            timeLabel.setText(time); // and it is set here in the timeLabel

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000); // This thread is to update the JFrame every second, it will through an Interruption Exception
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

