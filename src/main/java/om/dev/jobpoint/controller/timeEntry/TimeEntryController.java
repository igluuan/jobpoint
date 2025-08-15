package om.dev.jobpoint.controller.timeEntry;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.dtos.request.timeEntry.TimeEntryRequest;
import om.dev.jobpoint.dtos.response.timeEntry.TimeEntryResponse;
import om.dev.jobpoint.service.TimeEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/time-entries")
@RequiredArgsConstructor
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntryResponse> registerPoint(@RequestBody TimeEntryRequest request) {
        TimeEntryResponse response = timeEntryService.registerPoint(request);
        return ResponseEntity.ok(response);
    }
}
