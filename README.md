# betliga
Jest to aplikacja do obstawiania meczów w tworzonych przez uzytkowników ligach, ma na celu rozwiązanie problemu wielu fanów esportu, którzy na różnych grupach "bawią" się w obstawianie meczów różnych lig esportowych. Robią to jednak w dość toporny sposób, np. zakłady wysyła się w postaci ankiety googlowej takiej jak ta 
![alt text](https://scontent-ams3-1.xx.fbcdn.net/v/t34.0-12/20371044_1625835537458045_1435834464_n.png?oh=b23b1a887b07b7e84de8447a193fccfc&oe=59793264)

Później ktoś ręcznie dodaje zakłady od każdej osoby, a wyniki prezentowane są w formie arkusza online 
![alt text](https://scontent-ams3-1.xx.fbcdn.net/v/t34.0-12/20427640_1625836840791248_1705407109_n.png?oh=d62f80ee5626bc2c762c350ff534931f&oe=597A78E1)

Cały proces wymaga dużo pracy od osoby zajmującej się tym i łatwo jest popełnić błąd. Zdecydowanie przydałaby się mu automatyzacja!

Funkcjonalności:
  
    -dwa rodzaje lig: 
      - punktowa - za każdy trafiony mecz zdobywa się punkty, liga trwa do końca sezonu, zwycięża osoba z największą ilością punktów 
      - pulowa - na starcie ligi każdy dostaje pule punktów
    - dwa rodzaje zabezpieczeń lig:
      - prywatna - trzeba się logować, żeby zobaczyć wyniki i wziąć udział w obstawianiu, obstawiać można też za pomocą betId bez logowania
      - publiczna - każdy widzi wyniki, do zagłosowania wystarczy podania swojego betId (betId, to wygenerowany ciąg znaków mający przyspieszyć proces obstawiania, nie trzeba się logować, wystarczy podać swój betId)
    - konfiguracja lig (ilość punktów za zwycięstwo, startowa pula etc.)
    - tworzenie ligi z nazwą, avatarem etc.
    - przydzielanie funkcji moderatorskich wybranym użytkownikom
    - możliwość zapraszania uczestników do zamkniętej ligi przez email lub do otwartej przez link
    - dodawanie zespołów do ligi, co umożliwi podgląd większej ilości statystyk
    - dodawanie meczów wybranych zespołów lub wpisywanie nazw drużyn na bieżąco do kolejki przez moderatora 
    - obstawianie wyników meczów przez uczestników za pomocą 
    - zamykanie kolejki z wpisanymi wynikami przez moderatora
    - automatyczne wyliczanie punktów i tworzenie rankingu

Projekt nie zamyka się tylko na ligi esportowe, każdy może stworzyć sobie ligę jaką chce, np polskiej Ekstraklasy. Od moderatora ligi zależy jak nazwie ligę, jakie mecze będzie dodawać i kogo zaprosi.
