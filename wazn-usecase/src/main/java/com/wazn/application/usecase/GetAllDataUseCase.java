package com.wazn.application.usecase;

import com.wazn.application.response.GetAllDataResponse;

import java.util.List;

public interface GetAllDataUseCase {

    List<GetAllDataResponse> getAllData();

    GetAllDataResponse getAllData(String mobile);

}
