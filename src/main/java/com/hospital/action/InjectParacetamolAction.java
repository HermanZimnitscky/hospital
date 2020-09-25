package com.hospital.action;

import com.hospital.Patient;

public class InjectParacetamolAction extends InjectAction {

    public InjectParacetamolAction(Patient patient) {
        this.setPatientHealthState(patient.getCurrentState());
    }

    @Override
    public void execute() {
        this.getPatientHealthState().paracetamol();
    }
}
