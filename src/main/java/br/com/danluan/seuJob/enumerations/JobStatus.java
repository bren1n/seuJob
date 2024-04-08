package br.com.danluan.seuJob.enumerations;

public enum JobStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String description;

    JobStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
