package no.didrik.service;

import no.didrik.Lanetaker;
import no.didrik.LoanApplication;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoanApplicationServiceTest {

    private LoanApplicationService service;

    @Before
    public void createService() {
        this.service = new LoanApplicationService();
    }

    private LoanApplication getBasicLoanApplication() {
        LoanApplication loanApplication = new LoanApplication().lanebelop(10L).behov("behov");
        loanApplication.addLanetakereItem(new Lanetaker().fnr("fnr").navn("navn"));
        return loanApplication;
    }

    @Test
    public void createLoanApplicationDoesNotReturnNull() {
        LoanApplication loanApplication = getBasicLoanApplication();

        LoanApplication res = service.createLoanApplication(loanApplication);
        assertNotNull(res.getId());
        assertNotEquals(Long.valueOf(0), res.getId());
    }


    @Test
    public void createLoanApplicationDoesNotReturnTheSameId() {
        LoanApplication loanApplication1 = getBasicLoanApplication();
        LoanApplication loanApplication2 = getBasicLoanApplication();

        LoanApplication res1 = service.createLoanApplication(loanApplication1);
        LoanApplication res2 = service.createLoanApplication(loanApplication2);

        assertNotEquals(res1.getId(), res2.getId());
    }

    @Test
    public void getApplicationById() {
        LoanApplication loanApplication = getBasicLoanApplication();
        LoanApplication submittedApplication = service.createLoanApplication(loanApplication);

        LoanApplication fetchedApplication = service.getLoanApplicationById(submittedApplication.getId());
        assertEquals(submittedApplication, fetchedApplication);
    }

    @Test
    public void listLoanApplications() {
        LoanApplication loanApplication = getBasicLoanApplication();
        service.createLoanApplication(loanApplication);

        assertEquals(1, service.listLoanApplications().size());
    }
}