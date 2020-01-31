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

## arkitektúr

* gagnasafn inniheldur allar upplýsingar sem leitað er í. það inniheldur töflurnar:

    `hótel, myndir, tög, notandi, staðföng, umsagnir, saga, bókanir, tungumál`

* leitað er í gagna gagnsafninu með því að snýða til fyrirspurnir úr uppgefnum upplýsingum og/eða textastreng og keyra þær á viðeigandi töflur. niuðurstaða leitarinnar er skilað í data strúktúr sem er formaður yfir í json.

## undirsögur

**finna gistingu:**

* filtera leitina út frá tímabili, verðbili, staðsetningu, tagi og hópastærð.

* vera viss um að inntak allra gilda í leitarskilyrðunum séu gild. td ekki bókstafir í talnastreng

* með innskráningu á notanda sé hægt að vista leitir, fá notkunarsögu og skrifa endurgjöf undir nafni.

* leita á mörgum tungumálum

* ég vil leita að gistimöguleikum eftir tagi eins og: útsýni, miðbær, útivist o.s.frv.

* As a customer/website visitor. I want to be able to search for a hotel by location to ensure that I can find accommodation at the place im traveling to.

**listi af niðurstöðum.**

* vill að niðurstaðn sé einn listi með öllum færslum sem uppfylla leitarskilyrðin.

* vill fá boð frá leitarkallinu sem lætur vita þegar niðurstaðan er tilbúin til lesturs.

* vill geta skipt leitarniðurstöðum í síður og einungis fengið þann fjölda niðurstaðna í senn sem fyllir eina síðu.

**bóka gistingu á völdum gististað.**

As a customer, I want to see that the payment process is associated to a reliable company so I know that this is not a scam/fraud. (e.g. Powered by Visa)

**vðhalda upplýsingunum í gagnasafninu.**

* As a webmaster. I want to link price range to ‘rooms available’ to avoid misleading information to our customers. (If lowest price room isn’t available, we won’t show that price for that hotel).

**tryggja öruggan aðgang að leitinni alla daga allt árið.**

* As a webmaster, I want to make sure that the payment process is handled by a verified third party to make the customer feel safe as well as making sure that payment is secure on our end.

* vera viss um að leitarstrengurinn sé ekki sql injection.

**tryggja að svartími einstakrar fyrirspurna fari ekki yfir 2 sec.**

> útgáfa 0.3

þessar sögur eiga ekki við þs. við erum að smíða þjónustu sem skaffar gögn ern ekki viðmótið sjálft...

As a customer/website visitor. I want to be able to sort the results that are within my parameters by price in order to get the best deals.

As a customer/website visitor. I want to see reviews/rating for each hotel next to it. This way I can avoid bad hotels.
