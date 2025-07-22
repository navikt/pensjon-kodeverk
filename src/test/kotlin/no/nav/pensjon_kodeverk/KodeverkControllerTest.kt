package no.nav.pensjon_kodeverk

import no.nav.pensjon_kodeverk.KodeverkController.Companion.tilgjengeligKoder
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.io.File

class KodeverkControllerTest {

    private val mockMvc = MockMvcBuilders.standaloneSetup(KodeverkController()).build()


    @Test
    fun `skal returnere forventet respons for alle kodetabeller`() {
        for (codeType in tilgjengeligKoder.keys) {
            val expectedJson = File("src/test/resources/${codeType.replaceFirstChar { it.lowercase() }}-respons.json").readText(Charsets.UTF_8)

            mockMvc.perform(
                MockMvcRequestBuilders.get("/api/codestable")
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("codeType", codeType)
            )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
        }

    }
}

