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

        //String strOldExchange = (oldExchange == null) ? null : oldExchange.getProperties().toString();
        //String strOldExchangeVal = (oldExchange == null) ? null : oldExchange.getProperty("videoThumbnailTimePosition").toString();

        //LOG.debug("\n\nVideoThumbnailAggregationStrategy :: \n\noldExchange headers == {} \n\nnewExchange Headers == {} \n\noldExchange videoThumbnailTimePosition header == {} \n\n", strOldExchange, newExchange.getProperties().toString(), strOldExchangeVal);

        if (oldExchange == null) {

            //LOG.debug("\n\nVideoThumbnailAggregationStrategy :: \n\nRETURNING == {} \n\n", newExchange.toString());

            return newExchange;

        } else {

            newExchange.getIn().setBody(oldExchange.getIn().getBody());

            //newExchange.getIn().setHeaders(oldExchange.getIn().getHeaders());
            //newExchange.getIn().getHeaders().put("videoThumbnailTimePosition", oldExchange.getIn().getHeader("videoThumbnailTimePosition"));
            //newExchange.getIn().getHeaders().putAll(oldExchange.getIn().getHeaders());

            //LOG.debug("VideoThumbnailAggregationStrategy :: \n\nRETURNING == {} \n\n", newExchange.toString());

            return newExchange;
        }

    }


}
