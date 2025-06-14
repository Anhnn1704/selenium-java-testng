package javaSDET;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;


public class Topic_01_Data_Type {
    //2 nhóm kiểu dữ liệu trong java
    //Cách khai báo:
    //1 - Access Modifier: phạm vi truy cập (private/ public/ protected/ default)
    public char cName = 'b';
    //2.1 - Access Modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (Ngoài hàm/ Trong hàm)
    private char cAddress;
    //2.2 - Tên biến - Giá trị gán sau (Hàm)
    public void clickToElement(){
        cAddress = 'c';
    }

    //Nhóm 1 - Kiểu dữ liệu nguyên thủy
    //char: ký tự (character) -- Khi gán giá trị (khởi tạo) nằm trong dấu (')
    char cZip = 'b';
    //byte/ short/ int/ long: số nguyên -- Khi gán giá trị (khởi tạo) không nằm trong dấu gì
    byte bNumber = -120;
    short sNumber = 1200;
    int iNumber = 350000;
    long lNumber = 234240234;
    //float/ double: số thực -- Khi gán giá trị (khởi tạo) không nằm trong dấu gì
    float fNumber = 15.7f;
    double dNumber = 15.925d;
    //boolean: logic
    boolean gender = false;

    //Nhóm 2 - Kiểu dữ liệu tham chiếu (reference type/ non-primtive)
    //string: chuỗi -- Khi gán giá trị (khởi tạo) nằm trong dấu (")
    String fullName = "Automation FC";

    //Class
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions actions = new Actions(fDriver);
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();
    //Interface
    WebDriver driver;
    JavascriptException jsExcutor;
    //Array
    String[] studentName ={"Hiền", "Nam", "Ánh"};
    int[] studentPhone = {372371927, 98764987,983456265};

    //List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();
    //Map
    Map<String, Integer> zip = new HashMap();
    //Object
    Object name ="";
    Object phone= 1578;
    Object isDispkayed = true;

    //Convention: Quy ước khi lập trình
    //Tên biến/ tên hàm: viết dưới dạng cancel case
    //Chữ cái đầu tiên luôn viết thường
    //name/ address/ city/ phone/ zipCode
    //clickToElement/ getUserName/ getPhoneNumber/ selectItemInDropdown
}
