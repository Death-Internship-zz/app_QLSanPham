package dienloi.kiemtra.nguyenthanhtu.app_qlsanpham.Model;

import java.io.Serializable;

public class Proc implements Serializable {
    Integer Id;
    String Name, Price, Type, Img;

    public Proc() { }

    public Proc(Integer id) {
        Id = id;
    }

    public Proc(String name, String price, String type, String img) {
        Name = name;
        Price = price;
        Type = type;
        Img = img;
    }

    public Proc(Integer id, String name, String price, String type, String img) {
        Id = id;
        Name = name;
        Price = price;
        Type = type;
        Img = img;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
