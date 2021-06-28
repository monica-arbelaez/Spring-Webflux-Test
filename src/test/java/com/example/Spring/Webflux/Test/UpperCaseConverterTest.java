package com.example.Spring.Webflux.Test;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

class UpperCaseConverterTest {
    final TestPublisher<String> testPublisher = TestPublisher.create();
    @Test
    void testUpperCase() {
        UpperCaseConverter uppercaseConverter = new UpperCaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
}