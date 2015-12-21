package serviceImpl; /**
 * Created by skaraptan on 2015-12-07.
 */
import DAO.HistoryService;
import model.Operation;

public class HistoryServiceImpl implements HistoryService{
    Operation[] history = new Operation[10];
    public Operation[] getAccountHistory(Long accountNumber){
            return history;            
    }
}
