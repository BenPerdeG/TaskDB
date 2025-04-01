import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;

public final class RavenDBDocumentStore {
    private static IDocumentStore store;

    static {
        store = new DocumentStore(new String[]{"http://192.168.22.118:8080"}, "TaskDB");
        DocumentConventions conventions = store.getConventions();
        conventions.setUseOptimisticConcurrency(true);

        store.initialize();
    }


    public static IDocumentStore getStore() {
        return store;
    }

}