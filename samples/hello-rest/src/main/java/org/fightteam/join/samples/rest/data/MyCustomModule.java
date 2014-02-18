package org.fightteam.join.samples.rest.data;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import org.fightteam.join.samples.rest.data.entity.User;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class MyCustomModule extends SimpleModule {
    public MyCustomModule() {
        super("MyCustomModule", new Version(1, 0, 0, "SNAPSHOT"));
    }

    @Override
    public void setupModule(SetupContext context) {
        SimpleSerializers serializers = new SimpleSerializers();
        SimpleDeserializers deserializers = new SimpleDeserializers();

        serializers.addSerializer(User.class, new MyEntitySerializer());
        //deserializers.addDeserializer(User.class, new MyEntityDeserializer());

        context.addSerializers(serializers);
        context.addDeserializers(deserializers);
    }
}
