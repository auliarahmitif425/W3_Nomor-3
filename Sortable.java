abstract class Sortable {
    public abstract int compare(Sortable b); // Setiap subclass wajib bikin cara membandingkan dirinya dengan objek lain

    public static void shell_sort(Sortable[] a) {
        int n = a.length; // Ambil panjang array
        int h = 1;        // Inisialisasi gap (jarak perbandingan)

        // Hitung gap awal dengan Knuth sequence (1, 4, 13, 40, ...)
        while (h < n/3) h = 3*h + 1; 

        // Loop utama: selama gap masih >= 1, lakukan pengurutan
        while (h >= 1) {
            // Iterasi mulai dari indeks h sampai akhir array
            for (int i = h; i < n; i++) {
                Sortable temp = a[i]; // Simpan elemen yang sedang diproses
                int j = i;            // Posisi elemen yang akan digeser

                // Geser elemen ke kanan selama elemen sebelumnya lebih besar dari temp
                while (j >= h && a[j - h].compare(temp) > 0) {
                    a[j] = a[j - h];  // Geser elemen ke posisi j
                    j -= h;           // Mundur sejauh gap h
                }

                a[j] = temp; // Masukkan elemen temp ke posisi yang tepat
            }

            h = h/3; // Kurangi gap (semakin kecil sampai akhirnya jadi 1)
        }
    }
}
