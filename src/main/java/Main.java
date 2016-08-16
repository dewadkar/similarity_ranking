import java.io.IOException;
import java.util.Map;

/**
 * Created by dewadkar on 8/12/2016.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        if(args.length < 3){
            System.out.println("Please specify three arguments, 1) data set dir path  \n 2) document file path with which similar document we need to rank  \n 3) number of similar documents");
            System.exit(0);
        }
        DataSet dataSet = new DataSet(args[0]);
        Map<Integer, Double> similarityMap = dataSet.cosineSimilarityForDocument(args[1]);
        dataSet.topNSimilar(similarityMap,Integer.valueOf(args[2]));


    }

    private static void runLocalTest() throws IOException {
        DataSet dataSet = new DataSet("resources/poems");
        Map<Integer, Double> similarityMap = dataSet.cosineSimilarityForDocument("resources/poems/1");
        dataSet.topNSimilar(similarityMap,6);
    }

}

