public class Meja {
    private int id;
    private int kapasitas;
    private boolean dipesan;

    public Meja(int id, int kapasitas) {
        this.id = id;
        this.kapasitas = kapasitas;
        this.dipesan = false;
    }

    public int getId() { return id; }
    public int getKapasitas() { return kapasitas; }
    public boolean isDipesan() { return dipesan; }
    public void setDipesan(boolean status) { this.dipesan = status; }
}