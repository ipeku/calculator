package hess;

import java.awt.event.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Mycalculator implements WindowListener, ActionListener {
	GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();

    Label display; 
    Button[] buttons;
    String[] buttonLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ",", "=", "+",
        "C",
    };

    Frame frame = new Frame("Ipek's Calculator"); 
    Panel panel = new Panel();
    
    int ind = 0; int op_num = 0;
    String op = ""; String first = ""; String sec = "";
    boolean com1 = false; boolean ext2 = false; boolean pass2 = false; boolean com2 = false; boolean prev_calc = false;
    
    public Mycalculator() {
        panel.setLayout(layout);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(3, 3, 3, 3);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        display = new Label("", Label.RIGHT);
; 
        display.setBackground(Color.white);
        display.setFont(new Font("Calibri", Font.PLAIN, 12));
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); 
        layout.setConstraints(display, constraints);
        panel.add(display);

        buttons = new Button[buttonLabels.length];
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[0] = new Button("C"); 
        buttons[0].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[0].addActionListener(this);
        layout.setConstraints(buttons[0], constraints);
        panel.add(buttons[0]);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[1] = new Button("/"); 
        buttons[1].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[1].addActionListener(this);
        layout.setConstraints(buttons[1], constraints);
        panel.add(buttons[1]);

        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[2] = new Button("*"); 
        buttons[2].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[2].addActionListener(this);
        layout.setConstraints(buttons[2], constraints);
        panel.add(buttons[2]);

        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[3] = new Button("-"); 
        buttons[3].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[3].addActionListener(this);
        layout.setConstraints(buttons[3], constraints);
        panel.add(buttons[3]);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[4] = new Button("7"); 
        buttons[4].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[4].addActionListener(this);
        layout.setConstraints(buttons[4], constraints);
        panel.add(buttons[4]);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[5] = new Button("8"); 
        buttons[5].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[5].addActionListener(this);
        layout.setConstraints(buttons[5], constraints);
        panel.add(buttons[5]);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[6] = new Button("9"); 
        buttons[6].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[6].addActionListener(this);
        layout.setConstraints(buttons[6], constraints);
        panel.add(buttons[6]);

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        buttons[7] = new Button("+"); 
        buttons[7].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[7].addActionListener(this);
        layout.setConstraints(buttons[7], constraints);
        panel.add(buttons[7]);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[8] = new Button("4"); 
        buttons[8].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[8].addActionListener(this);
        layout.setConstraints(buttons[8], constraints);
        panel.add(buttons[8]);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[9] = new Button("5"); 
        buttons[9].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[9].addActionListener(this);
        layout.setConstraints(buttons[9], constraints);
        panel.add(buttons[9]);

        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[10] = new Button("6"); 
        buttons[10].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[10].addActionListener(this);
        layout.setConstraints(buttons[10], constraints);
        panel.add(buttons[10]);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[11] = new Button("1"); 
        buttons[11].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[11].addActionListener(this);
        layout.setConstraints(buttons[11], constraints);
        panel.add(buttons[11]);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[12] = new Button("2"); 
        buttons[12].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[12].addActionListener(this);
        layout.setConstraints(buttons[12], constraints);
        panel.add(buttons[12]);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[13] = new Button("3"); 
        buttons[13].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[13].addActionListener(this);
        layout.setConstraints(buttons[13], constraints);
        panel.add(buttons[13]);

        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        buttons[14] = new Button("="); 
        buttons[14].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[14].addActionListener(this);
        layout.setConstraints(buttons[14], constraints);
        panel.add(buttons[14]);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2; 
        constraints.gridheight = 1;
        buttons[15] = new Button("0"); 
        buttons[15].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[15].addActionListener(this);
        layout.setConstraints(buttons[15], constraints);
        panel.add(buttons[15]);

        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        buttons[16] = new Button(","); 
        buttons[16].setFont(new Font("Arial", Font.PLAIN, 20));
        buttons[16].addActionListener(this);
        layout.setConstraints(buttons[16], constraints);
        panel.add(buttons[16]);


        panel.setBackground(Color.orange);
        frame.add(panel);

        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(400, 500);
        frame.setResizable(false);
        frame.setVisible(true);

        display.addKeyListener(new KeyAdapter() {public void keyTyped(KeyEvent e) {e.consume();}});}

    
    public static void main(String args[]) {
    	Mycalculator calculator = new Mycalculator();
    }
    
    public void actionPerformed(ActionEvent e) {
        String buton = e.getActionCommand();
        String read = display.getText();
        if (read.equals("0") && buton.equals("0")) {read = "Error"; resetall();}
        if(buton.equals(",")) buton = ".";
          read = read.replaceAll("\\,", ".");
        if(buton.equals(",")) buton = ".";
        if(read.equals("0")|| read.equals("+0")||read.equals("-0")) {
            if(buton.equals("+") || buton.equals("-") || buton.equals("/")|| buton.equals("*")|| buton.equals(".")) read = read;
            else if (read.equals("-0")) read = "-";
            else if(read.equals("+0"))read = "+";
            else read = "";
        }
        if (!read.equals("Error")) {
            if (read.length() == 0) {
                if (buton.equals("/") || buton.equals("*") || buton.equals(".") || buton.equals("=")) {read = "Error"; resetall();}
                else if(buton.equals("C")) {read = ""; resetall();}
                else {
                    if(buton.equals("0"))com1 = true;
                    read += buton;
                }
            }
            else if (read.length() == 1) {
                if(buton.equals("C")) {resetall(); read = "";}
                else if(buton.equals("=")) {read = "Error"; resetall();}
                else {
                    switch (read) {
                        case "-": case "+":
                            if (buton.equals("/") || buton.equals("*") || buton.equals(".") ||
                                    buton.equals("+") || buton.equals("-") || buton.equals("=")) {
                                read = "Error";
                                resetall();
                            }
                            else {read += buton;}
                            break;
                        default:
                            if(buton.equals("/") || buton.equals("*")|| buton.equals("+") || buton.equals("-")) {
                                pass2 = true;
                                first = read;
                                op = buton;
                                op_num++;
                                ind = read.length();
                                read += buton;
                                com1 = false;
                            }
                            else if(buton.equals(".")) {
                                if(prev_calc) {read = "Error"; resetall();}
                                else {com1 = false; com2 = true; read += buton;}
                            }
                            else {
                                if(prev_calc) {read = "Error"; resetall();}
                                else if(read.equals("0") && ((buton.equals("0") || buton.equals("1") || buton.equals("2") ||buton.equals("3") || buton.equals("4") || buton.equals("5") || buton.equals("6") || buton.equals("7") ||buton.equals("8") || buton.equals("9")))) {
                                    read = buton; resetall();
                                }
                                else {read += buton;}
                            }
                            break;
                    }
                }
            }
            else if(read.length() > 1) {
                String last = String.valueOf(read.charAt(read.length() - 1));
                if(last.equals(",")) {last = ".";}
                if(!pass2) {
                    switch(buton) {
                        case "C":
                            read = "";
                            resetall();
                            break;
                        case "=":
                            read = "Error";
                            resetall();
                            break;
                        case "+": case "-": case "/": case "*":
                            if(last.equals(".")) {read = "Error"; resetall();}
                            else {
                                pass2 = true;
                                first = read;
                                op = buton;
                                read += buton;
                                ind = read.length() - 1;
                                if(buton.equals("+") || buton.equals("-")) {op_num++;}
                            }
                            break;                            
                        case ".":
                            if(prev_calc) {read = "Error"; resetall();}
                            else if(com2) {read = "Error"; resetall();}
                            else {read += buton; com2 = true;}
                            break;

                        default:
                            if(prev_calc) {read = "Error";resetall();}
                            else {read +=  buton;}
                            break;
                    }
                }
                else {
                    if(!(last.equals("-") || last.equals("*") || last.equals("+") || last.equals("/"))) {ext2 = true;}
                    switch (buton) {
                        case "C":
                            read = "";
                            resetall();
                            break;

                        case "=":
                            if (!(last.equals(".") || last.equals("-") || last.equals("*") ||
                                    last.equals("+") || last.equals("/"))) {
                                sec = read.substring(ind + 1);
                                read = hesapla(first, sec, op);
                                com1 = false;
                                com2 = false;
                                pass2 = false;
                                ext2 = false;
                                ind = 0;
                                op_num = 0;
                                op = "";
                                first = "";
                                sec = "";
                            }
                            else {read = "Error"; resetall();}
                            break;
                            
                        case "/": case "*":
                            if(ext2) {read = "Error"; resetall();}
                            else if (last.equals("-") || last.equals("+") || last.equals("*") || last.equals("/")) {read = "Error"; resetall();}
                            else {
                                if (op_num == 1) {read += buton; op_num++;}
                                else if (op_num == 2) {read = "Error"; resetall();}
                            }
                            break;
                            
                        case "+": case "-":
                            if(ext2) {
                                read = "Error";
                                resetall();
                            }
                            else if (op_num == 1 || last.equals("*") || last.equals("/")) {
                                read += buton;
                                op_num++;
                            }
                            else if (last.equals(".") || last.equals("+") || last.equals("-")) {
                                read = "Error";
                                resetall();
                            }
                            break;
                            
                        case ".":
                            if (com2 || last.equals("-") || last.equals("*") || last.equals("+") || last.equals("/")) {read = "Error";resetall();}
                            else {com2 = true; com1 = false; read += buton;}
                            break;

                        default:
                            if (((buton.equals("0") || buton.equals("1") || buton.equals("2") ||buton.equals("3") || buton.equals("4") || buton.equals("5") || buton.equals("6") || buton.equals("7") ||buton.equals("8") || buton.equals("9"))) && !com2 && ind < read.length() - 1 && read.charAt(ind + 1) == '0') {
                                StringBuilder read_former = new StringBuilder(read);
                                read_former.setCharAt(ind + 1, buton.charAt(0));
                                read = read_former.toString();
                            }
                            else if (((buton.equals("0") || buton.equals("1") || buton.equals("2") ||buton.equals("3") || buton.equals("4") || buton.equals("5") || buton.equals("6") || buton.equals("7") ||buton.equals("8") || buton.equals("9"))) && !com2 && ind < read.length() - 2 && read.charAt(ind + 2) == '0' &&(read.charAt(ind + 1) == '-' || read.charAt(ind + 1) == '+')) {
                                StringBuilder read_former = new StringBuilder(read);
                                read_former.setCharAt(ind + 2, buton.charAt(0));
                                read = read_former.toString();
                            }
                            else {read += buton;}
                            break;
                    }
                }
            }
        }
        else {
            if(buton.equals("C")) { resetall(); read = "";}
        }
        display.setText(read.replace('.', ','));
    }
    public String hesapla(String sayi1, String sayi2, String fourtransactions) {
        BigDecimal numm1 = new BigDecimal(sayi1.replace(',', '.'));
        BigDecimal numm2 = new BigDecimal(sayi2.replace(',', '.'));
        BigDecimal res = BigDecimal.ZERO;
        switch (fourtransactions) {
            case "/":
                if (numm2.compareTo(BigDecimal.ZERO) != 0) {
                    res = numm1.divide(numm2, 10, RoundingMode.HALF_UP);
                }
                else return "Error";
                break;
            case "+":
                res = numm1.add(numm2);
                break;
            case "-":
                res = numm1.subtract(numm2);
                break;
            case "*":
                res = numm1.multiply(numm2);
                break;
        }
        prev_calc = true;
        return res.stripTrailingZeros().toPlainString().replace('.', ',');
    }
    void resetall() {
    	op = ""; first = ""; sec = "";
        com1 = false; com2 = false; pass2 = false; ext2 = false; prev_calc = false;
        ind = 0; op_num = 0;     
    }
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {frame.dispose(); System.exit(0);}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}
}