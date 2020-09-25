package com.hospital.action;

import com.hospital.Patient;


public class InjectInsulinAction extends InjectAction {

    public InjectInsulinAction(Patient patient) {
        this.setPatientHealthState(patient.getCurrentState());
    }

    @Override
    public void execute() {
        this.getPatientHealthState().insulin();
    }
}
