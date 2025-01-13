package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * gkislin
 * 19.07.2016
 */
public class Organization {
    private final Link homePage;

    private final List<Position> positions;

    public Organization(String name, String url, List<Position> positions) {
        Objects.requireNonNull(positions, "positions must not be null");
        this.positions = positions;
        this.homePage = new Link(name, url);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;
        return homePage.equals(that.homePage) && positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", positions=" + positions +
                '}';
    }

    public static class Position {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String title;
        private final String description;

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;
            return startDate.equals(position.startDate) &&
                    endDate.equals(position.endDate) &&
                    title.equals(position.title) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            int result = startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + title.hashCode();
            result = 31 * result + Objects.hashCode(description);
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}
