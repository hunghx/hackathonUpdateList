package ra.service;

import ra.model.Singer;

public class SingerService {
    private Singer[] sings = new Singer[100];
    private int size = 0;

    public Singer[] getAllSingers() {
        return sings;
    }

    public int getSize() {
        return size;
    }

     // sáu khi đã có dữ liệu của đối tượng singer
    public void save(Singer singer){
        if(findById(singer.getSingerId())==null){
            // chức năng thêm mới
            for (int i = 0; i < sings.length; i++) {
                if(sings[i]== null){
                    sings[i] = singer;
                    size++;
                    System.out.println("thêm mới thành công");
                    return;
                }
            }
        }else {
            // update
            for (int i = 0; i < sings.length; i++) {
                if(sings[i]!= null && sings[i].getSingerId()==singer.getSingerId()){
//                    đây là đối tượng cần update thông tin
                    sings[i] = singer;
                    System.out.println("cập nhật thành công");
                    return;
                }
            }
        }
    }
    public Singer findById(int id){
        for (Singer sing: sings
             ) {
            if(sing!=null && sing.getSingerId() == id){
                // tìm thấy
                return sing;
            }
        }
        // không tìm thấy
        return null;
    }
    public  void deleteSinger(int idDel){
        if(findById(idDel) == null){
            // không ttoonf tại
            System.err.println("ID không tồn tại");
            return;
        }
        // cho phép xóa
        for (int i = 0; i < sings.length; i++) {
           if(sings[i]!=null && sings[i].getSingerId() == idDel) {
               sings[i] = null;
               size--;
               System.out.println("Xóa thành công");
               break;
           }
        }

    }
    public int getNewId(){

        // id tự tăng
        int max=0;
        for (Singer sing : sings
             ) {
            if(sing!=null && sing.getSingerId()> max){
                max = sing.getSingerId();
            }
        }
        return max+1;
    }
}
