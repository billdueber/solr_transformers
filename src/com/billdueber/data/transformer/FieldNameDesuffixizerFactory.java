package com.billdueber.data.transformer;

import java.util.List;
import java.util.Map;

import java.io.IOException;

import org.apache.solr.common.params.SolrParams;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.transform.DocTransformer;
import org.apache.solr.response.transform.TransformerFactory;


public class FieldNameDesuffixizerFactory extends TransformerFactory {

    @Override
    public DocTransformer create(String field, SolrParams params, SolrQueryRequest req) {
        String[] extra = null;
        String ext = params.get("extra");
        if (ext != null) {
            extra = ext.split(",");
        }
        return new FieldNameDesuffixizer(field, extra);
    }
}
