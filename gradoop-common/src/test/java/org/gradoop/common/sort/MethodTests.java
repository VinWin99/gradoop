package org.gradoop.common.sort;

import org.gradoop.common.exceptions.SortException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MethodTests {

    /**
     * When - The given String graph needs to be sorted by the age attribute
     * Then - The output SortedInfo String is sorted by age for each node
     */
    @Test
    public void sortGraphAge() {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortRouter graphSortRouter = new GraphSortRouter();
        String actual = graphSortRouter.sortType(graph, "age");

        String expected = "SortedInfo{sortedBy='age', count=8, " +
                "items=[ {name: \"Bob\", age: 24}, " +
                "{name: \"Alice\", age: 30},  " +
                "{name: \"Jacob\", age: 27}, " +
                "{name: \"Marc\", age: 40}, " +
                "{name: \"Sara\", age: 33},  " +
                "{name: \"Paul\", age: 37},  " +
                "{name: \"Mike\", age: 23},  " +
                "{name: \"Jil\", age: 32}]}";


        assertEquals(expected, actual);

    }

    /**
     * When - The given String graph needs to be sorted by the name attribute
     * Then - The output SortedInfo String is sorted by name for each node
     */
    @Test
    public void sortGraphName() {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortRouter graphSortRouter = new GraphSortRouter();
        String actual = graphSortRouter.sortType(graph, "name");

        String expected = "SortedInfo{sortedBy='name', count=10, " +
                "items=[Acme Corp, Alice, Bob, Globex Inc., Jacob, Jil, Marc, Mike, Paul, Sara]}";


        assertEquals(expected, actual);

    }

    /**
     * When - The given String graph needs to be sorted by the Company attribute
     * Then - The output SortedInfo String is sorted by Company for each node
     */
    @Test
    public void sortGraphCompany() {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortRouter graphSortRouter = new GraphSortRouter();
        String actual = graphSortRouter.sortType(graph, "company");

        String expected = "SortedInfo{sortedBy='Company', count=2, items=[Acme Corp, Globex Inc.]}";

        assertEquals(expected, actual);

    }

    /**
     * When - The given String graph needs to be sorted
     * Then - The Graph needs to be a valid graph to sort by having the correct attributes
     */
    @Test
    public void validateGraph() {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortRouter graphSortRouter = new GraphSortRouter();
        assertTrue(graphSortRouter.validateGraph(graph));

    }

    /**
     * When - The given String graph nodes to be sorted by age
     * Then - the nodes values can be sorted by a age comparator for the sortAge method
     */
    @Test
    public void ageOnlyTest() {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortStrategyHelper graphSortStrategyHelper = new GraphSortStrategyHelper();
        String actual = graphSortStrategyHelper.sortAgeOnly(graph);

        String expected = "SortedInfo{sortedBy='company', count=2, items=[Acme Corp, Globex Inc.]}";

        assertEquals(expected, actual);

    }

    /**
     * When - The given String graph nodes to be sorted by a given attribute
     * Then - the nodes values can be organized by the sortAny for the sortAny method
     * @throws SortException
     */
    @Test
    public void sortAnyTest() throws SortException {
        String graph = "g1:graph[" +
                "(p1:Person {name: \"Bob\", age: 24})-[:friendsWith]->" +
                "(p2:Person{name: \"Alice\", age: 30})-[:friendsWith]->(p1)" +
                "(p2)-[:friendsWith]->(p3:Person {name: \"Jacob\", age: 27})-[:friendsWith]->(p2) " +
                "(p3)-[:friendsWith]->(p4:Person{name: \"Marc\", age: 40})-[:friendsWith]->(p3) " +
                "(p4)-[:friendsWith]->(p5:Person{name: \"Sara\", age: 33})-[:friendsWith]->(p4) " +
                "(c1:Company {name: \"Acme Corp\"}) " +
                "(c2:Company {name: \"Globex Inc.\"}) " +
                "(p2)-[:worksAt]->(c1) " +
                "(p4)-[:worksAt]->(c1) " +
                "(p5)-[:worksAt]->(c1) " +
                "(p1)-[:worksAt]->(c2) " +
                "(p3)-[:worksAt]->(c2) " + "] " +
                "g2:graph[" +
                "(p4)-[:friendsWith]->(p6:Person {name: \"Paul\", age: 37})-[:friendsWith]->(p4) " +
                "(p6)-[:friendsWith]->(p7:Person {name: \"Mike\", age: 23})-[:friendsWith]->(p6) " +
                "(p8:Person {name: \"Jil\", age: 32})-[:friendsWith]->(p7)-[:friendsWith]->(p8) " +
                "(p6)-[:worksAt]->(c2) " +
                "(p7)-[:worksAt]->(c2) " +
                "(p8)-[:worksAt]->(c1) " + "]";

        // call sort method
        GraphSortStrategyHelper graphSortStrategyHelper = new GraphSortStrategyHelper();
        String actual = graphSortStrategyHelper.sortAny(graph, "works");

        assertNotNull(actual);

    }
}
