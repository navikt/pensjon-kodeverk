package no.nav.pensjon_kodeverk

import java.time.LocalDate
import java.time.ZoneId

fun LocalDate.toEpochMilli() = atStartOfDay(ZoneId.of("Europe/Oslo")).toInstant().toEpochMilli()