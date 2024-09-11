package com.example.unicode.dto.client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogInRequest {

    @NotBlank(message = "BITS ID is required")
    @Pattern(regexp = "20\\d{2}\\d[a-zA-Z]\\d{1}[a-zA-Z]{2}\\d{4}\\d[a-zA-Z]", 
             message = "BITS ID must be in the format 20xx(number)x(alphabet)x(number)xx(alphabets)xxxx(numbers)")
    private String bitsID;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Lab Number is required")
    private String labNumber;

    @NotBlank(message = "System Number is required")
    private int systemNumber;

    @NotBlank(message = "IP Address is required")
    private String ipAddress;

        // Constructor for deserialization
    public LogInRequest(
        @JsonProperty("bitsID") String bitsID,
        @JsonProperty("name") String name,
        @JsonProperty("labNumber") String labNumber,
        @JsonProperty("systemNumber") Integer systemNumber,
        @JsonProperty("ipAddress") String ipAddress
    ) {
        this.bitsID = bitsID;
        this.name = name;
        this.labNumber = labNumber;
        this.systemNumber = systemNumber;
        this.ipAddress = ipAddress;
    }

    // Getters and Setters
    public String getBitsID() {
        return bitsID;
    }

    public void setBitsID(String bitsID) {
        this.bitsID = bitsID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabNumber() {
        return labNumber;
    }

    public void setLabNumber(String labNumber) {
        this.labNumber = labNumber;
    }

    public int getSystemNumber() {
        return systemNumber;
    }

    public void setSystemNumber(int systemNumber) {
        this.systemNumber = systemNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
