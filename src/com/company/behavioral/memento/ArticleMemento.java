package com.company.behavioral.memento;

public class ArticleMemento {

    private String autor;
    private String text;

    public ArticleMemento(String autor, String text){
        this.autor = autor;
        this.text = text;
    }

    public String getAutor(){
        return autor;
    }

    public String getText(){
        return text;
    }
}
