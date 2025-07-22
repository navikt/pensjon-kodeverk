package no.nav.pensjon_kodeverk

import no.nav.pensjon_kodeverk.kodetabeller.SakType
import no.nav.pensjon_kodeverk.kodetabeller.VedtakType
import no.nav.pensjon_kodeverk.kodetabeller.toDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/codestable", produces = [MediaType.APPLICATION_JSON_VALUE])
class KodeverkController {

    @GetMapping()
    fun getKodeverk(@RequestParam("codeType") codeType: String): List<Any> {
        return tilgjengeligKoder[codeType]!!
    }

    companion object {
        val tilgjengeligKoder = mapOf(
            "SakType" to SakType.entries.map { it.toDto() },
            "VedtakType" to VedtakType.entries.map { it.toDto() }
        )
    }
}