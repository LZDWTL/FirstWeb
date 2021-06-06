package cn.edu;

/**
 * @author LZDWTL
 * @date 2021-06-06 20:54
 */
public class test {
    public static void main(String[] args) {
        Jdbc jdbc=new Jdbc();
        String username="张三";
        String password="123";
        System.out.println(jdbc.selectUser(username, password));
    }
}
