package onemount.com;


import java.io.*;
import java.util.List;

public class CSVWrite {
    public static void write(List<Diem> outputDiem) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID");
        sb.append(',');
        sb.append("Name");
        sb.append(',');
        sb.append("Email");
        sb.append(',');
        sb.append("Bonus");
        sb.append(',');
        sb.append("Report");
        sb.append(',');
        sb.append("App");
        sb.append(',');
        sb.append("LT");
        sb.append(',');
        sb.append("TD");
        sb.append('\n');

        for (Diem diem: outputDiem) {
           SinhVien sv =  diem.getSv();
            sb.append(sv.getId());
            sb.append(',');
            sb.append(sv.getName());
            sb.append(',');
            sb.append(sv.getEmail());
            sb.append(',');
            sb.append(sv.getBonus());
            sb.append(',');
            sb.append(sv.getReport());
            sb.append(',');
            sb.append(sv.getApp());
            sb.append(',');
            sb.append(sv.getLt());
            sb.append(',');
            sb.append(diem.getTongDiem());
            sb.append('\n');
        }

        try (PrintWriter writer = new PrintWriter("output.csv")) {

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void WriteObjectToFile(List<SinhVien> sv, String filepath) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(sv);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}