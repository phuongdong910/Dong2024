package com.codegym.demomanagementstudent.dao;

import com.codegym.demomanagementstudent.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO {
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) {
        this.entityManager.persist(sinhVien);
    }

    @Override
    public SinhVien getById(int id) {
        return this.entityManager.find(SinhVien.class, id);
    }

    public SinhVienDAOImpl() {
        super();
    }

    @Override
    public List<SinhVien> getByName(String ten) {
        String jpql = "SELECT s FROM SinhVien s WHERE s.ten=:t";
        TypedQuery<SinhVien> query = this.entityManager.createQuery(jpql, SinhVien.class);
        query.setParameter("t", ten);
        return query.getResultList();
    }


    @Override
    public List<SinhVien> getAll() {
        String jpql = "SELECT s FROM SinhVien s";
        return this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public SinhVien update(SinhVien sinhVien) {

        return this.entityManager.merge(sinhVien);
    }

    @Override
    public int updateAllTen(String ten) {
        String jpql = "UPDATE SinhVien s SET s.ten=:t";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("t", ten);
        return query.executeUpdate();
    }

    @Override
    public void delete(Long id) {
        SinhVien sinhVien = this.entityManager.find(SinhVien.class, id);
        this.entityManager.remove(sinhVien);
    }

    @Override
    public void deleteByTen(String ten) {
        String jpql = "DELETE FROM SinhVien s WHERE s.ten=:t";
        Query query = this.entityManager.createQuery(jpql);
        query.setParameter("t", ten);
        query.executeUpdate();

    }
}
