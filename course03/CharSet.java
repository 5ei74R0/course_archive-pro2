public class CharSet {
    private char[] array;

    void init() {
        array = new char[] {'0', '0', '0', '0'};
    }

    int count() {
        int res = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != '0') ++res;
        }
        return res;
    }

    boolean search(char x) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == x) return true;
        }
        return false;
    }

    void add(char x) {
        if (search(x)) return;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == '0') {
                array[i] = x;
                return;
            }
        }
        array[0] = x;
        return;
    }

    void remove(char x) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == x) {
                array[i] = '0';
                return;
            }
        }
        return;
    }
}
