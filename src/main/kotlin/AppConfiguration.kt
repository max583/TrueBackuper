import com.beust.klaxon.Klaxon
import java.io.File

class AppConfiguration (
    var tasks: ArrayList<Task> = ArrayList<Task>()) {
    fun load(configFileFormat: ConfigFileFormat = ConfigFileFormat.JSON,
                fileName: String) {
        logger.info("Load configuration.")
        logger.info("Work directory: " + System.getProperty("user.dir"))
        val result = fromFile(configFileFormat,fileName)
        result?.tasks?.forEach {
            val task = Task(it.taskName,it.sourceDirs,it.destDir)
            tasks.add(task)
            logger.info("Task: " + task.taskName
                    + " | sourceDirs: " + task.sourceDirs.joinToString(separator = ",", prefix = "[", postfix = "]")
                    + " | destDir: " + task.destDir )
        }
    }

    private fun fromFile(configFileFormat: ConfigFileFormat, fileName: String): FullConfig? {
        return when (configFileFormat) {
            ConfigFileFormat.JSON -> Klaxon().parse<FullConfig>(File(fileName).inputStream().bufferedReader().use { it.readText() })
            //ConfigFormat.XML ->
            else -> FullConfig(arrayListOf())
        }
    }
}