package in.sbms.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestRate {
    Integer id;
    String type;
    Double rateValue;
}