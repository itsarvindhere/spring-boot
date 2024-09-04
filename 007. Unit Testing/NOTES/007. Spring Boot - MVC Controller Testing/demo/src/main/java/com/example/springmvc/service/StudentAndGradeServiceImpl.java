package com.example.springmvc.service;

import com.example.springmvc.models.*;
import com.example.springmvc.repository.HistoryGradeRepository;
import com.example.springmvc.repository.MathGradeRepository;
import com.example.springmvc.repository.ScienceGradeRepository;
import com.example.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentAndGradeServiceImpl implements StudentAndGradeService{

    private final StudentRepository studentRepository;
    private final MathGradeRepository mathGradeRepository;
    private final ScienceGradeRepository scienceGradeRepository;
    private final HistoryGradeRepository historyGradeRepository;

    @Autowired
    public StudentAndGradeServiceImpl(
            StudentRepository studentRepository,
            MathGradeRepository mathGradeRepository,
            ScienceGradeRepository scienceGradeRepository,
            HistoryGradeRepository historyGradeRepository
    ) {
        this.studentRepository = studentRepository;
        this.mathGradeRepository = mathGradeRepository;
        this.scienceGradeRepository = scienceGradeRepository;
        this.historyGradeRepository = historyGradeRepository;
    }

    @Override
    public void createStudent(String firstName, String lastName, String email) {

        CollegeStudent student = new CollegeStudent(firstName, lastName, email);

        studentRepository.save(student);
    }

    @Override
    public boolean checkIfStudentExists(int id) {
        Optional<CollegeStudent> student = studentRepository.findById(id);
        return student.isPresent();
    }

    @Override
    public void deleteStudent(int id) {
        if (checkIfStudentExists(id)) {
            this.studentRepository.deleteById(id);
        }
    }

    @Override
    public Iterable<CollegeStudent> getGradebook() {
        return studentRepository.findAll();
    }

    @Override
    public boolean createGrade(double grade, int id, String gradeType) {
        if (checkIfStudentExists(id) && grade >= 0 && grade <= 100) {
            switch (gradeType) {
                case "math" -> {
                    MathGrade mathGrade = new MathGrade();
                    mathGrade.setGrade(grade);
                    mathGrade.setStudentId(id);
                    mathGradeRepository.save(mathGrade);
                    return true;
                }
                case "science" -> {
                    ScienceGrade scienceGrade = new ScienceGrade();
                    scienceGrade.setGrade(grade);
                    scienceGrade.setStudentId(id);
                    scienceGradeRepository.save(scienceGrade);
                    return true;
                }
                case "history" -> {
                    HistoryGrade historyGrade = new HistoryGrade();
                    historyGrade.setGrade(grade);
                    historyGrade.setStudentId(id);
                    historyGradeRepository.save(historyGrade);
                    return true;
                }
            }
        }
        return false;
    }
}
