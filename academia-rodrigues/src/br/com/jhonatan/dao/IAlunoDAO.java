package br.com.jhonatan.dao;

import br.com.jhonatan.domain.Aluno;

import java.util.Collection;

public interface IAlunoDAO {



    public Boolean cadastrar(Aluno aluno);
    public void excluir(Long cpf);
    public void alterar(Aluno aluno);
    public Aluno consultar(Long cpf);
    public Collection<Aluno> buscarTodos();


}
