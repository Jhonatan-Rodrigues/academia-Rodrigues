package br.com.jhonatan.dao;

import br.com.jhonatan.domain.Aluno;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AlunoSetDao implements IAlunoDAO {

    private Set<Aluno> set;

    public AlunoSetDao() {
        this.set = new HashSet<>();
    }


    @Override
    public Boolean cadastrar(Aluno aluno) {
        return this.set.add(aluno);
    }

    @Override
    public void excluir(Long cpf) {
        Aluno alunoExiste = null;
        for (Aluno aluno : this.set) {
            if (aluno.getCpf().equals(cpf)) {
                alunoExiste = aluno;
                break;
            }
        }
        if (alunoExiste != null) {
            this.set.remove(alunoExiste);
        }

    }

    @Override
    public void alterar(Aluno aluno) {

        if (this.set.contains(aluno)) {
            for (Aluno alunoExiste : this.set) {
                alunoExiste.setNome(aluno.getNome());
                alunoExiste.setFaixa(aluno.getFaixa());
                alunoExiste.setCpf(aluno.getCpf());
                alunoExiste.setNumero(aluno.getNumero());
                alunoExiste.setMensalidade(aluno.getMensalidade());

            }
        }

    }

    @Override
    public Aluno consultar(Long cpf) {
        for (Aluno alunoExiste : this.set) {
            if (alunoExiste.getCpf().equals(cpf)) {
                return alunoExiste;
            }
        }
        return null;
    }

    @Override
    public Collection<Aluno> buscarTodos() {
        return this.set;
    }
}
