package com.how2java;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.mapper.CategoryMapper;
import com.how2java.mapper.OrderMapper;
import com.how2java.mapper.ProductMapper;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.how2java.pojo.Category;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
//      根据配置文件mybatis-config.xml得到sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//      然后再根据sqlSessionFactory 得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

//注解方式
        //    Category 注解方式 sqlSession getMapper 以及对应的一对多形式
//        CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
//        listAll(cm);

        //        Product 注解方式 多对一形式
/*        ProductMapper pm = sqlSession.getMapper(ProductMapper.class);
        List<Product> ps = pm.list();
        for (Product p : ps){
            System.out.println(p + "\t对应的分类是：\t" + p.getCategory().getName());
        }*/

//        Order 注解方式 多对多形式
//        (看起来像一对多，其实从Product中通过OrderItems也可以得到多个Order(Product里加 List<OderItem> orderItems)，
//          并且因为商品不会在一个订单里重复出现，所以订单也不会重复，这样多对多的关系就好理解了)
/*        OrderMapper om = sqlSession.getMapper(OrderMapper.class);
        List<Order> os = om.list();
        for(Order o : os){
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            if(ois != null){
                for(OrderItem oi : ois){
//                    System.out.println(oi.getProduct().getName() + oi.getProduct().getPrice() + oi.getNumber());
                    System.out.format("\t%s\t%f\t%d%n",
                            oi.getProduct().getName(), oi.getProduct().getPrice(), oi.getNumber());
                }
            }
        }*/

//        注解动态SQL语句测试
/*        CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
        listAll(cm);*/

//相关概念
//        mybatis 的分页操作
//        清除原有数据
       /* List<Category> cs = sqlSession.selectList("listCategory");
        for(Category c : cs){
            sqlSession.delete("deleteCategory",c);
        }
        for(int i=0;i<100;i++){
            Category c = new Category();
            c.setName("category name" + i);
            sqlSession.insert("addCategory",c);
        }
//        XML方式
        Map<String,Integer> params = new HashMap<>();
        params.put("start",0);
        params.put("count",5);
        List<Category> cs2 = sqlSession.selectList("listCategory",params);
        for (Category c : cs2){
            System.out.println(c.getName());
        }
//        注解方式
        CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
        List<Category> cs2 = cm.listByPage(0,5);
        for (Category c : cs2){
            System.out.println(c.getName());
        }*/

//        PageHelper 实现强大分页
        /*CategoryMapper cm = sqlSession.getMapper(CategoryMapper.class);
        PageHelper.offsetPage(0,5);
        List<Category> cs2 = cm.list();
        for (Category c : cs2){
            System.out.println(c.getName());
        }
        PageInfo pageInfo = new PageInfo<>(cs2);
        System.out.println("总数："+pageInfo.getTotal());
        System.out.println(pageInfo);*/

//      一级缓存
//      Mybatis的一级缓存在session上，只要通过session查过的数据，
//      都会放在session上，下一次再查询相同id的数据，（不同的session不同的缓存）
//      都直接冲缓存中取出来，而不用到数据库里去取了。

//        Mybatis二级缓存是SessionFactory，
//        如果两次查询基于同一个SessionFactory，（所有的session缓存都一样）
//        那么就从二级缓存中取数据，而不用到数据库里去取了。

//        Mybatis整合C3P0数据库连接池

//        逆向工程
//        用逆向工程的方式，首先保证数据库里有表，
//        然后通过Mybatis Generator生成pojo, mapper和xml。
//        可以节约大家的时间，提高开发效率，降低出错几率


        sqlSession.commit();
        sqlSession.close();


//XML方式
/*      最后通过session的selectList方法，调用sql语句listCategory。listCategory这个就是在配置文件Category.xml中那条sql语句设置的id。
        执行完毕之后，得到一个Category集合，遍历即可看到数据。*/
/*        List<Category> cs=sqlSession.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }*/

//        CRDU基本操作
/*        Category c = new Category();
        c.setName("新增加的Category");
        sqlSession.insert("addCategory",c);
        listAll(sqlSession);*/

/*
        Category c = new Category();
        c.setId(6);
        sqlSession.delete("deleteCategory",c);
        listAll(sqlSession);
*/

/*        Category c = sqlSession.selectOne("getCategory",3);
        System.out.println(c.getName());*/

/*
        Category c = sqlSession.selectOne("getCategory",3);
        c.setName("修改后的Category");
        sqlSession.update("updateCategory",c);
        listAll(sqlSession);
*/
//        模糊查询
/*        List<Category> cs = sqlSession.selectList("listCategoryByName","y1");
        for(Category c: cs){
            System.out.println(c.getName());
        }*/

//        多条件查询
/*        Map<String,Object> params = new HashMap<>();
        params.put("id",2);
        params.put("name","cat");
        List<Category> cs = sqlSession.selectList("listCategoryByIdAndName",params);
        for (Category c : cs){
            System.out.println(c.getName());
        }*/

//        一对多查询
/*        List<Category> cs = sqlSession.selectList("listCategoryByOne2N");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }*/

//        多对一查询
/*        List<Product> ps = sqlSession.selectList("listProduct");
        for(Product p : ps){
            System.out.println(p + "对应的分类是：\t" + p.getCategory());
        }*/

//        更新Product的类别 p5 从类2变为类1
    /*    Category c1 = sqlSession.selectOne("getCategory",1);
        System.out.println(c1);
        Product p5 = sqlSession.selectOne("getProduct",5);
        p5.setCategory(c1);
        sqlSession.update("updateProduct",p5);

        List<Category> cs = sqlSession.selectList("listCategoryByOne2N");
        for (Category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }*/

//        addOrderItem(sqlSession);
//        deleteOrderItem(sqlSession);
//        listAll(sqlSession);

//        deleteOrder(sqlSession);

  /*      System.out.println("查询所有");
        List<Product> ps = sqlSession.selectList("listProduct");
        for (Product p : ps){
            System.out.println(p);
        }

        System.out.println("模糊查询");
        Map<String, Object> params = new HashMap<>();
        params.put("name","a");
//        System.out.println(params.get("name"));
//        将#｛属性｝写在if语句中，mybatis会去对象中从它的get方法中取值
        ps = sqlSession.selectList("listProduct",params);
        for (Product p : ps){
            System.out.println(p);
        }*/

//        where语句 + choose when otherwise
//        有多个when标签 符合条件时 只会执行第一个符合条件的when标签里的语句
//        Map<String, Object> params = new HashMap<>();
//        params.put("name","a");
//        params.put("price",90);

//        foreach语句
/*        List<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(3);
        ids.add(5);*/

        //        System.out.println(params.get("name"));
//        将#｛属性｝写在if语句中，mybatis会去对象中从它的get方法中取值
        /*List<Product> ps = sqlSession.selectList("listProduct",params);
        for (Product p : ps) {
            System.out.println(p);
        }

        sqlSession.commit();
        sqlSession.close();

    }

    private static void deleteOrder(SqlSession sqlSession) {
        Order o1 = sqlSession.selectOne("getOrder",1);
        sqlSession.delete("deleteOrder",o1);
    }


    private static void deleteOrderItem(SqlSession sqlSession) {
        Order o1 = sqlSession.selectOne("getOrder",1);
        Product p6 = sqlSession.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setOrder(o1);
        oi.setProduct(p6);
        sqlSession.delete("deleteOrderItem", oi);
    }

    private static void addOrderItem(SqlSession sqlSession) {
        Order o1 = sqlSession.selectOne("getOrder",1);
        Product p6 = sqlSession.selectOne("getProduct",6);
        OrderItem oi = new OrderItem();
        oi.setOrder(o1);
        oi.setProduct(p6);
        oi.setNumber(200);
        sqlSession.insert("addOrderItem",oi);
    }*/

        /*    private static void listAll(SqlSession sqlSession) {
         *//*        List<Category> cs = sqlSession.selectList("listCategory");
        for(Category c : cs){
            System.out.println(c.getName());
        }*//*
        List<Order> os = sqlSession.selectList("listOrder");
        for (Order o : os) {
            System.out.println(o.getCode());
            List<OrderItem> ois = o.getOrderItems();
            for (OrderItem oi : ois) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(), oi.getProduct().getPrice(),
                        oi.getNumber());
            }
        }
    }*/

    }//main

//    注解方式测试
    private static void update(CategoryMapper mapper) {
        Category c= mapper.get(8);
        c.setName("修改了的Category名稱");
        mapper.update(c);
        listAll(mapper);
    }

    private static void get(CategoryMapper mapper) {
        Category c= mapper.get(8);
        System.out.println(c.getName());
    }

    private static void delete(CategoryMapper mapper) {
        mapper.delete(2);
        listAll(mapper);
    }

    private static void add(CategoryMapper mapper) {
        Category c = new Category();
        c.setName("新增加的Category");
        mapper.add(c);
        listAll(mapper);
    }

    private static void listAll(CategoryMapper mapper) {
//        注解测试
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
        }

//        一对多形式
/*        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p.getName());
            }
        }*/

    }
}
