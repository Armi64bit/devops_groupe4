package tn.esprit.devopsproject.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devopsproject.entities.ActivitySector;
import tn.esprit.devopsproject.repositories.ActivitySectorRepository;
import tn.esprit.devopsproject.repositories.ProductRepository;
import tn.esprit.devopsproject.repositories.StockRepository;
import tn.esprit.devopsproject.services.ActivitySectorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;



@SpringBootTest

class ActivitySectorImplTest {

    @Mock
    ActivitySectorRepository activitySectorRepository;

    @InjectMocks
    ActivitySectorImpl activitySectorService;

    @Test
    void retrieveAllActivitySectors() {
       // ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);

      //  ActivitySectorImpl activitySectorService = new ActivitySectorImpl();

        // Given
        List<ActivitySector> mockActivitySectors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ActivitySector mockActivitySector = new ActivitySector();
            mockActivitySector.setIdSecteurActivite((long) i);
            mockActivitySectors.add(mockActivitySector);
        }
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
        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L);
        when(activitySectorRepository.save(any(ActivitySector.class))).thenReturn(mockActivitySector);

        // When
        ActivitySector addedActivitySector = activitySectorService.addActivitySector(mockActivitySector);

        // Then
        assertNotNull(addedActivitySector);
        assertEquals(mockActivitySector.getIdSecteurActivite(), addedActivitySector.getIdSecteurActivite());
    }

    @Test
    void deleteActivitySector() {
        // Given
        Long idToDelete = 1L;

        // When
        activitySectorService.deleteActivitySector(idToDelete);

        // Then
        verify(activitySectorRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    void updateActivitySector() {
        // Given
        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L);
        when(activitySectorRepository.save(any(ActivitySector.class))).thenReturn(mockActivitySector);

        // When
        ActivitySector updatedActivitySector = activitySectorService.updateActivitySector(mockActivitySector);

        // Then
        assertNotNull(updatedActivitySector);
        assertEquals(mockActivitySector.getIdSecteurActivite(), updatedActivitySector.getIdSecteurActivite());
    }

    @Test
    void retrieveActivitySector() {
        // Given
        Long idToRetrieve = 1L;
        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(idToRetrieve);
        when(activitySectorRepository.findById(idToRetrieve)).thenReturn(Optional.of(mockActivitySector));

        // When
        ActivitySector retrievedActivitySector = activitySectorService.retrieveActivitySector(idToRetrieve);

        // Then
        assertNotNull(retrievedActivitySector);
        assertEquals(idToRetrieve, retrievedActivitySector.getIdSecteurActivite());
    }
}