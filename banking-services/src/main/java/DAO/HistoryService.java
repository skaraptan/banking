
package DAO;
import model.Operation;

public interface HistoryService {
    Operation[] getAccountHistory(Long accountNumber);
    //void addToHistory(Account account, Operation operation);
}
