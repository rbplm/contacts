KONTAKTIDE RAKENDUS

Rakenduse käivitamiseks klooni rakendus IDEsse aadressilt: https://github.com/rbplm/contacts või lae alla samalt aadressilt veebilehitsejas, valides nupult code download zip

Avanud rakenduse põhikausta IDEs, talita järgnevalt. 

Seadista andmebaas ja loo tabel

1. Navigeeri kaustas faili application.properties kataloogis contacts/back/src/main/resources/application.properties
2. Järgi failis märgitud juhiseid enda andmebaasi nime ning kasutajatunnuse ja parooli seadistamiseks
3. Kasuta faili sql_dump.sql kataloogis contacts\back\database, et luua tabel ja importida andmed. Järgi failis toodud juhiseid.

Seadista ja käivita back-end

1. Navigeeri terminalis juurkataloogi ..contacts/back ja sisesta käsklus ./gradlew build
2. Samas kataloogis sisesta käsklus ./gradlew bootRun, et programm käivitada.

Seadista ja käivita front-end

1. Navigeeri terminalis juurkataloogi ..contacts/front ja sisesta käsklus npm install
2. Samas kataloogis sisesta käsklus npm run dev, et programm tööle panna
3. Mine veebilehitsejas konsoolis toodud URL-aadressile

Kasuta rakendust.
