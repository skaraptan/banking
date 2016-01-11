
package DAO;

import model.Account;
import model.Operation;

import java.util.List;

public interface HistoryService {
    List<Operation> getAccountHistory(Account account);
    void addToHistory(Operation operation);
}
