package ra.controller;

import ra.model.Song;
import ra.service.SongService;

import java.util.List;

public class SongController {
    private SongService songService = new SongService();
    public List<Song> getAll(){
        return songService.getAllSongs();
    }
    public int getSize(){
        return songService.getSize();
    }
    public void save(Song song){
        songService.save(song); ;
    }
    public Song findById(String id){
        return songService.findById(id);
    }
    public void deleteSong(String id){
        songService.deleteSong(id);
    }
}
