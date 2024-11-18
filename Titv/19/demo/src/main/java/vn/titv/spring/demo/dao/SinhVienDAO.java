package vn.titv.spring.demo.dao;

import vn.titv.spring.demo.entity.SinhVien;

public interface SinhVienDAO {
    public void save(SinhVien sinhVien);


    public SinhVien getById(int id);


}
