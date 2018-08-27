package com.ifpb.mongodb.dao;

import com.ifpb.mongodb.database.MongoConnectionPojo;
import com.ifpb.mongodb.model.ItemVenda;
import com.ifpb.mongodb.model.Venda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.push;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
/**
 *
 * @author Lucas
 */
public class VendaDao {

    private MongoCollection collection;
    
    public VendaDao(){
        collection = new MongoConnectionPojo()
                .getCollection("Venda", Venda.class);
    }
    
    public void salvar(Venda venda){
        collection.insertOne(venda);
    }
    
    public List<Venda> listar(){
        MongoCursor cursor = collection.find().iterator();
        
        List<Venda> vendas = new ArrayList<>();
        
        while(cursor.hasNext()){
            vendas.add((Venda) cursor.next());
        }
        return vendas;
    }
    
    public Venda FindByCodigo(int id){
       Venda venda = (Venda) collection.find(eq("codigo", id)).first();
           return venda;
    }
    
    public boolean DeleteByCodigo(int id){
        DeleteResult result = collection.deleteOne(eq("codigo", id));
        
        return result.getDeletedCount()>0;
    }
    
    public boolean InsertOnVenda(int idVenda, ItemVenda item){
        if(FindByCodigo(idVenda) != null){
            UpdateResult result = collection.updateOne(eq("codigo", idVenda),
                    push ("itens", new Document("produto", item.getProduto())
                    .append("quantidade", item.getQuantidade())));
            return result.getModifiedCount()>0;
        }
        return false;
    }
}

