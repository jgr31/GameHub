# GameHub

Aplicació d'escriptori desenvolupada amb **Java Swing** i **NetBeans** per gestionar usuaris, videojocs i lloguers.

## Tecnologies

- Java 26, Swing i Maven.
- **FlatLaf Dark** per a l'aparença de la interfície.
- **ValidationAPI**, biblioteca pròpia per validar les dades dels formularis.
- **Bundle_ca.properties** per als textos de la interfície en català (`ca-ES`).

## Requisits i execució

Cal tenir **JDK 26** i **Apache NetBeans** amb suport Maven. Per primera vegada, Maven necessita connexió a Internet per descarregar les dependències externes.

1. Obrir el projecte **ValidationAPI** (carpeta `ValidationAPI`) amb NetBeans i executar **Clean and Build**.
2. Obrir el projecte **GameHub** (carpeta principal) i executar **Clean and Build**.
3. Executar **GameHub** amb **Run Project (F6)**. La classe principal és `com.jordigelabert.gamehub.GameHub`.

> L'ordre de compilació és important: GameHub utilitza la biblioteca local ValidationAPI.

## Funcionalitats

- Crear i esborrar usuaris, amb validació dels camps obligatoris, nom, DNI i telèfon.
- Crear i esborrar videojocs amb estoc independent per a **PS5, Xbox, PC i Switch 2**.
- Registrar lloguers amb dates automàtiques, selecció de plataforma disponible i descompte d'una unitat d'estoc.
- Registrar devolucions i recuperar una unitat d'estoc de la plataforma corresponent.
- Impedir l'eliminació d'usuaris o jocs amb lloguers actius.
- Consultar l'historial de lloguers a la taula principal: **verd** per als retornats i **vermell** per als vençuts.

## Dades inicials

En iniciar l'aplicació es carreguen automàticament aquestes dades:

| Usuari | Videojoc | Estoc inicial del videojoc |
| --- | --- | --- |
| Laura Garcia Martínez | FIFA 25 (Esports) | PS5: 3; Switch 2: 2 |
| Marc López Sánchez | Cyberpunk 2077 (Acció) | Xbox: 2; PC: 3 |

També es generen dos lloguers actius:

- **Laura** lloga **FIFA 25** per a **PS5**.
- **Marc** lloga **Cyberpunk 2077** per a **PC**.

Cada lloguer inicial consumeix una unitat de la seva plataforma. Per tant, en obrir l'aplicació, l'estoc disponible és **PS5: 2** per a FIFA 25 i **PC: 2** per a Cyberpunk 2077. Els lloguers tenen una durada prevista de **3 dies**.

## Proves recomanades

1. Crear un usuari i comprovar que es rebutgen els noms que no comencen amb majúscula.
2. Crear un videojoc i comprovar que les plataformes sense estoc queden desactivades en registrar un lloguer.
3. Registrar un lloguer i verificar que l'estoc de la plataforma disminueix en una unitat.
4. Intentar esborrar un usuari o videojoc amb lloguers actius i comprovar que l'operació es bloqueja.
5. Retornar un lloguer i verificar que apareix en verd a la taula principal i que recupera una unitat d'estoc.
6. Comprovar que els lloguers que superen la data prevista de devolució apareixen en vermell.

## Emmagatzematge

Les dades es mantenen **en memòria** durant l'execució. En tancar i tornar a obrir GameHub, es restableixen les dades inicials. No és necessària cap base de dades.
