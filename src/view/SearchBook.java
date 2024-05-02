package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.BookDao;
import model.dao.FactoryDao;

public class SearchBook extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JLabel labelIdBook = new JLabel("Informe o id do livro");
	private JTextField searchBook = new JTextField();
	private JButton cancel = new JButton("Cancelar");
	private JButton confirm = new JButton("Confirmar");
	private String title;
	
	public SearchBook(String title) {
		this.title = title;
		init();
		configurateComponents();
		addCompenentsInScreen();
		cancelOperation();
		confirmOperation();
	}
	
	private void init() {
		configurateScreen();
	}
	
	private void configurateScreen() {
		setLayout(null);
		if (this.title.equals("edit")) setTitle("Editar Livro");
		else if (this.title.equals("delete")) setTitle("Apagar Livro");
		else setTitle("Exibir descrição");
		setSize(300, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void configurateComponents() {
		labelIdBook.setBounds(20, 20, 150, 20);
		searchBook.setBounds(20, 40, 240, 25);
		cancel.setBounds(20, 100, 110, 30);
		confirm.setBounds(150, 100, 110, 30);
	}
	
	private void addCompenentsInScreen() {
		getContentPane().add(searchBook);
		getContentPane().add(labelIdBook);
		getContentPane().add(cancel);
		getContentPane().add(confirm);
	}
	
	private void cancelOperation() {
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new DisplayingBooks();
				
				dispose();
				
			}
		});
	}
	
	private void confirmOperation() {
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int id = Integer.parseInt(searchBook.getText());
					
					if (getTitle().equals("Apagar Livro")) {
						BookDao dao = FactoryDao.createBookDao();
						
						dao.deleteById(id);
						JOptionPane.showMessageDialog(rootPane, "Livro apagado");
						dispose();
						new DisplayingBooks();
					}
					else if (getTitle().equals(("Exibir descrição"))) {
						System.out.println("Exibir descrição");
						new DescriptionBook(id);
						dispose();
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(rootPane, "Informe um número");
				}
				
			}
		});
	}
	
}
