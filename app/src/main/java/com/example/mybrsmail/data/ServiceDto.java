package com.example.mybrsmail.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceDto {
    @SerializedName("say")
    @Expose
    private Integer say;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("lastDate")
    @Expose
    private String lastDate;

    public Integer getSay() {
        return say;
    }

    public void setSay(Integer say) {
        this.say = say;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "ServiceDto{" +
                "say=" + say +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", lastDate='" + lastDate + '\'' +
                '}';
    }
}
