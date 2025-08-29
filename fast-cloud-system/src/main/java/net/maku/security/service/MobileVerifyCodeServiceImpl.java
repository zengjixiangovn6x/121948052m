package net.maku.security.service;

import lombok.AllArgsConstructor;
import net.maku.api.module.message.SmsApi;
import net.maku.framework.common.utils.Result;
import net.maku.framework.security.mobile.MobileVerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * 短信验证码效验
 *
 * @author 阿沐 babamu@126.com
 */
@Service
@AllArgsConstructor
public class MobileVerifyCodeServiceImpl implements MobileVerifyCodeService {
    private final SmsApi smsApi;

    @Override
    public boolean verifyCode(String mobile, String code) {
        Result<Boolean> result = smsApi.verifyCode(mobile, code);

        return result.getData();
    }
}
