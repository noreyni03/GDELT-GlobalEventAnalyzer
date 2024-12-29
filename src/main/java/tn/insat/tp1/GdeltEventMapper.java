// GdeltEventMapper.java
package tn.insat.tp1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class GdeltEventMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text outputKey = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Format GDELT: les colonnes sont séparées par des tabulations
        String[] fields = value.toString().split("\\t");

        // Vérifier si nous avons assez de champs
        if (fields.length >= 29) {
            // Extraire le code du pays (colonne 51) et le type d'événement (colonne 26)
            String countryCode = fields[51].trim();
            String eventCode = fields[26].trim();

            // Créer une clé combinée pays-événement
            if (!countryCode.isEmpty() && !eventCode.isEmpty()) {
                String combinedKey = countryCode + ":" + eventCode;
                outputKey.set(combinedKey);
                context.write(outputKey, one);
            }
        }
    }
}
