//@Entity
public class Task {

    private String title;
    private String description;
    private int priority;
    private Status status;

    public enum Status {
        PENDING(0), IN_PROGRESS(1), PAUSED(2), DONE(3);
        private int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status fromValue(int value) {
            for (Status status : Status.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            throw new IllegalArgumentException("Invalid status value: " + value);
        }
    }

    public Task() {
    }
    public Task(String title, String description, int priority, Status status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
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

    @Override
    public String toString() {
        return "- Task -\n\tName:\t\t "+this.title+"\n\tDescription: "+this.description+"\n\tPriority:\t "+this.priority+"\n\tStatus:\t\t "+this.status+"\n" ;
    }
}
