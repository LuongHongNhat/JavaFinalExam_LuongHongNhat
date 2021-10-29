package onemount.com;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static String readFileAsString(String fileName)throws Exception

    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    public static void main(String[] args) throws Exception

    {
        //Câu 1.1: Đọc danh sách sinh viên từ tập tin data.csv được cung cấp

        List<SinhVien> lstSinhVien = CSVRead.read("C:\\Users\\nhatlh2\\Desktop\\data.csv");

        for (int i = 0; i < lstSinhVien.size(); i++) {
            System.out.println("Thông tin SV thứ " + (i +1) +"\n "+ lstSinhVien.get(i).toString());
        }

        //Câu 1.2: Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất
        Collections.sort(lstSinhVien);
        Collections.reverse(lstSinhVien);
        for (int i = 0; i < 10; i++) {
            System.out.println("Thông tin SV thứ " + (i +1) +"\n "+ lstSinhVien.get(i).toString());
        }

        //Câu 1.3: Tính điểm tổng kết cho từng sinh viên
        ArrayList<Diem> lstDiem = new ArrayList<>();

        for (int i = 0; i < lstSinhVien.size(); i++) {
            double d = SinhVien.tongDiem(lstSinhVien.get(i));
//            System.out.println("Tổng điểm SV thứ " + (i +1) +"\n "+ d);

            Diem diem = new Diem();
            diem.tongDiem = d;
            diem.sv = lstSinhVien.get(i);
            lstDiem.add(diem);
        }

        //Câu 1.4: Liệt kê danh sách 10 sinh viên có tổng kết thấp nhất

        Collections.sort(lstDiem, new Comparator<Diem>() {
            @Override
            public int compare(Diem diem1, Diem diem2) {
                return Double.compare(diem1.tongDiem,diem2.tongDiem);

            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println("Thông tin SV thứ " + (i +1) +"\n "+ lstDiem.get(i).tongDiem);
        }
        //Câu 1.5: Xuat danh sach diem ra file csv
        CSVWrite.write(lstDiem);

        // Cau 2.1
        //^[\w-\._\+%]+@(outlook.com|gmail.com)\./
        String email = "^[\\w]+@gmail.com";
        String outlook = "^[\\w]+@outlook.com";

        //Cau 2.2
        ArrayList<SinhVien> lstSinhVienGmail = new ArrayList<>();
        ArrayList<SinhVien> lstSinhVienOutlook = new ArrayList<>();

        for (SinhVien sv: lstSinhVien) {
            if(sv.isGmailFormat()){
                lstSinhVienGmail.add(sv);
            }else if(sv.isOutlookFormat()){
                lstSinhVienOutlook.add(sv);
            }
        }

        for (SinhVien sv : lstSinhVienGmail) {
            System.out.println("Thông tin SV thứ " + sv.getEmail());
        }
        //Cau 2.3

        CSVWrite.WriteObjectToFile(lstSinhVienOutlook,"outlook.bin");

        List<SinhVien> sinhViens = CSVRead.readObjectToFile("outlook.bin");
        for (SinhVien sv : sinhViens) {
            System.out.println("Thông tin SV thứ " + sv.getEmail());
        }
    }
        //Cau3: Unit test: thu muc test

}
