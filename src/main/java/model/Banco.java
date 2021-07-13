package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private static List<Empresa> lista = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        lista.add(new Empresa(chaveSequencial++,"Alura"));
        lista.add(new Empresa(chaveSequencial++,"Caelum"));
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        lista.add(empresa);
    }

    public void remove(Integer id) {
        Optional<Empresa> empresa = getEmpresas().stream().filter(empresa1 -> empresa1.getId() == id).findFirst();
        lista.remove(empresa.get());
    }

    public Empresa buscaEmpresaPelaId(Integer id){
        return getEmpresas().stream().filter(empresa -> empresa.getId() == id).findFirst().get();
    }
    public static List<Empresa> getEmpresas(){
        return Banco.lista;
    }

}