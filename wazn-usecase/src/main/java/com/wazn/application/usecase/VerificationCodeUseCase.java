package com.wazn.application.usecase;

import com.wazn.application.response.VerificationCodeResponse;

public interface VerificationCodeUseCase {

    VerificationCodeResponse verifyCode(String mobile, String code);
}
