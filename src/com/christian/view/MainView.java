package com.christian.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.christian.dao.LivroDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 563, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnMenuProfessor = new JButton("Menu Professor");
		btnMenuProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfessorView viewProfessor = new ProfessorView();
				viewProfessor.main(null);
				
			}
		});
		btnMenuProfessor.setBounds(61, 89, 151, 23);
		frame.getContentPane().add(btnMenuProfessor);
		
		JButton btnMenuAluno = new JButton("Menu Aluno");
		btnMenuAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoView viewAluno = new AlunoView();
				viewAluno.main(null);
			}
		});
		btnMenuAluno.setBounds(344, 89, 151, 23);
		frame.getContentPane().add(btnMenuAluno);
		
		JButton btnMenuLivro = new JButton("Menu Livro");
		btnMenuLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroView viewLivro = new LivroView();
				viewLivro.main(null);
			}
		});
		btnMenuLivro.setBounds(61, 180, 151, 23);
		frame.getContentPane().add(btnMenuLivro);
		
		JButton btnMenuExemplar = new JButton("Menu Exemplar");
		btnMenuExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemplarView viewExemplar = new ExemplarView();
				viewExemplar.main(null);
			}
		});
		btnMenuExemplar.setBounds(344, 180, 151, 23);
		frame.getContentPane().add(btnMenuExemplar);
		
		JLabel lblBibliotecaUnisul = new JLabel("Biblioteca Unisul");
		lblBibliotecaUnisul.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblBibliotecaUnisul.setBounds(194, 11, 213, 36);
		frame.getContentPane().add(lblBibliotecaUnisul);
	}
}
