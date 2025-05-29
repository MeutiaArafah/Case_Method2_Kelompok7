public class AllMethod {
    NodeKendaraan head;
    NodeKendaraan tail;

    boolean isEmpty(){
        return (head == null);
    }

    public void addLast(Kendaraan input) {
        NodeKendaraan ndInput = new NodeKendaraan(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public int size(){
        int count = 0;
        NodeKendaraan temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

}
