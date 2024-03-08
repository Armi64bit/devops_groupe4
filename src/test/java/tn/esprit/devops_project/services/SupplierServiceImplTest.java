package tn.esprit.devops_project.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

 class SupplierServiceImplTest {

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Mock
    private SupplierRepository supplierRepository;


    @BeforeEach
     void initMocks() {
        MockitoAnnotations.openMocks(this); // Initialize the mocks
    }

    @Test
     void testRetrieveAllSuppliers() {
        // Mock the repository behavior
        List<Supplier> expectedSuppliers = new ArrayList<>();
        expectedSuppliers.add(new Supplier());
        expectedSuppliers.add(new Supplier());
        when(supplierRepository.findAll()).thenReturn(expectedSuppliers);

        // Call the service method
        List<Supplier> actualSuppliers = supplierService.retrieveAllSuppliers();

        // Assert the results
        assertEquals(expectedSuppliers, actualSuppliers);
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
     void testAddSupplier() {
        // Create a new supplier
        Supplier newSupplier = new Supplier();
        newSupplier.setCode("S123");
        newSupplier.setLabel("New Supplier");

        // Mock the repository behavior
        when(supplierRepository.save(newSupplier)).thenReturn(newSupplier);

        // Call the service method
        Supplier savedSupplier = supplierService.addSupplier(newSupplier);

        // Assert the results
        assertEquals(newSupplier, savedSupplier);
        verify(supplierRepository, times(1)).save(newSupplier);
    }


    @Test
     void testDeleteSupplier() {
        // Mock the repository behavior
        Long supplierId = 1L;
        doNothing().when(supplierRepository).deleteById(supplierId);

        // Call the service method
        supplierService.deleteSupplier(supplierId);

        // Assert that the deletion was called
        verify(supplierRepository, times(1)).deleteById(supplierId);
    }

    @Test
     void testRetrieveSupplier() {
        // Create an existing supplier
        Supplier existingSupplier = new Supplier();
        existingSupplier.setIdSupplier(1L);
        existingSupplier.setCode("S789");
        existingSupplier.setLabel("Retrieved Supplier");

        // Mock the repository behavior
        when(supplierRepository.findById(existingSupplier.getIdSupplier())).thenReturn(Optional.of(existingSupplier));

        // Call the service method
        Supplier retrievedSupplier = supplierService.retrieveSupplier(existingSupplier.getIdSupplier());

        // Assert the results
        assertEquals(existingSupplier, retrievedSupplier);
        verify(supplierRepository, times(1)).findById(existingSupplier.getIdSupplier());
    }

    @Test
     void testRetrieveSupplier_NotFound() {
        // Mock the repository behavior to return empty optional
        Long supplierId = 10L;
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.empty());

        // Call the service method
        assertThrows(IllegalArgumentException.class, () -> supplierService.retrieveSupplier(supplierId));

        // Verify that the repository was called
        verify(supplierRepository, times(1)).findById(supplierId);
    }//
}