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

    private Exchange original;

    private static final Logger LOG = LoggerFactory.getLogger(VideoThumbnailAggregationStrategy.class);

    public VideoThumbnailAggregationStrategy() {
        this(null);
    }

    public VideoThumbnailAggregationStrategy(Exchange original) {
        this.original = original;
    }

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        /*String strOldExchange = (oldExchange == null) ? null : oldExchange.getIn().getHeaders().toString();
        String strOldExchangeVal = (oldExchange == null) ? null : oldExchange.getIn().getHeader("videoThumbnailTimePosition").toString();

        LOG.debug("\n\nVideoThumbnailAggregationStrategy :: \n\noldExchange headers == {} \n\nnewExchange Headers == {} \n\noldExchange videoThumbnailTimePosition header == {} \n\n", strOldExchange, newExchange.getIn().getHeaders().toString(), strOldExchangeVal);

        if (oldExchange == null) {

            LOG.debug("\n\nVideoThumbnailAggregationStrategy :: \n\nRETURNING == {} \n\n", newExchange.toString());

            return newExchange;

        } else {

            newExchange.getIn().setBody(oldExchange.getIn().getBody());

            //newExchange.getIn().setHeaders(oldExchange.getIn().getHeaders());
            //newExchange.getIn().getHeaders().put("videoThumbnailTimePosition", oldExchange.getIn().getHeader("videoThumbnailTimePosition"));
            //newExchange.getIn().getHeaders().putAll(oldExchange.getIn().getHeaders());

            LOG.debug("VideoThumbnailAggregationStrategy :: \n\nRETURNING == {} \n\n", newExchange.toString());

            return newExchange.get;
        }*/

        Exception exception = checkException(oldExchange, newExchange);
        if (exception != null) {
            if (original != null) {
                original.setException(exception);
                original.getIn().getHeaders().put("videoThumbnailTimePosition", oldExchange.getIn().getHeader("videoThumbnailTimePosition"));
            } else {
                oldExchange.setException(exception);
                oldExchange.getIn().getHeaders().put("videoThumbnailTimePosition", original.getIn().getHeader("videoThumbnailTimePosition"));
            }
        }

        return original != null ? original : oldExchange;
    }

    protected Exception checkException(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange.getException();
        } else {
            return (newExchange != null && newExchange.getException() != null)
                    ? newExchange.getException()
                    : oldExchange.getException();
        }
    }
}
