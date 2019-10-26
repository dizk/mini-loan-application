package no.didrik.service;

import no.didrik.LoanApplication;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LoanApplicationService {

    private final AtomicLong counter = new AtomicLong(0);
    private final Map<Long, LoanApplication> loanApplications = new ConcurrentHashMap<>();

    public LoanApplication createLoanApplication(LoanApplication loanApplication) {
        long id = counter.incrementAndGet();
        loanApplications.put(id, loanApplication.id(id));
        return loanApplication;
    }


    public LoanApplication getLoanApplicationById(Long id) {
        return loanApplications.get(id);
    }

    public Collection<LoanApplication> listLoanApplications() {
        return  loanApplications.values();
    }
}
