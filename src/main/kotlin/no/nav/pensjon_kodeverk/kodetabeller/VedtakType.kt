package no.nav.pensjon_kodeverk.kodetabeller

import no.nav.pensjon_kodeverk.toEpochMilli
import java.time.LocalDate
import java.time.Month

enum class VedtakType(val decode: String, val valid: Boolean, val fromDate: LocalDate, val toDate: LocalDate?, val code: String, val kanLope: Boolean, val codeAsString: String) {
    AFPEO("AFP-etteroppgjør", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "AFPEO", false, "AFPEO"),
    ANKE("Anke", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "ANKE", false, "ANKE"),
    AVSL("Avslag", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "AVSL", false, "AVSL"),
    ENDRING("Endring", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "ENDRING", true, "ENDRING"),
    ERSTATNING("Erstatning", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "ERSTATNING", false, "ERSTATNING"),
    ETTERGIV_GJELD("Ettergivelse av gjeld", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "ETTERGIV_GJELD", false, "ETTERGIV_GJELD"),
    FORGANG("Førstegang", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "FORGANG", true, "FORGANG"),
    FRYS("Frys", false, LocalDate.of(1899,  Month.DECEMBER,  31), LocalDate.of(2008,  Month.DECEMBER,  31), "FRYS", false, "FRYS"),
    GOMR("G-omregning", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "GOMR", true, "GOMR"),
    INTERNKON("Internkontroll", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "INTERNKON", false, "INTERNKON"),
    KLAGE("Klage", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "KLAGE", false, "KLAGE"),
    MTK("Merskatt tilbakekrevning", false, LocalDate.of(1899,  Month.DECEMBER,  31), LocalDate.of(2008,  Month.DECEMBER,  31), "MTK", false, "MTK"),
    OMGJ_TILBAKE("Omgjøring av tilbakekreving", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "OMGJ_TILBAKE", false, "OMGJ_TILBAKE"),
    OPPHOR("Opphør", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "OPPHOR", false, "OPPHOR"),
    OPPTJ("Opptjening", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "OPPTJ", false, "OPPTJ"),
    REGULERING("Regulering av pensjon", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "REGULERING", true, "REGULERING"),
    SAK_OMKOST("Saksomkostninger", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "SAK_OMKOST", false, "SAK_OMKOST"),
    SAMMENSTOT("Sammenstøt", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "SAMMENSTOT", true, "SAMMENSTOT"),
    TILBAKEKR("Tilbakekreving", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "TILBAKEKR", false, "TILBAKEKR"),
    UT_VURDERING_EO("Vurdering av etteroppgjør", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "UT_VURDERING_EO", false, "UT_VURDERING_EO"),
    UTSEND_AVTALELAND("Utsendelse til avtaleland", true, LocalDate.of(1899,  Month.DECEMBER,  31), null, "UTSEND_AVTALELAND", false, "UTSEND_AVTALELAND"),
}

data class VedtakTypeDto(
    val decode: String,
    val valid: Boolean,
    val fromDate: Long,
    val toDate: Long?,
    val code: String,
    val kanLope: Boolean,
    val codeAsString: String,
)

fun VedtakType.toDto() = VedtakTypeDto(
    decode = decode,
    valid = valid,
    fromDate = fromDate.toEpochMilli(),
    toDate = toDate?.toEpochMilli(),
    code = code,
    kanLope = kanLope,
    codeAsString = codeAsString
)
