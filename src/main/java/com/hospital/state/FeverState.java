package com.hospital.state;

import com.hospital.Constant;
import com.hospital.Patient;
import com.hospital.action.InjectAspirinAction;
import com.hospital.action.InjectParacetamolAction;

public class FeverState extends PatientHealthState {
    private Patient patient;

    public FeverState(Patient patient) {
        this.patient = patient;
        this.setStateCode(Constant.FEVER_STATE_CODE);
    }

    @Override
    public void aspirin() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectParacetamolAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
        this.patient.setCurrentState(patient.getHealthState());
    }

    @Override
    public void antibiotic() {

    }

    @Override
    public void insulin() {

    }

    @Override
    public void paracetamol() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectAspirinAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
        this.patient.setCurrentState(patient.getHealthState());
    }

    @Override
    public void wait40Days() {

    }

}
