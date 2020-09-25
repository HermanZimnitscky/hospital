package com.hospital.factory;

import com.hospital.Patient;
import com.hospital.action.InjectAction;
import com.hospital.action.Wait40DaysAction;

public class Wait40DaysActionFactory extends InjectActionFactory {
    @Override
    public InjectAction getInjectAction(Patient patient) {
        return new Wait40DaysAction(patient);
    }
}
