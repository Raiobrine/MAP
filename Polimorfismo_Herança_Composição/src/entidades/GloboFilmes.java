package entidades;

import java.util.ArrayList;
import java.util.Map;

import exceptions.FilmeNotFoundException;

public class GloboFilmes {
    //Array da classe Filme
    private ArrayList<Filme> listaFilmes;

    public GloboFilmes() {
        this.listaFilmes = new ArrayList<Filme>();
    }

    //Gets e Sets---------------------------------------------------------------------------------
    public ArrayList<Filme> getFilmes() {
        return this.listaFilmes;
    }

    //Teste de excessao caso nao exista o filme
    public Filme getFilme(String nome) throws FilmeNotFoundException {
        for (Filme filme : listaFilmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        throw new FilmeNotFoundException(nome);
    }
    //-----------------------------------------------------------------------------------------------

    public boolean cadastrarFilme(String nome, int ano, Map<String, ArrayList<String>> funcionarios, ArrayList<String> trilhaSonora) {
        Filme novoFilme = new Filme(nome, ano);

        //Se o filme ja for existente
        if (listaFilmes.contains(novoFilme)) {
            return false;
        }

        for (Map.Entry<String, ArrayList<String>> campo : funcionarios.entrySet()) {
            novoFilme.cadastrarFuncionario(campo.getKey(), campo.getValue());
        }

        novoFilme.setTrilhaSonora(trilhaSonora);
        listaFilmes.add(novoFilme);
        return true;
    }

    public String mostrarFilmografia(String nome, String funcao) {
        StringBuilder filmografia = new StringBuilder();
        for (Filme filme : listaFilmes) {
            for (Funcionario funcionario : filme.getFuncionarios()) {
                if (nome.equals(funcionario.getNome())) {
                    for (String func : funcionario.getFuncoes()) {
                        if (func.equals(funcao)) {
                            filmografia.append("Filme: ").append(filme.getNome()).append(", ").append(funcao+": ").append(nome+"\n");
                        }
                    }
                }
            }
        }

        return filmografia.toString();
    }

    public String mostrarInformacoesFilme(String nome) throws FilmeNotFoundException {
        return getFilme(nome).toString();
    }
}
