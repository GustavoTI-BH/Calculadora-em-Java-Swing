package calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Font;
import java.text.DecimalFormat;

public class calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textPainel;
	private JTextField textPainelHistorico;
	private double num1 = 0;
	private double num2 = 0;
	private String operacao = "";
	private double resp = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculadora() {
		setTitle("CALCULADORA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DecimalFormat df = new DecimalFormat("0.##");
		
		textPainel = new JTextField();
		textPainel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPainel.setEditable(false);
		textPainel.setHorizontalAlignment(SwingConstants.RIGHT);
		textPainel.setBounds(10, 27, 192, 40);
		contentPane.add(textPainel);
		textPainel.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "7");
			}
		});
		btn7.setBounds(10, 78, 45, 40);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "8");
			}
		});
		btn8.setBounds(59, 78, 45, 40);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "9");
			}
		});
		btn9.setBounds(108, 78, 45, 40);
		contentPane.add(btn9);
		
		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textPainel.getText());
				textPainelHistorico.setText(df.format(num1) + " + ");
				operacao = "+";
				textPainel.setText("");
			}
		});
		btnSoma.setBounds(157, 78, 45, 40);
		contentPane.add(btnSoma);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "4");
			}
		});
		btn4.setBounds(10, 122, 45, 40);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "5");
			}
		});
		btn5.setBounds(59, 122, 45, 40);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "6");
			}
		});
		btn6.setBounds(108, 122, 45, 40);
		contentPane.add(btn6);
		
		JButton btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textPainel.getText());
				textPainelHistorico.setText(df.format(num1) + " - ");
				operacao = "-";
				textPainel.setText("");
			}
		});
		btnSubtracao.setBounds(157, 122, 45, 40);
		contentPane.add(btnSubtracao);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "1");
			}
		});
		btn1.setBounds(10, 166, 45, 40);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "2");
			}
		});
		btn2.setBounds(59, 166, 45, 40);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "3");
			}
		});
		btn3.setBounds(108, 166, 45, 40);
		contentPane.add(btn3);
		
		JButton btnMultiplicacao = new JButton("x");
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textPainel.getText());
				textPainelHistorico.setText(df.format(num1) + " x ");
				operacao = "x";
				textPainel.setText("");
			}
		});
		btnMultiplicacao.setBounds(157, 166, 45, 40);
		contentPane.add(btnMultiplicacao);
		
		JButton btnPonto = new JButton(".");
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + ".");
			}
		});
		btnPonto.setBounds(10, 210, 45, 40);
		contentPane.add(btnPonto);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "0");
			}
		});
		btn0.setBounds(59, 210, 45, 40);
		contentPane.add(btn0);
		
		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(textPainel.getText());
				textPainelHistorico.setText(df.format(num1) + " / ");
				operacao = "/";
				textPainel.setText("");
			}
		});
		btnDivisao.setBounds(108, 210, 45, 40);
		contentPane.add(btnDivisao);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num2 = Double.parseDouble(textPainel.getText());
				if(operacao == "+") {
					resp = num1 + num2;
				} else if(operacao == "-"){
					resp = num1 - num2;
				} else if(operacao == "x"){
					resp = num1 * num2;
				} else if(operacao == "/"){
					resp = num1 / num2;
				};
				textPainelHistorico.setText(df.format(num1) + " " + operacao + " " + df.format(num2) + " =");			
				textPainel.setText("" + df.format(resp));
			}
		});
		btnIgual.setBounds(157, 210, 45, 40);
		contentPane.add(btnIgual);
		
		textPainelHistorico = new JTextField();
		textPainelHistorico.setHorizontalAlignment(SwingConstants.RIGHT);
		textPainelHistorico.setEditable(false);
		textPainelHistorico.setBounds(10, 11, 192, 20);
		contentPane.add(textPainelHistorico);
		textPainelHistorico.setColumns(10);
	}
}
