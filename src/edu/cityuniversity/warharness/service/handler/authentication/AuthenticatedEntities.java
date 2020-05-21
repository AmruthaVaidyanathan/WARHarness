package edu.cityuniversity.warharness.service.handler.authentication;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 *
 */
public class AuthenticatedEntities {
    private static final List<String> entities = ImmutableList.of(
            "WARHarnessWebUI"
    );

    public static boolean isAuthenticated(String entity) {
        return entities.contains(entity);
    }
}
