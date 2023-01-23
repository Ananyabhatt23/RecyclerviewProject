package com.example.recyclerviewp.data;

public class Contacts {
    public  String name = "";
    public String mobile_no;
    public int image;
    public Contacts(String name, String mobile_no, int image)
    {
        this.name=name;
        this.mobile_no=mobile_no;
        this.image=image;
    }
    public String getName()
    {
        return name;
    }
    public String getMobile_no()
    {
        return mobile_no;

    }
    public int getImage()
    {
        return image;
    }

}
