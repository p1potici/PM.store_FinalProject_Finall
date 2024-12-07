package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for verifying hover functionality on the main menu.
 */
class HoverMenuTest extends BaseTest {

    private ProductPage productPage;

    @BeforeEach
    void testSetup() {
        productPage = new ProductPage(driver);
    }

    @Test
    void testHoverMenu() {
        productPage.goTo(); // Navigate to the homepage
        System.out.println("Navigated to the homepage.");

        productPage.openDropdownMenu(); // Hover over the dropdown menu
        System.out.println("Hovered over the dropdown menu.");

        // Verify the dropdown menu is visible
        assertTrue(productPage.isDropdownVisible(),
                "Dropdown menu should be visible after hover.");
        System.out.println("Dropdown menu is visible after hover.");

        // Move the mouse away from the dropdown menu
        productPage.moveMouseAway();
        System.out.println("Moved the mouse away from the dropdown menu.");

        // Wait for a short time to simulate UI behavior
        productPage.waitFor(2000);

        // Verify the dropdown menu is no longer visible
        assertFalse(productPage.isDropdownVisible(), "Dropdown menu should collapse after the mouse leaves.");
        System.out.println("Dropdown menu collapsed after mouse left.");
    }
}
