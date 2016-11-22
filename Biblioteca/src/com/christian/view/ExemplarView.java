package com.christian.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.christian.controller.IController;
import com.christian.controller.LivroController;
import com.christian.dao.ExemplarDao;
import com.christian.model.Exemplar;
import com.christian.model.Livro;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ExemplarView {

	private JFrame frmCadastrarExemplar;
	private JTextField textFieldCodigo;
	private JTextField textFieldLocalizacao;
	private JTextField textFieldEdicao;
	private IController livroController;
	private IController exemplarController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExemplarView window = new ExemplarView();
					window.frmCadastrarExemplar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExemplarView() {
		livroController = new LivroController();
		initialize();
	}
	
	public JComboBox obterLivros(JComboBox comboBoxLivro){
		List<Livro> listaLivros = livroController.Select(); 
		for (Livro livro : listaLivros) {
			comboBoxLivro.addItem(livro.getId()+ "- " + livro.getTitulo());
		}
		
		return comboBoxLivro;
	}
	
	public List<Livro> obterLivros(){
		return livroController.Select();
	}
	public void cadastrarExemplar(){
		criarExemplar();
		vincularExemplar();
	}
	
	public void vincularExemplar(){
		
	}
	public void criarExemplar(){
		Exemplar exemplar = new Exemplar();
		
		exemplar.setLocalização(textFieldLocalizacao.getText());
		exemplar.setEdicao(textFieldEdicao.getText());
		exemplar.setCodigo(textFieldCodigo.getText());
		
		exemplarController.Create(exemplar);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarExemplar = new JFrame();
		frmCadastrarExemplar.setTitle("Cadastrar Exemplar");
		frmCadastrarExemplar.setBounds(100, 100, 563, 364);
		frmCadastrarExemplar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarExemplar.getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigo.setBounds(63, 108, 46, 14);
		frmCadastrarExemplar.getContentPane().add(lblCodigo);
		
		JLabel lblLocalizacao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLocalizacao.setBounds(63, 156, 86, 14);
		frmCadastrarExemplar.getContentPane().add(lblLocalizacao);
		
		JLabel lblEdicao = new JLabel("Edi\u00E7\u00E3o");
		lblEdicao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdicao.setBounds(63, 206, 46, 14);
		frmCadastrarExemplar.getContentPane().add(lblEdicao);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(229, 105, 86, 20);
		frmCadastrarExemplar.getContentPane().add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		textFieldLocalizacao = new JTextField();
		textFieldLocalizacao.setColumns(10);
		textFieldLocalizacao.setBounds(229, 153, 86, 20);
		frmCadastrarExemplar.getContentPane().add(textFieldLocalizacao);
		
		textFieldEdicao = new JTextField();
		textFieldEdicao.setColumns(10);
		textFieldEdicao.setBounds(229, 203, 86, 20);
		frmCadastrarExemplar.getContentPane().add(textFieldEdicao);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLivro.setBounds(63, 61, 46, 14);
		frmCadastrarExemplar.getContentPane().add(lblLivro);
		
		//List<Livro> listaLivros =  obterLivros();
		JComboBox comboBoxLivro = new JComboBox();
		comboBoxLivro = obterLivros(comboBoxLivro);
		comboBoxLivro.setBounds(229, 58, 124, 20);
		frmCadastrarExemplar.getContentPane().add(comboBoxLivro);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criarExemplar();
			}
		});
		btnInserir.setBounds(131, 241, 89, 23);
		frmCadastrarExemplar.getContentPane().add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(317, 241, 108, 23);
		frmCadastrarExemplar.getContentPane().add(btnPesquisar);
		
		JLabel lblMenuExemplar = new JLabel("Menu Exemplar");
		lblMenuExemplar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenuExemplar.setBounds(231, 11, 122, 14);
		frmCadastrarExemplar.getContentPane().add(lblMenuExemplar);
	}
}
