package lukashermansson.me

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import lukashermansson.me.api.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
       /* withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }*/
    }
}