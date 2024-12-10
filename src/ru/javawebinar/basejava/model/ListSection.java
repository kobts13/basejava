package ru.javawebinar.basejava.model;

import java.util.List;

public class ListSection extends Section {
    private List<String> items;

    public ListSection(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "items=" + items +
                '}';
    }
}
