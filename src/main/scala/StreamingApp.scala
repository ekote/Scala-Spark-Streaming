import org.apache.spark.streaming.dstream.ConstantInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object StreamingApp extends App {

  val sc = new SparkContext("local[*]", "appname" , new SparkConf())
  val ssc = new StreamingContext(sc, batchDuration = Seconds(5))

  val rdd = sc.parallelize(0 to 10)
  val ds = new ConstantInputDStream(ssc, rdd)
  ds.print()
  ssc.start()
  ssc.awaitTermination()
}