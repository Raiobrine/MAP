package entidades;

import java.util.ArrayList;

public class Filme {
    private String nome;
    private int ano;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<String> trilhaSonora;

    public Filme(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.funcionarios = new ArrayList<Funcionario>();
        this.trilhaSonora = new ArrayList<String>();
    }

    //Gets e Sets---------------------------------------------------------------------------------
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<String> getTrilhaSonora() {
        return this.trilhaSonora;
    }
    public void setTrilhaSonora(ArrayList<String> trilhaSonora) {
        this.trilhaSonora = trilhaSonora;
    }

    //-----------------------------------------------------------------------------------------------

    // Cadastra funcionario e sua funcao
    public boolean cadastrarFuncionario(String nome, ArrayList<String> funcoes) {
        Funcionario funcionarioDoFilme = new Cineasta(nome, funcoes);

        for (Funcionario funcionario : getFuncionarios()) {
                // Funcionario ja cadastrado
                if (funcionario.getNome().equals(nome)) {
                    return false;
                }
            }
        funcionarios.add(funcionarioDoFilme);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Filme)) {
            return false;
        }

        Filme outroFilme = (Filme)obj;
        return this.nome != null && this.nome.equals(outroFilme.getNome());
    }

    @Override
    public String toString() {
        StringBuilder filme = new StringBuilder();

        filme.append("Filme: ").append(this.nome).append("\n");
        filme.append("Ano: ").append(this.ano).append("\n");

        filme.append("Diretor: ");

        StringBuilder diretores = new StringBuilder();
        StringBuilder roteiristas = new StringBuilder();
        StringBuilder atores = new StringBuilder();
        StringBuilder cinegrafistas = new StringBuilder();

        for (Funcionario funcionario : funcionarios) {
            for (String funcao : funcionario.getFuncoes()) {
                if (funcao.equals("Diretor")) {
                    diretores.append(funcionario.getNome()).append(",");
                }
                if (funcao.equals("Roteirista")) {
                    roteiristas.append(funcionario.getNome()).append(",");
                }
                if (funcao.equals("Ator")) {
                    atores.append(funcionario.getNome()).append(",");
                }
                if (funcao.equals("Cinegrafista")) {
                    cinegrafistas.append(funcionario.getNome()).append(",");
                }
            }
        }
        filme.append(diretores);

        filme.append("\n").append("Roteiristas: ");
        filme.append(roteiristas);

        filme.append("\n").append("Elenco: ");
        filme.append(atores);

        filme.append("\n").append("Cinegrafistas: ");
        filme.append(cinegrafistas);

        filme.append("\n").append("Trilha Sonora: ").append(this.trilhaSonora).append("\n");

        return filme.toString();
    }
}
