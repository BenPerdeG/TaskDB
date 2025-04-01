//@Entity
public class Task {

    String title;
    String description;
    int priority;
    public Status status;

    public enum Status {
        PENDING(0), IN_PROGRESS(1), PAUSED(2), DONE(3);
        private int value;

        Status(int value) {
            this.value = value;
        }
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
