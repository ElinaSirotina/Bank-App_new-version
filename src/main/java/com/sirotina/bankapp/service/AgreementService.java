package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Agreement;
import com.sirotina.bankapp.entity.enums.AgreementStatus;
import com.sirotina.bankapp.service.exception.AgreementNotFoundException;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    List<Agreement> getAll();

    Agreement getAgreementById(UUID id) throws AgreementNotFoundException;

    Agreement create(Agreement dto);

    Agreement updateAgreementById(UUID id, Agreement dto) throws AgreementNotFoundException;

    void deleteAgreementById(UUID id);

    List<Agreement> getAgreementsByStatus(AgreementStatus status);


}
