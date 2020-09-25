package com.hospital.action;

import com.hospital.state.PatientHealthState;

public abstract class InjectAction {
    private PatientHealthState patientHealthState;

    public abstract void execute();

    public PatientHealthState getPatientHealthState() {
        return patientHealthState;
    }

    public void setPatientHealthState(PatientHealthState patientHealthState) {
        this.patientHealthState = patientHealthState;
    }

}
