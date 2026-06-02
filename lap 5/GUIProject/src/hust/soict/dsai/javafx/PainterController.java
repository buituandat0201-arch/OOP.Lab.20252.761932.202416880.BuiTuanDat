package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup toolsGroup;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color drawColor = Color.BLACK; // Mặc định mực màu đen [cite: 918]
        
        // Kiểm tra xem nút Eraser có đang được tích chọn hay không [cite: 1007]
        if (eraserRadioButton.isSelected()) {
            drawColor = Color.WHITE; // Chọn cục tẩy thì chuyển sang mực trắng [cite: 1008]
        }

        // Tạo một chấm tròn nhỏ tại tọa độ con trỏ chuột và đẩy vào vùng vẽ [cite: 915, 916]
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawColor); [cite: 918]
        drawingAreaPane.getChildren().add(newCircle); [cite: 918]
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa sạch toàn bộ các chấm tròn trên khung vẽ [cite: 927]
        drawingAreaPane.getChildren().clear(); [cite: 935]
    }
}