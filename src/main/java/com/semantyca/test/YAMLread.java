package com.semantyca.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.semantyca.test.pojo.Language;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YAMLread {
    static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {

            List<Language> languages = new ArrayList<>();
            InputStream is = YAMLread.class.getResourceAsStream("/defaultValues.yml");
            JsonNode rootNode = mapper.readTree(is);
            JsonNode drNode = rootNode.path("languages");
            Iterator<JsonNode> itr = drNode.elements();
            while (itr.hasNext()) {
                Language language = mapper.treeToValue(itr.next(), Language.class);
                languages.add(language);
            }

            //String vals = ReflectionToStringBuilder.toString(languages, ToStringStyle.MULTI_LINE_STYLE);
            System.out.println(languages);

        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }
}
