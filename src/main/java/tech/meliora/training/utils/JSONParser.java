package tech.meliora.training.utils;

import tech.meliora.training.domain.Operands;

/**
 *
 * @author kamochu
 */
public class JSONParser {

    /**
     * Convert this json {"a":5,"b":6} to Operands instance
     *
     * @param jsonString
     * @return
     */
    public static Operands parse(String jsonString) throws Exception {

        if (jsonString == null) {
            throw new Exception("Data is null");
        }

        System.out.println("Received: " + jsonString);
        Operands operands = new Operands();

        //remove  - "a":5, "b":6
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        System.out.println("Removed {}: " + jsonString);

        //split by , -  get three values "operation": add "operand1":5 and "operand2":6
        String parts[] = jsonString.split(",");
        System.out.println("split by ',' : " + parts[0] + " and " + parts[1] + "and" + parts[2]);

        //split first value by : - "operation" and "value"  (if first value is a, set a to operands.a, if  b do what is needed )
        String partsOfPart0[] = parts[0].split(":");
        System.out.println("split part 1 by ':' : " + partsOfPart0[0] + " and " + partsOfPart0[1]);

        //Remove "" from add
        String partsOfPart01 = partsOfPart0[1].substring(1, partsOfPart0[1].length() - 1);

        if (partsOfPart0[0].equals("\"operation\"")) {

            System.out.println("updating operation : " + partsOfPart0[1]);
            operands.setOperation(partsOfPart01);
        }
//        else if (partsOfPart0[0].equals("\"b\"")) {
//            System.out.println("updating b : " + partsOfPart0[1]);
//            operands.setB(Integer.parseInt(partsOfPart0[1]));
//        }



        //split second value by : - "operand1" and "value"  (if first value is a, set a to operands.a, if  b do what is needed )
        String partsOfPart1[] = parts[1].split(":");
        System.out.println("split part 1 by ':' : " + partsOfPart1[0] + " and " + partsOfPart1[1]);

        if (partsOfPart1[0].equals("\"operand1\"")) {

            System.out.println("updating operand1 : " + partsOfPart1[1]);
            operands.setA(Integer.parseInt(partsOfPart1[1]));
        }
//        else if (partsOfPart1[0].equals("\"b\"")) {
//            System.out.println("updating b : " + partsOfPart1[1]);
//            operands.setB(Integer.parseInt(partsOfPart1[1]));
//        }

        //split third value by : - "a" and 5  (if first value is a, set a to operands.a, if  b do what is needed )
        String partsOfPart2[] = parts[2].split(":");

        System.out.println("split part 2 by ':' : " + partsOfPart2[0] + " and " + partsOfPart2[1]);

        if (partsOfPart2[0].equals("\"operand2\"")) {
            operands.setA(Integer.parseInt(partsOfPart2[1]));
            System.out.println("updating operand2 : " + partsOfPart1[1]);
        }
//        else if (partsOfPart2[0].equals("\"b\"")) {
//            operands.setB(Integer.parseInt(partsOfPart2[1]));
//            System.out.println("updating b : " + partsOfPart1[1]);
//        }

        System.out.println("Operands as an object: " + operands);

        return operands;

    }

}
