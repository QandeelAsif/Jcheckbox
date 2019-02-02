package gui_jcjeckbox;

import java.awt.event.*;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.EventListener;
import java.awt.*;



public class checkBox extends JFrame{

    private JTextField tf;
    private JCheckBox boldbox;
    private JCheckBox italicbox;
    
    public checkBox()
    {
        setTitle("Change Font");
        setLayout(new FlowLayout());
        
        tf= new JTextField("WHAT THE ACTUAL HELL", 20);
        tf.setFont(new Font("Serif",Font.PLAIN,15));   //Serif is one of five font family name
        add(tf);
        
         boldbox = new JCheckBox("Bold");
         italicbox = new JCheckBox("Italic");
        add(boldbox);
        add(italicbox);
        
        TheHandler  handler=new TheHandler();
         boldbox.addItemListener(handler); //item lostener is preferred over action listeners in checkboxes
         italicbox.addItemListener(handler);
 }
    
    private class  TheHandler implements ItemListener{
        public void itemStateChanged (ItemEvent event)     //function to over ride in "Item Listener class"
        {
            Font font_var = null;
            if(boldbox.isSelected() && italicbox.isSelected())
                font_var =new Font("Serif",Font.BOLD+Font.ITALIC,15);
            else if (boldbox.isSelected()){
                font_var =new Font("Serif",Font.BOLD,15);
              //  italicbox.setEnabled(false);     //this completely disables the checkbox
            }
            else if (italicbox.isSelected())
            {
            font_var =new Font("Serif",Font.ITALIC,15);
             //boldbox.setEnabled(false);         ////this completely disables the checkbox
            }
            else 
                font_var = new Font("Serif",Font.PLAIN,15);
            tf.setFont(font_var);
            
        }
    }
}
