package com.christian.view;

import java.awt.EventQueue;
import java.lang.Integer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.christian.controller.AlunoController;
import com.christian.controller.IController;
import com.christian.controller.LivroController;
import com.christian.model.Livro;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LivroView {

	private JFrame frmCadastrarLivro;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private LivroController livroController = null;
	private JButton btnDeletar;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivroView window = new LivroView();
					window.frmCadastrarLivro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LivroView() {
		livroController = new LivroController();
		initialize();
	}

	private void inserirLivro(){
		Livro livro = new Livro();
		
		livro.setAutor(textFieldAutor.getText());
		livro.setTitulo(textFieldTitulo.getText());
		
		livroController.Create(livro);
	}
	
	private void deletarLivro(int id){
		if(validarCampos()){
			livroController.Delete(id);
		} else{
			JOptionPane.showMessageDialog(null, "Livro não encontrado");
		}
	}
	private boolean validarCampos(){
		boolean valido = false;
		if (textFieldAutor.getText() != "" &&
				textFieldTitulo.getText() != "" //&& 
				/*textFieldCursos.getText() != ""*/){
			valido = true;
		}
		return valido;
	}
	private void pesquisarLivro (String titulo){
		Livro livro = livroController.selectByTitulo(titulo);
		if (livro != null){
			textFieldAutor.setText(livro.getAutor());
			textFieldTitulo.setText(livro.getTitulo());
		}else{
			JOptionPane.showMessageDialog(null, "Livro não encontrado");
			textFieldAutor.setText("");
			textFieldTitulo.setText("");
		}
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarLivro = new JFrame();
		frmCadastrarLivro.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmCadastrarLivro.setTitle("Cadastrar Livro");
		frmCadastrarLivro.setBounds(100, 100, 561, 360);
		frmCadastrarLivro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarLivro.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(93, 70, 86, 14);
		frmCadastrarLivro.getContentPane().add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutor.setBounds(93, 134, 46, 14);
		frmCadastrarLivro.getContentPane().add(lblAutor);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(225, 67, 86, 20);
		frmCadastrarLivro.getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setColumns(10);
		textFieldAutor.setBounds(225, 131, 86, 20);
		frmCadastrarLivro.getContentPane().add(textFieldAutor);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirLivro();
			}
		});
		btnInserir.setBounds(233, 197, 89, 23);
		frmCadastrarLivro.getContentPane().add(btnInserir);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarLivro(Integer.parseInt(textFieldId.getText()));
			}
		});
		btnDeletar.setBounds(70, 197, 89, 23);
		frmCadastrarLivro.getContentPane().add(btnDeletar);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(225, 98, 86, 20);
		frmCadastrarLivro.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(93, 101, 46, 14);
		frmCadastrarLivro.getContentPane().add(lblId);
		
		JLabel lblMenuLivro = new JLabel("Menu Livro");
		lblMenuLivro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenuLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuLivro.setBounds(27, 11, 452, 14);
		frmCadastrarLivro.getContentPane().add(lblMenuLivro);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarLivro(textFieldTitulo.getText());
			}
		});
		btnPesquisar.setBounds(390, 197, 89, 23);
		frmCadastrarLivro.getContentPane().add(btnPesquisar);
	}
}
