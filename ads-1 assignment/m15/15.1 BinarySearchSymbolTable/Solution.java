import java.util.Scanner; 
class SymbolTables<Key extends Comparable<Key>, Value> {  
    /**
     * Key Array for Key Type.
     */
    private Key[] kys;
    /**
     * Value Array for Value Type.
     */
    private Value[] vls;
    /**
     * Size of the Array.
     */
    private int size;
    SymbolTables(int limit) {
        kys = (Key[]) new Comparable[limit];
        vls = (Value[]) new Object[limit];
        size = 0;
    }
    public void put(final Key key, final Value val) {
        if (size == 0) {
            kys[size] = key;
            vls[size] = val;
            size++;
        } else {
            int index = rank(key);
            if (index == size) {
                kys[index] = key;
                vls[index] = val;
                size++;
            } else if (!contains(key)) {
                for (int i = size; i > index; i--) {
                    kys[i] = kys[i - 1];
                    vls[i] = vls[i - 1];
                }
                kys[index] = key;
                vls[index] = val;
                size++;
            } else {
                vls[index] = val;
            }
        }
    }
    public int size() {
        return size;
    }
    public void kys() {
        for (int i = 0; i < size; i++) {
            System.out.println(kys[i] + " " + vls[i]);
        }
    }
    public boolean contains(final Key key) {
        int index = rank(key);
        return kys[index].compareTo(key) == 0;
    } 
    /**
     *
     * @param      key   The key
     *
     * @return     { returns the value of given key }
     */
    public Value get(Key key) {
        if (contains(key)) {
            int index = rank(key);
            return vls[index];
        }
        return null;
    }      
    /**
     * Max keys in Table.
     *
     * @return     { Returns max key }
     */
    public Key max() {
        return kys[size - 1];
    }
    /**
     *
     * @param      key   The key
     *
     * @return     { Returns the key which is smaller or equal to the given. }
     */
    public Key floor(final Key key) {
        int index = rank(key);
        if (contains(key)) {
            return key;
        } else if (index == 0) {
            return null;
        }
        return kys[index - 1];
    }
    public int rank(final Key key) {
        int lo = 0;
        int hi = size - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (kys[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else if (kys[mid].compareTo(key) > 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    public void delMin() {
        for (int i = 0; i < size - 1; i++) {
            kys[i] = kys[i + 1];
            vls[i] = vls[i + 1];
        }
        size--;
    }
}
public final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] symbol = sc.nextLine().split(" ");
         SymbolTables<String, Integer> symtable = new SymbolTables<String, 
         Integer>(symbol.length);
        for (int i = 0; i < symbol.length; i++) {
            symtable.put(symbol[i], i);
        }
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");  
            switch (input[0]) {
                case "max":
                    System.out.println(symtable.max());
                break;
                case "floor":
                    System.out.println(symtable.floor(input[1]));
                break;
                case "get":
                    System.out.println(symtable.get(input[1]));
                break;
                case "contains":
                    System.out.println(symtable.contains(input[1]));
                break;
                case "rank":
                    System.out.println(symtable.rank(input[1]));
                break;
                case "delMin":
                    symtable.delMin();
                break;
                case "kys":
                    symtable.kys();  
                break;
                case "size":
                System.out.println(symtable.size());
                break;
                default:
                break;
            } 
        }
    }
}