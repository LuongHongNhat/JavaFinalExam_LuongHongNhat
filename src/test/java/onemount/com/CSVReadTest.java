package onemount.com;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CSVReadTest {

    @Test
    public void readSuccessData() throws Exception {
        List<SinhVien> svReadData = CSVRead.read("C:\\Users\\nhatlh2\\Desktop\\data.csv");
        assertTrue(!svReadData.isEmpty());

    }
}