import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;
import net.ravendb.client.documents.conventions.DocumentConventions;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.List;


public class CRUD {

    private String URL = "http://192.168.22.118:8080";
    private String DATABASE = "TaskDB";

    public int create(String title, String description, int priority, int status){

        try (IDocumentStore store = new DocumentStore(new String[]{URL}, DATABASE)) {

            DocumentConventions conventions = store.getConventions();

            store.initialize();

            try (IDocumentSession session = store.openSession()) {

                Task task = new Task();
                task.setTitle(title);
                task.setDescription(description);
                task.setPriority(priority);

                if(status > 3  || status<0){
                    System.out.println("Error al introducir el status. Prueba con un numero entr 0-3");
                    return -1;
                }
                else {


                task.setStatus(Task.Status.fromValue(status));

                session.store(task);

                session.saveChanges();
                return 1;
                }
            }
            catch (Exception e){
                return -1;
            }
        }
        catch (Exception e){
            return -1;
        }
    }

    public int delete(String titulo){
        try (IDocumentStore store = new DocumentStore(new String[]{URL}, DATABASE)) {


            store.initialize();

            try (IDocumentSession session = store.openSession()) {

                List<Task> results = session.query(Task.class)
                        .whereEquals("title", titulo)
                        .toList();
                for (Task task : results) {
                    session.delete(task);
                }

                session.saveChanges();
                return 1;
            }
            catch (Exception e){
                return -1;
            }
        }
        catch (Exception e){
            return -1;
        }
    }

    public int update(String titulo, String nuevoTitulo, String description, int priority, int status ){
        try (IDocumentStore store = new DocumentStore(new String[]{URL}, DATABASE)) {


            store.initialize();
            if(status > 3  || status<0){
                System.out.println("Error al introducir el status. Prueba con un numero entr 0-3");
                return -1;
            }
            try (IDocumentSession session = store.openSession()) {

                List<Task> results = session.query(Task.class)
                        .whereEquals("title", titulo)
                        .toList();
                for (Task task : results) {
                    session.delete(task);
                    Task updated = new Task(nuevoTitulo,description,priority,Task.Status.fromValue(status));
                    session.store(updated);
                }

                session.saveChanges();
                return 1;
            }
            catch (Exception e){
                return -1;
            }
        }
        catch (Exception e){
            return -1;
        }
    }

    public int selectALL( ){
        try (IDocumentStore store = new DocumentStore(new String[]{URL}, DATABASE)) {


            store.initialize();
            try (IDocumentSession session = store.openSession()) {

                List<Task> results = session.query(Task.class).toList();
                for (Task task : results) {
                    System.out.println(task);
                }

                session.saveChanges();
                return 1;
            }
            catch (Exception e){
                return -1;
            }
        }
        catch (Exception e){
            return -1;
        }
    }



}

