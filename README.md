# Rock Paper Scissors – JavaFX Desktop Game

A small, polished **JavaFX** application that lets you play Rock‑Paper‑Scissors against the computer with smooth animations and score tracking.

<p align="center">
  <img src="https://user-images.githubusercontent.com/placeholder/rps-preview.gif" width="480" alt="Gameplay preview"/>
</p>

---

## ✨ Features

* Clean **Material‑style** UI built in **FXML / Scene Builder**
* Hero images change dynamically as you hover / click
* Random AI powered by `java.util.Random`
* Round‑win glow animation & end‑game dialog (first to 5)
* "Restart" button to reset scores without restarting the app
* All assets packaged inside the runnable JAR – no external dependencies except the JavaFX runtime.

---

## Project Layout

```
RockPaperScissors/
├── src/
│   └── application/
│       ├── Main.java            # Launches JavaFX app
│       ├── Frame.java           # Controller logic (event handlers)
│       └── Frame.fxml           # UI layout created with SceneBuilder
├── Resources/                   # PNG icons for moves & outcomes
│   ├── Rock.png / Paper.png / Scissors.png
│   └── victory.png / defeat.png
└── README.md
```

> IntelliJ IDEA project files (`.idea/`, `*.iml`) and pre‑built `out/` classes are included for convenience; feel free to delete and re‑import.

---

## 🏃 Running the Game

### 1 · Prerequisites
* **JDK 17** or newer
* **JavaFX SDK 21** (if using the raw `java` command). IntelliJ & Eclipse users can instead add the *JavaFX* library via project settings.

### 2 · Via IDE
1. Import the project as *Gradle* → *Java* (or simple IntelliJ project).
2. Mark the `Resources/` folder as *Resources Root* so that images are on the class‑path (`/Resources/Rock.png`).
3. Run `Main.java`.

### 3 · Via command line
```bash
# Compile (assuming JavaFX is in $PATH_TO_FX)
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml \
      -d build $(find src -name "*.java")
# Run
java  --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml \
      -cp build application.Main
```
Or simply execute the provided fat JAR (contains class files but NOT JavaFX runtime):
```bash
java -jar RockPaperScissors.jar
```

> Replace `$PATH_TO_FX` with the path to the `lib/` folder of the JavaFX SDK.

---

## ⚙️ Gameplay Logic (pseudo‑code)
```
playerMove = ROCK | PAPER | SCISSORS
computerMove = randomChoice()
if playerMove == computerMove → draw
else if (playerMove beats computerMove) → playerScore++
else → computerScore++
first to 5 triggers Alert("Victory" / "Defeat")
```
Determining the winner is handled by a simple `switch` on the controller.

---

## ✍️ Customisation Ideas
* Replace PNGs in `Resources/` with your own art or emojis.
* Add sound effects using `AudioClip`.
* Extend to **Best‑of‑N** or *Rock‑Paper‑Scissors‑Lizard‑Spock*.
* Persist high scores in a local text file.

---

## 📚 References
* JavaFX documentation – <https://openjfx.io>
* Oracle tutorial: *Getting Started with FXML*.


