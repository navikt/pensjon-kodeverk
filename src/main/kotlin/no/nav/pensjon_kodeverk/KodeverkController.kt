package no.nav.pensjon_kodeverk

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/codestable", produces = [MediaType.APPLICATION_JSON_VALUE])
class KodeverkController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun getKodeverk(
        @RequestParam("codeType") codeType: String,
        @AuthenticationPrincipal jwt: Jwt
    ): ResponseEntity<String> {
        val azpName = jwt.getClaimAsString("azp_name") ?: "ukjent"
        logger.info("Kall mottatt fra $azpName for å hente $codeType")

        val resourcePath = "kodeverk/$codeType.json"
        val resource = this::class.java.classLoader.getResource(resourcePath)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Ugyldig codeType: $codeType")

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(resource.readText())
    }

    @GetMapping("/ping")
    fun ping(): ResponseEntity<Any> {
        return ResponseEntity.ok().build()
    }
}