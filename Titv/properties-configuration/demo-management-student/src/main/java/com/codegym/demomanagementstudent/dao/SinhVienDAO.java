package com.codegym.demomanagementstudent.dao;

import com.codegym.demomanagementstudent.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {

    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAll();

    public List<SinhVien> getByName(String ten);

    public SinhVien update(SinhVien sinhVien);

    public int updateAllTen(String ten);

    public void delete (Long id );

    public void deleteByTen(String ten);


}