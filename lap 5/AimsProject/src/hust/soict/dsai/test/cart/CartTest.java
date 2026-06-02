package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	    public static void main(String[] args) {

	        // Tạo giỏ hàng
	        Cart cart = new Cart();

	        // Tạo các DVD mẫu
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
	        dvd1.setCategory("Animation");
	        dvd1.setDirector("Roger Allers");
	        dvd1.setLength(87);
	        dvd1.setCost(19.95f);

	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
	        dvd2.setCategory("Sci-Fi");
	        dvd2.setDirector("George Lucas");
	        dvd2.setLength(124);
	        dvd2.setCost(24.95f);

	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
	        dvd3.setCategory("Animation");
	        dvd3.setDirector("Ron Clements");
	        dvd3.setLength(90);
	        dvd3.setCost(18.99f);

	        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers");
	        dvd4.setCategory("Action");
	        dvd4.setDirector("Joss Whedon");
	        dvd4.setLength(143);
	        dvd4.setCost(29.99f);

	        // Thêm vào giỏ hàng
	        cart.addMedia(dvd1);
	        cart.addMedia(dvd2);
	        cart.addMedia(dvd3);
	        cart.addMedia(dvd4);

	        // =========================
	        // TEST IN GIỎ HÀNG
	        // =========================
	        cart.print();

	        
	        
	    }
	}