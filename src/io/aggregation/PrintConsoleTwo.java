package io.aggregation;

import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Created by mda on 5/16/16.
 */
public class PrintConsoleTwo extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected PrintConsoleTwo(InputStream in) {
        super(in);
    }

}
