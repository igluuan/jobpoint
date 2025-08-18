package om.dev.jobpoint.service;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.dtos.request.timeEntry.TimeEntryRequest;
import om.dev.jobpoint.dtos.response.timeEntry.TimeEntryResponse;
import om.dev.jobpoint.mapper.TimeEntryMapper;
import om.dev.jobpoint.model.TimeEntry;
import om.dev.jobpoint.model.User;
import om.dev.jobpoint.repository.TimeEntryRepository;
import om.dev.jobpoint.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeEntryService {
    private final TimeEntryRepository timeEntryRepository;
    private final UserRepository userRepository;
    private final TimeEntryMapper timeEntryMapper;

    public TimeEntryResponse registerPoint(TimeEntryRequest request){
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        TimeEntry timeEntry = timeEntryMapper.toTimeEntry(request, user);
        TimeEntry savedTimeEntry = timeEntryRepository.save(timeEntry);
        return timeEntryMapper.toTimeEntryResponse(savedTimeEntry);
    }
}
