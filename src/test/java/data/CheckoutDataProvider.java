package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Provides test data for checkout forms.
 */
public class CheckoutDataProvider {
    public static Stream<Arguments> validCheckoutData() {
        return Stream.of(
                Arguments.of(
                        "John.Doee@example.com", // Email
                        "VoieVod",
                        "Doei",
                        "0763001892",
                        "Cluj",
                        "Cluj-Napoca",
                        "Strada Principala 123"
                )
        );
    }
}
