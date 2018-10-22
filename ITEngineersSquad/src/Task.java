public class Task {
    private String title;
    private String description;
    private String status; // TODO consider removing, probably unnecessary here. Or make it Enum and go further.
    private String reqsQuality; // Requirements quality TODO: make it Enum
    private Engineer assignee;
    private float totalEstimationHours; // TODO: memorize estimations providers

    public Task(String title, String description, String status, String reqsQuality) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.reqsQuality = reqsQuality;
        this.totalEstimationHours = 0;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public void setTotalEstimationHours(float totalEstimationHours) {
        this.totalEstimationHours = totalEstimationHours;
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

    public void addEstimationHours(float estimationHours) {
        this.totalEstimationHours += estimationHours;
    }

    public float getTotalEstimationHours(){
        return this.totalEstimationHours;
    }
}
