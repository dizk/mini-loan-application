package no.didrik.controller;

import no.didrik.LoanApplication;
import no.didrik.api.LoanApplicationsApiDelegate;
import no.didrik.service.LoanApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanApplicationController implements LoanApplicationsApiDelegate {
    private final Logger logger = LoggerFactory.getLogger(LoanApplicationController.class);

    private final LoanApplicationService service;

    public LoanApplicationController(LoanApplicationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<LoanApplication> createLoanApplication(LoanApplication loanApplication) {
        LoanApplication result = service.createLoanApplication(loanApplication);
        logger.info("created a new loan application: {}", result);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LoanApplication> showLoanApplicationById(Long loanApplicationId) {
        return new ResponseEntity<>(service.getLoanApplicationById(loanApplicationId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LoanApplication>> listLoanApplications() {
        return new ResponseEntity<>(new ArrayList<>(service.listLoanApplications()), HttpStatus.OK);
    }
}
