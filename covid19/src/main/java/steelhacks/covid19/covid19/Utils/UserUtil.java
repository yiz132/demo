package steelhacks.covid19.covid19.Utils;

import common.Constants;
import steelhacks.covid19.covid19.Entity.User;

import javax.servlet.http.HttpSession;


public class UserUtil {

    public static final String USER = Constants.LOGIN_USER;

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
       // AdminUtil.deleteAdminFromSession(session);
        session.setAttribute(USER, user);
        session.setAttribute("userType",user.getCkind());
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static User getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (User) attribute;
    }

    /**
     * 从Session中删除登陆用户的个人信息
     *
     * @param session
     */
    public static void deleteUserFromSession(HttpSession session) {
        session.removeAttribute(USER);
    }
}
