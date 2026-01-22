# pensjon-kodeverk

Kodeverk som tidligere (og fortsatt) ligger i PEN sin database er trekt ut hit for Psak (og Pselv) for å minke kall til DB.
Dette er en temporær løsning.

Når vi ikke lengre bruker CTI, eller mer enn decode på CTI, vil denne være overflødig og vi kan legge enum i Psak (og Pselv).

### Hvordan kjøre lokalt?

1. Kjør `./fetch-secrets.sh` i terminal
3. Kjør main i PensjonKodeverkApplication med følgende valg i Run/Debug configuration
   * "Environment variables" med path til din locale .evn-fil  
      feks: `/Users/<degselv>/workspace/pensjon-kodeverk/.env`

så finner du appen kjørende på typisk: http://localhost:8080