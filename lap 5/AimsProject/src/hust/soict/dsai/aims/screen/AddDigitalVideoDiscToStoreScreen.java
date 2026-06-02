package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfLength = new JTextField(20);

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store"); [cite: 1418]
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Director:"));
        panel.add(tfDirector);
        panel.add(new JLabel("Length:"));
        panel.add(tfLength);
    }

    @Override
    protected void saveItem() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added to store successfully!");
        tfDirector.setText("");
        tfLength.setText("");
    }
}