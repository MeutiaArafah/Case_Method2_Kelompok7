public class AllMethod {
    NodeKendaraan head;
    NodeKendaraan tail;

    boolean isEmpty() {
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

    public int size() {
        int count = 0;
        NodeKendaraan temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        
        System.out.println("\n-- Antrian Kendaraan --");
        NodeKendaraan temp = head;
        int nomor = 1;
        System.out.println("Antrian kendaraan:");
        while (temp != null) {
            temp.data.tampilInformasi();
            temp = temp.next;
            nomor++;
        }
    }
    
    public Kendaraan removeFirst() {
        if (isEmpty()) {
            return null;
        }
        
        Kendaraan removedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return removedData;
    }
}