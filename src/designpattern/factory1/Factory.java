package designpattern.factory1;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 19:27
 */
public interface Factory {
    Connection createConnection();

    Statement createStatement();
}
