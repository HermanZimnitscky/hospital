package com.hospital.factory;

import com.hospital.Patient;
import com.hospital.action.InjectAction;

public abstract class InjectActionFactory {
    public abstract InjectAction getInjectAction(Patient patient);
}
