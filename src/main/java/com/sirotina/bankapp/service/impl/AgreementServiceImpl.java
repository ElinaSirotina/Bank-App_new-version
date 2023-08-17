package com.sirotina.bankapp.service.impl;

import com.sirotina.bankapp.entity.Agreement;
import com.sirotina.bankapp.entity.enums.AgreementStatus;
import com.sirotina.bankapp.mapper.AgreementMapper;
import com.sirotina.bankapp.repository.AgreementRepository;
import com.sirotina.bankapp.service.AgreementService;
import com.sirotina.bankapp.service.exception.AgreementNotFoundException;
import com.sirotina.bankapp.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    private final AgreementMapper agreementMapper;

    @Override
    public List<Agreement> getAll() {
        List<Agreement> agreements = agreementRepository.findAll();
        return agreements;
    }

    @Override
    public List<Agreement> getAgreementsByStatus(AgreementStatus status) {
        List<Agreement> agreements = agreementRepository.findByStatus(status);
        return agreements;
    }

    @Override
    public Agreement getAgreementById(UUID id) throws AgreementNotFoundException {
        Optional<Agreement> agreementOptional = agreementRepository.findById(id);
        if (agreementOptional.isPresent()) {
            Agreement agreement = agreementOptional.get();
            return agreement;
        } else {
            throw new AgreementNotFoundException(ErrorMessage.AGREEMENT_NOT_FOUND);
        }
    }

    @Override
    public Agreement create(Agreement agreement) {
        Agreement savedAgreement = agreementRepository.save(agreement);
        return savedAgreement;
    }

    @Override
    public Agreement updateAgreementById(UUID id, Agreement dto) throws AgreementNotFoundException {
        Optional<Agreement> agreementOptional = agreementRepository.findById(id);
        if (agreementOptional.isPresent()) {
            Agreement agreement = agreementOptional.get();
            agreement.setInterestRate(dto.getInterestRate());
            agreement.setStatus(dto.getStatus());
            agreement.setSum(dto.getSum());
            agreement.setUpdatedAt(new Timestamp(new Date().getTime()));
            Agreement updatedAgreement = agreementRepository.save(agreement);
            return updatedAgreement;
        } else {
            throw new AgreementNotFoundException(ErrorMessage.AGREEMENT_NOT_FOUND);
        }
    }

    @Override
    public void deleteAgreementById(UUID id) {
        agreementRepository.deleteById(id);
    }
}
