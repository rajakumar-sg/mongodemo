package com.example.preferences;

import com.example.preferences.model.UserPreference;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import jakarta.inject.Singleton;
import org.bson.BsonArray;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

@Singleton
public class UserPreferenceService {

    private final MongoCollection<UserPreference> userPreferenceCollection;

    public UserPreferenceService(MongoClient mongoClient) {
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);
        userPreferenceCollection = mongoClient.getDatabase("RME2")
                .withCodecRegistry(pojoCodecRegistry)
                .getCollection("userPreference", UserPreference.class);
    }

    public boolean set(String user, String key, String value) {
        return userPreferenceCollection.updateOne(
                Filters.eq("user", user).toBsonDocument(),
                Updates.set("value", value),
                new UpdateOptions().upsert(true)
        ).wasAcknowledged();
    }
}