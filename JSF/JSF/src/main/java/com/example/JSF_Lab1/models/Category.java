package com.example.JSF_Lab1.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Category {
    @Setter
    @Getter
    String categoryLabel;
    @Setter
    @Getter
    String categoryValue;
    @Setter
    @Getter
    int categoryVotes;

    public Category(String categoryLabel, String categoryValue, int categoryVotes) {
        this.categoryLabel = categoryLabel;
        this.categoryValue = categoryValue;
        this.categoryVotes = categoryVotes;
    }

    public Category() {
    }


}
