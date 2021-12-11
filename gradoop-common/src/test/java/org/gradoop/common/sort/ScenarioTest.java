package org.gradoop.common.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScenarioTest {

    /**
     * CS427 https://github.com/dbs-leipzig/gradoop/issues/185
     * When - A given graph in String format need to be sorted based on various attributes
     * Then - The graph is sorted and returned in a Sorted Info String object
     */
    @Test
    public void sortScenarioTest() {
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

        GraphSortRouter graphSortRouter = new GraphSortRouter();
        String sortedGraphAge = graphSortRouter.sortType(graph, "age");
        String expectedAge = "SortedInfo{sortedBy='age', count=8, " +
                "items=[ {name: \"Bob\", age: 24}, " +
                "{name: \"Alice\", age: 30},  " +
                "{name: \"Jacob\", age: 27}, " +
                "{name: \"Marc\", age: 40}, " +
                "{name: \"Sara\", age: 33},  " +
                "{name: \"Paul\", age: 37},  " +
                "{name: \"Mike\", age: 23},  " +
                "{name: \"Jil\", age: 32}]}";


        assertEquals(expectedAge, sortedGraphAge);
        String sortedGraphName = graphSortRouter.sortType(graph, "name");
        String expectedName = "SortedInfo{sortedBy='name', count=10, " +
                "items=[Acme Corp, Alice, Bob, Globex Inc., Jacob, Jil, Marc, Mike, Paul, Sara]}";

        assertEquals(expectedName, sortedGraphName);
        String sortedGraphCompany = graphSortRouter.sortType(graph, "company");

        String expectedCompany = "SortedInfo{sortedBy='Company', count=2, items=[Acme Corp, Globex Inc.]}";

        assertEquals(expectedCompany, sortedGraphCompany);

    }
}
