<div align="center">
  <h1>🏆 Pokémon: Ascensão de um Campeão</h1>
  <p><i>An educational turn-based battle game developed in Java.</i></p>

  <!-- Badges -->
  <img src="https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Terminal_Game-4D4D4D?style=for-the-badge&logo=windows-terminal&logoColor=white" alt="Terminal" />
</div>

<br>

> **⚖️ Legal Disclaimer:** This project is **not affiliated with or sponsored by Nintendo or The Pokémon Company**. All names, creatures, concepts, and terms related to Pokémon are used strictly as a thematic reference without any commercial purpose. This was developed exclusively for educational purposes to practice Object-Oriented Programming (OOP) and game logic.

---

## 📑 Table of Contents

- [Preview](#preview)
- [Description](#description)
- [Technical Focus](#technical-focus)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Roadmap](#roadmap)
- [Author](#author)

---

## <a id="preview"></a>📽 Preview

<div align="center">
  <img src="Screenshot/pokemon.gif" alt="Game Demo" width="80%" />
</div>

---

## <a id="description"></a>🎮 Description

**Pokémon: Ascensão de um Campeão** (Ascension of a Champion) is a terminal-based game inspired by classic RPG mechanics and turn-based battles. 

Players start by choosing their initial Pokémon, navigate through a sequence of battles, and ultimately compete in a tournament. *(Note: The game logic and terminal outputs are written in Brazilian Portuguese).*

**Core Features:**
- **Starter Selection:** Choose your initial companion.
- **Turn-based Combat:** Strategic battle system against multiple opponents.
- **Tournament Mode:** A sequential boss-rush style challenge.
- **Resource Management:** HP and status tracking during combat.
- **Economy & Inventory:** Built-in coin system with a functional shop to buy items.

---

## <a id="technical-focus"></a>⚙️ Technical Focus

This project was built during my Software Development studies at **Cesae Digital**. It serves as a practical application of core software engineering concepts rather than a commercial product.

**Key Concepts Applied:**
- **Object-Oriented Programming (OOP):** Deep use of classes, inheritance, encapsulation, and polymorphism to structure Pokémon, attacks, and items.
- **Control Flow & Logic:** Managing game loops, turn transitions, and combat calculations.
- **Data Structures:** Extensive use of Java Collections (Lists) to manage inventory, movesets, and enemy queues.
- **File Manipulation:** Reading and writing data to persist game states (if applicable) and manage game assets.
- **Modularity:** Structuring the codebase so new Pokémon or items can be added easily without breaking existing logic.

---

## <a id="architecture"></a>🏗 Architecture

The codebase is organized by feature and responsibility, making it easy to navigate and scale:

```text
Pokemon_Ascensao_de_um_Campeao/
├── Main.java           # Application entry point
├── Game/               # Core game loop and battle logic
├── Pokemons/           # OOP models (Pokemon, NPC, Evolution forms)
├── Item/               # Inventory and Shop mechanics
├── Enum/               # Game constants (Maps, Status, Types)
├── Assets/             # Utility classes (Audio, ConsoleColors, FileTools)
├── Artes/              # ASCII art text files for terminal rendering
├── AudioFiles/         # .wav files for background music and cries
└── Screenshot/         # Media for documentation
```
*(Note: Build artifacts and IDE configuration folders like `.idea` and `out` are excluded from this tree).*

---

## <a id="getting-started"></a>🚀 Getting Started

### Prerequisites
* **Java JDK 21** (GraalVM recommended)
* A terminal or an IDE like IntelliJ IDEA.

### Installation & Execution

Since the Java files are located in the root directory (no `src` folder), you can run the project using the terminal or your IDE.

**Option 1: Using an IDE (Recommended)**
1. Clone the repository: `git clone https://github.com/thaisliira/Pokemon_Ascensao_de_um_Campeao.git`
2. Open the folder `Pokemon_Ascensao_de_um_Campeao` in IntelliJ IDEA or Eclipse.
3. Locate `Main.java` in the root folder, right-click it, and select **Run 'Main'**.

**Option 2: Using the Terminal**
```bash
# 1. Clone the repository
git clone [https://github.com/thaisliira/Pokemon_Ascensao_de_um_Campeao.git](https://github.com/thaisliira/Pokemon_Ascensao_de_um_Campeao.git)
cd Pokemon_Ascensao_de_um_Campeao

# 2. Compile the Java files
javac *.java Assets/*.java Enum/*.java Game/*.java Item/*.java Pokemons/*.java

# 3. Run the application
java Main
```

---

## <a id="roadmap"></a>🗺️ Roadmap

Future updates currently in development to expand the project:

- [ ] **Graphical User Interface (GUI):** Migrating from the terminal to a visual interface.
- [ ] **Catching Mechanics:** Allowing the player to capture defeated or wild Pokémon to expand their team.
- [ ] **Save System:** Implementing a database or JSON serialization to save player progress.

---

## <a id="author"></a>👩‍💻 Author

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/thaisliira">
        <img src="https://avatars.githubusercontent.com/thaisliira?size=100" width="80px;" alt="Thais Lira profile"/><br>
        <sub><b>Thais Lira</b></sub>
      </a>
    </td>
  </tr>
</table>
