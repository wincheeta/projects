public class Heap {
    private int[] data;
    private int size;
    private int height;

    public Heap(int size) {
        this.data = new int[size];
        this.size = 0;
    }

    public void add(int element) {
        data[size++] = element;
        perlocateUp(size - 1);
        this.height = (int) (Math.log(size) / Math.log(2));
    }

    public int removeMin() {
        if (size > 0) {
        int out = data[0];
        data[0] = data[--size];
        data[size] = 0;
        perlocateDown(0);
        return out;
    }
    return 0;
    }

    public void perlocateUp(int pos) {
        if (data[(pos - 1) / 2] > data[pos]) {
            int temp = data[(pos - 1) / 2];
            data[(pos - 1) / 2] = data[pos];
            data[pos] = temp;
            perlocateUp((pos - 1) / 2);
        }
    }

    public void swap(int pos1, int pos2) {
        int temp = data[pos1];
        data[pos1] = data[pos2];
        data[pos2] = temp;
    }

    public void perlocateDown(int pos) {
        if (data[pos] != 0) {
        if (data[2 * pos + 1] < data[2 * pos + 2]) {
            if (data[2 * pos + 1] < data[pos]) {
                this.swap(2 * pos + 1, pos);
                perlocateDown(2 * pos + 1);
            } else if (data[2 * pos + 2] < data[pos]) {
                this.swap(2 * pos + 2, pos);
                perlocateDown(2 * pos + 2);
            }
        } else if (data[2 * pos + 1] > data[2 * pos + 2]) {
            if (data[2 * pos + 2] < data[pos]) {
                this.swap(2 * pos + 2, pos);
                perlocateDown(2 * pos + 2);
            } else if (data[2 * pos + 1] < data[pos]) {
                this.swap(2 * pos + 1, pos);
                perlocateDown(2 * pos + 1);
            }
        }
    }}



    /*public void print(){
        for (int i = 0; i < height; i++) {
            for (int j = (int)Math.pow(2,i); j < (int)Math.pow(2,i+1); j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
        }
    }*/

    public static void main(String[] args) {
        Heap heap = new Heap(16);
        heap.add(1);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        heap.add(3);
        heap.add(5);
        heap.add(3);
        heap.add(6);
        for (int i : heap.data) {
            System.out.print(i + "|");
        }
        System.out.println();
        for (int i : heap.data) {
            int temp = heap.removeMin();
            System.out.print(temp + ", ");
            for (int j : heap.data) {
                System.out.print(j + "|");
            }
            System.out.println();
        }
    }
}
