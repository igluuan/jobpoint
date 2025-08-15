package om.dev.jobpoint.dtos.request.timeEntry;

import om.dev.jobpoint.enums.RecordType;

import java.util.UUID;

public record TimeEntryRequest(UUID userId, RecordType type) {
}
