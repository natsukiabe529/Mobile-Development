package com.example.presidentlistrecycleview;

import java.util.Comparator;

public class President {
    private int id;
    private String name;
    private int dateOfElection;
    private String imageURL;

    public President(int id, String name, int dateOfElection, String imageURL) {
        this.id = id;
        this.name = name;
        this.dateOfElection = dateOfElection;
        this.imageURL = imageURL;
    }

    public static Comparator<President> PresidentNameAZComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<President> PresidentNameZAComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

    public static Comparator<President> PresidentDateAscendingComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getDateOfElection() - p2.getDateOfElection();
        }
    };

    public static Comparator<President> PresidentDateDescendingComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getDateOfElection() - p1.getDateOfElection();
        }
    };

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfElection=" + dateOfElection +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateOfElection() {
        return dateOfElection;
    }

    public void setDateOfElection(int dateOfElection) {
        this.dateOfElection = dateOfElection;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
