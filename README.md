# Familiar
Project description:
Familiar is a hobby project with two goals. 
The first goal is to create a tool for tabletop RPG players to keep their data, notes, characters in one place. It would also familiar.service.assist the game master with numerous tasks during play, like making hidden rolls, keeping private records or helping with combat.
My second goal is honing my programming skills. As someone new to software development, building a simple software from ground up should really provide a few experience points.

Core features:
* Should support core DnD fifth edition with an option to adding different rulesets in the future
* Users can create campaigns
* Users can create characters and link them to campaigns
* Campaigns and players are stored
* Users can see the statistics of each player linked to the campaign and can modify any player related data
* Users can add hidden notes to characters and campaigns
* Users can make ability or luck rolls for the characters
* Users can initiate combat, which keeps track of characters health, status and sequence
* Users can initiate a session
* Session details (summary, players, etc.) is stored
* Characters can be in active or passive state for a session
* Users can request random ideas for party encounters
* Runs locally in terminal
* Data is persisted in JSON

Advanced features:
* Supports multiple users with different roles (STORYTELLER or PLAYER)
* Deployed publicly to web
* Data is persisted in SQL
* Players can request a printable character sheet which is filled with the existing data
Generate random or semi-random characters based on the party's level