package com.hospital.state;

import com.hospital.Constant;
import com.hospital.Patient;
import com.hospital.action.InjectAspirinAction;
import com.hospital.action.InjectParacetamolAction;

public class TuberculosisState extends PatientHealthState {
    private Patient patient;


    public TuberculosisState(Patient patient) {
        this.patient = patient;
        this.setStateCode(Constant.TUBERCULOSIS_STATE_CODE);
    }

    @Override
    public void aspirin() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectParacetamolAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
    }

    @Override
    public void antibiotic() {
        this.patient.setCurrentState(patient.getHealthState());
    }

    @Override
    public void insulin() {

    }

    @Override
    public void paracetamol() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectAspirinAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
    }

    @Override
    public void wait40Days() {

    }

}
