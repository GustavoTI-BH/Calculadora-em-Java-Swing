
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPainel;
	private JTextField textPainelHistorico;
	private double num1 = 0;
	private double num2 = 0;
	private String operacao = "";
	private double resp = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
					frame.setResizable(false);
					Image imagem = ImageIO.read(getClass().getResource("calculadora-icone.png"));

					frame.setIconImage(imagem);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		// Criando toda a estrutura da janela da calculadora
		setTitle("CALCULADORA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DecimalFormat df = new DecimalFormat("0.##");

		// Criando o painel, onde irá receber a operação detalhada
		textPainelHistorico = new JTextField();
		textPainelHistorico.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.GRAY));
		textPainelHistorico.setHorizontalAlignment(SwingConstants.RIGHT);
		textPainelHistorico.setEditable(false);
		textPainelHistorico.setBounds(10, 11, 192, 20);
		contentPane.add(textPainelHistorico);
		textPainelHistorico.setColumns(10);

		// Criando o painel, onde irá receber os números das operações
		textPainel = new JTextField();
		textPainel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.GRAY));
		textPainel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPainel.setEditable(false);
		textPainel.setHorizontalAlignment(SwingConstants.RIGHT);
		textPainel.setBounds(10, 27, 192, 40);
		contentPane.add(textPainel);
		textPainel.setColumns(10);

		// Criando o botão de operação de porcentagem
		// ----------------------------------------------------------------------------------------------------
		JButton btnPorcentagem = new JButton("%");
		btnPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num1 = Double.parseDouble(textPainel.getText());
					textPainelHistorico.setText(df.format(num1) + " % ");
					operacao = "%";
					textPainel.setText("");
					resp = num1 / 100;
					textPainel.setText("" + df.format(resp));
				}
				;
			}
		});
		btnPorcentagem.setBounds(10, 78, 45, 40);
		contentPane.add(btnPorcentagem);

		// Criando o botão de apagar todo o painel
		// ----------------------------------------------------------------------------------------------------
		JButton btnCE = new JButton("CE");
		btnCE.setFont(new Font("Arial", Font.BOLD, 8));
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText("");
				textPainelHistorico.setText("");
			}
		});
		btnCE.setBounds(59, 78, 45, 40);
		contentPane.add(btnCE);

		// Criando o botão de apagar somente a parte debaixo do painel
		// ----------------------------------------------------------------------------------------------------
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText("");
			}
		});
		btnC.setBounds(108, 78, 45, 40);
		contentPane.add(btnC);

		// Criando o botão apagar apenas o ultimo caracter digitado
		// ----------------------------------------------------------------------------------------------------
		JButton btnApagar = new JButton("◄");
		
		AbstractAction actionTeclaApagar = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argApagar) {
				// simula o click no botão
				btnApagar.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeApagar = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0);
		String actionNameApagar = "";
		InputMap inputMapApagar = btnApagar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapApagar.put(keyStrokeApagar, actionNameApagar);
		ActionMap actionMapApagar = btnApagar.getActionMap();
		actionMapApagar.put(actionNameApagar, actionTeclaApagar);
		textPainel.setText(actionNameApagar);
		
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					String numApagar = textPainel.getText();
					numApagar = numApagar.substring(0, numApagar.length() - 1);
					textPainel.setText(numApagar);
				}
				;
			}
		});
		btnApagar.setBounds(157, 78, 45, 40);
		contentPane.add(btnApagar);

		// Criando o botão nuúmero 7
		// ----------------------------------------------------------------------------------------------------
		JButton btn7 = new JButton("7");

		AbstractAction actionTecla7 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg7) {
				// simula o click no botão
				btn7.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum7 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0);
		String actionNameNum7 = "";
		InputMap inputMapNum7 = btn7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum7.put(keyStrokeNum7, actionNameNum7);
		ActionMap actionMapNum7 = btn7.getActionMap();
		actionMapNum7.put(actionNameNum7, actionTecla7);
		textPainel.setText(actionNameNum7);
		if (KeyEvent.VK_7 == '7') {
			KeyStroke keyStroke7 = KeyStroke.getKeyStroke(KeyEvent.VK_7, 0);
			String actionName7 = "";
			InputMap inputMap7 = btn7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap7.put(keyStroke7, actionName7);
			ActionMap actionMap7 = btn7.getActionMap();
			actionMap7.put(actionName7, actionTecla7);
			textPainel.setText(actionName7);
		}

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "7");
			}
		});
		btn7.setBounds(10, 122, 45, 40);
		contentPane.add(btn7);

		// Criando o botão nuúmero 8
		// ----------------------------------------------------------------------------------------------------
		JButton btn8 = new JButton("8");

		AbstractAction actionTecla8 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg8) {
				// simula o click no botão
				btn8.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum8 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0);
		String actionNameNum8 = "";
		InputMap inputMapNum8 = btn8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum8.put(keyStrokeNum8, actionNameNum8);
		ActionMap actionMapNum8 = btn8.getActionMap();
		actionMapNum8.put(actionNameNum8, actionTecla8);
		textPainel.setText(actionNameNum8);
		if (KeyEvent.VK_8 == '8') {
			KeyStroke keyStroke8 = KeyStroke.getKeyStroke(KeyEvent.VK_8, 0);
			String actionName8 = "";
			InputMap inputMap8 = btn8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap8.put(keyStroke8, actionName8);
			ActionMap actionMap8 = btn8.getActionMap();
			actionMap8.put(actionName8, actionTecla8);
			textPainel.setText(actionName8);
		}

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "8");
			}
		});
		btn8.setBounds(59, 122, 45, 40);
		contentPane.add(btn8);

		// Criando o botão nuúmero 9
		// ----------------------------------------------------------------------------------------------------
		JButton btn9 = new JButton("9");

		AbstractAction actionTecla9 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg9) {
				// simula o click no botão
				btn9.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum9 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0);
		String actionNameNum9 = "";
		InputMap inputMapNum9 = btn9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum9.put(keyStrokeNum9, actionNameNum8);
		ActionMap actionMapNum9 = btn9.getActionMap();
		actionMapNum8.put(actionNameNum8, actionTecla8);
		textPainel.setText(actionNameNum8);
		if (KeyEvent.VK_9 == '9') {
			KeyStroke keyStroke9 = KeyStroke.getKeyStroke(KeyEvent.VK_9, 0);
			String actionName9 = "";
			InputMap inputMap9 = btn9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap9.put(keyStroke9, actionName9);
			ActionMap actionMap9 = btn9.getActionMap();
			actionMap9.put(actionName9, actionTecla9);
			textPainel.setText(actionName9);
		}

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "9");
			}
		});
		btn9.setBounds(108, 122, 45, 40);
		contentPane.add(btn9);

		// Criando o botão de operção soma
		// ----------------------------------------------------------------------------------------------------
		JButton btnSoma = new JButton("+");

		AbstractAction actionTeclaSoma = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argSoma) {
				// simula o click no botão
				btnSoma.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeSoma = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0);
		String actionNameSoma = "";
		InputMap inputMapSoma = btnSoma.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapSoma.put(keyStrokeSoma, actionNameSoma);
		ActionMap actionMapSoma = btnSoma.getActionMap();
		actionMapSoma.put(actionNameSoma, actionTeclaSoma);
		textPainel.setText(actionNameSoma);

		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num1 = Double.parseDouble(textPainel.getText());
					textPainelHistorico.setText(df.format(num1) + " + ");
					operacao = "+";
					textPainel.setText("");
				}
				;
			}
		});
		btnSoma.setBounds(157, 122, 45, 40);
		contentPane.add(btnSoma);

		// Criando o botão nuúmero 4
		// ----------------------------------------------------------------------------------------------------
		JButton btn4 = new JButton("4");
		
		AbstractAction actionTecla4 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg4) {
				// simula o click no botão
				btn4.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0);
		String actionNameNum4 = "";
		InputMap inputMapNum4 = btn4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum8.put(keyStrokeNum4, actionNameNum4);
		ActionMap actionMapNum4 = btn4.getActionMap();
		actionMapNum4.put(actionNameNum4, actionTecla4);
		textPainel.setText(actionNameNum4);
		if (KeyEvent.VK_4 == '4') {
			KeyStroke keyStroke4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, 0);
			String actionName4 = "";
			InputMap inputMap4 = btn4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap4.put(keyStroke4, actionName4);
			ActionMap actionMap4 = btn4.getActionMap();
			actionMap4.put(actionName4, actionTecla4);
			textPainel.setText(actionName4);
		}
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "4");
			}
		});
		btn4.setBounds(10, 166, 45, 40);
		contentPane.add(btn4);

		// Criando o botão nuúmero 5
		// ----------------------------------------------------------------------------------------------------
		JButton btn5 = new JButton("5");
		
		AbstractAction actionTecla5 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg5) {
				// simula o click no botão
				btn5.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum5 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0);
		String actionNameNum5 = "";
		InputMap inputMapNum5 = btn5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum5.put(keyStrokeNum5, actionNameNum5);
		ActionMap actionMapNum5 = btn5.getActionMap();
		actionMapNum5.put(actionNameNum5, actionTecla5);
		textPainel.setText(actionNameNum5);
		if (KeyEvent.VK_5 == '5') {
			KeyStroke keyStroke5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, 0);
			String actionName5 = "";
			InputMap inputMap5 = btn5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap5.put(keyStroke5, actionName5);
			ActionMap actionMap5 = btn5.getActionMap();
			actionMap5.put(actionName5, actionTecla5);
			textPainel.setText(actionName5);
		}
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "5");
			}
		});
		btn5.setBounds(59, 166, 45, 40);
		contentPane.add(btn5);

		// Criando o botão nuúmero 6
		// ----------------------------------------------------------------------------------------------------
		JButton btn6 = new JButton("6");
		
		AbstractAction actionTecla6 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg6) {
				// simula o click no botão
				btn6.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum6 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0);
		String actionNameNum6 = "";
		InputMap inputMapNum6 = btn6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum6.put(keyStrokeNum6, actionNameNum6);
		ActionMap actionMapNum6 = btn6.getActionMap();
		actionMapNum6.put(actionNameNum6, actionTecla6);
		textPainel.setText(actionNameNum6);
		if (KeyEvent.VK_6 == '6') {
			KeyStroke keyStroke6 = KeyStroke.getKeyStroke(KeyEvent.VK_6, 0);
			String actionName6 = "";
			InputMap inputMap6 = btn6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap6.put(keyStroke6, actionName6);
			ActionMap actionMap6 = btn6.getActionMap();
			actionMap6.put(actionName6, actionTecla6);
			textPainel.setText(actionName6);
		}
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "6");
			}
		});
		btn6.setBounds(108, 166, 45, 40);
		contentPane.add(btn6);

		// Criando o botão de operação de subtração
		// ----------------------------------------------------------------------------------------------------
		JButton btnSubtracao = new JButton("-");
		
		AbstractAction actionTeclaSubtracao = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argSoma) {
				// simula o click no botão
				btnSubtracao.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeSubtracao = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0);
		String actionNameSubtracao = "";
		InputMap inputMapSubtracao = btnSubtracao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapSubtracao.put(keyStrokeSubtracao, actionNameSubtracao);
		ActionMap actionMapSubtracao = btnSubtracao.getActionMap();
		actionMapSubtracao.put(actionNameSubtracao, actionTeclaSubtracao);
		textPainel.setText(actionNameSubtracao);
		
		btnSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num1 = Double.parseDouble(textPainel.getText());
					textPainelHistorico.setText(df.format(num1) + " - ");
					operacao = "-";
					textPainel.setText("");
				}
				;
			}
		});
		btnSubtracao.setBounds(157, 166, 45, 40);
		contentPane.add(btnSubtracao);

		// Criando o botão nuúmero 1
		// ----------------------------------------------------------------------------------------------------
		JButton btn1 = new JButton("1");
		
		AbstractAction actionTecla1 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg1) {
				// simula o click no botão
				btn1.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum1 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0);
		String actionNameNum1 = "";
		InputMap inputMapNum1 = btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum1.put(keyStrokeNum1, actionNameNum1);
		ActionMap actionMapNum1 = btn1.getActionMap();
		actionMapNum1.put(actionNameNum1, actionTecla1);
		textPainel.setText(actionNameNum1);
		if (KeyEvent.VK_1 == '1') {
			KeyStroke keyStroke1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, 0);
			String actionName1 = "";
			InputMap inputMap1 = btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap1.put(keyStroke1, actionName1);
			ActionMap actionMap1 = btn1.getActionMap();
			actionMap1.put(actionName1, actionTecla1);
			textPainel.setText(actionName1);
		}
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "1");
			}
		});
		btn1.setBounds(10, 210, 45, 40);
		contentPane.add(btn1);

		// Criando o botão nuúmero 2
		// ----------------------------------------------------------------------------------------------------
		JButton btn2 = new JButton("2");
		
		AbstractAction actionTecla2 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg2) {
				// simula o click no botão
				btn2.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum2 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0);
		String actionNameNum2 = "";
		InputMap inputMapNum2 = btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum2.put(keyStrokeNum2, actionNameNum2);
		ActionMap actionMapNum2 = btn2.getActionMap();
		actionMapNum2.put(actionNameNum2, actionTecla2);
		textPainel.setText(actionNameNum2);
		if (KeyEvent.VK_2 == '2') {
			KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, 0);
			String actionName2 = "";
			InputMap inputMap2 = btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap2.put(keyStroke2, actionName2);
			ActionMap actionMap2 = btn2.getActionMap();
			actionMap2.put(actionName2, actionTecla2);
			textPainel.setText(actionName2);
		}
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "2");
			}
		});
		btn2.setBounds(59, 210, 45, 40);
		contentPane.add(btn2);

		// Criando o botão nuúmero 3
		// ----------------------------------------------------------------------------------------------------
		JButton btn3 = new JButton("3");
		
		AbstractAction actionTecla3 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg3) {
				// simula o click no botão
				btn3.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum3 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0);
		String actionNameNum3 = "";
		InputMap inputMapNum3 = btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum3.put(keyStrokeNum3, actionNameNum3);
		ActionMap actionMapNum3 = btn2.getActionMap();
		actionMapNum3.put(actionNameNum3, actionTecla3);
		textPainel.setText(actionNameNum3);
		if (KeyEvent.VK_3 == '3') {
			KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, 0);
			String actionName3 = "";
			InputMap inputMap3 = btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap3.put(keyStroke3, actionName3);
			ActionMap actionMap3 = btn3.getActionMap();
			actionMap3.put(actionName3, actionTecla3);
			textPainel.setText(actionName3);
		}
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "3");
			}
		});
		btn3.setBounds(108, 210, 45, 40);
		contentPane.add(btn3);

		// Criando o botão de operação de multiplicação
		// ----------------------------------------------------------------------------------------------------
		JButton btnMultiplicacao = new JButton("x");
		
		AbstractAction actionTeclaMultiplicacao = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argPonto) {
				// simula o click no botão
				btnMultiplicacao.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeMultiplicacao = KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0);
		String actionNameMultiplicacao = "";
		InputMap inputMapMultiplicacao = btnMultiplicacao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapMultiplicacao.put(keyStrokeMultiplicacao, actionNameMultiplicacao);
		ActionMap actionMapMultiplicacao = btnMultiplicacao.getActionMap();
		actionMapMultiplicacao.put(actionNameMultiplicacao, actionTeclaMultiplicacao);
		textPainel.setText(actionNameMultiplicacao);
		
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num1 = Double.parseDouble(textPainel.getText());
					textPainelHistorico.setText(df.format(num1) + " x ");
					operacao = "x";
					textPainel.setText("");
				}
				;
			}
		});
		btnMultiplicacao.setBounds(157, 210, 45, 40);
		contentPane.add(btnMultiplicacao);

		// Criando o botão de ponto/virgula
		// ----------------------------------------------------------------------------------------------------
		JButton btnPonto = new JButton(".");
		
		AbstractAction actionTeclaPonto = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argPonto) {
				// simula o click no botão
				btnPonto.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokePonto = KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0);
		String actionNamePonto = "";
		InputMap inputMapPonto = btnPonto.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapPonto.put(keyStrokePonto, actionNamePonto);
		ActionMap actionMapPonto = btnPonto.getActionMap();
		actionMapPonto.put(actionNamePonto, actionTeclaPonto);
		textPainel.setText(actionNamePonto);
		
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					textPainel.setText(textPainel.getText() + ".");
				}
				;
			}
		});
		btnPonto.setBounds(10, 254, 45, 40);
		contentPane.add(btnPonto);

		// Criando o botão nuúmero 0
		// ----------------------------------------------------------------------------------------------------
		JButton btn0 = new JButton("0");

		AbstractAction actionTecla0 = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// simula o click no botão
				btn0.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeNum0 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0);
		String actionNameNum0 = "";
		InputMap inputMapNum0 = btn0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapNum0.put(keyStrokeNum0, actionNameNum0);
		ActionMap actionMapNum0 = btn0.getActionMap();
		actionMapNum0.put(actionNameNum0, actionTecla0);
		textPainel.setText(actionNameNum0);
		if (KeyEvent.VK_0 == '0') {
			KeyStroke keyStroke0 = KeyStroke.getKeyStroke(KeyEvent.VK_0, 0);
			String actionName0 = "";
			InputMap inputMap0 = btn0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap0.put(keyStroke0, actionName0);
			ActionMap actionMap0 = btn0.getActionMap();
			actionMap0.put(actionName0, actionTecla0);
			textPainel.setText(actionName0);
		}
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPainel.setText(textPainel.getText() + "0");
			}
		});
		btn0.setBounds(59, 254, 45, 40);
		contentPane.add(btn0);

		// Criando o botão de operação de divisão
		// ----------------------------------------------------------------------------------------------------
		JButton btnDivisao = new JButton("÷");
		
		AbstractAction actionTeclaDivisao = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argDivisao) {
				// simula o click no botão
				btnDivisao.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeDivisao = KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0);
		String actionNameDivisao = "";
		InputMap inputMapDivisao = btnDivisao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapDivisao.put(keyStrokeDivisao, actionNameDivisao);
		ActionMap actionMapDivisao = btnDivisao.getActionMap();
		actionMapDivisao.put(actionNameDivisao, actionTeclaDivisao);
		textPainel.setText(actionNameDivisao);
		
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num1 = Double.parseDouble(textPainel.getText());
					textPainelHistorico.setText(df.format(num1) + " ÷ ");
					operacao = "÷";
					textPainel.setText("");
				}
				;
			}
		});
		btnDivisao.setBounds(108, 254, 45, 40);
		contentPane.add(btnDivisao);

		// Criando o botão de resultado da opeções
		// ----------------------------------------------------------------------------------------------------
		JButton btnIgual = new JButton("=");
		
		AbstractAction actionTeclaIgual = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent argIgual) {
				// simula o click no botão
				btnIgual.doClick();
			}
		};

		// Associa o listener com a tecla clicada para que seja disparado toda vez,
		// mesmo
		// quando o foco não está no botão
		KeyStroke keyStrokeIgual = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0);
		String actionNameIgual = "";
		InputMap inputMapIgual = btnIgual.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMapIgual.put(keyStrokeIgual, actionNameIgual);
		ActionMap actionMapIgual = btnIgual.getActionMap();
		actionMapIgual.put(actionNameIgual, actionTeclaIgual);
		
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPainel.getText() == null || textPainel.getText().trim().equals("")) {

				} else {
					num2 = Double.parseDouble(textPainel.getText());
					if (operacao == "+") {
						resp = num1 + num2;
					} else if (operacao == "-") {
						resp = num1 - num2;
					} else if (operacao == "x") {
						resp = num1 * num2;
					} else if (operacao == "÷") {
						resp = num1 / num2;
					}
					;
					textPainelHistorico.setText(df.format(num1) + " " + operacao + " " + df.format(num2) + " =");
					textPainel.setText("" + df.format(resp));
				}
				;
			}
		});
		btnIgual.setBounds(157, 254, 45, 40);
		contentPane.add(btnIgual);
	}
}