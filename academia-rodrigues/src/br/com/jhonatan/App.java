package br.com.jhonatan;

import br.com.jhonatan.dao.AlunoSetDao;
import br.com.jhonatan.dao.IAlunoDAO;
import br.com.jhonatan.domain.Aluno;

import javax.swing.*;

public class App {

    private static IAlunoDAO iAlunoDAO;

    public static void main(String[] args) {

        iAlunoDAO = new AlunoSetDao();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para atualizar e 5 para sair: ",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida! Digite 1 para cadastrar, "
                            + "2 para Consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }
        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastrar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Ok, vamos lá! DIgite os dados do seu aluno separado por virgula "
                                + "nome,faixa,cpf,numero,pagamento",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);

            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF.", "Consultar",
                        JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

            } else if (isExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF.", "Exluir",
                        JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);

            } else {
                String dados = JOptionPane.showInputDialog(null,
                        "Ok, vamos lá! DIgite os dados do seu aluno separado por virgula "
                                + "nome,faixa,cpf,numero,pagamento",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção invalida! Digite 1 para cadastrar, "
                            + "2 para Consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String dados) {
        iAlunoDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Aluno Excluido! ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExcluir(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Aluno aluno = new Aluno(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4]);
        Boolean isCadastrado = iAlunoDAO.cadastrar(aluno);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso! ", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Aluno já cadastrado em nosso sistema! ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void consultar(String dados) {
        Aluno aluno = iAlunoDAO.consultar(Long.parseLong(dados));
        if (aluno != null) {
            JOptionPane.showMessageDialog(null, "Aluno encontrado: " + aluno.toString(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Aluno não foi encontrado: ", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private static boolean isCadastrar(String opcao) {
            if("1".equals(opcao)) {
                return true;
            }
            return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso serviço de cadastro! ", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }



    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static void alterar(String dados) {
        String[] isAtualizar = dados.split(",");
        Aluno aluno = new Aluno(isAtualizar[0], isAtualizar[1], isAtualizar[2], isAtualizar[3], isAtualizar[4]);
        iAlunoDAO.alterar(aluno);
    }
}