package com.xxLiuxx.ucenterservice.service;

import com.xxLiuxx.ucenterservice.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxLiuxx.ucenterservice.entity.vo.RegisterVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * member service
 * </p>
 *
 * @author Yuchen Liu
 * @since 2021-03-09
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    /**
     * login
     * @param member
     * @return token
     */
    String login(UcenterMember member);

    /**
     * register
     * @param registerVo
     */
    void register(RegisterVo registerVo);

    /**
     * get user by wechat openid
     * @param openid
     * @return
     */
    UcenterMember getByOpenId(String openid);

    /**
     * get user info from token
     * @param request
     * @return
     */
    Map<String, Object> getUserInfo(HttpServletRequest request);

  /**
   * Count daily register number
   * @param date date
   * @return
   */
    Integer countDailyRegister(String date);
}
