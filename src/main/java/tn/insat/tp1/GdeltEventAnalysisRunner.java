// GdeltEventAnalysisRunner.java
package tn.insat.tp1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class GdeltEventAnalysisRunner {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: GdeltEventAnalysisRunner <input path> <output path>");
            System.exit(-1);
        }

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "GDELT Event Analysis");

        job.setJarByClass(GdeltEventAnalysisRunner.class);

        // Configuration des classes Mapper et Reducer
        job.setMapperClass(GdeltEventMapper.class);
        job.setCombinerClass(GdeltEventReducer.class);
        job.setReducerClass(GdeltEventReducer.class);

        // Configuration des types de sortie
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // Configuration des chemins d'entrée/sortie
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
