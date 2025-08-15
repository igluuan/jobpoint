package om.dev.jobpoint.dtos.response.timeEntry;

import om.dev.jobpoint.enums.RecordType;

import java.time.LocalDateTime;
import java.util.UUID;

public record TimeEntryResponse(UUID userId, LocalDateTime dateTime, RecordType type) {
}
