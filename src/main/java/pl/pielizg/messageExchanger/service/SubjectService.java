package pl.pielizg.messageExchanger.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.pielizg.messageExchanger.model.dto.SubjectDTO;

/**
 * Created by Pielizg on 2017-08-21.
 */
public interface SubjectService {

    Page<SubjectDTO> printSubjects(Pageable pageable);

    SubjectDTO findSubjectById(int id);

    SubjectDTO insertSubject(SubjectDTO subjectDTO);

}
