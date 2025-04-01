import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;

public final class RavenDBDocumentStore {
    private static IDocumentStore store;

    static {

        //Create new Document Store with the url of the RavenDB Server
        //and with `Hospital` set as the default database
        store = new DocumentStore(new String[]{"http://192.168.22.118:8080"}, "TaskDB");

        //Edit the conventions to enable optimistic concurrency
        DocumentConventions conventions = store.getConventions();
        conventions.setUseOptimisticConcurrency(true);

        store.initialize();
    }

    //Return the single Document Store instance
    public static IDocumentStore getStore() {
        return store;
    }

}