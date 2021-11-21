package org.gradoop.common.sort;

import static sort.gradoop.SortConstantsUtil.*;

public class GraphSortRouter {

    /**
     *
     * @param graph String representation of a graph
     * @param flag String indicating the attribute to sort on
     * @return String of the Sorted Graph given by Strategy
     */
    public String sortType(String graph, String flag) {
        if (validateGraph(graph)) {
            if (AGE.equals(flag)) {
                return GraphSortStrategyHelper.sortAge(graph);
            } else if (NAME.equals(flag)) {
                return GraphSortStrategyHelper.sortName(graph);
            } else if (COMPANY.equalsIgnoreCase(flag)) {
                return GraphSortStrategyHelper.sortCompany(graph);
            }
            return "Unsuitable sort";
        } else {
            return "Failed validation";
        }
    }

    /**
     *
     * @param graph String representation of a graph
     * @return boolean indicating if this is a valid graph to sort on
     */
    public boolean validateGraph(String graph) {
        return graph.contains(AGE) || graph.contains(NAME) || graph.contains(COMPANY);
    }

}
