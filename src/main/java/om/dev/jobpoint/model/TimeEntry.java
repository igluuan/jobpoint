package om.dev.jobpoint.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import om.dev.jobpoint.enums.RecordType;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_entries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times_entries_id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "date_time", updatable = false, nullable = false)
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "record_type", nullable = false)
    private RecordType recordType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
