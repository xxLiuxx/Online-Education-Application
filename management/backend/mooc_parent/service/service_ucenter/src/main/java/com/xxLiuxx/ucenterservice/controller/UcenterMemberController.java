package com.xxLiuxx.ucenterservice.controller;


import com.xxLiuxx.commonutils.entity.CommonResult;
import com.xxLiuxx.commonutils.orderVo.UcenterMemberOrder;
import com.xxLiuxx.commonutils.utils.JwtUtils;
import com.xxLiuxx.ucenterservice.entity.UcenterMember;
import com.xxLiuxx.ucenterservice.entity.vo.RegisterVo;
import com.xxLiuxx.ucenterservice.service.UcenterMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * member controller
 * </p>
 *
 * @author Yuchen Liu
 * @since 2021-03-09
 */
@RestController
@RequestMapping("/ucenterservice/ucenter-member")
@CrossOrigin
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;

    @PostMapping("login")
    public CommonResult login(@RequestBody UcenterMember member) {
        String token = this.memberService.login(member);
        return CommonResult.success().data("token", token);
    }

    @PostMapping("register")
    public CommonResult register(@RequestBody RegisterVo registerVo) {
        this.memberService.register(registerVo);
        return CommonResult.success();
    }

    @GetMapping("auth")
    public CommonResult authUser(HttpServletRequest request) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        UcenterMember member = this.memberService.getById(memberId);
        return CommonResult.success().data("member", member);
    }

    @GetMapping("getUserInfo")
    public CommonResult getUserInfo(HttpServletRequest request) {
        Map<String, Object> userInfo = this.memberService.getUserInfo(request);
        return CommonResult.success().data("userInfo", userInfo);
    }

    @GetMapping("{memberId}")
    public UcenterMemberOrder getUserInfoById(@PathVariable String memberId) {
        UcenterMember member = this.memberService.getById(memberId);
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(member, ucenterMemberOrder);
        return ucenterMemberOrder;
    }

    @GetMapping("countRegister/{date}")
    public CommonResult countDailyRegister(@PathVariable String date) {
        Integer dailyRegister = this.memberService.countDailyRegister(date);

        return CommonResult.success().data("dailyRegister", dailyRegister);
    }
}

