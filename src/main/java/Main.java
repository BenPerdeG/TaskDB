import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.documents.session.IDocumentSession;

public class Main {
    public static void main(String[] args) {

        try (IDocumentStore store = new DocumentStore(new String[]{"http://192.168.22.118:8080"}, "TaskDB")) {

            DocumentConventions conventions = store.getConventions();

            store.initialize();

            try (IDocumentSession session = store.openSession()) {

                Task task = new Task();
                task.setTitle("task slfj4");
                task.setDescription("If this works el merino se rapa");
                task.setPriority(99);
                task.setStatus(Task.Status.IN_PROGRESS);

                session.store(task);

                session.saveChanges();
            }

        }


    }
}
