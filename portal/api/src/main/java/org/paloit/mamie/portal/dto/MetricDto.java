package org.paloit.mamie.portal.dto;

import java.util.UUID;

public class MetricDto {

    private UUID componentUUID;
    private long timeStamp;
    private long cpuLoad;

    public MetricDto() {
    }

    public MetricDto(UUID componentUUID, long timeStamp, long cpuLoad) {
        this.componentUUID = componentUUID;
        this.timeStamp = timeStamp;
        this.cpuLoad = cpuLoad;
    }

    public UUID getComponentUUID() {
        return componentUUID;
    }

    public void setComponentUUID(UUID componentUUID) {
        this.componentUUID = componentUUID;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(long cpuLoad) {
        this.cpuLoad = cpuLoad;
    }
}
