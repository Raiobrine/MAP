package exceptions;
public class FilmeNotFoundException extends Exception{
    public FilmeNotFoundException(String nome) {
        super("Filme: "+nome +" não existe!", new Throwable("Filme incorreto ou não existe"));
    }
}
