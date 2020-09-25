package com.hospital.action;

import com.hospital.Patient;


public class InjectAspirinAction extends InjectAction {

    public InjectAspirinAction(Patient patient) {
        this.setPatientHealthState(patient.getCurrentState());
    }

    @Override
    public void execute() {
        this.getPatientHealthState().aspirin();
    }
}
