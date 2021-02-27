
import java.util.Arrays;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

import java.util.Arrays;
// import java.util.Scanner;

//  import jdk.dynalink.beans.StaticClass;

public class learnJava {
    public static void main(String[] args) {

        System.out.println("hello, world!"); // 语句w
        // Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        // System.out.print("Input your name: "); // 打印提示
        // String name = scanner.nextLine(); // 读取一行输入并获取字符串

        // System.out.print("Input your score: "); // 打印提示
        // int score1 = scanner.nextInt(); // 读取一行输入并获取整数
        // int score2 = scanner.nextInt(); // 读取一行输入并获取整数
        // double rate = (score2-score1)*100.0/score1;
        // System.out.printf("Hi, %s, you are %.2f%%\n", name, rate); // 格式化输出

        // 计算PI
        // double pi = 0;
        // for (int i = 1;i<10000;i+=2) {
        // pi=4.0/i-pi;
        // }
        // System.out.println(Math.abs(pi));

        // 数组操作

        int[] a = { 3,4,2,7,6,9,8,1,5 };
       

        BubbleSort mysort = new BubbleSort();
        mysort.sort(a);
        System.out.println(Arrays.toString(a));


        Person ming = new Person();
        ming.setName("XIAOMING");
        ming.setAge(20);
        System.out.println(ming.getName() + ", " + ming.getAge());

        Person Hong = new Student("XIAOHONG", 21, 90);//upcasting
        
        System.out.println(Hong.getName() + ", " + Hong.getAge());

        Student wang = new Student("WANG", 22, 87.5); 
        System.out.println(wang.getName() + ", " + wang.getAge() + ", " + wang.getScore());
        System.out.println(wang instanceof Person);
        System.out.println(Hong instanceof Student);



        //算个税 重写@Override 多态 Polymorphic
        Income[] incomes = new Income[] {
            new Salary(7500),
            new ManuscriptFee(5000)
        };
        System.out.printf("税收为%f",getTotal.totalTax(incomes));
        System.out.println();
    
        //枚举类
        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day.toString() + ". It's weekend!");
            
        } else {
            System.out.println("Today is " + day + ". It's workday!");
            
        }
        
        // 真随机数
        // SecureRandom sr = null;
        // try {
        //     sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        // } catch (NoSuchAlgorithmException e) {
        //     sr = new SecureRandom(); // 获取普通的安全随机数生成器
        // }
        // byte[] buffer = new byte[16];
        // sr.nextBytes(buffer); // 用安全随机数填充buffer
        // System.out.println(Arrays.toString(buffer));
    

    
    
    
    
    }



    

}


class getTotal {
    public static double totalTax(Income...incomes){
        double total = 0;
        for (Income income : incomes) {
            total += income.getTax();
        }
        return total;
    }
}

// 冒泡排序类
class BubbleSort {
    public void sort(int[] ns) {
        // 排序前:
        //System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = ns[j];
                    ns[j] = ns[j+1];
                    ns[j+1] = tmp;
                    flag = 1;
                }   
            }
            if (flag == 1) {
                //System.out.printf("第%d轮;\n",i+1); 
            }
            else{
                //System.out.println("done");
                break;
            }
        }
        // 排序后:
       // System.out.println(Arrays.toString(ns));
    }
}


class Person {
    // field,protected 可以被子类访问
    protected String name;
    protected int age;

    //不带参构造方法
    public Person() {
    }

    // 带参构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // method
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip(); // 去掉首尾空格
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

}


class Student extends Person {

    private double score;

    public Student(String name,int age,double score){
        super(name,age);
        this.score = score;

    }

    public double getScore(){
        return this.score;
    }
    public void setScore(double score){
        if (score < 0 || score > 150) {
            throw new IllegalArgumentException("invalid score value");

        }
        this.score = score;
    }





}

// 抽象类
// abstract class Income {
//     protected double income;

//     public Income(double income){
//          this.income = income;
//     }

//     public abstract double getTax();
    
// }


// 接口
interface Income{
    double getTax();
}

class Salary implements Income {
    private double income;

    // public Salary(double income) {
    //     super(income);
    //     // TODO Auto-generated constructor stub
    // }
    public Salary(double income){
                  this.income = income;
    }
    
    

    public double getTax(){
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}


class ManuscriptFee implements Income {
    private double income;

    // public ManuscriptFee(double income) {
    //     super(income);
    //     // TODO Auto-generated constructor stub
    // }
    public ManuscriptFee(double income){
        this.income = income;
}

    public double getTax(){
        
        // 稿费税太难算。。。
        return 8.88;
    }

}


// 枚举类

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}
















// 抽象 封装 继承 多态


