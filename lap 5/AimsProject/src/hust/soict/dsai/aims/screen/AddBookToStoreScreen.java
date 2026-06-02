package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors = new JTextField(20);

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store"); [cite: 1418]
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Authors (comma-separated):"));
        panel.add(tfAuthors);
    }

    @Override
    protected void saveItem() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        
        Book book = new Book(title, category, cost);
        String[] authorList = tfAuthors.getText().split(",");
        for (String author : authorList) {
            if (!author.trim().isEmpty()) {
                book.addAuthor(author.trim());
            }
        }
        
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added to store successfully!");
        tfAuthors.setText("");
    }
}