package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class Controller implements Initializable {
    @FXML private TextField pathId;
    @FXML private TextField endId;
    @FXML private ProgressBar barId;
    @FXML private ListView<String> listId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.items.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change obj) {
                listId.setItems(obj.getList());
            }
        });
    }

    @FXML
    protected void btnFindClick(ActionEvent event) {
        String path = pathId.getText();
        String end = endId.getText();

        Main.items.clear();
        barId.setProgress(-1);

        new FindTask(Main.items, path, end).doWork();

        barId.setProgress(1);
    }

    @FXML
    protected void btnCancelClick(ActionEvent event){
        System.out.println("Try to cancel!");
    }
}
