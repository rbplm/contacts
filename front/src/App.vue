Sinu kliendil, kes tegeleb salajaste kontaktide haldamisega, on probleem. Tal on vaja kiires korras selle
tarbeks minimalistlikku infosüsteemi. Arutades võimalikku lahendust üheskoos kliendi ja arhitektiga
olete ühel meelel, et see lahendus ei saa olema pikaaegne vaid pigem ajutine, minimaalseid nõudeid täitev. Lepitakse kokku
järgnevas:
Kliendi nõuded: - Näeb kontaktide kirjeid. - Kontakti kirjes talletatakse kontakti pärisnimi, salajane kood-nimi ja telefoninumber.
- Saab nime järgi sorteerida - Saab kontakte otsida - Saab lisada uusi kontakti kirjeid. -
Lahendust saab kasutada läbi veebibrauseri.
Tehnilised nõuded: - Infosüsteemil peab olema REST API, mis toetab JSON andmeformaati, et
lahendust saaks liidestada teiste süsteemidega. - Back-end tehnoloogia Java. - JavaScript kasutajaliides,
mis suhtleb infosüsteemi REST API'ga kirjete lisamisel ja kuvamisel (ei pea mõtlema disaini või kujunduse peale).
Angular või Vue. - Lahendus peab toetama kõikvõimalike sümbolitega kontaktide nimesid. - Süsteemi kasutajad ja
kontaktandmed on talletatud andmebaasis PostgreSQL.
Lõpptulemus: - Tarkvara kood ja andmebaasi mudel (näiteks SQL dump) edastada failina. - Juhend kuidas tarkvara käivitada




<script setup>
import ContactsTable from "@/components/ContactsTable.vue";
</script>

<template>
  <main>
    <ContactsTable/>

  </main>
</template>

