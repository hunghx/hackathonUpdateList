package ra.service;

import ra.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private List<Song> songs ;


    public SongService() {
        songs = new ArrayList<>();
    }

    public List<Song> getAllSongs() {
        return songs;
    }

    public int getSize() {
        return songs.size();
    }

    // sáu khi đã có dữ liệu của đối tượng song
    public void save(Song song){
        if(findById(song.getSongId())==null){
            // chức năng thêm mới
            songs.add(song);

        }else {
            // update
            songs.set(songs.indexOf(song),song);
        }
    }
    public Song findById(String id){
        for (Song song: songs
        ) {
            if( song.getSongId().equals(id)){
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
        songs.remove(findById(idDel));
    }
}
