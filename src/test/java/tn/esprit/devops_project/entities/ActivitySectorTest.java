package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    void constructorWithIdAndName_ShouldSetIdAndName() {
        // Arrange
        Long id = 1L;
        String name = "Test Sector";

        // Act
        ActivitySector activitySector = new ActivitySector(id, name);

        // Assert
        assertNotNull(activitySector);
        assertEquals(id, activitySector.getIdSecteurActivite());
        assertEquals(name, activitySector.getLibelleSecteurActivite());
    }

    @Test
    void constructorWithAllFieldsExceptId_ShouldSetFieldsCorrectly() {
        // Arrange
        String code = "XYZ";
        String name = "Test Sector";
        Set<Supplier> suppliers = new HashSet<>();

        // Act
        ActivitySector activitySector = new ActivitySector(code, name, suppliers);

        // Assert
        assertNotNull(activitySector);
        assertNull(activitySector.getIdSecteurActivite()); // id will be generated
        assertEquals(code, activitySector.getCodeSecteurActivite());
        assertEquals(name, activitySector.getLibelleSecteurActivite());
        assertEquals(suppliers, activitySector.getSuppliers());
    }
}
