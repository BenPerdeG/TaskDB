import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.documents.session.IDocumentSession;

public class Main {
    public static void main(String[] args) {

        CRUD crud = new CRUD();
//        if (crud.update("Prueba Crud","Prueba CRU update","Cru mi villano favorito",69,3)==1) {
//            System.out.println("Tarea borrada con exito");
//        }
//        else {
//            System.out.println("Parece que algo ha salido mal");
//        }

        crud.selectALL();
    }
}
