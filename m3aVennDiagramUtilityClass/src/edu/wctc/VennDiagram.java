package edu.wctc;

import java.util.HashSet;
import java.util.Set;

public class VennDiagram<T> {
    private String label1;
    private String label2;
    private String label3;
    private Set<T> circle1;
    private Set<T> circle2;
    private Set<T> circle3;


    public VennDiagram(String label1, String label2, String label3) {
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
        this.circle1 = new HashSet<>();
        this.circle2 = new HashSet<>();
        this.circle3 = new HashSet<>();
    }

    private Set<T> getCircleForLabel(String label) {
        if (label == label1) {
            return circle1;
        } else if (label == label2) {
            return circle2;
        } else if (label == label3) {
            return circle3;
        } else {
            return null;
        }
    }

    public void add(T item, String... labels) {
        for (int i = 0; i < labels.length; i++) {
            getCircleForLabel(labels[i]).add(item);
        }
    }

    public Set<T> unionOf(String first, String second) {
        Set<T> firstOrSecond = new HashSet<>(getCircleForLabel(first));
        firstOrSecond.addAll(getCircleForLabel(second));
        return firstOrSecond;
    }

    public Set<T> intersectionOf(String first, String second) {
        Set<T> firstAndSecond = new HashSet<>(getCircleForLabel(first));
        firstAndSecond.retainAll(getCircleForLabel(second));
        return firstAndSecond;
    }

    public Set<T> complementOf(String first, String second) {
        Set<T> firstButNotSecond = new HashSet<>(getCircleForLabel(first));
        firstButNotSecond.removeAll(getCircleForLabel(second));
        return firstButNotSecond;
    }

    public Set<T> diagramCenter() {
        Set<T> allThree = new HashSet<>(getCircleForLabel(label1));
        allThree.retainAll(getCircleForLabel(label2));
        allThree.retainAll(getCircleForLabel(label3));
        return allThree;
    }

}
