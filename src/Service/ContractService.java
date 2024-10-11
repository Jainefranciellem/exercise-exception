package Service;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;
import interfaces.OnlinePaymentInterface;

public class ContractService {

    private OnlinePaymentInterface onlinePaymentInterface;

    public ContractService(OnlinePaymentInterface onlinePaymentInterface) {
        this.onlinePaymentInterface = onlinePaymentInterface;
    }
    
    public void processContract( Contract contract, Integer months) {

        Double installment = contract.getTotalValue() / months;
        
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            Double insterest = onlinePaymentInterface.interest(installment, i);
            Double sum = installment + insterest;
            Double paymentFee = onlinePaymentInterface.paymentFee(sum);
            Double total = installment + paymentFee + insterest;
            Installment intInstallmentTotal = new Installment(dueDate, total);

            contract.getInstallments().add(intInstallmentTotal);
        }
    }
}
