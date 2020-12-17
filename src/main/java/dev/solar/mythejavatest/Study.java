package dev.solar.mythejavatest;

public class Study {

    private StudyStatus status = StudyStatus.STARTED;

    private int limit;

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return this.limit;
    }
}
