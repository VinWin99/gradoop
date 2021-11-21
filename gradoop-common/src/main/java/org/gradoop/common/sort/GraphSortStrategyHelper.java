package org.gradoop.common.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.gradoop.common.sort.SortConstantsUtil.AGE;
import static org.gradoop.common.sort.SortConstantsUtil.NAME;
import static org.gradoop.common.sort.SortConstantsUtil.COMPANY;

public class GraphSortStrategyHelper {

    /**
     * <p> The strategy routes here if the chose attribute is age, to sort by age
     * @param graph String representation of a graph
     * @return String of Sorted Info Object containing graph's attributes sorted by Age
     */
    public static String sortAge(String graph) {
        String[] result = graph.split(AGE);
        ArrayList<String> people = new ArrayList<>();
        String[] nameSplit = graph.split("}\\)-");
        for (int i = 0; i < nameSplit.length ; i++) {
            String temp = nameSplit[i];
            if (temp.contains("age")) {
                int index = temp.indexOf("Person");
                String temp2 = temp.substring(index);
                StringBuilder sb = new StringBuilder(temp2);
                sb.append("}");
                people.add(sb.toString().substring(6));
            }
        }

        SortedInfo sInfo = new SortedInfo(AGE, result.length - 1, people);
        return sInfo.toString();
    }

    /**
     * <p> The strategy routes here if the chose attribute is name, to sort by name
     * @param graph String representation of a graph
     * @return String of Sorted Info Object containing graph's attributes sorted by Name
     */
    public static String sortName(String graph) {
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(graph);
        ArrayList<String> names = new ArrayList<>();
        while (m.find()) {
            names.add(m.group(1));
        }
        Collections.sort(names);
        SortedInfo sortedInfo = new SortedInfo(NAME, names.size(), names);
        return sortedInfo.toString();
    }

    /**
     * <p> The strategy routes here if the chose attribute is Company, to sort by Company
     * @param graph String representation of a graph
     * @return String of Sorted Info Object containing graph's attributes sorted by Company
     */
    public static String sortCompany(String graph) {
        String[] result = graph.split(COMPANY);
        ArrayList<String> companies = new ArrayList<>();
        Pattern p = Pattern.compile("Company \\{name: \"([^\"]*)\"");
        Matcher m = p.matcher(graph);
        while (m.find()) {
            companies.add(m.group(1));
        }

        Collections.sort(companies);

        SortedInfo sInfo = new SortedInfo(COMPANY, result.length - 1, companies);
        return sInfo.toString();
    }

    /**
     * <p> The sortAge method uses this to fetch and order the actual ages
     * @param graph String representation of a graph
     * @return String of Sorted Info Object containing graph's attributes sorted by Company
     */
    public static String sortAgeOnly(String graph) {
        String[] result = graph.split(AGE);
        ArrayList<String> ages = new ArrayList<>();
        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(graph);
        while (m.find()) {
            ages.add(m.group(1));
        }

        Collections.sort(ages);

        SortedInfo sInfo = new SortedInfo(AGE, result.length - 1, ages);
        return sInfo.toString();
    }

}
