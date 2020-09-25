package com.hospital.action;

import com.hospital.Patient;


public class Wait40DaysAction extends InjectAction {

    public Wait40DaysAction(Patient patient) {
        this.setPatientHealthState(patient.getCurrentState());
    }

    @Override
    public void execute() {
        this.getPatientHealthState().wait40Days();
    }
}
