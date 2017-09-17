package pl.pielizg.messageExchanger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.pielizg.messageExchanger.Repository.SubjectRepository;
import pl.pielizg.messageExchanger.map.Mapper;
import pl.pielizg.messageExchanger.model.dao.Subject;
import pl.pielizg.messageExchanger.model.dto.SubjectDTO;

/**
 * Created by Pielizg on 2017-08-21.
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private Mapper mapper;

    @Override
    public Page<SubjectDTO> printSubjects(Pageable pageable) {

        Page<Subject> page = repository.findAll(pageable);

        return mapper.mapSubjectPage(page);
    }

    @Override
    public SubjectDTO findSubjectById(int id) {

        Subject subject = repository.findOne(id);

        return mapper.map(subject);
    }

    @Override
    public SubjectDTO insertSubject(SubjectDTO subjectDTO) {
        Subject subject = mapper.map(subjectDTO);

        int id = repository.save(subject).getId();

        return findSubjectById(id);
    }
}
