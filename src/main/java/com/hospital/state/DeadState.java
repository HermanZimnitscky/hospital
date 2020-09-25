package com.hospital.state;

import com.hospital.Constant;
import com.hospital.Patient;


public class DeadState extends PatientHealthState {
    private Patient patient;

    public DeadState(Patient patient) {
        this.patient = patient;
        this.setStateCode(Constant.DEAD_STATE_CODE);
    }

    @Override
    public void aspirin() {

    }

    @Override
    public void antibiotic() {

    }

    @Override
    public void insulin() {

    }

    @Override
    public void paracetamol() {

    }

    @Override
    public void wait40Days() {

    }
}
