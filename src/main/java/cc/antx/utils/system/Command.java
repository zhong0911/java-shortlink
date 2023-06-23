package cc.antx.utils.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * 执行系统终端命令类
 *
 * @author zhong
 * @date 2023-02-03 13:39
 */
public class Command {
    public static void main(String[] args) {
        simulateTerminal();
    }


    /**
     * 执行cmd命令并获取输出结果
     *
     * @return 执行命令的结果
     */
    public static String executeTerminalCommand(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = br.readLine()) != null) {
                str.append(line).append("\n");
            }
            return str.toString().trim();
        } catch (Exception e) {
            return "'" + cmd + "'" + " is not recognized as an internal or external command, operable program or batch file.";
        }
    }


    public static void simulateTerminal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String dir = System.getProperty("user.dir");
            System.out.print(dir + ">");
            String cmd = scanner.nextLine();
            if (cmd.trim().equals("")) continue;
            System.out.println(executeTerminalCommand(cmd));
        }
    }
}