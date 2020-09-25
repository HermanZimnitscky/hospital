package com.hospital.state;

public abstract class PatientHealthState {

    private String stateCode;

    public abstract void aspirin();

    public abstract void antibiotic();

    public abstract void insulin();

    public abstract void paracetamol();

    public abstract void wait40Days();

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
