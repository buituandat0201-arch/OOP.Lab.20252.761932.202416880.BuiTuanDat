package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Artist:"));
        panel.add(tfArtist);
    }

    @Override
    protected void saveItem() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();

        // Tạo đối tượng CD mới và đưa vào hệ thống Store
        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "Compact Disc added to store successfully!");
        tfArtist.setText("");
    }
}