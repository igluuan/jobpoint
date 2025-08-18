package om.dev.jobpoint.mapper;

import om.dev.jobpoint.dtos.request.timeEntry.TimeEntryRequest;
import om.dev.jobpoint.dtos.response.timeEntry.TimeEntryResponse;
import om.dev.jobpoint.model.TimeEntry;
import om.dev.jobpoint.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeEntryMapper {
    public TimeEntry toTimeEntry(TimeEntryRequest request, User user){
        return new TimeEntry(
                null,
                LocalDateTime.now(),
                request.type(),
                user
        );
    }

    public TimeEntryResponse toTimeEntryResponse(TimeEntry timeEntry) {
        return new TimeEntryResponse(
                timeEntry.getUser().getId(),
                timeEntry.getDateTime(),
                timeEntry.getRecordType()
        );
    }
}
