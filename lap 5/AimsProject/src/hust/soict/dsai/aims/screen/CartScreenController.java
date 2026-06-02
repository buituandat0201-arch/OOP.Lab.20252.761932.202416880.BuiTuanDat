package hust.soict.dsai.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia; [cite: 1209]

    @FXML
    private TableColumn<Media, String> colMediaTitle; [cite: 1216]

    @FXML
    private TableColumn<Media, String> colMediaCategory; [cite: 1217]

    @FXML
    private TableColumn<Media, Float> colMediaCost; [cite: 1226]

    @FXML
    private Button btnPlay; [cite: 1302]

    @FXML
    private Button btnRemove; [cite: 1302]

    public CartScreenController(Cart cart) {
        super(); [cite: 1228]
        this.cart = cart; [cite: 1229]
    }

    @FXML
    private void initialize() { [cite: 1244]
        // Định nghĩa cách các cột lấy thuộc tính từ đối tượng Media
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title")); [cite: 1245, 1246]
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category")); [cite: 1247, 1248]
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost")); [cite: 1249, 1250]
        
        // Đưa dữ liệu danh sách từ giỏ hàng vào bảng hiển thị
        tblMedia.setItems(this.cart.getItemsOrdered()); [cite: 1251]

        // Ban đầu chưa chọn dòng nào -> ẩn các nút chức năng đi [cite: 1303]
        btnPlay.setVisible(false); [cite: 1311]
        btnRemove.setVisible(false); [cite: 1312]

        // Theo dõi sự kiện click chọn dòng trên bảng để cập nhật trạng thái nút bấm [cite: 1346]
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() { [cite: 1313, 1347]
            @Override
            public void change(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) { [cite: 1341, 1342]
                if (newValue != null) { [cite: 1343]
                    updateButtonBar(newValue); [cite: 1344]
                }
            }
        });
    }

    // Hàm cập nhật trạng thái ẩn/hiện nút Play và Remove [cite: 1350]
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true); [cite: 1350]
        if (media instanceof Playable) { [cite: 1350]
            btnPlay.setVisible(true); [cite: 1350]
        } else {
            btnPlay.setVisible(false); [cite: 1360]
        }
    }

    // Xử lý sự kiện khi bấm nút Remove sản phẩm [cite: 1367]
    @FXML
    void btnRemovePressed(ActionEvent event) { [cite: 1371]
        Media media = tblMedia.getSelectionModel().getSelectedItem(); [cite: 1373]
        cart.removeMedia(media); [cite: 1373]
        // Bảng TableView sẽ tự động cập nhật lại danh sách nhờ vào cơ chế ObservableList [cite: 1375]
    }
}