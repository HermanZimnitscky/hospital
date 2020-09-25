package com.hospital.factory;

import com.hospital.Patient;
import com.hospital.action.InjectAction;
import com.hospital.action.InjectInsulinAction;

public class InjectInsulinActionFactory extends InjectActionFactory {
    @Override
    public InjectAction getInjectAction(Patient patient) {
        return new InjectInsulinAction(patient);
    }
}
