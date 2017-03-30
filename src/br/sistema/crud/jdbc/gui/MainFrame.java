package br.sistema.crud.jdbc.gui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.sistema.crud.jdbc.bo.PessoaBO;
import br.sistema.crud.jdbc.bo.UfBO;
import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.EnderecoDTO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.dto.UfDTO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.util.MensagensUtil;

import java.awt.Color;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 7973973234717597809L;
	private JTabbedPane mainTabbedPane;
	private JLabel lblSexo;
	private JRadioButton rbtFeminino;
	private JRadioButton rbtMasculino;
	private JLabel lblCpf;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelListagem;
	private JPanel panelCadastro;
	private ButtonGroup grpSexo;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JPanel panelConsulta;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JTextField txtCepFiltro;
	private JComboBox comboUfFiltro;
	private JPanel panelFiltro;
	private JLabel lblNumeroUpdate;
	private JLabel lblCepUpdate;
	private JLabel lblUfUpdate;
	private JTextField txtNumeroUpdate;
	private JTextField txtCepUpdate;
	private JComboBox comboUfUpdate;
	private JLabel lblBairroUpdate;
	private JLabel lblCidadeUpdate;
	private JTextField txtBairroUpdate;
	private JTextField txtCidadeUpdate;
	private JLabel lblLograUpdate;
	private JTextField txtLograUpdate;
	private JPanel panelEnderecoUpdate;
	private JPanel panelSexo;
	private JLabel lblUF;
	private JLabel lblCep;
	private JTextField txtCep;
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JLabel lblLogra;
	private JTextField txtLogra;
	private JPanel panelEnderecoCadastro;
	private JPanel panelPrincipalCadastro;
	private JComboBox comboUf;
	private ButtonGroup bgrSexoUpdate;
	private JLabel lblIDValor;
	private JLabel lblIDUpdate;
	private JButton btnUpdate;
	private JLabel lblCPFUpdate;
	private JLabel lblSexoUpdate;
	private JLabel lblDtNascUpdate;
	private JTextField txtCPFUpdate;
	private JRadioButton rbtMascUpdate;
	private JRadioButton rbtFemUpdate;
	private JTextField txtDtNascUpdate;
	private JLabel lblNomeUpdate;
	private JTextField txtNomeUpdate;
	private JPanel panelUpdate;
	private JInternalFrame internalUpdate;
	private JButton btnDeleteAll;
	private ButtonGroup btgOrderBy;
	private JLabel lblOrderBy;
	private JRadioButton rbtNomeOrder;
	private JRadioButton rbtCpfOrder;
	private JScrollPane scrollListConsulta;
	private JTable tableListConsulta;
	private JPanel panelTabelaList;
	private JButton btnConsulta;
	private ButtonGroup grpSexoConsulta;
	private JLabel lblSexoConsulta;
	private JRadioButton rbtMascConsulta;
	private JRadioButton rbtFemConsulta;
	private JTextField txtCpfConsulta;
	private JLabel lblCpfConsulta;
	private JLabel lblNomeConsulta;
	private JTextField txtNomeConsulta;
	private JScrollPane scrollListagem;
	private JTable tableListagem;
	private JLabel lblNasc;
	private JTextField txtNasc;
	private List<Integer> idsPessoas = new ArrayList<Integer>();
	
	// Formatter de datas
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private PessoaDTO pessoaDTO;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		getContentPane().setForeground(Color.GREEN);
		getContentPane().setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setBackground(Color.GREEN);
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Principal");
			this.setPreferredSize(new java.awt.Dimension(1012, 619));
			{
				mainTabbedPane = new JTabbedPane();
				{
					panelCadastro = new JPanel();
					panelCadastro.setBackground(Color.gray);
					GroupLayout panelCadastroLayout = new GroupLayout((JComponent)panelCadastro);
					panelCadastro.setLayout(panelCadastroLayout);
					mainTabbedPane.addTab("Cadastro", null, panelCadastro, null);
					panelCadastro.setPreferredSize(new java.awt.Dimension(403, 255));
					panelCadastroLayout.setHorizontalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addComponent(getPanelPrincipalCadastro(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getPanelSexo(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addGroup(panelCadastroLayout.createSequentialGroup()
						        .addComponent(getPanelEnderecoCadastro(), GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 0, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addGap(260)
						        .addComponent(getBtnLimpar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						        .addGap(19)
						        .addComponent(getBtnCadastrar(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)))
						.addContainerGap(37, 37));
					panelCadastroLayout.setVerticalGroup(panelCadastroLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelCadastroLayout.createParallelGroup()
						    .addComponent(getPanelEnderecoCadastro(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						    .addGroup(GroupLayout.Alignment.LEADING, panelCadastroLayout.createSequentialGroup()
						        .addComponent(getPanelPrincipalCadastro(), GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						        .addGap(18)
						        .addComponent(getPanelSexo(), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
						.addGroup(panelCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(getBtnLimpar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(getBtnCadastrar(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(148, 148));
				}
				{
					panelListagem = new JPanel();
					panelListagem.setBackground(Color.gray);
					GroupLayout panelListagemLayout = new GroupLayout((JComponent)panelListagem);
					panelListagem.setLayout(panelListagemLayout);
					mainTabbedPane.addTab("Consulta", null, getPanelConsulta(), null);
					mainTabbedPane.addTab("Listagem", null, panelListagem, null);
					panelListagem.setPreferredSize(new java.awt.Dimension(965, 516));
					panelListagemLayout.setHorizontalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panelListagemLayout.createParallelGroup()
						    .addGroup(panelListagemLayout.createSequentialGroup()
						        .addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 0, Short.MAX_VALUE))
						    .addGroup(GroupLayout.Alignment.LEADING, panelListagemLayout.createSequentialGroup()
						        .addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						        .addGap(0, 811, Short.MAX_VALUE))
						    .addComponent(getInternalUpdate(), GroupLayout.Alignment.LEADING, 0, 942, Short.MAX_VALUE))
						.addContainerGap());
					panelListagemLayout.setVerticalGroup(panelListagemLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(getBtnDeleteAll(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(getScrollListagem(), GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(getInternalUpdate(), 0, 311, Short.MAX_VALUE)
						.addContainerGap());
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 548, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(mainTabbedPane, 0, 970, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			this.setSize(1012, 619);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JRadioButton getRbtMasculino() {
		if(rbtMasculino == null) {
			rbtMasculino = new JRadioButton();
			rbtMasculino.setText("Masculino");
			rbtMasculino.setSelected(true);
			getGrpSexo().add(rbtMasculino);
		}
		return rbtMasculino;
	}
	
	private JRadioButton getJRadioButton1() {
		if(rbtFeminino == null) {
			rbtFeminino = new JRadioButton();
			rbtFeminino.setText("Feminino");
			getGrpSexo().add(rbtFeminino);
		}
		return rbtFeminino;
	}
	
	private JLabel getJLabel1() {
		if(lblSexo == null) {
			lblSexo = new JLabel();
			lblSexo.setText("Sexo:");
		}
		return lblSexo;
	}
	
	private ButtonGroup getGrpSexo() {
		if(grpSexo == null) {
			grpSexo = new ButtonGroup();
		}
		return grpSexo;
	}
	
	private JTextField getJTextField1() {
		if(txtNasc == null) {
			txtNasc = new JTextField();
		}
		return txtNasc;
	}
	
	private JLabel getJLabel1x() {
		if(lblNasc == null) {
			lblNasc = new JLabel();
			lblNasc.setText("Dt. Nasc:");
		}
		return lblNasc;
	}
	
	private JButton getBtnLimpar() {
		if(btnLimpar == null) {
			btnLimpar = new JButton();
			btnLimpar.setText("Limpar");
			btnLimpar.setMnemonic(java.awt.event.KeyEvent.VK_L);
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtNome.setText("");
					txtCpf.setText("");
					txtNasc.setText("");
					rbtMasculino.setSelected(true);
					txtLogra.setText("");
					txtBairro.setText("");
					txtCidade.setText("");
					txtCep.setText("");
					txtNumero.setText("");
					comboUf.setSelectedIndex(0);
				}
			});
		}
		return btnLimpar;
	}
	
	private JButton getBtnCadastrar() {
		if(btnCadastrar == null) {
			btnCadastrar = new JButton();
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.setMnemonic(java.awt.event.KeyEvent.VK_C);
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					EnderecoDTO enderecoDTO = new EnderecoDTO();
					PessoaBO pessoaBO = new PessoaBO();
					try {
						String nome = txtNome.getText();
						String cpf = txtCpf.getText();
						String nasc = txtNasc.getText();

						pessoaBO.validaNome(nome);
						pessoaBO.validaCpf(cpf);
						pessoaBO.validaDtNasc(nasc);
						
						pessoaDTO.setNome(nome);
						pessoaDTO.setCpf(Long.parseLong(cpf));
						
						pessoaDTO.setDtNascimento(dateFormat.parse(nasc));
						char sexo = rbtMasculino.isSelected() ? 'M' : 'F';
						pessoaDTO.setSexo(sexo);
						
						enderecoDTO.setLogradouro(txtLogra.getText());
						enderecoDTO.setBairro(txtBairro.getText());
						enderecoDTO.setCep(txtCep.getText().equals("") ? null : Integer.parseInt(txtCep.getText()));
						enderecoDTO.setCidade(txtCidade.getText());
						enderecoDTO.setNumero(txtNumero.getText().equals("") ? null : Long.parseLong(txtNumero.getText()));
						
						// Valida os dados do endereço
						pessoaBO.validaEndereco(enderecoDTO);
						
						UfDTO ufDTO = new UfDTO();
						ufDTO.setIdUF(comboUf.getSelectedIndex() + 1);
						enderecoDTO.setUfDTO(ufDTO);
						
						pessoaDTO.setEnderecoDTO(enderecoDTO);
						pessoaBO.cadastrar(pessoaDTO);
						MensagensUtil.addMsg(MainFrame.this, "Cadastro efetuado com sucesso!");
						MainFrame.this.dispose();
						main(null);
					} catch (Exception e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnCadastrar;
	}
	
	private JTable getTableListagem() {
		final PessoaBO pessoaBO = new PessoaBO();
		try {
			String[][] lista = pessoaBO.listagem(idsPessoas);
			if(tableListagem == null) {
				tableListagem = new JTable();
			}
			TableModel tableListagemModel = 
					new DefaultTableModel(
							lista,
							new String[] { "Id", "Nome", "CPF", "Sexo", "Dt. Nasc.", "Logradouro", "CEP", "UF", "", "" });
			tableListagem.setModel(tableListagemModel);
			
			Action actionDelecao = new AbstractAction() {
				private static final long serialVersionUID = -6939769650161954746L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja realmente remover essa pessoa?");
					if (resp == 0) {
						JTable table = (JTable) actionEvent.getSource();
						
						int linha = Integer.parseInt(actionEvent.getActionCommand());
						((DefaultTableModel) table.getModel()).removeRow(linha);
						try {
							pessoaDTO = pessoaBO.buscaPorId(idsPessoas.get(linha));

							pessoaBO.removePessoa(idsPessoas.get(linha), getPessoaDTO().getEnderecoDTO().getIdEndereco());
							idsPessoas.remove(linha);
							MensagensUtil.addMsg(MainFrame.this, "Pessoa removida com sucesso!");
						} catch (NegocioException e) {
							e.printStackTrace();
							MensagensUtil.addMsg(MainFrame.this, e.getMessage());
						}
					}
				}
			};

			Action actionEdicao = new AbstractAction() {
				private static final long serialVersionUID = -421951775656187572L;

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					int linha = Integer.parseInt(actionEvent.getActionCommand());
					try {
						pessoaDTO = pessoaBO.buscaPorId(idsPessoas.get(linha));
						populaInternalUpdate(pessoaDTO);
					} catch (NegocioException e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			};
			
			ButtonColumn buttonColumnEdicao = new ButtonColumn(tableListagem, actionEdicao, 8);
			ButtonColumn buttonColumnDelecao = new ButtonColumn(tableListagem, actionDelecao, 9);
			buttonColumnDelecao.setMnemonic(KeyEvent.VK_D);
			buttonColumnEdicao.setMnemonic(KeyEvent.VK_E);
		} catch (NegocioException e) {
			e.printStackTrace();
			MensagensUtil.addMsg(MainFrame.this, e.getMessage());
		}
		return tableListagem;
	}
	
	private void populaInternalUpdate(PessoaDTO pessoaDTO) {
		this.lblIDValor.setText(pessoaDTO.getIdPessoa().toString());
		this.txtNomeUpdate.setText(pessoaDTO.getNome());
		this.txtCPFUpdate.setText(pessoaDTO.getCpf().toString());
		this.txtDtNascUpdate.setText(dateFormat.format(pessoaDTO.getDtNascimento()));
		this.rbtMascUpdate.setSelected(pessoaDTO.getSexo() == 'M');
		this.rbtFemUpdate.setSelected(pessoaDTO.getSexo() == 'F');
		
		EnderecoDTO endereco = pessoaDTO.getEnderecoDTO();
		this.txtLograUpdate.setText(endereco.getLogadouro());
		this.txtBairroUpdate.setText(endereco.getBairro());
		this.txtCidadeUpdate.setText(endereco.getCidade());
		this.txtNumeroUpdate.setText(endereco.getNumero().toString());
		this.txtCepUpdate.setText(endereco.getCep().toString());
		this.comboUfUpdate.setSelectedIndex(endereco.getUfDTO().getIdUF() - 1);
		this.internalUpdate.setVisible(true);
	}
	
	private JScrollPane getScrollListagem() {
		if(scrollListagem == null) {
			scrollListagem = new JScrollPane();
			scrollListagem.setViewportView(getTableListagem());
		}
		return scrollListagem;
	}
	
	private JPanel getPanelConsulta() {
		if(panelConsulta == null) {
			panelConsulta = new JPanel();
			panelConsulta.setBackground(Color.gray);
			GroupLayout panelConsultaLayout = new GroupLayout((JComponent)panelConsulta);
			panelConsulta.setLayout(panelConsultaLayout);
			panelConsulta.setPreferredSize(new java.awt.Dimension(498, 353));
			panelConsultaLayout.setHorizontalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelConsultaLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 823, Short.MAX_VALUE))
				    .addComponent(getPanelTabelaList(), GroupLayout.Alignment.LEADING, 0, 946, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, panelConsultaLayout.createSequentialGroup()
				        .addComponent(getPanelFiltro(), GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 339, Short.MAX_VALUE)))
				.addGap(7));
			panelConsultaLayout.setVerticalGroup(panelConsultaLayout.createSequentialGroup()
				.addContainerGap(17, 17)
				.addComponent(getPanelFiltro(), GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getBtnConsulta(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(getPanelTabelaList(), 0, 207, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelConsulta;
	}
	
	private JTextField getJTextField1x() {
		if(txtNomeConsulta == null) {
			txtNomeConsulta = new JTextField();
		}
		return txtNomeConsulta;
	}
	
	private JLabel getJLabel1xx() {
		if(lblNomeConsulta == null) {
			lblNomeConsulta = new JLabel();
			lblNomeConsulta.setText("Nome:");
		}
		return lblNomeConsulta;
	}

	private JLabel getJLabel1xxx() {
		if(lblCpfConsulta == null) {
			lblCpfConsulta = new JLabel();
			lblCpfConsulta.setText("CPF:");
		}
		return lblCpfConsulta;
	}
	
	private JTextField getJTextField1xx() {
		if(txtCpfConsulta == null) {
			txtCpfConsulta = new JTextField();
		}
		return txtCpfConsulta;
	}
	
	private JRadioButton getJRadioButton1x() {
		if(rbtFemConsulta == null) {
			rbtFemConsulta = new JRadioButton();
			rbtFemConsulta.setText("Feminino");
			getGrpSexoConsulta().add(rbtFemConsulta);
		}
		return rbtFemConsulta;
	}
	
	private JRadioButton getJRadioButton2() {
		if(rbtMascConsulta == null) {
			rbtMascConsulta = new JRadioButton();
			rbtMascConsulta.setText("Masculino");
			rbtMascConsulta.setSelected(true);
			getGrpSexoConsulta().add(rbtMascConsulta);
		}
		return rbtMascConsulta;
	}
	
	private JLabel getJLabel2() {
		if(lblSexoConsulta == null) {
			lblSexoConsulta = new JLabel();
			lblSexoConsulta.setText("Sexo:");
		}
		return lblSexoConsulta;
	}
	
	private ButtonGroup getGrpSexoConsulta() {
		if(grpSexoConsulta == null) {
			grpSexoConsulta = new ButtonGroup();
		}
		return grpSexoConsulta;
	}
	
	private JButton getBtnConsulta() {
		if(btnConsulta == null) {
			btnConsulta = new JButton();
			btnConsulta.setText("Consultar");
			btnConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					getTableListConsulta();
				}
			});
		}
		return btnConsulta;
	}
	
	private JPanel getPanelTabelaList() {
		if(panelTabelaList == null) {
			panelTabelaList = new JPanel();
			panelTabelaList.setBackground(Color.gray);
			GroupLayout panelTabelaListLayout = new GroupLayout((JComponent)panelTabelaList);
			panelTabelaList.setLayout(panelTabelaListLayout);
			panelTabelaList.setBorder(BorderFactory.createTitledBorder("Listagem"));
			panelTabelaListLayout.setHorizontalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getScrollListConsulta(), 0, 912, Short.MAX_VALUE)
				.addContainerGap());
			panelTabelaListLayout.setVerticalGroup(panelTabelaListLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getScrollListConsulta(), 0, 155, Short.MAX_VALUE)
				.addContainerGap());
		}
		return panelTabelaList;
	}
	
	private JTable getTableListConsulta() {
		if(tableListConsulta == null) {
			tableListConsulta = new JTable();
		} else {
			String nome = txtNomeConsulta.getText();
			Long cpf = txtCpfConsulta.getText().equals("") ? null : Long.parseLong(txtCpfConsulta.getText());
			char sexo = rbtMascConsulta.isSelected() ? 'M' : 'F';
			String orderBy = rbtNomeOrder.isSelected() ? "nome" : "cpf";
			
			PessoaBO pessoaBO = new PessoaBO();
			try {
				String[][] lista = pessoaBO.listaConsulta(nome, cpf, sexo, orderBy);
				TableModel tableListConsultaModel = 
						new DefaultTableModel(
								lista,
								new String[] { "Id", "Nome", "CPF", "Endereço", "Sexo", "Dt. Nasc." });
				tableListConsulta.setModel(tableListConsultaModel);
			} catch (Exception e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return tableListConsulta;
	}
	
	private JScrollPane getScrollListConsulta() {
		if(scrollListConsulta == null) {
			scrollListConsulta = new JScrollPane();
			scrollListConsulta.setViewportView(getTableListConsulta());
		}
		return scrollListConsulta;
	}
	
	private JRadioButton getJRadioButton1xx() {
		if(rbtCpfOrder == null) {
			rbtCpfOrder = new JRadioButton();
			rbtCpfOrder.setText("CPF");
			getBtgOrderBy().add(rbtCpfOrder);
		}
		return rbtCpfOrder;
	}
	
	private JRadioButton getJRadioButton2x() {
		if(rbtNomeOrder == null) {
			rbtNomeOrder = new JRadioButton();
			rbtNomeOrder.setText("Nome");
			rbtNomeOrder.setSelected(true);
			getBtgOrderBy().add(rbtNomeOrder);
		}
		return rbtNomeOrder;
	}
	
	private JLabel getJLabel1xxxx() {
		if(lblOrderBy == null) {
			lblOrderBy = new JLabel();
			lblOrderBy.setText("Order by:");
		}
		return lblOrderBy;
	}
	
	private ButtonGroup getBtgOrderBy() {
		if(btgOrderBy == null) {
			btgOrderBy = new ButtonGroup();
		}
		return btgOrderBy;
	}
	
	private JButton getBtnDeleteAll() {
		if(btnDeleteAll == null) {
			btnDeleteAll = new JButton();
			btnDeleteAll.setText("Deletar tudo");
			btnDeleteAll.setMnemonic(java.awt.event.KeyEvent.VK_D);
			btnDeleteAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaBO pessoaBO = new PessoaBO();
						int resp = JOptionPane.showConfirmDialog(MainFrame.this, "Deseja realmente remover tudo?");
						if (resp == 0) {
							try {
								pessoaBO.removeTudo();
								String[][] lista = pessoaBO.listagem(idsPessoas);
								if (lista.length == 0) {
									btnDeleteAll.setEnabled(false);
								}
							} catch (NegocioException e) {
								e.printStackTrace();
								MensagensUtil.addMsg(MainFrame.this, e.getMessage());
							}
							MensagensUtil.addMsg(MainFrame.this, "Pessoas removidas com sucesso!");
							getTableListagem();
						}
				}
			});
		}
		return btnDeleteAll;
	}
	
	private JInternalFrame getInternalUpdate() {
		if(internalUpdate == null) {
			internalUpdate = new JInternalFrame();
			internalUpdate.getContentPane().setBackground(Color.gray);
			internalUpdate.setBackground(Color.gray);
			GroupLayout internalUpdateLayout = new GroupLayout((JComponent)internalUpdate.getContentPane());
			internalUpdate.getContentPane().setLayout(internalUpdateLayout);
			internalUpdate.setVisible(true);
			internalUpdate.setBounds(12, 192, 942, 311);
			internalUpdate.setName("");
			internalUpdate.setTitle("Edita Pessoa");
			internalUpdateLayout.setHorizontalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 916, Short.MAX_VALUE)
				.addContainerGap());
			internalUpdateLayout.setVerticalGroup(internalUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(getPanelUpdate(), 0, 257, Short.MAX_VALUE)
				.addContainerGap());
		}
		return internalUpdate;
	}
	
	private JPanel getPanelUpdate() {
		if(panelUpdate == null) {
			panelUpdate = new JPanel();
			panelUpdate.setBackground(Color.gray);
			GroupLayout panelUpdateLayout = new GroupLayout((JComponent)panelUpdate);
			panelUpdate.setLayout(panelUpdateLayout);
			panelUpdate.setBorder(BorderFactory.createTitledBorder("Edição de Pessoa"));
			panelUpdateLayout.setHorizontalGroup(panelUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(panelUpdateLayout.createSequentialGroup()
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addGroup(panelUpdateLayout.createSequentialGroup()
				                .addGroup(panelUpdateLayout.createParallelGroup()
				                    .addComponent(getJLabel1xxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(getJLabel4(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addGroup(panelUpdateLayout.createParallelGroup()
				                    .addComponent(getJTextField1xxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(getJTextField3(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJLabel1xxxxxxx(), GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				                .addGap(18)
				                .addComponent(getJLabel1xxxxxxxx(), GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
				                .addGap(200)))
				        .addGap(26)
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addComponent(getJLabel1xxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel2x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				        .addGap(7)
				        .addGroup(panelUpdateLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				                .addComponent(getJRadioButton2xx(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				                .addComponent(getJRadioButton1xxx(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				                .addGap(11))
				            .addComponent(getJTextField1xxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				        .addGap(76))
				    .addComponent(getPanelEnderecoUpdate(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(getBtnUpdate(), 0, 119, Short.MAX_VALUE));
			panelUpdateLayout.setVerticalGroup(panelUpdateLayout.createSequentialGroup()
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(getJRadioButton2xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJRadioButton1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJLabel2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJLabel1xxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				        .addComponent(getJLabel1xxxxxxxx(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addGroup(panelUpdateLayout.createSequentialGroup()
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJTextField1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJTextField3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				    .addGroup(panelUpdateLayout.createSequentialGroup()
				        .addGap(22)
				        .addGroup(panelUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJTextField1xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addGap(12)))
				.addGroup(panelUpdateLayout.createParallelGroup()
				    .addComponent(getPanelEnderecoUpdate(), GroupLayout.Alignment.LEADING, 0, 109, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, panelUpdateLayout.createSequentialGroup()
				        .addGap(93)
				        .addComponent(getBtnUpdate(), 0, 16, Short.MAX_VALUE)))
				.addContainerGap());
		}
		return panelUpdate;
	}
	
	private JTextField getJTextField1xxx() {
		if(txtNomeUpdate == null) {
			txtNomeUpdate = new JTextField();
		}
		return txtNomeUpdate;
	}
	
	private JLabel getJLabel1xxxxx() {
		if(lblNomeUpdate == null) {
			lblNomeUpdate = new JLabel();
			lblNomeUpdate.setText("Nome:");
		}
		return lblNomeUpdate;
	}
	
	private JTextField getJTextField1xxxx() {
		if(txtDtNascUpdate == null) {
			txtDtNascUpdate = new JTextField();
		}
		return txtDtNascUpdate;
	}
	
	private JRadioButton getJRadioButton1xxx() {
		if(rbtFemUpdate == null) {
			rbtFemUpdate = new JRadioButton();
			rbtFemUpdate.setText("Feminino");
			getBgrSexoUpdate().add(rbtFemUpdate);
		}
		return rbtFemUpdate;
	}
	
	private JRadioButton getJRadioButton2xx() {
		if(rbtMascUpdate == null) {
			rbtMascUpdate = new JRadioButton();
			rbtMascUpdate.setText("Masculino");
			getBgrSexoUpdate().add(rbtMascUpdate);
			rbtMascUpdate.setSelected(true);
		}
		return rbtMascUpdate;
	}

	private JTextField getJTextField3() {
		if(txtCPFUpdate == null) {
			txtCPFUpdate = new JTextField();
		}
		return txtCPFUpdate;
	}
	
	private JLabel getJLabel1xxxxxx() {
		if(lblDtNascUpdate == null) {
			lblDtNascUpdate = new JLabel();
			lblDtNascUpdate.setText("Dt. Nasc:");
		}
		return lblDtNascUpdate;
	}
	
	private JLabel getJLabel2x() {
		if(lblSexoUpdate == null) {
			lblSexoUpdate = new JLabel();
			lblSexoUpdate.setText("Sexo:");
		}
		return lblSexoUpdate;
	}

	private JLabel getJLabel4() {
		if(lblCPFUpdate == null) {
			lblCPFUpdate = new JLabel();
			lblCPFUpdate.setText("CPF:");
		}
		return lblCPFUpdate;
	}
	
	private JButton getBtnUpdate() {
		if(btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setText("Editar");
			btnUpdate.setMnemonic(java.awt.event.KeyEvent.VK_E);
			btnUpdate.setSize(114, 28);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					PessoaDTO pessoaDTO = new PessoaDTO();
					EnderecoDTO enderecoDTO = new EnderecoDTO();
					PessoaBO pessoaBO = new PessoaBO();
					try {
						String nome = txtNomeUpdate.getText();
						String cpf = txtCPFUpdate.getText();
						String nasc = txtDtNascUpdate.getText();

						pessoaBO.validaNome(nome);
						pessoaBO.validaCpf(cpf);
						pessoaBO.validaDtNasc(nasc);
						
						pessoaDTO.setNome(nome);
						pessoaDTO.setCpf(Long.parseLong(cpf));
						
						pessoaDTO.setDtNascimento(dateFormat.parse(nasc));
						char sexo = rbtMascUpdate.isSelected() ? 'M' : 'F';
						pessoaDTO.setSexo(sexo);
						
						enderecoDTO.setIdEndereco(getPessoaDTO().getEnderecoDTO().getIdEndereco());
						enderecoDTO.setLogradouro(txtLograUpdate.getText());
						enderecoDTO.setBairro(txtBairroUpdate.getText());
						enderecoDTO.setCep(txtCepUpdate.getText().equals("") ? null : Integer.parseInt(txtCepUpdate.getText()));
						enderecoDTO.setCidade(txtCidadeUpdate.getText());
						enderecoDTO.setNumero(txtNumeroUpdate.getText().equals("") ? null : Long.parseLong(txtNumeroUpdate.getText()));
						
						// Valida os dados do endereço
						pessoaBO.validaEndereco(enderecoDTO);
						
						UfDTO ufDTO = new UfDTO();
						ufDTO.setIdUF(comboUfUpdate.getSelectedIndex() + 1);
						enderecoDTO.setUfDTO(ufDTO);
						
						pessoaDTO.setEnderecoDTO(enderecoDTO);
						pessoaDTO.setIdPessoa(getPessoaDTO().getIdPessoa());
						PessoaDAO pessoaDAO = new PessoaDAO();
						pessoaDAO.atualizar(pessoaDTO);
						MensagensUtil.addMsg(MainFrame.this, "Pessoa atualizada com sucesso!");
						getTableListagem();
					} catch (Exception e) {
						e.printStackTrace();
						MensagensUtil.addMsg(MainFrame.this, e.getMessage());
					}
				}
			});
		}
		return btnUpdate;
	}

	private JLabel getJLabel1xxxxxxx() {
		if(lblIDUpdate == null) {
			lblIDUpdate = new JLabel();
			lblIDUpdate.setText("ID:");
		}
		return lblIDUpdate;
	}
	
	private JLabel getJLabel1xxxxxxxx() {
		if(lblIDValor == null) {
			lblIDValor = new JLabel();
		}
		return lblIDValor;
	}
	
	private ButtonGroup getBgrSexoUpdate() {
		if(bgrSexoUpdate == null) {
			bgrSexoUpdate = new ButtonGroup();
		}
		return bgrSexoUpdate;
	}

	private String[] converteEstados(List<UfDTO> lista) {
		String[] result = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			UfDTO ufDTO = lista.get(i);
			result[i] = ufDTO.getDescricao();
		}
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getComboUf() {
		if(comboUf == null) {
			try {
				UfBO ufBO = new UfBO();
				ComboBoxModel comboUfModel;
				comboUfModel = new DefaultComboBoxModel(converteEstados(ufBO.listaUfs()));
				comboUf = new JComboBox();
				comboUf.setModel(comboUfModel);
			} catch (NegocioException e) {
				e.printStackTrace();
			}
		}
		return comboUf;
	}
	
	private JPanel getPanelPrincipalCadastro() {
		if(panelPrincipalCadastro == null) {
			panelPrincipalCadastro = new JPanel();
			panelPrincipalCadastro.setBackground(Color.gray);
			GroupLayout panelPrincipalCadastroLayout = new GroupLayout((JComponent)panelPrincipalCadastro);
			panelPrincipalCadastro.setLayout(panelPrincipalCadastroLayout);
			panelPrincipalCadastro.setBorder(BorderFactory.createTitledBorder("Pessoa"));
			{
				lblNome = new JLabel();
				lblNome.setText("Nome:");
			}
			{
				txtNome = new JTextField();
			}
			{
				lblCpf = new JLabel();
				lblCpf.setText("CPF:");
			}
			{
				txtCpf = new JTextField();
			}
			panelPrincipalCadastroLayout.setVerticalGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblNome, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(txtCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblCpf, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, GroupLayout.PREFERRED_SIZE)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, 20));
			panelPrincipalCadastroLayout.linkSize(SwingConstants.VERTICAL, new Component[] {lblCpf, lblNome});
			panelPrincipalCadastroLayout.linkSize(SwingConstants.VERTICAL, new Component[] {txtCpf, txtNome});
			panelPrincipalCadastroLayout.setHorizontalGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup()
				    .addComponent(lblNome, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(lblCpf, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelPrincipalCadastroLayout.createParallelGroup()
				    .addGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, panelPrincipalCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField1(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(49, Short.MAX_VALUE));
			panelPrincipalCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblCpf, lblNome});
			panelPrincipalCadastroLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtCpf, txtNome});
		}
		return panelPrincipalCadastro;
	}
	
	private JPanel getPanelEnderecoCadastro() {
		if(panelEnderecoCadastro == null) {
			panelEnderecoCadastro = new JPanel();
			panelEnderecoCadastro.setBackground(Color.gray);
			GroupLayout panelEnderecoCadastroLayout = new GroupLayout((JComponent)panelEnderecoCadastro);
			panelEnderecoCadastro.setLayout(panelEnderecoCadastroLayout);
			panelEnderecoCadastro.setBorder(BorderFactory.createTitledBorder("Endereço"));
			panelEnderecoCadastroLayout.setHorizontalGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup()
				    .addComponent(getJLabel1xxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4x(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel5(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getComboUf(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField4(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField3x(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField2x(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField1xxxxxx(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				        .addComponent(getJTextField1xxxxx(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(136, Short.MAX_VALUE));
			panelEnderecoCadastroLayout.setVerticalGroup(panelEnderecoCadastroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField3x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField4(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel4x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoCadastroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getComboUf(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel5(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(47, 47));
		}
		return panelEnderecoCadastro;
	}
	
	private JTextField getJTextField1xxxxx() {
		if(txtLogra == null) {
			txtLogra = new JTextField();
		}
		return txtLogra;
	}
	
	private JLabel getJLabel1xxxxxxxxx() {
		if(lblLogra == null) {
			lblLogra = new JLabel();
			lblLogra.setText("Logradouro:");
		}
		return lblLogra;
	}
	
	private JTextField getJTextField1xxxxxx() {
		if(txtBairro == null) {
			txtBairro = new JTextField();
		}
		return txtBairro;
	}
	
	private JLabel getJLabel1xxxxxxxxxx() {
		if(lblBairro == null) {
			lblBairro = new JLabel();
			lblBairro.setText("Bairro:");
		}
		return lblBairro;
	}
	
	private JTextField getJTextField2x() {
		if(txtCidade == null) {
			txtCidade = new JTextField();
		}
		return txtCidade;
	}
	
	private JLabel getJLabel2xx() {
		if(lblCidade == null) {
			lblCidade = new JLabel();
			lblCidade.setText("Cidade:");
		}
		return lblCidade;
	}
	
	private JTextField getJTextField3x() {
		if(txtNumero == null) {
			txtNumero = new JTextField();
		}
		return txtNumero;
	}
	
	private JLabel getJLabel3x() {
		if(lblNumero == null) {
			lblNumero = new JLabel();
			lblNumero.setText("Número:");
		}
		return lblNumero;
	}
	
	private JTextField getJTextField4() {
		if(txtCep == null) {
			txtCep = new JTextField();
		}
		return txtCep;
	}
	
	private JLabel getJLabel4x() {
		if(lblCep == null) {
			lblCep = new JLabel();
			lblCep.setText("CEP:");
		}
		return lblCep;
	}
	
	private JLabel getJLabel5() {
		if(lblUF == null) {
			lblUF = new JLabel();
			lblUF.setText("UF:");
		}
		return lblUF;
	}
	
	private JPanel getPanelSexo() {
		if(panelSexo == null) {
			panelSexo = new JPanel();
			panelSexo.setBackground(Color.gray);
			GroupLayout panelSexoLayout = new GroupLayout((JComponent)panelSexo);
			panelSexo.setLayout(panelSexoLayout);
			panelSexo.setBorder(BorderFactory.createTitledBorder("Sexo"));
			panelSexoLayout.setHorizontalGroup(panelSexoLayout.createSequentialGroup()
				.addContainerGap(24, Short.MAX_VALUE)
				.addComponent(getJLabel1(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(getRbtMasculino(), GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				.addComponent(getJRadioButton1(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(97, 97));
			panelSexoLayout.setVerticalGroup(panelSexoLayout.createSequentialGroup()
				.addContainerGap(20, 20)
				.addGroup(panelSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getRbtMasculino(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(26, 26));
		}
		return panelSexo;
	}
	
	private JPanel getPanelEnderecoUpdate() {
		if(panelEnderecoUpdate == null) {
			panelEnderecoUpdate = new JPanel();
			panelEnderecoUpdate.setBackground(Color.gray);
			GroupLayout panelEnderecoUpdateLayout = new GroupLayout((JComponent)panelEnderecoUpdate);
			panelEnderecoUpdate.setLayout(panelEnderecoUpdateLayout);
			panelEnderecoUpdate.setBorder(BorderFactory.createTitledBorder("Endereço"));
			panelEnderecoUpdateLayout.setHorizontalGroup(panelEnderecoUpdateLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup()
				    .addComponent(getJLabel1xxxxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup()
				    .addComponent(getJTextField2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				.addGap(39)
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelEnderecoUpdateLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(getJLabel1xxxxxxxxxxxxx(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoUpdateLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(getJLabel2xxxx(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelEnderecoUpdateLayout.createSequentialGroup()
				        .addComponent(getJLabel3(), GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup()
				    .addComponent(getJComboBoxUpdateUf(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField2xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(155, 155));
			panelEnderecoUpdateLayout.setVerticalGroup(panelEnderecoUpdateLayout.createSequentialGroup()
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1xxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField2xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel3(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelEnderecoUpdateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJComboBoxUpdateUf(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxxxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
		}
		return panelEnderecoUpdate;
	}
	
	private JTextField getJTextField1xxxxxxx() {
		if(txtLograUpdate == null) {
			txtLograUpdate = new JTextField();
		}
		return txtLograUpdate;
	}
	
	private JLabel getJLabel1xxxxxxxxxxx() {
		if(lblLograUpdate == null) {
			lblLograUpdate = new JLabel();
			lblLograUpdate.setText("Logradouro:");
		}
		return lblLograUpdate;
	}
	
	private JTextField getJTextField1xxxxxxxx() {
		if(txtCidadeUpdate == null) {
			txtCidadeUpdate = new JTextField();
		}
		return txtCidadeUpdate;
	}
	
	private JTextField getJTextField2() {
		if(txtBairroUpdate == null) {
			txtBairroUpdate = new JTextField();
		}
		return txtBairroUpdate;
	}
	
	private JLabel getJLabel1xxxxxxxxxxxx() {
		if(lblCidadeUpdate == null) {
			lblCidadeUpdate = new JLabel();
			lblCidadeUpdate.setText("Cidade:");
		}
		return lblCidadeUpdate;
	}
	
	private JLabel getJLabel2xxx() {
		if(lblBairroUpdate == null) {
			lblBairroUpdate = new JLabel();
			lblBairroUpdate.setText("Bairro:");
		}
		return lblBairroUpdate;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getJComboBoxUpdateUf() {
		if(comboUfUpdate == null) {
			try {
				UfBO ufBO = new UfBO();
				ComboBoxModel comboUfModel;
					comboUfModel = new DefaultComboBoxModel(converteEstados(ufBO.listaUfs()));
				comboUfUpdate = new JComboBox();
				comboUfUpdate.setModel(comboUfModel);
			} catch (NegocioException e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return comboUfUpdate;
	}
	
	private JTextField getJTextField1xxxxxxxxx() {
		if(txtCepUpdate == null) {
			txtCepUpdate = new JTextField();
		}
		return txtCepUpdate;
	}
	
	private JTextField getJTextField2xx() {
		if(txtNumeroUpdate == null) {
			txtNumeroUpdate = new JTextField();
		}
		return txtNumeroUpdate;
	}
	
	private JLabel getJLabel1xxxxxxxxxxxxx() {
		if(lblUfUpdate == null) {
			lblUfUpdate = new JLabel();
			lblUfUpdate.setText("UF:");
		}
		return lblUfUpdate;
	}
	
	private JLabel getJLabel2xxxx() {
		if(lblCepUpdate == null) {
			lblCepUpdate = new JLabel();
			lblCepUpdate.setText("CEP:");
		}
		return lblCepUpdate;
	}
	
	private JLabel getJLabel3() {
		if(lblNumeroUpdate == null) {
			lblNumeroUpdate = new JLabel();
			lblNumeroUpdate.setText("Número:");
		}
		return lblNumeroUpdate;
	}

	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}
	
	private JPanel getPanelFiltro() {
		if(panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.setBackground(Color.gray);
			GroupLayout panelFiltroLayout = new GroupLayout((JComponent)panelFiltro);
			panelFiltro.setLayout(panelFiltroLayout);
			panelFiltro.setBorder(BorderFactory.createTitledBorder("Filtro"));
			panelFiltroLayout.setHorizontalGroup(panelFiltroLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(panelFiltroLayout.createParallelGroup()
				    .addGroup(panelFiltroLayout.createSequentialGroup()
				        .addGroup(panelFiltroLayout.createParallelGroup()
				            .addComponent(getJLabel1xx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel2(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addGroup(panelFiltroLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				                .addComponent(getJTextField1x(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				                .addGap(73))
				            .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				                .addComponent(getJTextField1xx(), GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				                .addGap(73))
				            .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				                .addComponent(getJRadioButton2(), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addGroup(panelFiltroLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				                        .addComponent(getJRadioButton1x(), GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
				                        .addGap(15))
				                    .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				                        .addComponent(getJRadioButton1xx(), GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				                        .addGap(8)
				                        .addGroup(panelFiltroLayout.createParallelGroup()
				                            .addComponent(getJLabel1xxxxxxxxxxxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
				                            .addComponent(getJLabel2xxxxx(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))))
				    .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createSequentialGroup()
				        .addComponent(getJLabel1xxxx(), GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJRadioButton2x(), GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
				        .addGap(140)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelFiltroLayout.createParallelGroup()
				    .addGroup(panelFiltroLayout.createSequentialGroup()
				        .addComponent(getJComboBoxUfFiltro(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelFiltroLayout.createSequentialGroup()
				        .addComponent(getJTextField1xxxxxxxxxx(), GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(55, Short.MAX_VALUE));
			panelFiltroLayout.setVerticalGroup(panelFiltroLayout.createSequentialGroup()
				.addGap(7)
				.addGroup(panelFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJTextField1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJTextField1xxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2xxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(panelFiltroLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, panelFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(getJTextField1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(getJLabel1xxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addGroup(panelFiltroLayout.createSequentialGroup()
				        .addGap(0, 10, Short.MAX_VALUE)
				        .addGroup(panelFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(getJComboBoxUfFiltro(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(getJLabel1xxxxxxxxxxxxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 1, GroupLayout.PREFERRED_SIZE)
				.addGroup(panelFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJRadioButton2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel2(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(54)
				.addGroup(panelFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(getJRadioButton2x(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJLabel1xxxx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(getJRadioButton1xx(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap());
		}
		return panelFiltro;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox getJComboBoxUfFiltro() {
		if(comboUfFiltro == null) {
			try {
				UfBO ufBO = new UfBO();
				ComboBoxModel comboUfModel;
						comboUfModel = new DefaultComboBoxModel(converteEstados(ufBO.listaUfs()));
				comboUfFiltro = new JComboBox();
				comboUfFiltro.setModel(comboUfModel);
			} catch (NegocioException e) {
				e.printStackTrace();
				MensagensUtil.addMsg(MainFrame.this, e.getMessage());
			}
		}
		return comboUfFiltro;
	}
	
	private JTextField getJTextField1xxxxxxxxxx() {
		if(txtCepFiltro == null) {
			txtCepFiltro = new JTextField();
		}
		return txtCepFiltro;
	}
	
	private JLabel getJLabel1xxxxxxxxxxxxxx() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("UF:");
		}
		return jLabel1;
	}
	
	private JLabel getJLabel2xxxxx() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("CEP:");
		}
		return jLabel2;
	}

}
