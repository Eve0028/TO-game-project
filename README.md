# Mini gra turowa

## Cel projektu
Stworznie tekstowej (lub częściowo graficznej) gry przygodowej bazującej na walkach turowych.

## Wzorce projektowe:
### Wzorce kreacyjne
- <b>Metoda wytwórcza / fabryka abstrakcyjna</b> - w celu tworzenia obiektów jednostek o różnych typach dziedziczących z tej samej klasy bazowej (potworów, bohaterów, przedmiotów itp.);
- <b>Singleton</b> - w celu stworzenia obiektu obsługującego bazę danych (wystarczy jedna instancja);
- <b>Prototyp</b> - w celu kopiowania obiektów tego samego typu (potworów, bohaterów, przedmiotów itp.);
- <b>Budowniczy</b> (dodatkowy) - w celu stworzenia poziomu / planszy, gdzie znajdują się określone jednostki npc.

### Wzorce strukturalne
- <b>Most</b> - oddzielenie GUI od API (opcji dostępnych dla klienta od ich implementacji);
- <b>Kompozyt</b> - w celu zmiany / odczytu / zapisu stanu wszystkich obiektów znajdujących się w drzewie obiektów, poprzez obiekt, który wykonuje rolę kontenera (np. plansza, przechowująca poszczególne rodzaje potworów lub grupy potworów);
- <b>Dekorator</b> (dodatkowy) - dodanie różnych typów dodatkowych właściwości obiektów w zależności od sytuacji (np. bonus do ataku dla przedmiotu gdy jest użyty przeciwko określonemu rodzajowi potworów);
- <b>Pyłek</b> (dodatkowy) - sporo jednostek npc będzie miało mnóstwo podobnych atrybutów;

### Wzorce behawioralne
- <b>Mediator / Obserwator</b> - komunikacja między komponentami gry (jeszcze nie zdecydowaliśmy jak powinna przebiegać, określony wzorzec wybierzemy już podczas pracy nad kodem);
  <br>Możliwości implementacji:
  - Obestwator - przedmioty "ubieralne" (subscribers) w ekwipunku będą zmieniać stan (sprawdzać czy zmienić stan) z "zabkolowany" na "dostępny" do ubioru, gdy poziom bohatera (publisher'a) osiągnie poziom przedmiotu;
  - Mediator - komunikacja komponentów będzie uzależniona od jednego głownego obiektu mediatora np. Game;
- <b>Pamiątka</b> - w celu tworzania zapisu stanu gry (przy użyciu serializacji);
- <b>Odwiedzający</b> - różne typy obiektów mogą oddziaływać na inne (np. opcja ataku przez bohatera innego npc będzie miała inne działanie w zależności od rodzaju atakowanego npc, lub użycie różnych rodzajów przedmotów przyniesie różne skutki);
- <b>Stan</b> (dodatkowy) - npc mogą posiadać stany np. wróg/przyjaciel - są one zmienialne w zależności od zachowania bohatera względem npc;
- <b>Strategia</b> (dodatkowy) - akcja użytkownika podczas walki turowej może przyjmować określoną akcje (strategie) ze zbioru np.: <em>atak</em>, <em>obrona</em>, <em>uzdrowienie</em>.
