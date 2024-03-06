package tn.esprit.devops_project.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivitySectorTest {

    @Mock
    private Supplier supplierMock;

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
        assertNull(activitySector.getCodeSecteurActivite());
        assertNull(activitySector.getSuppliers());
    }

    @Test
    void constructorWithAllFieldsExceptId_ShouldSetFieldsCorrectly() {
        // Arrange
        String code = "XYZ";
        String name = "Test Sector";
        Set<Supplier> suppliers = new HashSet<>();
        suppliers.add(supplierMock);

        // Act
        ActivitySector activitySector = new ActivitySector(code, name, suppliers);

        // Assert
        assertNotNull(activitySector);
        assertNull(activitySector.getIdSecteurActivite());
        assertEquals(code, activitySector.getCodeSecteurActivite());
        assertEquals(name, activitySector.getLibelleSecteurActivite());
        assertEquals(suppliers, activitySector.getSuppliers());
    }
}
