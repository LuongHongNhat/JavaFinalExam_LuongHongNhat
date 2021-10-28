package onemount.com;

import org.junit.Test;

import static org.junit.Assert.*;

public class SinhVienTest {
    @Test
    public void shouldAnswerWithTrue()
    {

       SinhVien sv = new SinhVien();
       sv.setBonus(5);
       sv.setReport(2);
       sv.setApp(10);
       sv.setLt(5.6);
        assertEquals(3.5, SinhVien.tongDiem(sv), 0.0);
    }
    @Test
    public void shouldAnswerWithFail()
    {

        SinhVien sv = new SinhVien();
        sv.setBonus(5);
        sv.setReport(2);
        sv.setApp(10);
        sv.setLt(5.6);
        assertNotEquals(3.6, SinhVien.tongDiem(sv), 0.0);
    }

    @Test
    public void isGmailPatternTest()
    {
        SinhVien sv = new SinhVien();
        sv.setEmail("luonghong@gmail.com");
        assertTrue(sv.isGmailFormat());

        SinhVien sv2 = new SinhVien();
        sv2.setEmail("luonghong@outlook.com");
        assertFalse(sv2.isGmailFormat());
    }
}
