package example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"InternshipCourse\"")
public class InternshipCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Student student;
    @Column(name = "time_hours")
    private int timeHours;


    public InternshipCourse() {

    }

    public InternshipCourse(Student student, int timeHours) {
        this.student = student;
        this.timeHours = timeHours;
    }

    @Override
    public String toString() {
        return "InternshipCourse{" +
                "student=" + student +
                ", timeHours=" + timeHours +
                '}';
    }
}
