package dao;

import com.luizhdteixeira.dao.DoctorDao;
import com.luizhdteixeira.dao.MedicalAppointmentDao;
import com.luizhdteixeira.dao.PatientDao;
import com.luizhdteixeira.domain.Doctor;
import com.luizhdteixeira.domain.MedicalAppointment;
import com.luizhdteixeira.domain.Patient;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MedicalAppointmentDaoTest {

    @Test
    public void save() {
        /*GIVEN*/
        MedicalAppointment appointment = new MedicalAppointment();
        Patient patient = new PatientDao().findByCode(1L);
        Doctor doctor = new DoctorDao().findByCode(1L);

        /*WHEN*/
        appointment.setDateAppointment(new Date());
        appointment.setTimeAppointment(new Date());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        /*THEN*/
        int i = 1;
        while (i >= 0) {
            new MedicalAppointmentDao().save(appointment);
            i--;
        }
        System.out.println("Salvo com sucesso!");

    }

    @Test
    public void findAll() {
        /*WHEN*/
        List<MedicalAppointment> appointmentList = new MedicalAppointmentDao().findAll();

        /*THEN*/
        System.out.println("Total de registros: " + appointmentList.size());
        for (MedicalAppointment appointment: appointmentList) {
            System.out.println("Data da Consulta: " + appointment.getDateAppointment());
        }
    }

    @Test
    public void findById() {
        /*GIVEN*/
        Long code = 1L;

        /*WHEN*/
        MedicalAppointment appointment = new MedicalAppointmentDao().findByCode(code);

        /*THEN*/
        System.out.println("Nome: " + appointment.getDateAppointment());

    }

    @Test
    public void update() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        MedicalAppointment appointment = new MedicalAppointmentDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(appointment)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            appointment.setTimeAppointment(new Date());
            new MedicalAppointmentDao().update(appointment);
            System.out.println("Registro editado");
        }
    }

    @Test
    public void delete() {
        /*GIVEN*/
        Long code = 2L;

        /*WHEN*/
        MedicalAppointment appointment = new MedicalAppointmentDao().findByCode(code);

        /*THEN*/
        if (Objects.isNull(appointment)) {
            System.out.println("Nenhum Registro Encontrado");
        } else {
            new MedicalAppointmentDao().delete(appointment);
            System.out.println("Registro excluido");
        }

    }
}
