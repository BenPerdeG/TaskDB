import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

public class DocumentStoreHolder {
    private static class DocumentStoreContainer {
        public static final IDocumentStore store =
                new DocumentStore(new String[]{"http://192.168.22.118:8080"}, "TaskDB");
        static {
            store.initialize();
        };
        public static IDocumentStore getStore(){
            return DocumentStoreContainer.store;
        }

    }
}