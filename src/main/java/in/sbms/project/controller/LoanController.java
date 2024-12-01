package in.sbms.project.controller;

import in.sbms.project.dto.InterestRate;
import in.sbms.project.service.LoanService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping(path = "/loans")
    @CircuitBreaker(name = "rateService", fallbackMethod = "getFallbackMethod")
    public ResponseEntity<InterestRate> getLoansByType(@RequestParam("type") String type) {
        return ResponseEntity.ok().body(loanService.getAllLoansByType(type.toUpperCase()));
    }

    public ResponseEntity<InterestRate> getFallbackMethod(String type, Exception ex) {
        System.out.println("*******Fallback method is called******" + ex.getMessage());
        InterestRate interestRate = new InterestRate(0, "Temp", 0.0);
        return ResponseEntity.ok(interestRate);
    }
}
