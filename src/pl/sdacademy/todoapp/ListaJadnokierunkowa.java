package pl.sdacademy.todoapp;

public class ListaJadnokierunkowa<T> {

    private Element first;

    public void add(Object e) {
        if (first == null) {
            first = new Element(e);
        } else {
            first.addNext(new Element(e));
        }
    }

    // zrobić toString !!!
    public String toString() {
        return this.first.toString();
    }

    // zrobić remove !!!

    public void remove(int index) {
        if (index == 0) {
            Element node = first.getNext();
            first.removeRef();
            first = node;
        } else {
            Element current = first;
            Element prev = null;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.getNext();
            }
            Element next = current.getNext();
            current.removeRef();
            prev.setNext(next);
        }
    }

    public Object getElement(int index) {
        Element currentElement = first;
        int iterationIndex = 0;
        while (iterationIndex < index) {
            currentElement = currentElement.getNext();
            iterationIndex++;
        }
        if (currentElement == null){
            return null;
        }else return currentElement.getText();
    }
}
