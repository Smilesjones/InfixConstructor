/*
Filename: PostfixToInfixMain.java
Author: Stephen Jones
Date: 18NOV2018
Purpose: Project 2 main class that defines the GUI, creates the object 
to perform postfix to infix conversion, creates the object that generates
the 3 address instructions. 

References used to help create code:

    (n.d.). Retrieved November 4, 2018, 
from http://www.java2s.com/Code/Java/Swing-JFC/BoxLayoutGlueSample.htm

 */
package cmsc350project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PostfixToInfixMain extends JFrame implements ActionListener {
    //GUI component variables
    private JTextField postfixEnter;
    private JButton constructButton;
    private JTextField infixResult;
    private JLabel enterLabel, resultLabel;
    private JPanel mainPanel, northPanel, southPanel, centralPanel;
    private Box centerBox;
    
    
    //Constructor defining the GUI and it's components
    public PostfixToInfixMain(){
        //Main JPanel
        mainPanel = new JPanel();
        //Add main panel to frame
        super.add(mainPanel);
        //North and south sub-panels
        northPanel = new JPanel();
        southPanel = new JPanel();
        centralPanel = new JPanel();
        //JTextField for entering data
        postfixEnter = new JTextField(15);
        //JButton to click for expression conversion
        constructButton = new JButton("Construct Infix");
        constructButton.addActionListener(this);
        //JTextField for reading the infix result
        infixResult = new JTextField(15);
        infixResult.setEditable(false);
        infixResult.setBackground(Color.LIGHT_GRAY);
        //JLabel for entering input and reading results 
        enterLabel = new JLabel("Enter Postfix Expression");
        resultLabel = new JLabel("Infix Expression", SwingConstants.RIGHT);
        //Create box and add button with glue spacers
        centerBox = Box.createHorizontalBox();
        centerBox.add(Box.createGlue());
        centerBox.add(constructButton);
        centerBox.add(Box.createGlue());
        //Add appropriate components to the north panel
        northPanel.add(enterLabel);
        northPanel.add(postfixEnter);
        //Add appropriate components to the south panel
        southPanel.add(resultLabel);
        southPanel.add(infixResult);
        centralPanel.add(centerBox);
        //Add north and south panels and centerBox to the main panel
        //mainPanel.add(northPanel, BorderLayout.PAGE_START);
        //mainPanel.add(centralPanel, BorderLayout.CENTER);
        //mainPanel.add(southPanel, BorderLayout.PAGE_END);
        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    //Actionlistener for the construct button.
    //Evaluates input data and sets the result text to the infix solution
    @Override
    public void actionPerformed(ActionEvent e) {
        //Create object with no parameters to use in catch
        PostfixToInfixConv infixExpression = new PostfixToInfixConv();
        ThreeAddressGenerate reset = new ThreeAddressGenerate();
        
        try{
        reset.create3AddressReport();
        //Input retrieved from the enter text field
        String input = postfixEnter.getText();
        //Create object to convert the postfix expression
        infixExpression = new PostfixToInfixConv(input);
        //Set the infix text field to result
        infixResult.setText(infixExpression.convertPostfixToInfix());
        //Create object to construct the 3 address instruction
        ThreeAddressGenerate output = new ThreeAddressGenerate(input);
        output.generateThreeAddress();
        output.create3AddressReport();
        }catch (NumberFormatException ne){
            String currentToken = infixExpression.getCurrentToken();
            JOptionPane.showMessageDialog(null, currentToken + 
                " is inappropriate.\nPlease enter integers or operators:\n" + 
                "+, -, *, or / ", "Inappropriate Character", 
                JOptionPane.ERROR_MESSAGE);
            infixResult.setText("ERROR");
            
        }catch (FileNotFoundException fe){
            JOptionPane.showMessageDialog(null, "File could not be found",
                "File Not Found", JOptionPane.ERROR_MESSAGE);
        }catch (NoSuchElementException ex) {
            JOptionPane.showMessageDialog(null, "Something went wrong.\n" + 
                    "Please check the postfix expression.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
        
    //Method to set the frame characteristics
    public static void setFrame(JFrame frame){
        //frame.setSize(400, 400);
        frame.setName("Postfix To Infix Converter");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);    
    }
    
    //Main method that instantiate the frame object and calls setFrame method
    public static void main(String[] args) {
        PostfixToInfixMain infixFrame = new PostfixToInfixMain();
        setFrame(infixFrame);
        
    }

    
    
}
