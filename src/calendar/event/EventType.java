package calendar.event;

public enum EventType {
    MEETING("Meeting"),
    PHONE_CALL("Phone Call"),
    REMINDER("Reminder");
    private String displayType;

    EventType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }
}
