package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa{

    private Integer id;
    private String nome;
    private Date dataAbertura = new Date();;

    public Empresa(String nome){
        this.setNome(nome);
    }

    public Empresa(String nome, Date dataAbertura){
        this.setNome(nome);
        this.setDataAbertura(dataAbertura);
    }

    public Empresa(Integer id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
}