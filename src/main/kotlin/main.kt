import mu.KotlinLogging
val logger = KotlinLogging.logger {}
val config = AppConfiguration()

fun main() {
    config.load(ConfigFileFormat.JSON,"src\\main\\resources\\TrueBackuper.json")
}