package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Manager;

import java.util.List;
import java.util.UUID;

public interface ManagerService {

    Manager getManagerById(UUID id);

    List<Manager> getAllManagers();

}
