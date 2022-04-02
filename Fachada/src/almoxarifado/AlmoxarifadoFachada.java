package almoxarifado;

import java.util.ArrayList;

//Verificar o estoque
public class AlmoxarifadoFachada {
    private ArrayList<Material> estoque;

    public AlmoxarifadoFachada() {
        this.estoque = new ArrayList<>();
    }

    public ArrayList<Material> getEstoque(){
        return this.estoque;
    }

    public void setEstoque(ArrayList<Material> estoque){
        this.estoque = estoque;
    }

    //Cadastrar o material
    public boolean cadastrarMaterial(String nomeDoMaterial, double valorDoMaterial) {
        Material materialNovo = new Material(nomeDoMaterial, valorDoMaterial);

        if(estoque.contains(materialNovo)){
            return false;
        }
        estoque.add(materialNovo);
        return true;
    }

    //Mostrar o estoque
    public String mostrarEstoque() {
        StringBuilder estoqueToString = new StringBuilder();

        for (Material material : estoque) {
            estoqueToString.append(material.toString()).append("\n");
        }
        return estoqueToString.toString();
    }

    //Comprar novo material
    public boolean comprarMaterial(String nomeDoMaterial, double valorDoMaterial) {
        if(cadastrarMaterial(nomeDoMaterial, valorDoMaterial)){
            return true;
        } 
        return false;
    }
    
}
