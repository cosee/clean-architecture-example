Dieses Projekt ist das Beispielprojekt für den Techtalk 
[Clean Architecture in der Praxis
- Frühjahrsputz mit Spring-Boot und Mapstruct](https://talks.cosee.biz/talk/806e0feb-4700-4f1c-9532-4af91a617d15) 
vom Mai 2020.

Die Code-Beispiele im Talk stammen aus diesem Projekt. Der Setup der Module is ebenfalls wie im Talk beschrieben.

Das Projekt kompiliert und enthält einige Tests, die die Umsetzung der Clean-Architecture bei Cosee demonstrieren.

## Prerequisites

Das Projekt benötigt eine Maven-Installation.

Es wird eine H2-Datenbank verwendet, die für die Tests gestartet werden muss.
Initial kann man H2 herunterladen, in dem man 

```bash
mvn validate # zum Herunterladen der Dependencies
```

ausführt. Danach kann die Datenbank mit

```bash
./h2-database/run-h2.sh
```

gestartet werden. Dann funktioniert auch 
 
```bash
mvn clean install
```


