package com.kosan.mybook;

import java.util.ArrayList;

public class BookData {
    public static String [][] data = new String[][]{
            {"Surat Kecil Untuk Ayah", "Boy Chandra", "https://ecs7.tokopedia.net/img/cache/700/product-1/2018/3/28/29432026/29432026_4c452108-d202-4668-8f90-2ec871a0efe5_538_804.jpg", "Dear,Ayah Apa kabar? Kuharap kau selalu dalam keadaan baik dan sehat. Tak terasa waktu bergulir dan aku beranjak dewasa. Tapi, semangat dan tenagamu untuk kami sekeluarga tak pernah pudar sedikit pun.‘Kagum’ setidaknya hanya kata kecil yang bisa kuucapkan. Ayah, sungguh kuingin membuatmu bahagia juga bangga. Di relung hati kusematkan namamu dalam doa. Aku sayang Ayah. Maaf, aku tak pernah mengatakannya.."},
            {"Satu Hari di 2018", "Boy Chandra", "https://cdn.gramedia.com/uploads/items/9789797945060__w414_hauto.jpg", "Sungguhlah, hal paling menyedihkan untuk ditatap di dunia ini adalah perempuan yang sedang patah hatinya. Walau kau tahu, setelah patah hati selalu ada cinta yang lebih baik. Jangan menjadikan cinta sebagai sesuatu yang salah. Sesuatu yang seolah menyakitimu. Kau dan aku pernah sepakat, bahwa bukan cinta yang menyakiti manusia. Sebab pada hakikatnya, cinta adalah kebahagiaan, walaupun patah hati tetap saja bisa menjadi kenangan tidak menyenangkan yang berulang."},
            {"Tentang Hujan", "Tere Liye", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1451905281i/28446637._SY475_.jpg", "Tentang persahabatan,Tentang cinta,Tentang perpisahan,Tentang melupakan,Tentang hujan"},
            {"Dream High Fantasy", "Nanik Puji Astutik", "https://scoopadm.apps-foundry.com/ebook-covers/23590/big_covers/ID_GARUD2015MTH05DHFA_B.jpg", "Kisah drama remaja yang unik. Melibatkan seorang remaja Indonesia bernama Nana, yang mendapat beasiswa belajar di Korea. Di sanalah, ia tak hanya mengejar cita-cita, tetapi juga cinta, persahabatan."},
            {"Annyeong Korea", "Elvira Fidelia Tanjung", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1325569360i/13363427.jpg", "Mendapat kesempatan beasiswa ke Negeri Ginseng bisa dibilang seperti menerima kado istimewa. Sebuah pengalaman yang tak bakal terlupakan seumur hidup. Priceless. Tak hanya mengenyam pendidikan, terbuka pula kesempatan berjalan-jalan gratis mengenal Korea Selatan -negeri yang terkenal akan modernitas sekaligus kekentalan budayanya."},
            {"Endles Winter in Korea", "Rizki De", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1392189652i/20797771.jpg", "Aku menarik napas dalam, udara dingin dapat kurasakan di dekat jendela. Kusentuhkan jari-jariku ke permukaan kaca. Rasa dingin menyengat kulitku. Kembali teringat kenangan saat aku masih kecil tentang Pangeran Salju. Bibirku tanpa sadar tersenyum. Ada kepedihan di hatiku hanya dengan mengingatnya. Namun semuanya telah berakhir, dan dongeng telah selesai."},
            {"Sang Pemimpi", "Andrea Hirata", "https://upload.wikimedia.org/wikipedia/id/thumb/8/89/Sang_Pemimpi_sampul.jpg/220px-Sang_Pemimpi_sampul.jpg", "sebuah kisah kehidupan yang mempesona yang akan membuat pembacanya percaya akan tenaga cinta, percaya pada kekuatan mimpi dan pengorbanan, selin itu juga memperkuat kepercayaan kepada Tuhan. Andrea berkelana menerobos sudut-sudut pemikiran di mana pembaca akan menemukan pandangan yang berbeda tentang nasib, tantangan intelektualitas, dan kegembiraan yang meluap-luap, sekaligus kesedihan yang mengharu biru. "},
            {"9 Matahari", "Adenita", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1236905460i/5556517.jpg", " bertemakan mimpi dan berlatarkan kota Bandung, kota yang penuh kreatifitas. Dalam novel ini Matari memiliki sifat yang pantang menyerah. Matari juga seorang wanita muda yang memiliki tekad yang kuat dalam menggapain mimpinya. Dalam perjalanan menggapai impiannya Tari di dukung oleh kakaknya dengan penuh pengertian dan sabar. Sementara ayahnya sangat keras dan keras kepala."},
            {"Mengejar Ngejar Mimpi: Diary Kocak Pemuda Nekat", "Dedi Padiku", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1401775587i/22396260.jpg", "Mengejar-ngejar Mimpi memilíki banyak bagian haru, yang akan membuatmu ikut berurai air mata. Sebuah novel inspiratif yang menguatkan semangat ketika kamu merasa lemah mencapai cita-cita."},
            {"Rentang Kisah", "Gita Savitri Devi", "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1506238325i/36294386.jpg", "Apa tujuan hidupmu? Kalau itu ditanyakan kepadaku saat remaja, aku pasti nggak bisa menjawabnya. Jangankan tujuan hidup, cara belajar yang benar saja aku nggak tahu. Setiap hari aku ke sekolah lebih suka bertemu teman-teman dan bermain kartu. Aku nggak tahu apa yang menjadi passion-ku. Aku sekadar menjalani apa yang ibu pilihkan untukku—termasuk melanjutkan kuliah di Jerman."},
    };
    public static ArrayList<Book>getListData(){
        Book book = null;
        ArrayList<Book>list = new ArrayList<>();
        for (String[] aData : data){
            book = new Book();
            book.setNama(aData[0]);
            book.setPengarang(aData[1]);
            book.setPhoto(aData[2]);
            book.setDesc(aData[3]);

            list.add(book);
        }
        return list;

    }
}
