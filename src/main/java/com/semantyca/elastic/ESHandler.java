package com.semantyca.elastic;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.Date;

public class ESHandler {

    public String putdata() {
        try {
            Jdbi jdbi = Jdbi.create("jdbc:postgresql://127.0.0.1:5432/administrator","postgres","12345");

            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            {
                builder.timeField("updated", new Date());
                builder.field("reason", "daily update");
            }
            builder.endObject();
            UpdateRequest request = new UpdateRequest("posts", "1")
                    .doc(builder);

        } catch (ElasticsearchException | IOException e) {
            System.out.println(e);
        }
        return "done";
    }
}
