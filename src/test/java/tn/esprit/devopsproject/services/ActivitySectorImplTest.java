package tn.esprit.devopsproject.services;

import org.junit.jupiter.api.Test;
import tn.esprit.devopsproject.entities.ActivitySector;
import tn.esprit.devopsproject.repositories.ActivitySectorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ActivitySectorImplTest {

    @Test
    void retrieveAllActivitySectors() {
        // Given
        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);

        // Create a list of mock ActivitySector objects
        List<ActivitySector> mockActivitySectors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ActivitySector mockActivitySector = new ActivitySector();
            mockActivitySector.setIdSecteurActivite((long) i); // Set necessary properties
            mockActivitySectors.add(mockActivitySector);
        }

        // Set up the behavior of the activitySectorRepository mock to return the list of mockActivitySector objects
        when(activitySectorRepository.findAll()).thenReturn(mockActivitySectors);

        // When
        List<ActivitySector> retrievedActivitySectors = activitySectorService.retrieveAllActivitySectors();

        // Then
        assertNotNull(retrievedActivitySectors);
        assertEquals(mockActivitySectors.size(), retrievedActivitySectors.size());
        for (int i = 0; i < mockActivitySectors.size(); i++) {
            assertEquals(mockActivitySectors.get(i).getIdSecteurActivite(), retrievedActivitySectors.get(i).getIdSecteurActivite());
        }
    }

    @Test
    void addActivitySector() {
        // Given
        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);

        // Create a mock ActivitySector object
        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L); // Set necessary properties

        // When
        activitySectorService.addActivitySector(mockActivitySector);

        // Then
        verify(activitySectorRepository, times(1)).save(mockActivitySector);
    }

    // Similarly, you can implement tests for other methods like deleteActivitySector, updateActivitySector, and retrieveActivitySector.
}
