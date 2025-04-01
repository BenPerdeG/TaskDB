import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;

public class DocumentStoreHolder {
    private static class DocumentStoreContainer{
    public static final IDocumentStore store = new DocumentStore("http://192.168.22.118:8080/")

    }

}
