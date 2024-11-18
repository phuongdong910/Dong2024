package com.codegym.demomanagementstudent.common;

import com.codegym.demomanagementstudent.dao.SinhVienDAOImpl;
import com.codegym.demomanagementstudent.entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                inMenu();
                int luaChon = scanner.nextInt();
                scanner.nextLine();
                if (luaChon == 1) {
                    // Gọi phương thức thêm sinh viên
                    themSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 2) {
                    // Goi ham tim sinh vien
                    timSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 3) {
                    // Goi ham tim sinh vien
                    timSinhVienBangTen(sinhVienDAOImpl);
                } else if (luaChon == 4) {
                    // Goi ham tim sinh vien
                    inTatCaSinhVien(sinhVienDAOImpl);
                } else if (luaChon == 5) {
                    // Goi ham tim sinh vien
                    capNhatSinhVienTheoId(sinhVienDAOImpl);
                } else if (luaChon == 6) {
                    // Goi ham tim sinh vien
                    capNhatTheoTen(sinhVienDAOImpl);
                } else if (luaChon == 7) {
                    // Goi ham tim sinh vien
                    xoaTheoId(sinhVienDAOImpl);
//                } else if (luaChon == 6) {
//                    // Goi ham tim sinh vien
//                    xoaTheoTen(sinhVienDAOImpl);
//                }
                }}
        };
    }

    private void xoaTheoId(SinhVienDAOImpl sinhVienDAOImpl) {
     Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        Long id = scanner.nextLong();
        sinhVienDAOImpl.delete(id);
    }

    private void capNhatTheoTen(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);
        // Lấy thông tin sinh viên
        System.out.println("Nhập tên");
        String ten = scanner.nextLine();
        int rows = sinhVienDAOImpl.updateAllTen(ten);
        System.out.println("Có " + rows + "dòng dữ liệu bị thay đổi!");

    }

    private void capNhatSinhVienTheoId(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mã sinh viên");
        int id = scanner.nextInt();
        scanner.nextLine();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Không tìm thấy!");
        } else {
            // Code lấy lại thông tin mới
            System.out.println("Nhập họ đệm: ");
            String ho_dem = scanner.nextLine();
            System.out.println("Nhập tên: ");
            String ten = scanner.nextLine();
            System.out.println("Nhập email");
            String email = scanner.nextLine();
            sinhVien.setHoDem(ho_dem);
            sinhVien.setTen(ten);
            sinhVien.setEmail(email);
            sinhVienDAOImpl.update(sinhVien);


        }
    }

    private void inTatCaSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        List<SinhVien> sinhViens = sinhVienDAOImpl.getAll();

        sinhViens.forEach(
                sinhVien -> {
                    System.out.println(sinhVien);
                }
        );
    }

    public void inMenu() {
        System.out.println("============================================");
        System.out.println("MENU:\n" +
                "1. Thêm sinh viên\n" +
                "2. Tìm sinh viên\n" +
                "3. Tìm kiếm sinh viên bằng tên\n" +
                "4. Hiển thị tất cả sinh viên\n" +
                "5. Cập nhật sinh viên dựa trên id\n" +
                "6. Cập nhật toàn bộ tên của sinh viên\n" +
                "7. Xóa sinh viên theo id\n" +
                "6. Xóa sinh viên theo tên\n" +
                "Lựa chọn: \n"
        );
    }

//    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
//        Scanner scanner = new Scanner(System.in);
//        // Lấy thông tin sinh viên
//        System.out.println("Nhập mã sinh viên: ");
//        int id = scanner.nextInt();
//        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
//        if(sinhVien==null){
//            System.out.println("Không tìm thấy!");
//        }else{
//            System.out.println(sinhVien);
//        }
//    }

    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên: ");
        int id = scanner.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if (sinhVien == null) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println(sinhVien);
        }
    }

    private void timSinhVienBangTen(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập  sinh viên: ");
        String ten = scanner.nextLine();
        List<SinhVien> sinhViens = sinhVienDAOImpl.getByName(ten);
        if (sinhViens.size() == 0) {
            System.out.println("Không tìm thấy sinh viên có tên trên");
        } else {
//            for (SinhVien s:sinhViens){
//                System.out.println(s);
//            }

            sinhViens.forEach(
                    sinhVien -> {
                        System.out.println(sinhVien);
                    }
            );
        }
    }


    //        public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl){
//            Scanner scanner = new Scanner(System.in);
//            // Lấy thông tin sinh viên
//            System.out.println("Nhập họ đệm: ");
//            String ho_dem = scanner.nextLine();
//            System.out.println("Nhập tên: ");
//            String ten = scanner.nextLine();
//            System.out.println("Nhập email: ");
//            String email = scanner.nextLine();
//            SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
//            // Luu xuong CSDL
//            sinhVienDAOImpl.save(sinhVien);
//        }
    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ đệm: ");
        String ho_dem = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        // lưu xuống DB
        sinhVienDAOImpl.save(sinhVien);
    }


}
