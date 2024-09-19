package com.example.unicode.service.admin;

import com.example.unicode.entity.admin.Lab;
import com.example.unicode.repository.admin.LabNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabNumberService {

    @Autowired
    private LabNumberRepository labNumberRepository;

    public void saveLabNumbers(List <String> labNumbers) {
        List<Lab> labs = new ArrayList<>();
        for (String labNumber : labNumbers) {
            Lab lab = new Lab();
            lab.setLabNumber(labNumber);
            labs.add(lab);
        }
        labNumberRepository.saveAll(labs);  // Save all lab numbers to the database
    }


    public List<String> getAllLabNumbers() {
        List<Lab> labs = labNumberRepository.findAll();
        return labs.stream()
                .map(Lab::getLabNumber)
                .collect(Collectors.toList());
    }
}
