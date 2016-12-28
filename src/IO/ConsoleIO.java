package IO;

import core.IOInterface;

import java.util.Scanner;

/**
 * Created by TangJiong on 2016/1/4.
 * 输入输出接口的System.in System.out实现
 */
public class ConsoleIO implements IOInterface {
    @Override
    public String input() {
        System.out.print("input here > ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            return scanner.nextLine();
        }
        return null;
    }

    @Override
    public void output(Object obj) {

        System.out.println(obj);

    }
}
