package com.devsuperior.eventos.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    /*Define o nome da coluna de chave estrangeira na tabela
    da entidade atual (Order) como client_id.
    Mapeia o relacionamento entre Order e User, permitindo que
     o Order se relacione com um User específico.*/
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, orphanRemoval = true)
    /*cascade = CascadeType.ALL:
O cascade indica que operações realizadas em Atividade (como persistir, remover ou atualizar) devem ser aplicadas também aos Blocos associados.
CascadeType.ALL significa que todas as operações de persistência serão propagadas, então, por exemplo, se você salvar uma Atividade, todos os Blocos associados a ela também serão salvos automaticamente.
orphanRemoval = true:
Esta opção especifica que se um Bloco for removido da lista de blocos da Atividade, ele deve ser automaticamente removido do banco de dados.
Isso é útil para manter a consistência, pois garante que, se você decidir que um Bloco não pertence mais a uma Atividade, ele será excluído.*/
    private List<Bloco> blocos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "atividade_participante",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();

    public Atividade() {
    }

    public Atividade(Long id, String nome, String descricao, Double preco,Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;
        return Objects.equals(getId(), atividade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
