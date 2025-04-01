import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Random;

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


            createTasksFori(store);

            createTask(store);

        }




    }

    private static void createTask(IDocumentStore store) {
        try (IDocumentSession session = store.openSession()) {

            Task task = new Task();
            task.setTitle("Task");
            task.setDescription("If this works el merino se rapa");
            task.setPriority(99);
            task.setStatus(Task.Status.IN_PROGRESS);

            session.store(task);

            session.saveChanges();
        }
    }

    private static void createTasksFori(IDocumentStore store) {
        for (int i = 5; i < 50; i++) {
            try (IDocumentSession session = store.openSession()) {

                Task task = new Task();
                task.setTitle("Task: " + i);
                task.setDescription("Random task, who know how will be done now...");
                task.setPriority((int) (Math.random() * 10) + 1);
                task.setStatus(Task.Status.IN_PROGRESS);

                session.store(task);

                session.saveChanges();
            }
        }
    }
}
