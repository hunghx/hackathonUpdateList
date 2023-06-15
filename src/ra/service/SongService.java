package ra.service;

import ra.model.Song;

public class SongService {
    private Song[] songs = new Song[100];
    private int size = 0;

    public Song[] getAllSongs() {
        return songs;
    }

    public int getSize() {
        return size;
    }

    // sáu khi đã có dữ liệu của đối tượng song
    public void save(Song song){
        if(findById(song.getSongId())==null){
            // chức năng thêm mới
            for (int i = 0; i < songs.length; i++) {
                if(songs[i]== null){
                    songs[i] = song;
                    size++;
                    System.out.println("thêm mới thành công");
                    return;
                }
            }
        }else {
            // update
            for (int i = 0; i < songs.length; i++) {
                if(songs[i]!= null && songs[i].getSongId().equals(song.getSongId())){
//                    đây là đối tượng cần update thông tin
                    songs[i] = song;
                    System.out.println("cập nhật thành công");
                    return;
                }
            }
        }
    }
    public Song findById(String id){
        for (Song song: songs
        ) {
            if(song!=null && song.getSongId().equals(id)){
                // tìm thấy
                return song;
            }
        }
        // không tìm thấy
        return null;
    }
    public  void deleteSong(String idDel){
        if(findById(idDel) == null){
            // không ton tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        for (int i = 0; i < songs.length; i++) {
            if(songs[i]!=null && songs[i].getSongId().equals(idDel)) {
                songs[i] = null;
                size--;
                System.out.println("Xóa thành công");
                break;
            }
        }
    }
}
