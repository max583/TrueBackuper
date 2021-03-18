import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ConfigTest {
    @Test
    fun testConfigStructure() {

        // JSON format
        val testConfig = AppConfiguration()
        testConfig.load(ConfigFileFormat.JSON,"src\\test\\resources\\TrueBackuperTest.json")
        assertNotNull(testConfig.tasks)
        assertEquals(testConfig.tasks.size,2)
        testConfig.tasks.forEach() {
            assertNotNull(it.destDir)
            assertNotNull(it.sourceDirs)
            assertNotNull(it.taskName)
        }

    }
}