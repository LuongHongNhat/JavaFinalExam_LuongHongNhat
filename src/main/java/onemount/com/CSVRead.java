package onemount.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVRead {
    public static List<SinhVien> read(String fileName)throws Exception

    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));

        //Câu 1.1: Đọc danh sách sinh viên từ tập tin data.csv được cung cấp
        String[] array = data.split("\r\n");

        ArrayList<SinhVien> lstSinhVien = new ArrayList<>();


        for (int i = 1; i < array.length; i++) {
            String[] splidedData = array[i].split(",");
            SinhVien new_SinhVien = new SinhVien();
            new_SinhVien.addDataToArrayList(splidedData);
            lstSinhVien.add(new_SinhVien);
        }

        return lstSinhVien;
    }

    public static List<SinhVien> readObjectToFile(String filepath) {

        try {

            FileInputStream fileOut = new FileInputStream(filepath);
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
            List<SinhVien> lstSV = (List<SinhVien>) objectOut.readObject();
            objectOut.close();
            return lstSV;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
