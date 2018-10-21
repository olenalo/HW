import java.util.HashMap;

public class Task {
    private String title;
    private String description;
    private String status; // TODO consider removing, probably unnecessary here
    private String reqsQuality; // Requirements quality
    private Engineer assignee;
    private HashMap estimations; // Estimations per assignees (engineers)

    public Task(String title, String description, String status, String reqsQuality) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.reqsQuality = reqsQuality;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReqsQuality(String reqsQuality) {
        this.reqsQuality = reqsQuality;
    }

    public void setAssignee(Engineer assignee) {
        this.assignee = assignee;
    }

    public void setEstimations(HashMap estimations) {
        this.estimations = estimations;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return this.status;
    }

    public String getReqsQuality() {
        return this.reqsQuality;
    }

    public Engineer getAssignee() {
        return this.assignee;
    }

    public HashMap getEstimations() {
        return this.estimations;
    }

    public int getTotalEstimation(){
        // TODO: implement
        return 0;
    }
}
