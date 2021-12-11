package org.gradoop.common.exceptions;

public class SortException extends Exception {
    //CS427 https://github.com/dbs-leipzig/gradoop/issues/185
    public SortException(String status) {
        super(status);
    }
}
