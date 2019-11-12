package minipro2.payment.payment.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CashUpSys  implements PaymentOption{

    private String msg;

}
