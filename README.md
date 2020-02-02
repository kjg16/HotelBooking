# HotelBooking

**Team 7H:** Ármann Schelander, Oliver Másson, Karl Jóhann Guðsteinsson.

Verkefnið er að skapa leitaraðgang að upplýsingum um gistimöguleika.

## markmið

Útvega library með vérænu viðmóti (interface), sem móttekur val notandans og skilar niðurstöðum úr gagnasafni á vélrænu formi (json).

## sögur

Við viljum:

* finna gistingu útfrá: heiti, staðsetningu, tímabili, verðbili, tagi og hópastærð.

* fá lista yfir alla gistimöguleika sem uppfylla leitarskilyrðin

* bóka gistingu á völdum gististað.

* vðhalda upplýsingunum í gagnasafninu

* tryggja öruggan aðgang að leitinni alla daga allt árið.

* tryggja að svartími einstakrar fyrirspurna fari ekki yfir 2 sec.

nánari upplýsingar um sögur og undirsögur má finna í [sögur.xlsx](sögur.xlsx). í töflunni eru dálkarnir:

* `id` sem innihedur einkvæmt auðkenni fyrri kröfina.
* `saga` sem er listi af sögum auðkendum [1..6]
* `undirsaga` listar af sögum undir ofangreindum sögum auðkendir [1..6].[1..n] þ.s `n` er flöldi undirsaga undir tiltekinni sögu.
* `tegund` flokkar sögurnar í  `F` = Functional; `Q` = Quality og `G` = General.
* `forgangur` flokkar sögurnar í forgang til úrvinnslu.

forgangur er skilgreindur eftirfarandi:

* 1 - mandatory.
* 2 - must have.
* 3 - nice to have.

## arkitektúr

* gagnasafn inniheldur allar upplýsingar sem leitað er í. það inniheldur töflurnar:

    `hótel, myndir, tög, notandi, staðföng, umsagnir, saga, bókanir, tungumál`

* leitað er í gagna gagnsafninu með því að snýða til fyrirspurnir úr uppgefnum upplýsingum og/eða textastreng og keyra þær á viðeigandi töflur. niuðurstaða leitarinnar er skilað í data strúktúr sem er formaður yfir í json.

> útgáfa 1.0
