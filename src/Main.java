import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách sản phẩm.
        List<Product> productList = new LinkedList<>();
        productList.add(new Product("CD01", "A", "Pana", 20));
        productList.add(new Product("CD02", "B", "Sony", 21));
        productList.add(new Product("CD03", "C", "Misu", 25));
        productList.add(new Product("CD04", "D", "Sun", 30));
        // Gọi phương thức ghi file, truyền tham số.
        writeToFile("productList.anh", productList ); // sau khi chạy lệnh này sẽ tự động tạo ra 1 file .anh cùng cấp với src.
        List<Product> productDataFromFile = readDataFromFile("productList.anh");
        // for each in ra từng sản phẩm.
        for (Product p:productList
             ) {
            System.out.println(p);
        }

        System.out.println("\n");


        productList.remove(1);
        for (Product p:productList
        ) {
            System.out.println(p);
        }

    }
    // viết phương thức ghi file.
    public static void writeToFile(String path, List<Product> products){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // viết phương thức đọc file, dữ liệu đầu ra là file có kiểu dữ liệu Product
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

}
