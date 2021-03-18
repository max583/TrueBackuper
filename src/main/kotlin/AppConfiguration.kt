import com.beust.klaxon.Klaxon
import java.io.File

class AppConfiguration (var tasks: ArrayList<Task> = ArrayList<Task>()) {
    init {
        logger.info("Load configuration.")
        logger.info("Work directory: " + System.getProperty("user.dir"))
        val result = Klaxon().parse<ConfigTemplate>(fromFile())
        result?.tasks?.forEach {
            val task = Task(it.taskName,it.sourceDirs,it.destDir)
            tasks.add(task)
            logger.info("Task: " + task.taskName
                    + " | sourceDirs: " + task.sourceDirs.joinToString(separator = ",", prefix = "[", postfix = "]")
                    + " | destDir: " + task.destDir )
        }
    }

    private fun fromFile(): String {
        return File("TrueBackuper.json").inputStream().bufferedReader().use { it.readText() }
    }
}