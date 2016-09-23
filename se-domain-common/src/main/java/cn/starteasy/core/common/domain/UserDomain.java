package cn.starteasy.core.common.domain;

/**
 * 用户基类  包括用户名、密码
 * <p/>
 * 创建时间: 14-10-4 下午10:18<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
public class UserDomain<T> extends CreateBaseDomain<T> {
    //用户名
    private String name;
    //密码
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
