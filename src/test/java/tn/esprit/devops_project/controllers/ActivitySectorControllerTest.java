package tn.esprit.devops_project.controllers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.services.Iservices.IActivitySector;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ActivitySectorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IActivitySector activitySectorService;

    @InjectMocks
    private ActivitySectorController activitySectorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(activitySectorController).build();
    }

    @Test
    public void testRetrieveAllActivitySectors() throws Exception {
        List<ActivitySector> activitySectors = new ArrayList<>();
        activitySectors.add(new ActivitySector(1L, "Sector 1"));
        activitySectors.add(new ActivitySector(2L, "Sector 2"));

        when(activitySectorService.retrieveAllActivitySectors()).thenReturn(activitySectors);

        mockMvc.perform(get("/activitySector"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Sector 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Sector 2"));

        verify(activitySectorService, times(1)).retrieveAllActivitySectors();
        verifyNoMoreInteractions(activitySectorService);
    }

    @Test
    public void testAddActivitySector() throws Exception {
        ActivitySector newActivitySector = new ActivitySector(3L, "Sector 3");

        when(activitySectorService.addActivitySector(any(ActivitySector.class))).thenReturn(newActivitySector);

        mockMvc.perform(post("/activitySector")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idSecteurActivite\":3,\"libelleSecteurActivite\":\"Sector 3\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idSecteurActivite").value(3))
                .andExpect(jsonPath("$.libelleSecteurActivite").value("Sector 3"));

        verify(activitySectorService, times(1)).addActivitySector(any(ActivitySector.class));
        verifyNoMoreInteractions(activitySectorService);
    }

    @Test
    public void testDeleteActivitySector() throws Exception {
        Long idToDelete = 1L;

        mockMvc.perform(delete("/activitySector/{id}", idToDelete))
                .andExpect(status().isOk());

        verify(activitySectorService, times(1)).deleteActivitySector(idToDelete);
        verifyNoMoreInteractions(activitySectorService);
    }

    @Test
    public void testUpdateActivitySector() throws Exception {
        ActivitySector updatedActivitySector = new ActivitySector(1L, "Updated Sector");

        when(activitySectorService.updateActivitySector(any(ActivitySector.class))).thenReturn(updatedActivitySector);

        mockMvc.perform(put("/activitySector")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idSecteurActivite\":1,\"libelleSecteurActivite\":\"Updated Sector\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idSecteurActivite").value(1))
                .andExpect(jsonPath("$.libelleSecteurActivite").value("Updated Sector"));

        verify(activitySectorService, times(1)).updateActivitySector(any(ActivitySector.class));
        verifyNoMoreInteractions(activitySectorService);
    }

    @Test
    public void testRetrieveActivitySector() throws Exception {
        Long idToRetrieve = 1L;
        ActivitySector activitySector = new ActivitySector(1L, "Sector 1");

        when(activitySectorService.retrieveActivitySector(idToRetrieve)).thenReturn(activitySector);

        mockMvc.perform(get("/activitySector/{id}", idToRetrieve))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idSecteurActivite").value(1))
                .andExpect(jsonPath("$.libelleSecteurActivite").value("Sector 1"));

        verify(activitySectorService, times(1)).retrieveActivitySector(idToRetrieve);
        verifyNoMoreInteractions(activitySectorService);
    }
}
