package com.example.JSF_Lab1.models;

import jakarta.faces.annotation.ManagedProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class VoteBean {
    @ManagedProperty(value = "#{listBean}")
    ListBean listBean;
    @Setter
    @Getter
    Boolean votes;
    @Setter
    @Getter
    String chosen;

    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }

    public ListBean getListBean() {
        return listBean;
    }

    public String voteButtonBack() {
        if (chosen != null) {
            listBean.incrementCategory(chosen);
            votes = true;
            return "/faces/results.xhtml";
        }
        return null;
    }
}
