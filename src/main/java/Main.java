import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.session.IDocumentSession;
import org.apache.catalina.User;

public class Main {
    public static void main(String[] args) {

        DocumentStore store = new DocumentStore("http://192.168.22.118:8080", "TaskDB");
        store.initialize();

        try (IDocumentSession session = store.openSession()) {
            // here goes your code
            User user = session.load(User.class, "users/1-A");
            user.setPassword("new password");
            session.saveChanges();
// data is persisted
// you can proceed e.g. finish web request
        }


    }
}
