package com.hospital.factory;

import com.hospital.Patient;
import com.hospital.action.InjectAction;
import com.hospital.action.InjectAspirinAction;

public class InjectAspirinActionFactory extends InjectActionFactory {
    @Override
    public InjectAction getInjectAction(Patient patient) {
        return new InjectAspirinAction(patient);
    }
}
