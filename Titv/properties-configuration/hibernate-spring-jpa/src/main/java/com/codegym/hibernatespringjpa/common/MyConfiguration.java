package com.codegym.hibernatespringjpa.common;

import com.codegym.hibernatespringjpa.dao.SinhVienDAOImpl;
import com.codegym.hibernatespringjpa.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);

                inMenu();
                int choose = scanner.nextInt();
                scanner.nextLine();
                if (choose == 1) {
                    themSinhVien(sinhVienDAOImpl);
                }

            }
        };
    }

    public void inMenu() {
        System.out.println("==================================================\n");
        System.out.println("MENU:\n" +
                "1. Thêm sinh viên\n" +
                "2. Tìm sinh viên\n" +
                "3. Xóa sinh viên\n");
    }
@Autowired
    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
    Scanner scanner = new Scanner(System.in);

    // Lấy thông tin sinh viên
        System.out.println("Nhập họ đệm: ");
        String ho_dem = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        //Lưu xuống CSDL
        sinhVienDAOImpl.save(sinhVien);

    }

}
