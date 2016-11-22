package com.christian.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import com.christian.controller.AlunoController;
import com.christian.controller.IController;
import com.christian.model.Aluno;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunoView {

	private JFrame frmCadastrarAluno;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldNomedoCurso;
	private IController alunoController;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoView window = new AlunoView();
					window.frmCadastrarAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlunoView() {
		alunoController = new AlunoController();
		initialize();
	}
	
	private void  cadastrarAluno() {
		
		if(validarCampos()){
			Aluno aluno = new Aluno();
			aluno.setNome(textFieldNome.getText());
			aluno.setMatricula(textFieldMatricula.getText());
			aluno.setNomeDoCurso(textFieldNomedoCurso.getText());
			alunoController.Create(aluno);
		}else{
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
		}				
	}
	
	private void pesquisarAluno(String matricula){
		Aluno aluno = alunoController.selectByMatricula(matricula);
		if(aluno != null){
			textFieldNome.setText(aluno.getNome());
			textFieldMatricula.setText(aluno.getMatricula());
			textFieldNomedoCurso.setText(aluno.getnomeDoCurso());
			alunoController.Update(aluno);
		}else{
			JOptionPane.showMessageDialog(null, "Aluno não encontrado");
		}
	}
	
	private void atualizarAluno(){
		//Aluno aluno = new Aluno();
		if(validarCampos()){
			Aluno aluno = alunoController.selectByMatricula(textFieldMatricula.getText());
			aluno.setNome(textFieldNome.getText());
			aluno.setNomeDoCurso(textFieldNomedoCurso.getText());
			alunoController.Update(aluno);		
		}else{
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
		}
	}
	
	private void deletarAluno(String matricula){
		if(validarCampos()){
			alunoController.Delete(matricula);
		}else{
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
		}
	}
	
	private void limparCampos(){
		textFieldMatricula.setText("");
		textFieldNome.setText("");
		textFieldNomedoCurso.setText("");
		textFieldMatricula.setEnabled(true);
	}
	
	private boolean validarCampos(){
		boolean valido = false;
		if (textFieldMatricula.getText() != "" &&
				textFieldNome.getText() != "" && 
				textFieldNomedoCurso.getText() != ""){
			valido = true;
		}
		return valido;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarAluno = new JFrame();
		frmCadastrarAluno.setTitle("Cadastrar Aluno");
		frmCadastrarAluno.setBounds(100, 100, 563, 364);
		frmCadastrarAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarAluno.getContentPane().setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Menu Aluno:");
		lblCadastrarAluno.setBounds(0, 0, 434, 19);
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastrarAluno.setHorizontalAlignment(SwingConstants.CENTER);
		frmCadastrarAluno.getContentPane().add(lblCadastrarAluno);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(63, 51, 44, 14);
		frmCadastrarAluno.getContentPane().add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatricula.setBounds(63, 76, 67, 14);
		frmCadastrarAluno.getContentPane().add(lblMatricula);
		
		JLabel lblNomeDoCurso = new JLabel("Nome do Curso:");
		lblNomeDoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDoCurso.setBounds(63, 103, 107, 14);
		frmCadastrarAluno.getContentPane().add(lblNomeDoCurso);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(247, 50, 86, 20);
		frmCadastrarAluno.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(247, 75, 86, 20);
		frmCadastrarAluno.getContentPane().add(textFieldMatricula);
		
		textFieldNomedoCurso = new JTextField();
		textFieldNomedoCurso.setColumns(10);
		textFieldNomedoCurso.setBounds(247, 102, 86, 20);
		frmCadastrarAluno.getContentPane().add(textFieldNomedoCurso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrarAluno();
			}
		});
		
		btnCadastrar.setBounds(120, 191, 104, 23);
		frmCadastrarAluno.getContentPane().add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pesquisarAluno(textFieldMatricula.getText());
			}
		});
		btnPesquisar.setBounds(10, 191, 97, 23);
		frmCadastrarAluno.getContentPane().add(btnPesquisar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarAluno();
			}
		});
		btnAtualizar.setBounds(234, 191, 89, 23);
		frmCadastrarAluno.getContentPane().add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarAluno(textFieldMatricula.getText());
			}
		});
		btnDeletar.setBounds(337, 191, 89, 23);
		frmCadastrarAluno.getContentPane().add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar ");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(436, 191, 89, 23);
		frmCadastrarAluno.getContentPane().add(btnLimpar);
	}
}
