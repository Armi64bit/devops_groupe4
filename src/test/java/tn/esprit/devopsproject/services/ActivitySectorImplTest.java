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

        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);


        List<ActivitySector> mockActivitySectors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ActivitySector mockActivitySector = new ActivitySector();
            mockActivitySector.setIdSecteurActivite((long) i); // Set necessary properties
            mockActivitySectors.add(mockActivitySector);
        }
  when(activitySectorRepository.findAll()).thenReturn(mockActivitySectors);


        List<ActivitySector> retrievedActivitySectors = activitySectorService.retrieveAllActivitySectors();


        assertNotNull(retrievedActivitySectors);
        assertEquals(mockActivitySectors.size(), retrievedActivitySectors.size());
        for (int i = 0; i < mockActivitySectors.size(); i++) {
            assertEquals(mockActivitySectors.get(i).getIdSecteurActivite(), retrievedActivitySectors.get(i).getIdSecteurActivite());
        }
    }

    @Test
    void addActivitySector() {

        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);


        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L); // Set necessary properties


        activitySectorService.addActivitySector(mockActivitySector);


        verify(activitySectorRepository, times(1)).save(mockActivitySector);
    }

    @Test
    void deleteActivitySector() {

        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);


        activitySectorService.deleteActivitySector(1L);


        verify(activitySectorRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateActivitySector() {

        ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);

        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L); // Set necessary properties


        when(activitySectorRepository.save(mockActivitySector)).thenReturn(mockActivitySector);
        ActivitySector updatedActivitySector = activitySectorService.updateActivitySector(mockActivitySector);


        assertNotNull(updatedActivitySector);
        assertEquals(mockActivitySector.getIdSecteurActivite(), updatedActivitySector.getIdSecteurActivite());
    }

    @Test
    void retrieveActivitySector() {

     ActivitySectorRepository activitySectorRepository = mock(ActivitySectorRepository.class);
        ActivitySectorImpl activitySectorService = new ActivitySectorImpl(activitySectorRepository);


        ActivitySector mockActivitySector = new ActivitySector();
        mockActivitySector.setIdSecteurActivite(1L); // Set necessary properties
  when(activitySectorRepository.findById(1L)).thenReturn(Optional.of(mockActivitySector));


        ActivitySector retrievedActivitySector = activitySectorService.retrieveActivitySector(1L);


        assertNotNull(retrievedActivitySector);
        assertEquals(mockActivitySector.getIdSecteurActivite(), retrievedActivitySector.getIdSecteurActivite());
    }

}
