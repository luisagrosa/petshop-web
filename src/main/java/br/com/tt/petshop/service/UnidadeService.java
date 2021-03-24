package br.com.tt.petshop.service;

import br.com.tt.petshop.exception.RegraDeNegocioVioladaException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository){
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> listar() {
        return unidadeRepository.listar();
    }

    public void criar(Unidade unidade){
        if(unidade.getNome().length() <= 3) {
            throw new RegraDeNegocioVioladaException("O nome da unidade de conter 3 caracteres");
        }
        unidadeRepository.criar(unidade);
    }

    public void editar(Unidade unidade){

        unidadeRepository.editar(unidade);
    }

    public void deletar(Unidade unidade){
        unidadeRepository.deletar(unidade);
    }
}
