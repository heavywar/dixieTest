package com.company;

class Sorting {
    static int compare(String a, String b) {
        if (a.length() < b.length() && b.startsWith(a))
            return -1;
        if (b.length() < a.length() && a.startsWith(b))
            return 1;
        return b.compareTo(a);
    }
}
