package com.christian.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.christian.controller.IController;
import com.christian.controller.ProfessorController;
import com.christian.model.Professor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProfessorView {

	private JFrame frmCadastroProfessor;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldCursos;
	private IController professorController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfessorView window = new ProfessorView();
					window.frmCadastroProfessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfessorView() {
		professorController = new ProfessorController();
		initialize();
	}

	public void cadastrarProfessor(){
		if (validarCampos()) {
			Professor professor = new Professor();
			
			professor.setNome(textFieldNome.getText());
			professor.setMatricula(textFieldMatricula.getText());
			professor.setCursos(textFieldCursos.getText());
			professorController.Create(professor);
			
		} else {

		}
	}
	
	public void pesquisarProfessor(String matricula ){
		Professor professor = professorController.selectByMatriculaProfessor(matricula);
		if(professor != null){
			textFieldNome.setText(professor.getNome());
			textFieldMatricula.setText(professor.getMatricula());
			textFieldCursos.setText(professor.getCursos());
			professorController.Update(professor);
		} else{
			JOptionPane.showMessageDialog(null, "professor não encontrado");
		}
	}
	public void deletarProfessor(String matricula){
		if(validarCampos()){
			professorController.Delete(matricula);
		}else{
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
		}
	}
	
	public void atualizarProfessor(){
		if (validarCampos()) {
			Professor professor = professorController.selectByMatriculaProfessor(textFieldMatricula.getText());
			professor.setNome(textFieldNome.getText());
			professor.setMatricula(textFieldMatricula.getText());
			professor.setCursos(textFieldCursos.getText());
			
			professorController.Update(professor);
						
			
		} else {
			JOptionPane.showMessageDialog(null, "Professor não encontrado");
		}
	}
	
	private boolean validarCampos(){
		boolean valido = false;
		if (textFieldMatricula.getText() != "" &&
				textFieldNome.getText() != "" //&& 
				/*textFieldCursos.getText() != ""*/){
			valido = true;
		}
		return valido;
	}
	private void limparCampos(){
		textFieldMatricula.setText("");
		textFieldNome.setText("");
		textFieldMatricula.setEnabled(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroProfessor = new JFrame();
		frmCadastroProfessor.setTitle("Cadastro Professor");
		frmCadastroProfessor.setBounds(100, 100, 563, 364);
		frmCadastroProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroProfessor.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(78, 70, 46, 14);
		frmCadastroProfessor.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(248, 67, 86, 20);
		frmCadastroProfessor.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatricula.setBounds(78, 125, 94, 14);
		frmCadastroProfessor.getContentPane().add(lblMatricula);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		textFieldMatricula.setBounds(248, 122, 86, 20);
		frmCadastroProfessor.getContentPane().add(textFieldMatricula);
		
		JLabel lblCursos = new JLabel("Cursos");
		lblCursos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursos.setBounds(78, 178, 68, 14);
		frmCadastroProfessor.getContentPane().add(lblCursos);
		
		textFieldCursos = new JTextField();
		textFieldCursos.setColumns(10);
		textFieldCursos.setBounds(248, 175, 86, 20);
		frmCadastroProfessor.getContentPane().add(textFieldCursos);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProfessor();
			}
		});
		btnInserir.setBounds(109, 227, 89, 23);
		frmCadastroProfessor.getContentPane().add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProfessor(textFieldMatricula.getText());
			}
		});
		btnPesquisar.setBounds(218, 227, 99, 23);
		frmCadastroProfessor.getContentPane().add(btnPesquisar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarProfessor(textFieldMatricula.getText());
			}
		});
		btnDeletar.setBounds(333, 227, 89, 23);
		frmCadastroProfessor.getContentPane().add(btnDeletar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCursos.setText("");
				textFieldMatricula.setText("");
				textFieldNome.setText("");
				textFieldMatricula.setEnabled(true);
			}
		});
		btnLimpar.setBounds(10, 227, 89, 23);
		frmCadastroProfessor.getContentPane().add(btnLimpar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				atualizarProfessor();
			}
		});
		btnAtualizar.setBounds(447, 227, 89, 23);
		frmCadastroProfessor.getContentPane().add(btnAtualizar);
		
		JLabel lblMenuProfessor = new JLabel("Menu Professor:");
		lblMenuProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenuProfessor.setBounds(242, 11, 143, 14);
		frmCadastroProfessor.getContentPane().add(lblMenuProfessor);
	}
}
