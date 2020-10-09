package dao;

import com.luizhdteixeira.dao.PatientDao;
import com.luizhdteixeira.domain.Patient;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PatientDaoTest {

    @Test
    public void save() {
        /*GIVEN*/
        Patient patient = new Patient();

        /*WHEN*/
        patient.setName("Ronaldo");
        patient.setAddress("Rua dos Boleiros, 52");
        patient.setPhone("1833416464");
        patient.setDateBirth(new Date(1992, 03, 07));
        patient.setDocument("12345678900");

        /*THEN*/
        int i = 1;
        while (i >= 0) {
            new PatientDao().save(patient);
            i--;
        }
        System.out.println("Salvo com sucesso!");

    }

    @Test
    public void findAll() {
        /*WHEN*/
        List<Patient> patientList = new PatientDao().findAll();

        /*THEN*/
        System.out.println("Total de registros: " + patientList.size());
        for (Patient patient: patientList) {
            System.out.println("Nome: " + patient.getName());
        }
    }

    @Test
    public void findById() {
        /*GIVEN*/
        Long code = 1L;

        /*WHEN*/
        Patient patient = new PatientDao().findByCode(code);

        /*THEN*/
        System.out.println("Nome: " + patient.getName());

    }

    @Test
    public void update() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        Patient patient = new PatientDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(patient)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            patient.setName("Rolando");
            new PatientDao().update(patient);
            System.out.println("Registro editado");
        }
    }

    @Test
    public void delete() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        Patient patient = new PatientDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(patient)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            new PatientDao().delete(patient);
            System.out.println("Registro excluido");
        }

    }
}
