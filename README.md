# StoryApp – Proyek Submission Aplikasi Story

StoryApp adalah aplikasi Android sederhana yang saya kembangkan sebagai bagian dari tugas akhir kelas Android Mahir Dicoding melalui program beasiswa IDCamp. Aplikasi ini memiliki fitur login, registrasi, menampilkan daftar cerita dari API, menambah cerita baru, dan melihat detail cerita.

---

## Cuplikan Layar

<table align="center">
  <tr>
    <td align="center" valign="top">
      <strong>Registration</strong><br>
      <img src="https://github.com/user-attachments/assets/73fa906e-24c9-45fe-9e5e-42c2c89fa0df" width="250"/>
    </td>
    <td align="center" valign="top">
      <strong>Home</strong><br>
      <img src="https://github.com/user-attachments/assets/4ec9d426-aa2b-4838-8794-949391ab3392" width="250"/>
    </td>
    <td align="center" valign="top">
      <strong>Detail</strong><br>
      <img src="https://github.com/user-attachments/assets/8d5473df-3207-4723-ac67-87f04b6a2fea" width="250"/>
    </td>
    <td align="center" valign="top">
      <strong>Upload Story</strong><br>
      <img src="https://github.com/user-attachments/assets/64b9028c-a87c-4e4a-8c49-95f2124b121d" width="250"/>
    </td>
  </tr>
</table>
<table align="center">
  <tr>
    <td align="center" valign="top">
      <strong>Language</strong><br>
      <img src="https://github.com/user-attachments/assets/ee2e79e4-f068-4b87-83e5-384bd0984b9e" width="250"/>
    </td>
    <td align="center" valign="top">
      <strong>Stack Widget</strong><br>
      <img src="https://github.com/user-attachments/assets/3c471f47-2ada-4e54-873d-bfa80db60618" width="250"/>
    </td>
  </tr>
</table>

---

## 🎯 Tujuan Pengembangan

Menyelesaikan submission akhir dengan menerapkan fitur-fitur sesuai standar pembelajaran, seperti:

- Halaman login dan register
- Menyimpan sesi login menggunakan DataStore
- Menampilkan daftar cerita dari API
- Menambah cerita dengan foto dan deskripsi
- Melihat detail cerita
- Logout yang menghapus data sesi
- Validasi input dan animasi dasar
- Arsitektur modern (MVVM)
- Penanganan data yang efisien (Paging 3, RemoteMediator)
- Pengalaman pengguna yang kaya (Maps, Animasi, Localization)
- Kualitas kode yang teruji (Unit & UI Testing)

---

## ✨Fitur Aplikasi

### Autentikasi
- Login dengan email dan password
- Register dengan nama, email, dan password
- Validasi password minimal 8 karakter langsung di EditText
- Validasi format email langsung di EditText
- Input password disembunyikan

### Manajemen Sesi
- Data token dan login disimpan di `DataStore`
- Jika sudah login, langsung diarahkan ke halaman utama
- Logout akan menghapus data sesi

### Daftar Cerita
- Infinite Scrolling Feed: Menampilkan daftar cerita dari API secara efisien menggunakan Paging 3 Library.
- Kapabilitas Offline-First: Menggunakan RemoteMediator untuk menyimpan data dari API ke database lokal (Room), memungkinkan aplikasi tetap dapat menampilkan data saat offline.
- Detail Cerita: Menampilkan detail cerita dengan animasi Shared Element Transition yang mulus.

### Tambah Cerita
- Upload Gambar: Memungkinkan pengguna mengunggah gambar dari Galeri dan Kamera.
- Lokasi GPS (Opsional): Menambahkan informasi lokasi pengguna saat ini (latitude & longitude) ke dalam cerita yang diunggah.

### Peta Cerita
- Visualisasi Geotag: Menggunakan Google Maps API untuk menampilkan semua cerita yang memiliki data lokasi dalam bentuk marker interaktif di peta.
- Custom Map Style: Menerapkan gaya peta kustom untuk tampilan yang lebih menarik.
  
### Fitur Tambahan
- Localization: Mendukung dua bahasa (Inggris & Indonesia).
- Home Screen Widget: Menampilkan daftar cerita terbaru langsung di home screen pengguna.
- Penanganan State: Menampilkan indikator Loading, pesan Error, dan Empty State saat berinteraksi dengan API.

## Teknologi yang Digunakan

| Kategori          | Teknologi yang Digunakan                  |
|-------------------|-------------------------------------------|
| **Bahasa** | Kotlin                                    |
| **Arsitektur** | MVVM (Model-View-ViewModel)               |
| **UI** | XML, ViewBinding, Custom Views            |
| **Asynchronous** | Kotlin Coroutines & Flow                  |
| **Networking** | Retrofit & OkHttp                         |
| **Data Handling** | Paging 3 dengan RemoteMediator            |
| **Database Lokal**| Room                                      |
| **Manajemen Sesi**| Jetpack DataStore                         |
| **Maps** | Google Maps API                           |
| **Image Loading** | Glide                                     |
| **Pengujian** | JUnit (Unit Test) & Espresso (UI Test)    |

---

## 🧪 Pengujian (Testing)
Aplikasi ini dilengkapi dengan pengujian otomatis untuk memastikan keandalan dan stabilitas:
- Unit Test: Mencakup 4+ kasus uji pada ViewModel untuk memverifikasi logika pengambilan data Paging (saat berhasil, data kosong, dll).
- UI Test: Mencakup 1 skenario krusial (seperti alur login-logout) untuk memastikan fungsionalitas antarmuka berjalan sesuai harapan.


