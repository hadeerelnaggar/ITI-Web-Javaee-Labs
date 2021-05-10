package com.example.JSF_Lab1.models;

import jakarta.annotation.ManagedBean;
import jakarta.inject.Named;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ListBean {
    @Getter
    @Setter
    Category[] categories;

    public ListBean() {
        categories = new Category[5];
        categories[0] = new Category("Skin Care", "skincare", 0);
        categories[1] = new Category("Clothes", "clothes", 0);
        categories[2] = new Category("Garden", "garden", 0);
        categories[3] = new Category("Home Appliances", "homeAppliances", 0);
        categories[4] = new Category("Sports", "sports", 0);
    }

    public void incrementCategory(String name) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getCategoryValue().equals(name)) {
                categories[i].setCategoryVotes(categories[i].getCategoryVotes() + 1);
            }
        }
    }
}
