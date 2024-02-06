// ********RoostGPT********
/*
Test generated by RoostGPT for test demoTestGitlab using AI Type Open AI and AI Model gpt-4

Test Scenario 1: Verify if the method is capable of finding the owner with the given ownerId.
- Input: ownerId (valid id present in the database)
- Expected Output: The owner object with the given id should be returned.

Test Scenario 2: Verify if the method returns the correct view when given a valid ownerId.
- Input: ownerId (valid id present in the database)
- Expected Output: The method should return VIEWS_OWNER_CREATE_OR_UPDATE_FORM.

Test Scenario 3: Verify if the method handles invalid ownerId (e.g., an id that doesn't exist in the database).
- Input: ownerId (invalid id not present in the database)
- Expected Output: The method should handle the situation appropriately. Depending on the implementation of the findById method, this might be returning a null owner, throwing an exception, or some other behavior.

Test Scenario 4: Verify if the method handles null ownerId.
- Input: null ownerId
- Expected Output: The method should handle the situation appropriately. This might be returning a null owner, throwing an exception, or some other behavior.

Test Scenario 5: Verify if the method adds the correct owner object to the model when given a valid ownerId.
- Input: ownerId (valid id present in the database)
- Expected Output: The owner object added to the model should match the owner with the given id.

Test Scenario 6: Verify if the method handles the situation when the model is null.
- Input: null model
- Expected Output: The method should handle the situation appropriately. This might be throwing an exception or some other behavior.

Please note that the exact expected behaviors might differ depending on the rest of your application, especially how the findById method and the model object are implemented.
*/

// ********RoostGPT********
package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OwnerController_initUpdateOwnerForm_5166028c6b_Test {

	@Mock
	private OwnerRepository owners;

	@Mock
	private Model model;

	private OwnerController controller;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.controller = new OwnerController(owners);
	}

	@Test
	public void testInitUpdateOwnerForm() {
		Owner owner = new Owner();
		owner.setId(1);
		when(owners.findById(1)).thenReturn(owner);

		String view = controller.initUpdateOwnerForm(1, model);

		verify(model).addAttribute(owner);
		assertEquals("owners/createOrUpdateOwnerForm", view);
	}

	@Test
    public void testInitUpdateOwnerFormWithInvalidId() {
        when(owners.findById(1)).thenReturn(null);

        String view = controller.initUpdateOwnerForm(1, model);

        verify(model).addAttribute((Owner) null);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

}
