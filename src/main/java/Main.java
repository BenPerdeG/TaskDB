import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.documents.session.IDocumentSession;

public class Main {
    public static void main(String[] args) {

        /*DocumentStore store = new DocumentStore("http://192.168.22.118:8080", "TaskDB");
        store.initialize();

        try (IDocumentSession session = store.openSession()) {
            // here goes your code
            User user = session.load(User.class, "users/1-A");
            user.setPassword("new password");
            session.saveChanges();
// data is persisted
// you can proceed e.g. finish web request
        }*/

        try (IDocumentStore store = new DocumentStore(new String[]{"http://192.168.22.118:8080"},"TaskDB")) {

            DocumentConventions conventions = store.getConventions();

            store.initialize();

            try (IDocumentSession session = store.openSession()) {

                Task task = new Task();
                task.setTitle("Task done");
                task.setDescription("Test of done statues");
                task.setPriority(1);
                task.setStatus(Task.Status.DONE);

                session.store(task);

                session.saveChanges();
            }

        }




    }
}
