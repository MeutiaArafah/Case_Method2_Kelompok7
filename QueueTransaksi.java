public class QueueTransaksi {
    TransaksiPengisian[] queue;
    int front;
    int rear;
    int maxSize;
    int count;
    
    public QueueTransaksi(int size) {
        maxSize = size;
        queue = new TransaksiPengisian[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == maxSize;
    }
    
    public void enqueue(TransaksiPengisian transaksi) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queue[rear] = transaksi;
            count++;
        } else {
            System.out.println("Queue penuh! Tidak dapat menambah transaksi.");
        }
    }
    
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        
        System.out.println("\n-- Riwayat Transaksi --");
        int temp = front;
        System.out.println("Daftar transaksi:");
        for (int i = 0; i < count; i++) {
        TransaksiPengisian t = queue[temp];
        System.out.println(t.kendaraan.platNomor + ": " + t.totalBayar);
        temp = (temp + 1) % maxSize;
        }
    }
}
