package com.hospital.action;

import com.hospital.Patient;


public class InjectAntibioticAction extends InjectAction {

    public InjectAntibioticAction(Patient patient) {
        this.setPatientHealthState(patient.getCurrentState());
    }

    @Override
    public void execute() {
        this.getPatientHealthState().antibiotic();
    }
}
