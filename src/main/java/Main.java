import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;

public class Main {
    public static void main(String[] args) {

        DocumentStore store = new DocumentStore("http://live-test.ravendb.net", "databaseName");
        store.initialize();

        try (IDocumentSession session = store.openSession()) {
            // here goes your code
        }
    }
}
