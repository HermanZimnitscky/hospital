package com.hospital;

import com.hospital.action.InjectAction;
import com.hospital.factory.*;
import com.hospital.utils.Validation;
import com.hospital.utils.ValidationInputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quarantine {
    private InjectActionFactory injectAspirinActionFactory;
    private InjectActionFactory injectAntibioticActionFactory;
    private InjectActionFactory injectInsulinActionFactory;
    private InjectActionFactory injectParacetamolActionFactory;
    private InjectActionFactory wait40DaysActionFactory;
    private Validation validation;

    private List<Patient> patients;

    public Quarantine(String subjects) {
        this.validation = new ValidationInputData();
        this.patients = getPatientsFromSting(subjects);
        this.injectAspirinActionFactory = new InjectAspirinActionFactory();
        this.injectAntibioticActionFactory = new InjectAntibioticActionFactory();
        this.injectInsulinActionFactory = new InjectInsulinActionFactory();
        this.injectParacetamolActionFactory = new InjectParacetamolActionFactory();
        this.wait40DaysActionFactory = new Wait40DaysActionFactory();
    }

    public void aspirin() {
        startInjection(this.injectAspirinActionFactory, patients);
    }

    public void antibiotic() {
        startInjection(this.injectAntibioticActionFactory, patients);
    }

    public void insulin() {
        startInjection(this.injectInsulinActionFactory, patients);
    }

    public void paracetamol() {
        startInjection(this.injectParacetamolActionFactory, patients);
    }

    public void wait40Days() {
        startInjection(this.wait40DaysActionFactory, patients);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, List<Patient>> patientMap = patients.stream().collect(Collectors.groupingBy(patient -> patient.getCurrentState().getStateCode()));
        for (String s : Constant.REPORT) {
            stringBuilder.append(s).append(Constant.COLON).append(patientMap.get(s) != null ? patientMap.get(s).size() : 0l).append(Constant.SPACE);
        }
        return stringBuilder.toString().trim();
    }

    private void startInjection(InjectActionFactory injectActionFactory, List<Patient> patients) {
        for (Patient patient : patients) {
            InjectAction injectAction = injectActionFactory.getInjectAction(patient);
            patient.inject(injectAction);
        }
    }

    private List<Patient> getPatientsFromSting(String subjects) {
        String[] input = subjects.split(Constant.COMMA);
        this.validation.validateInputString(input);
        List<Patient> patients = new ArrayList<>();
        for (String string : input) {
            Patient patient = new Patient();
            patient.initCurrentState(string);
            patients.add(patient);

        }
        return patients;
    }

}
