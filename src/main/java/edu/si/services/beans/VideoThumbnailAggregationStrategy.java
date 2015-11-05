package edu.si.services.beans;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by jbirkhimer on 11/4/15.
 */
public class VideoThumbnailAggregationStrategy implements AggregationStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(VideoThumbnailAggregationStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        } else {

            //oldExchange.getIn().setBody(merged);

            oldExchange.getIn().getHeaders();

            LOG.info(">>>>>>>>>>>>>>> OLD HEADERS: {} <<<<<<<<<<<<<<<<<<<<<<", oldExchange.getIn().getHeaders());

            newExchange.getIn().getHeaders();
            LOG.info(">>>>>>>>>>>>>>> NEW HEADERS: {} <<<<<<<<<<<<<<<<<<<<<<", newExchange.getIn().getHeaders());
            //.getOut().setHeaders(exchange.getIn().getHeaders());
            newExchange.getIn().setHeaders(oldExchange.getIn().getHeaders());
            return newExchange;
        }
    }
}
