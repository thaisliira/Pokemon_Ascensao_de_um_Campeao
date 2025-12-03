PokéGotchi - Documentação de Escopo do Projeto

1. Visão Geral do Jogo

Objetivo: O jogador adota um Pokémon inicial (Água, Fogo ou Elétrico), cuida de suas necessidades fisiológicas (estilo Tamagotchi), treina seus atributos e batalha contra NPCs e selvagens para sobreviver até o Grande Torneio (Dia 100).
Condição de Derrota: O HP chegar a 0 em batalha (Game Over ou Perda de Progresso) ou negligência extrema das necessidades (Fome/Energia = 0 por muito tempo).

2. Estrutura de Classes (Class Structure)

2.1. Superclasse: Pokemon

Classe abstrata ou base que contém o que todo monstro possui.

Atributos (Attributes):

name: String (Nome do Pokémon, ex: "Charmander")

type: PokemonType (Enum: FIRE, WATER, ELECTRIC)

level: int (Nível atual)

experience: int (XP acumulado)

currentHp: int (Vida atual)

maxHp: int (Vida máxima baseada no nível)

attack: int (Poder ofensivo)

defense: int (Resistência a danos)

Tamagotchi Stats:

hunger: int (0 a 100)

energy: int (0 a 100)

mood: int (0 a 100 - Humor/Felicidade)

hygiene: int (0 a 100)

status: StatusCondition (Enum: NORMAL, HUNGRY, TIRED, HAPPY, FAINTED)

Métodos (Methods):

showDetails(): Exibe status completo.

eat(Item food): Recupera hunger.

sleep(): Recupera energy, passa o tempo.

takeDamage(int damage): Reduz currentHp.

updateStatus(): Verifica se está com fome/sono e atualiza o Enum status.

2.2. Subclasse: PlayerPokemon (extends Pokemon)

O Pokémon controlado pelo usuário. Possui complexidade maior de gerenciamento.

Atributos Adicionais:

moveSet: ArrayList<Move> (Lista de golpes aprendidos, máx 4)

canEvolve: boolean (Flag ativada por nível ou evento)

inventory: ArrayList<Item> (Itens carregados)

coins: int (Dinheiro para a loja)

activeBuffs: ArrayList<Buff> (Modificadores temporários)

age: int (Dias de vida)

Métodos Específicos:

train(String attribute): Gasta energia para subir Atk/Def.

buyItem(Item item): Gasta coins, adiciona ao inventário.

evolve(): Altera o nome e boosta status base se canEvolve for true.

2.3. Subclasse: NpcPokemon (extends Pokemon)

Pokémons inimigos (selvagens ou treinadores rivais).

Atributos Adicionais:

minSpawnLevel: int (Nível mínimo para aparecer no jogo)

personality: PersonalityType (Enum: AGGRESSIVE, DEFENSIVE, TIMID)

difficultyTier: int (1 a 5, define a IA de batalha)

3. Classes de Apoio (Support Classes)

3.1. Classe Move (Golpe)

Atributos:

name: String

category: MoveCategory (Enum: PHYSICAL, SPECIAL)

type: PokemonType (Elemento do golpe)

power: int (Dano base)

accuracy: double (Chance de acerto)

3.2. Classe Item

Atributos:

name: String

itemType: ItemType (Enum: FOOD, POTION, BATTLE_BOOST)

price: int

effectValue: int (Quanto cura ou alimenta)

description: String

3.3. Classe Battle (Sistema de Combate)

Gerencia o turno entre PlayerPokemon e NpcPokemon.

Atributos:

player: PlayerPokemon

enemy: NpcPokemon

turnCount: int

isFinished: boolean

Métodos:

startBattle(): Inicializa a cena.

executeTurn(Move playerMove): Calcula velocidade, quem ataca primeiro, aplica danos.

calculateDamage(Move move, Pokemon attacker, Pokemon defender):

Fórmula básica: (Attacker.attack * Move.power) - (Defender.defense / 2).

Multiplicador de Tipo: Água > Fogo > Elétrico > Água (Pedra, Papel, Tesoura).

checkWinCondition(): Se alguém zerar HP.

distributeXp(): Se jogador vencer, ganha XP e Coins.

3.4. Classe Shop (Loja)

Atributos:

healingItems: ArrayList<Item>

foods: ArrayList<Item> (Berries)

dailySpecials: ArrayList<Item>

Métodos:

listItems(): Mostra catálogo.

generateDailyStock(): Randomiza itens especiais do dia.

4. Motor do Jogo (Game Engine)

Classe: GameController (JogoTamagotchi)

A classe principal que roda o loop while.

Atributos:

myPokemon: PlayerPokemon

wildSpawns: ArrayList<NpcPokemon> (Banco de dados de inimigos possíveis)

shop: Shop

currentDay: int (Inicia em 1)

timeOfDay: TimeCycle (Enum: MORNING, AFTERNOON, NIGHT)

Fluxo Principal (Método gameLoop()):

Menu Inicial: Jogador escolhe o tipo (Fire, Water, Electric).

Instanciação: Cria o objeto myPokemon com base na escolha.

Loop Diário (while currentDay <= 100 && myPokemon.hp > 0):

Exibir Status (Fome, Energia, Humor).

Menu de Ações (Manhã/Tarde/Noite):

1. Feed (Requer item no inv, +Hunger)

2. Sleep (Pula turno, +Energy, -Hunger)

3. Train (+Atk/Def, -Energy, -Hunger)

4. Explore/Battle (Chance de achar item ou iniciar Battle)

5. Visit Shop

Decaimento: Ao fim de cada ação/ciclo:

hunger -= 15

energy -= 20

hygiene -= 10

Checagem Crítica: Se hunger < 0 ou hp < 0 -> Game Over.

5. Timeline de Eventos (Obrigatórios)

O método checkDailyEvents(int day) será chamado todo início de dia.

Dia 01: Início da jornada. Tutorial básico.

Dia 05 - "Special Training":

Opção de gastar 50% de energia para ganhar muito XP.

Dia 20 - "Mini Tournament":

Batalha obrigatória contra um NPC de nível médio.

Recompensa: Moedas extras e Item Raro (ex: Rare Candy).

Dia 40 - "Friendship Evolution":

Se mood > 80 e level > 15, canEvolve vira true.

Menu para evoluir (muda sprite/nome e aumenta stats base).

Dia 60 - "Weather Event":

Define uma variável global weatherCondition.

Dura 5 dias. (Ex: Chuva aumenta dano de Water, Sol aumenta Fire).

Dia 80 - "Survival Test":

Durante 3 dias, a fome e energia caem 2x mais rápido.

Dia 100 - "The Grand Tournament":

Sequência de 3 batalhas (Quartas, Semi, Final).

Sem cura automática entre elas (depende do inventário do jogador).

Vitória = Zera o jogo com troféu.

6. Enums e Constantes Necessárias

Para organizar o código e evitar "Magic Strings".

// Tipos de Pokemon
enum PokemonType { FIRE, WATER, ELECTRIC, GRASS, NORMAL }

// Estado do Tamagotchi
enum StatusCondition { NORMAL, HUNGRY, TIRED, SICK, HAPPY }

// Tipos de Itens
enum ItemType { FOOD, POTION, WEAPON, TOY }

// Ciclo do Dia
enum TimeCycle { MORNING, AFTERNOON, NIGHT }


7. Lógica de Interação de Tipos (Pedra-Papel-Tesoura)

Dentro do método calculateDamage da classe Battle:

WATER tem vantagem (x2 dano) contra FIRE.

FIRE tem vantagem (x2 dano) contra ELECTRIC (Adaptação para equilíbrio triangular simples, já que no original é Ground, mas aqui usaremos esses 3).

ELECTRIC tem vantagem (x2 dano) contra WATER.

Dano Neutro: x1.

Dano Pouco Efetivo: x0.5
