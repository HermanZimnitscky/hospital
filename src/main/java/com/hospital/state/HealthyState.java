package com.hospital.state;

import com.hospital.Constant;
import com.hospital.Patient;
import com.hospital.action.*;

public class HealthyState extends PatientHealthState {
    private Patient patient;


    public HealthyState(Patient patient) {
        this.patient = patient;
        this.setStateCode(Constant.HEALTHY_STATE_CODE);
    }

    @Override
    public void aspirin() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectParacetamolAction.class)) {
            this.patient.setCurrentState(patient.getDeadState());
        }
    }

    @Override
    public void antibiotic() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectInsulinAction.class) && patient.getStartState().getClass().equals(HealthyState.class)) {
            this.patient.setCurrentState(patient.getFeverState());
        }
    }

    @Override
    public void insulin() {
        if (patient.getInjectActions() != null && patient.getInjectActions().contains(InjectAntibioticAction.class) && patient.getStartState().getClass().equals(HealthyState.class)) {
            this.patient.setCurrentState(patient.getFeverState());
        }
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
