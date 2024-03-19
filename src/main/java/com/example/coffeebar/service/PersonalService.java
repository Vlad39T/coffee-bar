package com.example.coffeebar.service;

import com.example.coffeebar.entity.Graphik;
import com.example.coffeebar.entity.Personal;
import com.example.coffeebar.entity.Position;
import com.example.coffeebar.repository.GraphikRepository;
import com.example.coffeebar.repository.PersonalRepository;
import com.example.coffeebar.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    private PersonalRepository personalRepository;
    private PositionRepository positionRepository;

    private GraphikRepository graphikRepository;

    @Autowired
    public void setGraphikRepository(GraphikRepository graphikRepository) {
        this.graphikRepository = graphikRepository;
    }

    @Autowired
    public void setPersonalRepository(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position getPositionByID(Long idPosition) {
        return positionRepository.findById(idPosition).get();

    }

    public void save(Personal personal, Long idPosition) {
        personal.setPosition(getPositionByID(idPosition));
        personalRepository.save(personal);
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Personal getPersonalByPhone(String phone) {
        return personalRepository.getPersonalByPhone(phone);
    }

    public List<Graphik> getAllGraphic() {
       return graphikRepository.findAll();
    }


    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }
}
