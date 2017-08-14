package com.billdueber.data.transformer;


import org.apache.solr.common.SolrDocument;
import org.apache.solr.response.transform.DocTransformer;

import java.io.IOException;
import java.util.Map;

public class FieldNameDesuffixizer extends DocTransformer {
    final String name;
    final String[] extra;
    final StringBuilder str = new StringBuilder();

    public FieldNameDesuffixizer(String name, String[] extra) {
        this.name = name;
        this.extra = extra;
    }

    @Override
    public String getName() {
        return "field_name_desuffixizer";
    }

    @Override
    public String[] getExtraRequestFields() {
        return extra;
    }

    /**
     * This transformer simply concatenates the values of multiple fields
     */
    @Override
    public void transform(SolrDocument doc, int docid, float score) throws IOException {
        Map<String, Object> fields = doc.getFieldValueMap();
        if (doc.containsKey("bill")) {
            Object value = doc.getFieldValue("bill");
            doc.addField("danit", value);
            doc.remove("bill");
            System.out.println("CHANGED ONE WITH VALUE" + value);
        }
    }
}
