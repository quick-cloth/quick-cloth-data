package org.example.quickclothdata.service.intf;

import org.example.quickclothdata.model.City;
import org.example.quickclothdata.model.ClotheBank;
import org.example.quickclothdata.model.Department;

import java.util.List;
import java.util.UUID;

public interface IClotheBankService {
    ClotheBank saveClotheBank(ClotheBank clotheBank);
    ClotheBank findClotheBankByUuid(UUID uuid);
    List<ClotheBank> getAllClotheBanksByFoundation(UUID foundationUuid);
}
