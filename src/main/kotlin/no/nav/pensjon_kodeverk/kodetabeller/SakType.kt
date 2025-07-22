package no.nav.pensjon_kodeverk.kodetabeller

import no.nav.pensjon_kodeverk.toEpochMilli
import java.time.LocalDate
import java.time.Month

enum class SakType(val decode: String, val valid: Boolean, val fromDate: LocalDate, val toDate: LocalDate?, val code: String, val frist: Int?, val codeAsString: String) {
    AFP("AFP",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"AFP",30,"AFP"),
    AFP_PRIVAT("AFP Privat",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"AFP_PRIVAT",60,"AFP_PRIVAT"),
    ALDER("Alderspensjon",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"ALDER",30,"ALDER"),
    BARNEP("Barnepensjon",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"BARNEP",30,"BARNEP"),
    FAM_PL("Familiepleierytelse",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"FAM_PL",30,"FAM_PL"),
    GAM_YRK("Gammel yrkesskade",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"GAM_YRK",30,"GAM_YRK"),
    GENRL("Generell",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"GENRL",null,"GENRL"),
    GJENLEV("Gjenlevendeytelse",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"GJENLEV",30,"GJENLEV"),
    GRBL("Grunnblanketter",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"GRBL",null,"GRBL"),
    KRIGSP("Krigspensjon",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"KRIGSP",30,"KRIGSP"),
    OMSORG("Omsorgsopptjening",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"OMSORG",30,"OMSORG"),
    UFOREP("Uføretrygd",true,LocalDate.of(1899, Month.DECEMBER, 31),null,"UFOREP",14,"UFOREP"),

}

data class SakTypeDto(
    val decode: String,
    val valid: Boolean,
    val fromDate: Long,
    val toDate: Long?,
    val code: String,
    val frist: Int?,
    val codeAsString: String,
)

fun SakType.toDto() = SakTypeDto(
    decode = decode,
    valid = valid,
    fromDate = fromDate.toEpochMilli(),
    toDate = toDate?.toEpochMilli(),
    code = code,
    frist = frist,
    codeAsString = codeAsString
)
