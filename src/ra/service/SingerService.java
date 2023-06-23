package ra.service;

import ra.model.Singer;

import java.util.ArrayList;
import java.util.List;

public class SingerService {
    private List<Singer> sings;

    public SingerService() {
        sings= new ArrayList<>();
    }

    public List<Singer> getAllSingers() {
        return sings;
    }

    public int getSize() {
        return sings.size();
    }

     // sáu khi đã có dữ liệu của đối tượng singer
    public void save(Singer singer){
        if(findById(singer.getSingerId())==null){
            // chức năng thêm mới
            sings.add(singer);
        }else {
            // update
            sings.set(sings.indexOf(findById(singer.getSingerId())),singer);
        }
    }
    public Singer findById(int id){
        for (Singer sing: sings) {
            if(sing.getSingerId() == id){
                // tìm thấy
                return sing;
            }
        }
        // không tìm thấy
        return null;
    }
    public  void deleteSinger(int idDel){
        if(findById(idDel) == null){
            // không ton tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        sings.remove(findById(idDel));

    }
    public int getNewId(){
        // id tự tăng
        int max=0;
        for (Singer sing : sings) {
            if(sing.getSingerId()> max){
                max = sing.getSingerId();
            }
        }
        return max+1;
    }
}
