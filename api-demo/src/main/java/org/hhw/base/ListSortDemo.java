package org.hhw.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListSortDemo {
    public static void main(String[] args) throws Exception {

        ListSortDemo testObj = new ListSortDemo();

        List<UserInfo> list = new ArrayList<UserInfo>();
        // public UserInfo(Integer userId, String username, Date birthDate,Integer age, float fRate, char ch)
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//        UserInfo user1 = new UserInfo(3, "bbb", formater.parse("1980-12-01"), 1, 1.2f, 'a');
//        UserInfo user2 = new UserInfo(0, "126", formater.parse("1900-10-11"), 3, -3.6f, 'c');
//        UserInfo user3 = new UserInfo(12, "5", formater.parse("1973-08-21"), 15, 9.32f, 'f');
//        UserInfo user4 = new UserInfo(465, "1567", formater.parse("2012-01-26"), 20, 12.56f, '0');
        UserInfo user5 = new UserInfo(5487, "&4m", formater.parse("2010-05-08"), 100, 165.32f, '5');
        UserInfo user6 = new UserInfo(5487, null, formater.parse("2016-12-30"), 103, 57.32f, 'm');
        UserInfo user7 = new UserInfo(5487, "jigg", formater.parse("2000-10-16"), 102, 53.32f, 'm');
        UserInfo user8 = new UserInfo(5487, null, formater.parse("2987-07-25"), 103, 56.32f, 'm');

//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.add(user4);
        list.add(user5);
        list.add(user6);
        list.add(user7);
        list.add(user8);

        System.out.println("\n-------原来序列-------------------");
        testObj.printfUserInfoList(list);

        // 按userId升序、username降序、birthDate升序排序
        String[] sortNameArr = {"userId", "username", "birthDate", "age"};
        boolean[] isAscArr = {true, true, true, false};
        ListUtils.sort(list, sortNameArr, isAscArr);
        System.out.println("\n--------按按userId升序、username降序、birthDate升序、age降序排序（如果userId相同，则按照username降序,如果username相同，则按照birthDate升序）------------------");
        testObj.printfUserInfoList(list);

    }

    private void printfUserInfoList(List<UserInfo> list) {
        for (UserInfo user : list) {
            System.out.println(user.toString());
        }
    }
}

class UserInfo {
    private Integer userId;
    private String username;
    private Date birthDate;
    private Integer age;
    private float fRate;
    private char ch;

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDatestr() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(getBirthDate());
    }

    public UserInfo(Integer userId, String username, Date birthDate, Integer age, float fRate, char ch) {
        super();
        this.userId = userId;
        this.username = username;
        this.birthDate = birthDate;
        this.age = age;
        this.fRate = fRate;
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "UserInfo [userId=" + userId + ", \tusername=" + username + ", \tbirthDate=" + getBirthDatestr()
                + ", \tage=" + age + ", fRate=" + fRate + ", ch=" + ch + "]";
    }

}
