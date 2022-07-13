package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CrudProduct {
    public List<Product> products = new ArrayList<>();

    public CrudProduct(){
        products.add(new Product(1,"abc","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRW4SUQmhNBwIG3mcXzuXRmAV4tbPGLGsGA3TsnD5lYCs926KV_ouhfsBiP3ju1ubZzvAY&usqp=CAU",500));
        products.add(new Product(2,"xyz","https://angiangtourism.vn/chup-cuc-hoa-mi-o-dau/imager_19742.jpg",1500));
    }

}
