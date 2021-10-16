package com.example.preferences;

import com.mongodb.assertions.Assertions;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class UserPreferenceServiceTest {

    @Inject
    UserPreferenceService userPreferenceService;

    @Test
    void testInsert() {
        Assertions.assertTrue(userPreferenceService.set("M1", "key1", "value1"));
    }
}