/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdibeans;

import beans.Cart;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import beans.BookException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import beans.Counterbean;

/**
 *
 * @author Hadeer
 */
@Named(value = "cartManagedBean")
@SessionScoped
public class CartManagedBean implements Serializable {

    @EJB
    Cart cart;
    @EJB
    Counterbean counterBean;
    String name;
    List<String> contents;
    String content;
    String title;
    int count;

    /**
     * Creates a new instance of CartManagedBean
     */
    public int getCount(){
        count = counterBean.getHits();
        return count;
    }
    
    public CartManagedBean() {
        contents = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String login() {
        try {
            cart.initialize(name);
            contents = cart.getContents();
        } catch (BookException e) {
            e.printStackTrace();
        }
        return "cartPage";
    }

    public String getName() {
        return name;
    }

    public String addContent() {
        cart.addBook(content);
        contents = cart.getContents();
        content = "";
        return "cartPage";

    }

    public String removeAll() {
        cart.remove();
        contents = cart.getContents();
        return "cartPage";

    }

    public String removeBook(String title) {
        try {
            Logger.getLogger(CartManagedBean.class.getName()).log(Level.INFO, title);
            cart.removeBook(title);
            contents = cart.getContents();

        } catch (BookException ex) {
            Logger.getLogger(CartManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "cartPage";

    }

    public List<String> getContents() {
        contents = cart.getContents();
        return contents;
    }
}
