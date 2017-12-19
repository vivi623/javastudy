import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Per> list = new ArrayList<Per>();
        list.add(new Per("a"));
        list.add(new Per("b"));
        dosometing(list);

        for (Per str : list){
            System.out.println(str.getName());
        }


    }

    public static void dosometing(List<Per> list) {
        List<Per> temp = new ArrayList<Per>();
        int index = 0;
        for (Per tmp : list){
            tmp.setName(String.valueOf(++index));
            temp.add(tmp);
        }

    }
}

class Per {
    public Per(String name) {
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}