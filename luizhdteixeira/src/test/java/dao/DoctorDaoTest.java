package dao;

import com.luizhdteixeira.dao.DoctorDao;
import com.luizhdteixeira.domain.Doctor;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class DoctorDaoTest {

    @Test
    public void save() {
        /*GIVEN*/
        Doctor doctor = new Doctor();

        /*WHEN*/
        doctor.setMedicalSpecialty("Clinico Geral");
        doctor.setRegionalCouncilOfMedicine("123456");

        /*THEN*/
        int i = 1;
        while (i >= 0) {
            new DoctorDao().save(doctor);
            i--;
        }
        System.out.println("Salvo com sucesso!");

    }

    @Test
    public void findAll() {
        /*WHEN*/
        List<Doctor> doctorList = new DoctorDao().findAll();

        /*THEN*/
        System.out.println("Total de registros: " + doctorList.size());
        for (Doctor doctor: doctorList) {
            System.out.println("Especialidade: " + doctor.getMedicalSpecialty());
            System.out.println("CRM: " + doctor.getRegionalCouncilOfMedicine());
        }
    }

    @Test
    public void findById() {
        /*GIVEN*/
        Long code = 1L;

        /*WHEN*/
        Doctor doctor = new DoctorDao().findByCode(code);

        /*THEN*/
        System.out.println("Especialidade: " + doctor.getMedicalSpecialty());
        System.out.println("CRM: " + doctor.getRegionalCouncilOfMedicine());

    }

    @Test
    public void update() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        Doctor doctor = new DoctorDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(doctor)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            doctor.setMedicalSpecialty("Pediatra");
            new DoctorDao().update(doctor);
            System.out.println("Registro editado");
        }
    }

    @Test
    public void delete() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        Doctor doctor = new DoctorDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(doctor)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            new DoctorDao().delete(doctor);
            System.out.println("Registro excluido");
        }

    }
}
