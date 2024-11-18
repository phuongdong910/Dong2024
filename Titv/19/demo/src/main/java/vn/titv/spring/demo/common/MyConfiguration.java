package vn.titv.spring.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.titv.spring.demo.dao.SinhVienDAOImpl;
import vn.titv.spring.demo.entity.SinhVien;

import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    @Autowired
    public CommandLineRunner getRunner(SinhVienDAOImpl sinhVienDAOImpl){
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            while(true){
                inMenu();
                int luaChon = scanner.nextInt();
                scanner.nextLine();
                if(luaChon==1){
                    // Gọi phương thức thêm sinh viên
                    themSinhVien(sinhVienDAOImpl);
                } else if (luaChon==2) {
                    // Goi ham tim sinh vien
                    timSinhVien(sinhVienDAOImpl);
                }
            }
        };
    }

    private void timSinhVien(SinhVienDAOImpl sinhVienDAOImpl) {
        Scanner scanner = new Scanner(System.in);
        // Lấy thông tin sinh viên
        System.out.println("Nhập mã sinh viên: ");
        int id = scanner.nextInt();
        SinhVien sinhVien = sinhVienDAOImpl.getById(id);
        if(sinhVien==null){
            System.out.println("Không tìm thấy!");
        }else{
            System.out.println(sinhVien);
        }
    }


    public void themSinhVien(SinhVienDAOImpl sinhVienDAOImpl){
        Scanner scanner = new Scanner(System.in);
        // Lấy thông tin sinh viên
        System.out.println("Nhập họ đệm: ");
        String ho_dem = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        SinhVien sinhVien = new SinhVien(ho_dem, ten, email);
        // Luu xuong CSDL
        sinhVienDAOImpl.save(sinhVien);
    }
    public void inMenu(){
        System.out.println("============================================\n");
        System.out.println("MENU:\n"+
                "1. Thêm sinh viên\n"+
                "2. Tìm sinh viên\n"+
                "3. Xóa sinh viên\n"+
                "Lựa chọn: \n"
        );
    }
}
