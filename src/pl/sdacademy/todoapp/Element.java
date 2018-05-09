package pl.sdacademy.todoapp;

public class Element {

    private Element next;
    private Object text;

    Element(Object text) {
        this.text = text;
    }

    public void addNext(Element e) {
        if (next == null) {
            next = e;
        } else {
            next.addNext(e);
        }
    }

    public void removeRef() {
        next = null;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public String toString() {
        if (next != null) {
            return text + " " + String.valueOf(next);
        } else {
            return String.valueOf(text);
        }
    }

    public Element getNext() {
        return next;
    }

    public Object getText() {
        return this.text;
    }
}

