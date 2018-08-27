package com.ifpb.mongodb.vision;

import com.ifpb.mongodb.dao.PessoaDao;
import com.ifpb.mongodb.dao.VendaDao;
import com.ifpb.mongodb.database.MongoConnection;
import com.ifpb.mongodb.model.ItemVenda;
import com.ifpb.mongodb.model.Pessoa;
import com.ifpb.mongodb.model.Produto;
import com.ifpb.mongodb.model.Venda;
import com.mongodb.client.MongoCollection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Main {
    
    public static void main(String[] args){
        
        VendaDao  dao= new VendaDao();
        
        //System.out.println(dao.FindByCodigo(2));
        
        Produto produto = new Produto(1, "Pc", 2000);
        
        ItemVenda item = new ItemVenda(produto, 1);
        
        dao.InsertOnVenda(1, item);
        
        System.out.println(dao.FindByCodigo(1));
        
        //dao.DeleteByCodigo(1);
        
       // ------UTILIZANDO MONGO COLLECTION POJO------ //
//        Produto produto1 = new Produto(1, "Teclado", 30);
//        Produto produto2 = new Produto(2, "Mouse", 20);
//        
//        ItemVenda item1 = new ItemVenda(produto1, 1);
//        ItemVenda item2 = new ItemVenda(produto2, 3);
//        
//        List<ItemVenda> itens = new ArrayList<>();
//        
//        itens.add(item1);
//        itens.add(item2);
//        
//        Venda venda = new Venda(1, itens, LocalDateTime.now());
//        
//        dao.salvar(venda);
        
//          System.out.println(dao.listar());
                  

//        
//        MongoConnection connection = new MongoConnection();
//        
//        MongoCollection collection = connection.getCollection("Pessoa");
//        
//        ----UTILIZANDO MONGO COLLECTION-----
//          PRECISA CONVERTER PARA DOCUMENTO
//        PessoaDao dao = new PessoaDao();
//        
//        dao.salvar(new Pessoa("111.111.111-22", "Maria", 21));
//        System.out.println(dao.listar());
//        System.out.println(dao.buscarPorCpf("111.111.111-11"));
//        System.out.println(dao.buscarPorCpf("222.222.222-22"));
//        
//        dao.deletarPorCpf("111.111.111-11");
//        
//        System.out.println(dao.listar());
//        
//        dao.atualizar(new Pessoa ("111.111.111-22", "Ana", 41));
//        
//        System.out.println(dao.buscarPorCpf("111.111.111-22"));
//   


    }
}
