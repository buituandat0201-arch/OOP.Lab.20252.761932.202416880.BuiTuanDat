package hust.soict.dsai.aims.screen;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super(); [cite: 1129]
        this.cart = cart; [cite: 1132]

        // Tạo JFXPanel để nhúng thành phần JavaFX vào JFrame của Swing [cite: 1119, 1153]
        JFXPanel fxPanel = new JFXPanel(); [cite: 1153]
        this.add(fxPanel); [cite: 1137]

        this.setTitle("Cart"); [cite: 1154]
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true); [cite: 1155]

        // Chạy tiến trình nạp cấu hình giao diện JavaFX một cách bất đồng bộ [cite: 1156]
        Platform.runLater(new Runnable() { [cite: 1156]
            @Override
            public void run() { [cite: 1158]
                try { [cite: 1159]
                    // Tải file fxml thiết kế giao diện
                    FXMLLoader loader = new FXMLLoader(getClass() [cite: 1160]
                            .getResource("/hust/soict/dsai/aims/screen/cart.fxml")); [cite: 1161]
                    
                    // Khởi tạo Controller thủ công để truyền thuộc tính dữ liệu giỏ hàng vào
                    CartScreenController controller = new CartScreenController(cart); [cite: 1162, 1163]
                    loader.setController(controller); [cite: 1164]
                    
                    Parent root = loader.load(); [cite: 1151]
                    // Gắn Scene JavaFX vào panel Swing trung gian
                    fxPanel.setScene(new Scene(root)); [cite: 1165]
                    
                } catch (IOException e) {
                    e.printStackTrace(); [cite: 1169]
                }
            }
        });
    }
}