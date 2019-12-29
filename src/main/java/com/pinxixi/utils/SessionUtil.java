<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
package com.pinxixi.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description: session的增加，删除，获取 <br>
 * date: 2019/12/21 15:51 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@Component
public class SessionUtil {
    /**
     * description: 写入session  <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:01 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @param sessionValue
     * @return void
     */
    public void addSession(String sessionkey, Object sessionValue) throws HttpSessionRequiredException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        httpServletRequest.getSession().setAttribute(sessionkey, sessionValue);
    }

    /**
     * description: 删除session <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:31 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @return void
     */
    public void deleteSession(String sessionkey) throws HttpSessionRequiredException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        httpServletRequest.getSession().removeAttribute(sessionkey);
    }

    /**
     * description: 获取Session <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:58 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @return java.lang.Object
     */
    public Object getSession(String sessionkey) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return httpServletRequest.getSession().getAttribute(sessionkey);
    }
}
<<<<<<< HEAD
=======
package com.pinxixi.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description: session的增加，删除，获取 <br>
 * date: 2019/12/21 15:51 <br>
 * author: laizhiwei <br>
 * version: 1.0 <br>
 */
@Component
public class SessionUtil {
    /**
     * description: 写入session  <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:01 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @param sessionValue
     * @return void
     */
    public void addSession(String sessionkey, Object sessionValue) throws HttpSessionRequiredException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        httpServletRequest.getSession().setAttribute(sessionkey, sessionValue);
    }

    /**
     * description: 删除session <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:31 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @return void
     */
    public void deleteSession(String sessionkey) throws HttpSessionRequiredException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        httpServletRequest.getSession().removeAttribute(sessionkey);
    }

    /**
     * description: 获取Session <br>
     * version: 1.0 <br>
     * date: 2019/12/21 16:58 <br>
     * author: laizhiwei <br>
     *
     * @param sessionkey
     * @return java.lang.Object
     */
    public Object getSession(String sessionkey) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return httpServletRequest.getSession().getAttribute(sessionkey);
    }
}
>>>>>>> pinxixi
=======
>>>>>>> d57567eb7f790b3d83549bd0d34f30e23631d97d
