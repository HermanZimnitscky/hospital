package com.hospital;

import com.hospital.action.InjectAction;
import com.hospital.state.*;

import java.util.LinkedList;

public class Patient {

    private PatientHealthState healthState;
    private PatientHealthState feverState;
    private PatientHealthState diabetesState;
    private PatientHealthState tuberculosisState;
    private PatientHealthState deadState;

    private PatientHealthState currentState;

    private PatientHealthState startState;

    private LinkedList<Class<? extends InjectAction>> injectActions;

    public void inject(InjectAction injectAction) {
        injectAction.execute();
        injectActions.add(injectAction.getClass());
    }

    public Patient() {
        this.healthState = new HealthyState(this);
        this.feverState = new FeverState(this);
        this.diabetesState = new DiabetesState(this);
        this.tuberculosisState = new TuberculosisState(this);
        this.deadState = new DeadState(this);
        injectActions = new LinkedList<>();
    }

    public void initCurrentState(String code) {
        if (code.equals(healthState.getStateCode())) {
            this.currentState = healthState;
            this.startState = healthState;
        }
        if (code.equals(feverState.getStateCode())) {
            this.currentState = feverState;
            this.startState = feverState;
        }
        if (code.equals(diabetesState.getStateCode())) {
            this.currentState = diabetesState;
            this.startState = diabetesState;
        }
        if (code.equals(tuberculosisState.getStateCode())) {
            this.currentState = tuberculosisState;
            this.startState = tuberculosisState;
        }
    }

    public PatientHealthState getHealthState() {
        return healthState;
    }

    public void setHealthState(PatientHealthState healthState) {
        this.healthState = healthState;
    }

    public PatientHealthState getFeverState() {
        return feverState;
    }

    public void setFeverState(PatientHealthState feverState) {
        this.feverState = feverState;
    }

    public PatientHealthState getDiabetesState() {
        return diabetesState;
    }

    public void setDiabetesState(PatientHealthState diabetesState) {
        this.diabetesState = diabetesState;
    }

    public PatientHealthState getTuberculosisState() {
        return tuberculosisState;
    }

    public void setTuberculosisState(PatientHealthState tuberculosisState) {
        this.tuberculosisState = tuberculosisState;
    }

    public PatientHealthState getDeadState() {
        return deadState;
    }

    public void setDeadState(PatientHealthState deadState) {
        this.deadState = deadState;
    }

    public PatientHealthState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PatientHealthState currentState) {
        this.currentState = currentState;
    }

    public LinkedList<? extends Class<? extends InjectAction>> getInjectActions() {
        return injectActions;
    }

    public void setInjectActions(LinkedList<Class<? extends InjectAction>> injectActions) {
        this.injectActions = injectActions;
    }

    public PatientHealthState getStartState() {
        return startState;
    }

    public void setStartState(PatientHealthState startState) {
        this.startState = startState;
    }
}
