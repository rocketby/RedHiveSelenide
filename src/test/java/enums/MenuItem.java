package enums;

public enum MenuItem {
    OPEN_DECKS("/overprime/deck/list"),
    OPEN_ARTICLES("/article/list"),
    CREATE_ARTICLE("/article/create"),
    CREATE_DECK("/overprime/deck/edit"),
    PRICE_CALCULATOR("/overprime/card-real-price-calculator");

    private final String link;

    MenuItem(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }


    @Override
    public String toString() {
        return link;
    }
}
