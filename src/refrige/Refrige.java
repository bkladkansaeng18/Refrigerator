/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refrige;

import Models.BeerWineandSpirits;
import Models.Beverages;
import Models.FreshAndBekery;
import Models.Item;
import Models.MeatAndSeefood;
import Models.Others;
import Models.PantryAndIngredients;
import Models.Refrigerator;
import Models.SnackAndDesserts;
import Models.User;
import Models.Vegerables;
import Models.addItem;
import java.security.MessageDigest;
import javax.persistence.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Morrrr
 */
public class Refrige {
    
    static Scanner input = new Scanner(System.in);
    
    static String toHexadecimal(String source) {
        
        return toHexadecimal(source.getBytes());
    }
    
    static String toHexadecimal(byte[] source) {
        
        StringBuilder sb = new StringBuilder();
        
        for (byte b : source) {
            
            String toAppend = String.format("%2X", b).replace(" ", "0"); // %X Hexadecimal
            sb.append(toAppend);
        }
        
        return sb.toString();
    }
    
    static String toMD5Hash(String source) {
        
        String result = "";
        
        try {
            
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5HashBytes = md5.digest(source.getBytes());
            
            result = toHexadecimal(md5HashBytes);
        } catch (NoSuchAlgorithmException e) {
            
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * @param username
     * @param password
     * @param name
     * @param email
     * @param brithday
     * @return
     */
    public static boolean setRegister(String username, String password, String name, String email, Date brithday) { //func register ถ้าสมัครได้ return true ไม่ได้ return false
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        User user = new User();
        
        TypedQuery<User> query = em.createQuery("SELECT a from Account a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(username)) {
                return false;
            } else if (i.getEmail().equals(email)) {
                return false;
            }
        }
        em.getTransaction().begin();
        user.setImgAcc("/UI/Static/Profile/profile160.png");
        user.setUser_username(username);
        user.setUser_password(toMD5Hash(password));
        user.setName(name);
        user.setEmail(email);
        user.setBrithday(brithday);
        user.setStatus(0);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return true;
    }

    public static boolean addItemRefrig(User user, Refrigerator refrig, Item item, int amou, Date date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        addItem aItem = new addItem(item, amou, date);
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                for (Refrigerator j : i.getRefrigerator()) {
                    if (j.getRefrig_id().equals(refrig.getRefrig_id())) {
                        em.getTransaction().begin();
                        j.addItem(aItem);
                        em.persist(j);
                        em.persist(aItem);
                        em.getTransaction().commit();
                        em.close();
                        emf.close();
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }    

    public static boolean removeItemRefrig(User user, Refrigerator refrig, Item item) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();        
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                for (Refrigerator j : i.getRefrigerator()) {
                    if (j.getRefrig_id().equals(refrig.getRefrig_id())) {
                        for (addItem k : j.getItem()) {
                            if (k.getItem().getBarcode().equals(item.getBarcode())) {
                                em.getTransaction().begin();
                                em.remove(k);
                                em.getTransaction().commit();
                                em.close();
                                emf.close();
                                return true;
                            }
                        }
                    }
                    
                }
            }
        }
        return false;
    }
    
    public static void setImage(User user, String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from Account a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                em.getTransaction().begin();
                i.setImgAcc("/UI/Static/Profile/" + name + ".png");
                em.persist(i);
                em.getTransaction().commit();
                em.close();
                emf.close();
            }
        }
    }

    public static Item checkItem(String barcode) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> query = em.createQuery("SELECT a from Item a", Item.class);
        List<Item> result = query.getResultList();
        for (Item i : result) {
            if (i.getBarcode().equals(barcode)) {
                return i;                
            }
        }
        
        return null;
    }

    public static User isLogin(String username, String password) { // ใช้ login return obj ของ user ที่ login
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from Account a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_password().equals(toMD5Hash(password)) && i.getUser_username().equals(username)) {
                return i;
            }
        }
        return null;
    }
    
    public static User getUser(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from Account a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(username)) {
                return i;
            }
        }
        return null;
    }
    
    public static boolean setFrid(User user, String refrig_name, String refrig_band, String refrig_color, String refrig_size) { // เพิ่มตู้เย็นแล้วก็รีเทิร์นเมื่อเพิ่มได้
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        Refrigerator reftig = new Refrigerator(user, refrig_name, refrig_band, refrig_color, refrig_size);
        TypedQuery<User> query = em.createQuery("SELECT a from Account a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            
            if (i.getUser_username().equals(user.getUser_username())) {
                em.getTransaction().begin();
                i.addRefrig(reftig);
                em.persist(i);
                em.persist(reftig);
                em.getTransaction().commit();
                em.close();
                emf.close();
                return true;
            }
        }
        return false;
    }
    
    public static boolean removeFriges(User user, Refrigerator refrig) { // ลบตู้เย็นออก
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                for (Refrigerator j : i.getRefrigerator()) {
                    if (j.getRefrig_id().equals(refrig.getRefrig_id())) {
                        em.getTransaction().begin();
                        em.remove(j);
                        em.getTransaction().commit();
                        return true;
                    }
                    
                }
            }
        }
        return false;
        
    }
    
    public static Refrigerator gerFriges(User user, Refrigerator refrig) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                for (Refrigerator j : i.getRefrigerator()) {
                    if (j.getRefrig_id().equals(refrig.getRefrig_id())) {
                        return j;
                    }
                }
            }
        }
        return null;
    }
    
    public static boolean editFriges(User user, Refrigerator refrig, String refrig_name, String refrig_band, String refrig_color, String refrig_size) { //แก้ไขข้อมูลตู้เย็น
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> queryUser = em.createQuery("SELECT a from User a", User.class);
        List<User> resultUser = queryUser.getResultList();
        for (User j : resultUser) {
            if (j.getUser_username().equals(user.getUser_username())) {
                for (Refrigerator i : j.getRefrigerator()) {
                    if (i.getRefrig_id().equals(refrig.getRefrig_id())) {
                        em.getTransaction().begin();
                        i.setRefrig_name(refrig_name);
                        i.setRefrig_band(refrig_band);
                        i.setRefrig_color(refrig_color);
                        i.setRefrig_size(refrig_size);
                        em.persist(i);
                        em.getTransaction().commit();
                        em.close();
                        emf.close();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean editUser(User user, String password, String name, String email, Date brithday) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                if (i.getUser_password().equals(toMD5Hash(password))) {
                    em.getTransaction().begin();
                    i.setName(name);
                    i.setEmail(email);
                    i.setBrithday(brithday);
                    em.persist(i);
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    public static boolean changePassword(User user, String curpassword, String newpassword) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getUser_username().equals(user.getUser_username())) {
                if (i.getUser_password().equals(toMD5Hash(curpassword))) {
                    em.getTransaction().begin();
                    i.setUser_password(toMD5Hash(newpassword));
                    em.persist(i);
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    public static boolean forgetPass(String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT a from User a", User.class);
        List<User> result = query.getResultList();
        for (User i : result) {
            if (i.getEmail().equals(email)) {
                if (i.getEmail().equals(email)) {
                    final String auth_host = "smtp.gmail.com";
                    final String auth_port = "587";
                    final String auth_email = "Refrigerator.cekmitl@gmail.com";
                    final String auth_password = "Refrigerator2018";
                    
                    Properties props = new Properties();
                    props.put("mail.smtp.starttls.enable", true);
                    props.put("mail.smtp.host", auth_host);
                    props.put("mail.smtp.socketFactory.port", auth_port);
                    props.put("mail.smtp.socketFactory.class",
                            "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", auth_port);
                    
                    try {
                        
                        Session mailSession = Session.getInstance(props,
                                new javax.mail.Authenticator() {
                            protected PasswordAuthentication
                                    getPasswordAuthentication() {
                                return new PasswordAuthentication(auth_email, auth_password);
                            }
                        });
                        
                        Message message = new MimeMessage(mailSession);
                        
                        message.setFrom(new InternetAddress(auth_email)); // From

                        /**
                         * * Recipient **
                         */
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(email)); // To
                        message.setSubject("Forget Password Refrigerator System");
                        message.setText("Hello " + i.getName() + " You username is " + i.getUser_username() + " Your password is 'forgetpass' when you login success You shuold change password!!");
                        
                        Transport.send(message);
                        
                        System.out.println("Mail Send Successfully.");
                        
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
                    em.getTransaction().begin();
                    i.setUser_password(toMD5Hash("forgetpass"));
                    em.persist(i);
                    em.getTransaction().commit();
                    em.close();
                    emf.close();
                    return true;
                }
                return false;
            }
        }
        return false;
        
    }
    
    public static void addItem(String name, String barcode, String description, int type) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/AccountDB.odb");
        EntityManager em = emf.createEntityManager();
        Item objItem;
        if (type == 0) {
            objItem = new Vegerables(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
            
        } else if (type == 1) {
            objItem = new MeatAndSeefood(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 2) {
            objItem = new FreshAndBekery(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 3) {
            objItem = new PantryAndIngredients(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 4) {
            objItem = new SnackAndDesserts(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 5) {
            objItem = new Beverages(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 6) {
            objItem = new BeerWineandSpirits(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        } else if (type == 7) {
            objItem = new Others(name, barcode, description);
            em.getTransaction().begin();
            em.persist(objItem);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
        
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException {
    // TODO code application logic here
//        int menu = 0;
//        addItem("ImgItem", "name", "barcode", "description", "exd", "Vegetables");
//        User user = isLogin("settakarn", "forgetpass");
//        setFrid(user, "ueiei", "Honda", "Bule", "2Kg");
//           List<Refrigerator>  a = gerFriges(user);
//           for(Refrigerator i : a){
//         
//            System.out.println(i.getItem().size());
//           }
//        while(menu != 4){
//            System.out.println("1. Register \n2. Login \n3. Forget Password \n 4. Exit");
//            menu = input.nextInt();
//            if(menu == 1){ 
//                 input.nextLine();
//                String username,  password,  name,  email,  brithday;
//                System.out.println("Username : ");
//                username = input.nextLine();
//                System.out.println("Password : ");
//                password = input.nextLine();
//                System.out.println("name : ");
//                name = input.nextLine();
//                System.out.println("Email : ");
//                email = input.nextLine();
//                System.out.println("brithday : ");
//                brithday = input.nextLine();
//                if(setRegister(username,  password,  name,  email,  brithday)){
//                    System.out.println("Success");
//                }else{
//                    System.out.println("Username cant use.");
//                }
//            
//            }
//            else if(menu == 2 ){
//                    input.nextLine();
//                String username,  password;
//                System.out.println("Username : ");
//                username = input.nextLine();
//                System.out.println("Password : ");
//                 password = input.nextLine();
//                User user = isLogin(username,password);
//                 if(user != null){
//                     while(true){
//                         System.out.println("Wellcome" + user.getName());
//                         String m = input.nextLine();
//                         if(m.equals("Exit")){
//                             break;
//                         }
//                         else if(m.equals("setFrige")){
//                             
//                         }
//                     }
//                 }else{
//                     System.out.println("username or password wrong!!");
//                 }
//                       
//            
//            }
//            else if(menu == 3 ){
//             input.nextLine();
//                String email;
//                System.out.println("E-mail : ");
//                email = input.nextLine();
//                forgetPass(email);
//            }
//            
//    }
//    }
}
