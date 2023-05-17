public class Test246 {

    private int getTime(String s) {
        String[] ss = s.split(":");
        return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
    }

    public boolean haveConflict1(String[] event1, String[] event2) {
        int e10 = getTime(event1[0]);
        int e11 = getTime(event1[1]);
        int e20 = getTime(event2[0]);
        int e21 = getTime(event2[1]);
        // int[] times = new int[] { t1, t2, t3, t4 };
        // Arrays.sort(times);
        // return times[3] - times[0] <= t2 - t1 + t4 - t3;
        return e10 <= e20 && e11 >= e20 || e10 >= e20 && e10 <= e21;
    }

    // 官方
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
    // ！！！反向的相交判断！！！

    public static void main(String[] args) {
        new Test246().haveConflict(
                new String[] { "10:00", "11:00" },
                new String[] { "14:00", "15:00" });
    }
}
