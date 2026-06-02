package hust.soict.hedspi.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAdd = new JButton("Add to cart");
        container.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(media);
                    javax.swing.JOptionPane.showMessageDialog(MediaStore.this, 
                        "Added " + media.getTitle() + " to cart successfully!");
                } catch (hust.soict.hedspi.aims.exception.LimitExceededException ex) {
                    javax.swing.JOptionPane.showMessageDialog(MediaStore.this, 
                        ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();

                        // Display JDialog with playing information
                        java.awt.Window parentWindow = javax.swing.SwingUtilities.windowForComponent(MediaStore.this);
                        javax.swing.JDialog dialog = new javax.swing.JDialog(parentWindow, "Play Media", 
                            java.awt.Dialog.ModalityType.APPLICATION_MODAL);
                        dialog.setSize(300, 150);
                        dialog.setLayout(new java.awt.BorderLayout());

                        String msg = "<html><body style='text-align: center;'><br><b>Playing Media:</b> " + media.getTitle() 
                            + "<br><b>Length:</b> " + ((Disc) media).getLength() + "s</body></html>";
                        JLabel label = new JLabel(msg, SwingConstants.CENTER);
                        dialog.add(label, java.awt.BorderLayout.CENTER);

                        JButton btnClose = new JButton("Close");
                        btnClose.addActionListener(evt -> dialog.dispose());
                        dialog.add(btnClose, java.awt.BorderLayout.SOUTH);

                        dialog.setLocationRelativeTo(MediaStore.this);
                        dialog.setVisible(true);
                    } catch (hust.soict.hedspi.aims.exception.PlayerException ex) {
                        javax.swing.JOptionPane.showMessageDialog(MediaStore.this, 
                            ex.getMessage(), "Illegal DVD Length", javax.swing.JOptionPane.ERROR_MESSAGE);
                        System.err.println("PlayerException occurred: " + ex.getMessage());
                        System.err.println(ex.toString());
                        ex.printStackTrace();
                    }
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}