package com.hospital.factory;

import com.hospital.Patient;
import com.hospital.action.InjectAction;
import com.hospital.action.InjectAntibioticAction;

public class InjectAntibioticActionFactory extends InjectActionFactory {
    @Override
    public InjectAction getInjectAction(Patient patient) {
        return new InjectAntibioticAction(patient);
    }
}
