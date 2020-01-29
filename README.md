# HotelBooking

Verkefnið er að skapa leitaraðgang að upplýsingum um gistimöguleika.

## markmið

Útvega library með vérænu viðmóti (interface), sem móttekur val notandans og skilar niðurstöðum úr gagnasafni á vélrænu formi (json).

## sögur

Við viljum:

* finna gistingu útfrá staðsetningu, tímabili, verðbili, tagi og hópastærð.

* fá lista yfir alla gistimöguleika sem uppfylla hliðarskilyrði

* bóka gistingu á völdum gististað.

* vðhalda upplýsingunum í gagnasafninu

## arkitektút

* gagnasafn inniheldur allar upplýsingar sem leitað er í. það inniheldur töflurnar:

    `hótel, myndir, tög, notandi, staðföng, umsagnir, saga, bókanir`

* leitað er í gagna gagnsafninu með því að snýða til fyrirspurnir úr uppgefnum upplýsingum og/eða textastreng og keyra þær á viðeigandi töflur. niuðurstaða leitarinnar er skilað í data strúktúr sem er formaður yfir í json.

## undirsögur

**Finna gistingu:**

* Vill filtera leitina út frá tímabili, verðbili, staðsetningu, tagi og hópastærð.

* vill vera viss um að inntak allra gilda í leitarskilyrðunum séu gils. td ekki bókstafir í talnastreng

* vill að með innskráningu á notanda sé hægt að vista leitir, fá notkunarsögu og skrifa endurgjöf undir nafni.

* vill leita á mörgum tungumálum

**listi af niðurstöðum**

* vill að niðurstaðn sé einn listi með öllum færslum sem uppfylla leitarskilyrðin.

* vill fá boð frá leitarkallinu sem lætur vita þegar niðurstaðan er tilbúin til lesturs.

**Bóka gistingu á völdum gististað**





> Útgáfa 0.1
