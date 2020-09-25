package com.hospital.state;

import com.hospital.Constant;
import com.hospital.Patient;
import com.hospital.action.InjectAspirinAction;
import com.hospital.action.InjectInsulinAction;
import com.hospital.action.InjectParacetamolAction;

public class DiabetesState extends PatientHealthState {
    private Patient patient;

    public DiabetesState(Patient patient) {
        this.patient = patient;
        this.setStateCode(Constant.DIABETES_STATE_CODE);
    }

    @Override
    public void aspirin() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectParacetamolAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
    }

    @Override
    public void antibiotic() {

    }

    @Override
    public void insulin() {
        this.patient.setCurrentState(patient.getDiabetesState());
    }

    @Override
    public void paracetamol() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectAspirinAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
        this.patient.setCurrentState(patient.getDeadState());
    }

    @Override
    public void wait40Days() {
        if (patient.getInjectActions() != null && !patient.getInjectActions().contains(InjectInsulinAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
    }

}
