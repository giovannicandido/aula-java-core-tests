package br.com.targettrust.model.livro;

import java.util.List;

// Model é bastante confundido ou semelhante ao banco de dados.
// Muitos sistema são modelados como banco: Acho um erro, mas no inicio de carreira muita gente faz.
public class Livro {
    private String titulo;
    private List<Autor> autor;
    private Editora editora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
