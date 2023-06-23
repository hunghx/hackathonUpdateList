package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

import java.util.List;

public class SingerController {
    private SingerService singerService = new SingerService();
    public List<Singer> getAll(){
        return singerService.getAllSingers();
    }
    public int getSize(){
        return singerService.getSize();
    }
    public void save(Singer singer){
         singerService.save(singer); ;
    }
    public Singer findById(int id){
        return singerService.findById(id);
    }
    public void deleteSinger(int id){
        singerService.deleteSinger(id);
    }
    public int getNewId(){
        return singerService.getNewId();
    }
}
