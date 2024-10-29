package com.devsuperior.eventos.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "categoria") // Diz que esse relacionamento é gerenciado pelo campo categoria na classe atividade
    //Ou seja, cada categoria sabe quem é a atividade associado por meio de seu próprio campo categoria.
    private List<Atividade> atividades = new ArrayList<>();
    /*Imagine que um usuário (cliente) pode fazer vários pedidos de compra, mas
     cada pedido pertence a apenas um cliente. Aqui, orders é uma lista desses pedidos
     associados a um cliente específico.*/

    /*EXPLICACAO:  anotação @OneToMany(mappedBy = "categoria") na lista atividades diz que:
Uma categoria pode estar associada a várias atividades.
A lista atividades em Categoria será preenchida automaticamente com todas as Atividades que
 possuem essa categoria específica associada.
A anotação @ManyToOne com @JoinColumn(name = "id_categoria") na classe Atividade:
Indica que cada Atividade está associada a uma única Categoria através da chave estrangeira id_categoria.
Ou seja, cada atividade "aponta" para a categoria a que pertence.*/

    public Categoria() {
    }
    public Categoria(String descricao, Long id) {
        this.descricao = descricao;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;
        return Objects.equals(getId(), categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
