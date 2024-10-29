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
    private Integer id;
    private String descroicao;

    @OneToMany(mappedBy = "categoria") // Diz que esse relacionamento é gerenciado pelo campo categoria na classe atividade
    //Ou seja, cada categoria sabe quem é a atividade associado por meio de seu próprio campo categoria.
    private List<Atividade> atividades = new ArrayList<>();
    /*Imagine que um usuário (cliente) pode fazer vários pedidos de compra, mas
     cada pedido pertence a apenas um cliente. Aqui, orders é uma lista desses pedidos
     associados a um cliente específico.*/
    public Categoria() {
    }
    public Categoria(String descroicao, Integer id) {
        this.descroicao = descroicao;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescroicao() {
        return descroicao;
    }

    public void setDescroicao(String descroicao) {
        this.descroicao = descroicao;
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
