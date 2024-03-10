package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Book;
import model.dao.BookDao;
import model.dao.FactoryDao;

public class FormRegisterBook extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel jNameBook = new JLabel("Nome do livro");
	private JTextField jTextNameBook = new JTextField();
	private JLabel jNameAuthor = new JLabel("Nome do autor");
	private JTextField jTextNameAuthor = new JTextField();
	private JLabel jDescriptionBook = new JLabel("Descrição do livro");
	private JTextArea jTextDescriptionBook = new JTextArea();
	private JButton consultBooks = new JButton("Mostar livros");
	private JButton saveBook = new JButton("Salvar");
	private JScrollPane scroll = new JScrollPane(jTextDescriptionBook);


	public FormRegisterBook() {
		init();
		configurateComponents();
		addCompenentsInScreen();
		consultAllBooks();
		insertBook();
	}

	private void init() {
		configurateScreen();
	}

	private void configurateScreen() {
		setLayout(null);
		setTitle("Cadastrar Livro");
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void configurateComponents() {
		jNameBook.setBounds(20, 20, 80, 20);
		jTextNameBook.setBounds(20, 40, 240, 25);
		jNameAuthor.setBounds(20, 75, 100, 20);
		jTextNameAuthor.setBounds(20, 95, 240, 25);
		jDescriptionBook.setBounds(20, 130, 120, 20);
		jTextDescriptionBook.setLineWrap(true);
		consultBooks.setBounds(20, 275, 110, 30);
		saveBook.setBounds(160, 275, 100, 30);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(20, 153, 240, 100);
	}

	private void addCompenentsInScreen() {
		getContentPane().add(jNameBook);
		getContentPane().add(jTextNameBook);
		getContentPane().add(jNameAuthor);
		getContentPane().add(jTextNameAuthor);
		getContentPane().add(jDescriptionBook);
		getContentPane().add(consultBooks);
		getContentPane().add(saveBook);
		getContentPane().add(scroll);
		
	}

	private void consultAllBooks() {
		consultBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new DisplayingBooks();

				dispose();
				

			}
		});
	}
	
	private void insertBook() {
		saveBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BookDao dao = FactoryDao.createBookDao();
				
				String nameBook = jTextNameBook.getText();
				String nameAuthor = jTextNameAuthor.getText();
				String description = jTextDescriptionBook.getText();
				
				if (checksfields(nameBook, nameAuthor, description)) {
					Book book = new Book(null, nameBook, nameAuthor, description);
					dao.insert(book);
					JOptionPane.showMessageDialog(rootPane, "Livro cadastrado");
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Algum campo está vázio");
				}
			
				
			}
		});
	}
	
	private boolean checksfields(String name, String nameBook, String description) {
		if (name.equals("") || nameBook.equals("")|| description.equals("")) return false;
		return true;
	}
}
