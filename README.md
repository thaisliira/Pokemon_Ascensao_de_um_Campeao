## 1. Classe geral: Pokemon

Atributos:

tipo (String ou Enum TipoPokemon)

level (int)

experiencia (int)

hpAtual (int)

hpMax (int)

## Atributos de batalha:

ataque (int)

defesa (int)

## Necessidades (Tamagotchi):

fome (int)

energia (int)

status (Enum: NORMAL, FOME, FELIZ, MACHUCADO...)

## Métodos:

mostrarDetalhes()

Métodos para alterar necessidades: comer(), dormir().

Métodos para danos/status.

## 2. Subclasse: TIPO Pokemon (controlado pelo Jogador) - agua, fogo, eletrico

Atributos adicionais:

moveset (ArrayList<Move>)

evolucaoDisponivel (boolean)

inventario (ArrayList<Item>)

moedas (int)

buffs (lista de modificadores temporários de batalha)

## 3. Subclasse: NPCPokemon

levelMinimoParaAparecer (int)

Pode ter personalidade (timido, agressivo, defensivo etc.)

## 4. Classe Move

Atributos:

nome (String)

power (int)

accuracy (int)

categoria (Enum: FOGO, AGUA, ELETRICO)

critChance (double)

pp (int)

## 5. Classe Item

Atributos:

nome

tipoItem (Enum: CURA, ARMA)

preco

efeito (texto ou função executada)

Possíveis subclasses: Pocao, armadura...

## 6. Classe Battle

Atributos:

pokemonA (Pokemon)

pokemonB (NPCPokemon ou outro jogador)

turnoAtual (int)

Métodos essenciais:

iniciarBatalha()

turno()

calcularDano(Move, atacante, defensor) — com a fórmula que montamos

ganharExperiencia()

## 7. Classe Loja (equivalente ao Shopping)

Possui:

ArrayList<Item> itensCura

ArrayList<Item> itensBatalha

Métodos:

listarItensAleatorios()

## 8. Classe JogoTamagotchi

Equivalente diretamente à “classe Sims”.

Responsável pelo ciclo diário (turnos do Tamagotchi).

Atributos:

Pokemon jogador

ArrayList<NPCPokemon> selvagens

Loja loja

int dia

Método principal:

jogo()

Fluxo por ciclo (manhã, tarde, noite):

O jogador escolhe:

Alimentar

Dormir

Treinar (aumenta ataque/defesa e diminui energia)

Explorar (chance de batalha ou itens)

Batalhar Torneio?

Ir à loja

Decaimento por ciclo:

fome −20

energia −25

humor −15

higiene −10

Se qualquer um < 25 → ações bloqueadas até resolver.

# 9. Eventos obrigatórios

Adaptado para Pokémon:

Dia 5 — “Treinamento Especial”

Escolher participar:

+50 XP

Pequena chance de aprender novo move

−30 energia

Dia 20 — “Tournament Mini”

Se quiser participar:

batalha obrigatória

recompensa: moedas + item raro

Dia 40 — “Amizade Máxima”

O Pokémon pode evoluir se requisitos forem cumpridos

Boost nos atributos

Dia 60 — “Evento climático”

Clima aleatório com efeitos por 5 dias

chuva aumenta moves Water

sol aumenta moves Fire

tempestade diminui humor

Dia 80 — “Teste de Resistência”

Pokémon passa por dias de necessidades caindo mais rápido

Recompensa final se sobreviver

Dia 100 — Checagem de Objetivo

Objetivos possíveis:

Evoluir totalmente

Atingir Level X

Ter um habitat completo

Aprender 4 moves poderosos

Vencer um número mínimo de batalhas

## 10. ArrayLists que você vai precisar

Perfeito para espelhar o projeto original.

No Pokémon:

ArrayList<Move> moveset

ArrayList<Item> inventario

Na Loja:

ArrayList<Item> itensCura

ArrayList<Item> berries

ArrayList<Item> decoracoes

No Jogo:

ArrayList<NPCPokemon> selvagens

## 11. Sistema de Batalha adaptado

Para comparação de vida/dano:

atributos: hpAtual, ataque, defesa

Componentes obrigatórios:

hpAtual -= danoRecebido

if (hpAtual <= 0) -> derrota

xp += xpGanhos

_________________________________________________________________________________________________________________________________________________

# tamagotchi_pokemon

## Necessidades Fisiológicas

Fome (comer diferentes tipos de berries ou comidas Pokémon).

Energia (dormir, cochilos, ciclos noturnos/diurnos).

Casamento ? 

## Crescimento e Evolução

Experiência acumulada não só por batalha, mas também por brincadeiras e cuidados.

Exercícios para aumentar atributos específicos: força, velocidade, foco, defesa.

Transformações temporárias (Mega, Dynamax, etc.) dependendo de decisões do jogo.

## Batalha

Level — nível do Pokémon.

HP (current) e MaxHP.

Attack, Defense (para dano físico)

Dano recebido



