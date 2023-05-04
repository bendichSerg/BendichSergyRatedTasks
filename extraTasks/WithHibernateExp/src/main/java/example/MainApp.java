package example;

import example.model.InternshipCourse;
import example.model.Student;
import example.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(InternshipCourse.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Task.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 0);
//            Task newTask = new Task("Make hibernate application", student);
//            student.getTasks().add(newTask);
//            session.persist(newTask);
//            session.getTransaction().commit();

            InternshipCourse newInternshipCourse = new InternshipCourse(student, 500);
            session.persist(newInternshipCourse);
            session.getTransaction().commit();


            sessionFactory.close();
        } finally {
            sessionFactory.close();
        }
    }
}

