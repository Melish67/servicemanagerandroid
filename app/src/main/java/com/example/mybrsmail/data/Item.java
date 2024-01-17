package com.example.mybrsmail.data;

public class Item {
    private String itemTitle;
    private String itemTitle2;
    private String itemTitle3;
    private String itemTitle4;
    private String itemTitle5;
    private String itemTitle6;
    private boolean expanded;

    public Item() {
    }

    public Item(String itemTitle, String itemTitle2, String itemTitle3, String itemTitle4, String itemTitle5, String itemTitle6) {
        this.itemTitle = itemTitle;
        this.itemTitle2 = itemTitle2;
        this.itemTitle3 = itemTitle3;
        this.itemTitle4 = itemTitle4;
        this.itemTitle5 = itemTitle5;
        this.itemTitle6 = itemTitle6;
        this.expanded = expanded;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemTitle2() {
        return itemTitle2;
    }

    public void setItemTitle2(String itemTitle2) {
        this.itemTitle2 = itemTitle2;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getItemTitle3() {
        return itemTitle3;
    }

    public void setItemTitle3(String itemTitle3) {
        this.itemTitle3 = itemTitle3;
    }

    public String getItemTitle4() {
        return itemTitle4;
    }

    public void setItemTitle4(String itemTitle4) {
        this.itemTitle4 = itemTitle4;
    }

    public String getItemTitle5() {
        return itemTitle5;
    }

    public void setItemTitle5(String itemTitle5) {
        this.itemTitle5 = itemTitle5;
    }

    public String getItemTitle6() {
        return itemTitle6;
    }

    public void setItemTitle6(String itemTitle6) {
        this.itemTitle6 = itemTitle6;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemTitle='" + itemTitle + '\'' +
                ", itemTitle2='" + itemTitle2 + '\'' +
                ", itemTitle3='" + itemTitle3 + '\'' +
                ", itemTitle4='" + itemTitle4 + '\'' +
                ", itemTitle5='" + itemTitle5 + '\'' +
                ", itemTitle6='" + itemTitle6 + '\'' +
                ", expanded=" + expanded +
                '}';
    }
}
