package ra.run;

import ra.config.InputMethods;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.model.Singer;
import ra.model.Song;

public class MusicManagement {
    private final static SingerController singerController = new SingerController();
    private final static SongController songController = new SongController();

    public static void main(String[] args) {
//        Config.scanner().nextInt()
//        Singer[] sings = {new Singer(1,"Hùng",19,"VN",true,"Nhạc vàng"),
//                new Singer(2,"Nam",19,"VN",true,"Nhạc Xanh")};
//        Song[] songs = {new Song("S001","Đi học","sss",null,"HH",new Date(),true),};
//        Song newSong  = new Song();
//        newSong.inputData(songs,sings);

        // xay menu
        while (true) {
            System.out.println("******************MUSIC-MANAGEMENT******************\n" +
                    "1. Quản lý ca sĩ [20 điểm]\n" +
                    "2. Quản lý bài hát [20 điểm]\n" +
                    "3. Tìm kiếm bài hát [25 điểm]\n" +
                    "4. Thoát [5 điểm]");
            System.out.println("Nhập vào  lựa chọn của bạn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    //menu quản lí ca sĩ
                    menuSingerManager();
                    break;
                case 2:
                    //menu quản lí bài hát
                    menuSongManager();
                    break;
                case 3:
                    // menu tìm kiếm
                    menuSearchManager();
                    break;
                case 4:
                    // thoát
                    System.exit(0);
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 4");
            }
        }

    }

    // menu quản lí ca sĩ
    public static void menuSingerManager() {
        byte choice = 0;
        while (choice != 5) {
            System.out.println("**********************SINGER-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ [5 điểm]\n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id [10 điểm]\n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)[5 điểm]\n" +
                    "5.Thoát\n");
            System.out.println("Nhập vào  lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // thêm mới n ca sĩ
                    createNewSinger();
                    break;
                case 2:
                    // hiển thị
                    showListSinger();
                    break;
                case 3:
                    // thay đổi thông tin theo mã ca sĩ
                    editSingerInfo();
                    break;
                case 4:
                    // xóa
                   deleteSinger();
                    break;
                case 5:
                    // quay lại
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 4");
                    break;
            }
        }

    }

    // thêm mới ca sĩ
    public static void createNewSinger() {
        // nhập vào số lượng ca sĩ cần thêm mới
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho ca sĩ thứ " + (i + 1));
            Singer newSinger = new Singer();
            // id tự tăng
            int newId = singerController.getNewId();
            newSinger.setSingerId(newId);
            System.out.println("New ID : " + newId);
            // nhập nhưngx thông tin còn lại
            newSinger.inputData();
            // tiến hành them mới vào mảng
            singerController.save(newSinger);
        }
    }

    // hiển thị danh sách ca sĩ
    public static void showListSinger() {
        if (singerController.getSize() == 0) {
            System.err.println("Không có ca sĩ nào ");
            return;
        }

        for (Singer singer : singerController.getAll()
        ) {
                singer.displayData();
        }
    }

    // up date thông tin
    public static void editSingerInfo() {
        System.out.println("Nhập vào id cần sửa");
        int idEdit = InputMethods.getInteger();
        Singer editSinger = singerController.findById(idEdit);

        if(editSinger ==null){
            System.err.println("Không tìm thấy ca sĩ ");
            return;
        }
        System.out.println("Đối tượng cần sửa là :");
        editSinger.displayData();
        // cho phép sửa
//        Singer updateSinger = new Singer();
//        updateSinger.setSingerId(idEdit);
        editSinger.inputData();
        singerController.save(editSinger);
    }
    public static void deleteSinger(){
        System.out.println("nhập vào id cần xóa ");
        int idDel = InputMethods.getInteger();
        singerController.deleteSinger(idDel);
    }


    public static void menuSongManager() {
        byte choice = 0;
        while (choice != 5) {
            System.out.println("**********************SONG-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ [5 điểm]\n" +
                    "3.Thay đổi thông tin bài hát theo mã id [10 điểm]\n" +
                    "4.Xóa bài hát theo mã id [5 điểm]\n" +
                    "5.Thoát");
            System.out.println("Nhập vào  lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // thêm mới n ca sĩ
                    createNewSong();
                    break;
                case 2:
                    // hiển thị
                    showListSong();
                    break;
                case 3:
                    // thay đổi thông tin theo mã ca sĩ
                    editSongInfo();
                    break;
                case 4:
                    // xóa
                    deleteSong();
                    break;
                case 5:
                    // quay lại
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 4");
                    break;
            }
        }

    }

    // thêm mới bài hát
    public static void createNewSong() {
        // nhập vào số lượng cbài hát cần thêm mới
        // lưu ý , phải có ca sĩ rồi ms thêm được bài hát
        if (singerController.getSize() == 0) {
            System.err.println("Không có ca sĩ nào , vui lóng quay ại thêm ca sĩ trước");
            return;
        }
        System.out.println("Nhập vào số lượng cần thêm mới");
        int n = InputMethods.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho bai hat thứ " + (i + 1));
            Song newSong = new Song();
            // nhập tat thông tin còn lại
            newSong.inputData(songController.getAll(), singerController.getAll());
            // tiến hành them mới vào mảng
            songController.save(newSong);
        }
    }

    // hiển thị danh sách ca sĩ
    public static void showListSong() {
        if (songController.getSize() == 0) {
            System.err.println("Không có bai hat nào ");
            return;
        }
        for (Song song : songController.getAll()) {
                song.displayData();
        }
    }

    // up date thông tin
    public static void editSongInfo() {
        System.out.println("Nhập vào id cần sửa");
        String idEdit = InputMethods.getString();
        Song editSong = songController.findById(idEdit);
        if(editSong ==null){
            System.err.println("Không tìm thấy ca sĩ ");
            return;
        }
        // cho phép sửa
        editSong.inputDataNotId( singerController.getAll());
        songController.save(editSong);
    }
    public static void deleteSong(){
        System.out.println("nhập vào id cần xóa ");
        String idDel = InputMethods.getString();
        songController.deleteSong(idDel);
    }

    public static void menuSearchManager() {

    }

}
