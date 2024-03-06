package tn.esprit.devops_project.entities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ActivitySectorTest {
    @Test
    void getIdSecteurActivite() {
        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setIdSecteurActivite(1L);

        // Act
        Long id = activitySector.getIdSecteurActivite();

        // Assert
        assertNotNull(id);
        assertEquals(1L, id);
    }

    @Test
    void getCodeSecteurActivite() {
        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("ABC");

        // Act
        String code = activitySector.getCodeSecteurActivite();

        // Assert
        assertNotNull(code);
        assertEquals("ABC", code);
    }
}
