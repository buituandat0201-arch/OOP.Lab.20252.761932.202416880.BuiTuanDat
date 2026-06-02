package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    
    // Các trường nhập liệu chung cho mọi loại Media [cite: 1416]
    protected JTextField tfTitle = new JTextField(20);
    protected JTextField tfCategory = new JTextField(20);
    protected JTextField tfCost = new JTextField(20);

    public AddItemToStoreScreen(Store store, Cart cart, String titleForm) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Tiêu đề của Form nhập liệu
        JLabel lblHeader = new JLabel(titleForm, SwingConstants.CENTER);
        lblHeader.setFont(new Font(lblHeader.getFont().getName(), Font.BOLD, 24));
        cp.add(lblHeader, BorderLayout.NORTH);

        // Panel trung tâm chứa các ô nhập liệu dạng Form lưới
        JPanel centerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        centerPanel.add(new JLabel("Title:"));
        centerPanel.add(tfTitle);
        centerPanel.add(new JLabel("Category:"));
        centerPanel.add(tfCategory);
        centerPanel.add(new JLabel("Cost:"));
        centerPanel.add(tfCost);

        // Gọi hàm bổ sung các trường nhập liệu đặc trưng của lớp con
        addCustomFields(centerPanel);

        cp.add(centerPanel, BorderLayout.CENTER);

        // Nút xác nhận lưu dữ liệu đặt ở phía Nam
        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> {
            try {
                saveItem();
                clearForm();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input data format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        cp.add(btnAdd, BorderLayout.SOUTH);

        setTitle(titleForm);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chỉ đóng form này, không tắt app
        setVisible(true);
    }

    // Hàm trừu tượng ép các lớp con phải tự định nghĩa thêm trường thông tin riêng
    protected abstract void addCustomFields(JPanel panel);
    
    // Hàm xử lý logic lưu trữ dữ liệu riêng biệt
    protected abstract void saveItem() throws Exception;

    private void clearForm() {
        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
    }
}