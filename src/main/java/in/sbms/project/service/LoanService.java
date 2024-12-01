package in.sbms.project.service;

import in.sbms.project.dto.InterestRate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoanService {


        private final RestTemplate restTemplate;

        private static final String RATE_SERVICE_URL = "http://localhost:8080/getRate/{type}";

        public LoanService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }


        public InterestRate getAllLoansByType(String type) {
            System.out.println("***Main method is called***");
            return restTemplate.getForObject(RATE_SERVICE_URL, InterestRate.class, type);
        }




    }