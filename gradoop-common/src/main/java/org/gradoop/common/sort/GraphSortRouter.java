package org.gradoop.common.sort;

import org.gradoop.common.exceptions.SortException;

import static org.gradoop.common.sort.SortConstantsUtil.AGE;
import static org.gradoop.common.sort.SortConstantsUtil.NAME;
import static org.gradoop.common.sort.SortConstantsUtil.COMPANY;

public class GraphSortRouter {

    /**
     * <p> The router for the sorting method to decide how to sort the graph
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
     * @param attribute String indicating the attribute to sort on
     * @return String of the Sorted Graph given by Strategy
     * @throws SortException when attribute does not exist in graph
     */
    public String sortOnAttribute(String graph, String attribute) throws SortException {
        return GraphSortStrategyHelper.sortAny(graph, attribute);
    }

    /**
     * <p> To make sure the graph can be validated
     * @param graph String representation of a graph
     * @return boolean indicating if this is a valid graph to sort on
     */
    public boolean validateGraph(String graph) {
        return graph.contains(AGE) || graph.contains(NAME) || graph.contains(COMPANY);
    }

}
