package org.gradoop.common.sort;

import java.util.List;

public class SortedInfo {
    public String sortedBy;
    public int count;
    public List<String> items;

    public SortedInfo(String sortedBy, int count, List<String> items) {
        this.sortedBy = sortedBy;
        this.count = count;
        this.items = items;
    }

    /**
     * CS427 https://github.com/dbs-leipzig/gradoop/issues/185
     * <p> Contents of the sorted info object can be given in String format
     * @return Sorted Info Object in String format
     */
    @Override
    public String toString() {
        return "SortedInfo{" +
                "sortedBy='" + sortedBy + '\'' +
                ", count=" + count +
                ", items=" + items +
                '}';
    }
}
