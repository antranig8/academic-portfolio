# CMSC 204 – Data Structures and Algorithms

This folder contains my projects and assignments for **CMSC 204 (Data Structures and Algorithms)**.  
The course focuses on:

- Implementing core data structures from scratch  
- Understanding algorithmic reasoning and runtime behavior  
- Working with lists, stacks, queues, trees, graphs, and hashing  
- Writing and interpreting JUnit tests  
- Building complete Java applications without relying on built-in collections

## Projects

### 1. [UserAccessManager](UserAccessManager/)
A console-based authentication system that manages user accounts, enforces password rules, handles failed login attempts, and locks accounts after repeated failures.  
Implements:
- Custom exceptions for invalid commands, duplicate users, locked accounts, and bad passwords  
- Secure SHA-256 hashing for password verification  
- File loading and command-line driven user management

---
### 2. [WarehouseOrderSimulation](WarehouseOrderSimulation/)
A full simulation of a warehouse shipping system using **a priority queue and stack built entirely from scratch**.  
Implements:
- Array-based generic priority queue (no Java Collections allowed)  
- Custom stack structure  
- Time-based shipping simulation with earliest-deadline-first logic  
- Late orders pushed to a return stack

---
### 3. [SpotifyAppSim](SpotifyAppSim/)
A simplified Spotify-style playlist manager using a fully custom **GenericLinkedList** with a bidirectional ListIterator.  
Features:
- Linked list implementation from the ground up  
- Playlist navigation (next, previous)  
- Parsing users/playlists/songs from text files  
- Custom exceptions for user validation and loading errors

---
### 4. [DictionaryBuilder](DictionaryBuilder/)
A full dictionary/concordance tool built on a **hash table with separate chaining** using custom linked lists.  
Functions include:
- Parsing text files and counting word frequencies  
- Custom hash table sizing using 4k+3 prime rules  
- Commands: search, add, delete, list, stats  
- Completely manual collision handling—no built-in collections permitted for buckets

---
### 5. [MorseCodeConverter](MorseCodeConverter/)
A Morse code → English converter built using a **binary tree constructed manually from provided mappings**.  
Includes:
- Generic TreeNode class  
- MorseCodeTree with dot/underscore (.-) traversal logic  
- File and string-based conversion interface  

---
### 6. [TownGraph](TownGraph/)
A graph-based mapping system that applies **Dijkstra’s Shortest Path Algorithm** to determine routes between towns.  
Implements:
- Graph using adjacency structures  
- Comparable Town and Road classes  
- TownGraphManager for loading files, adding towns/roads, and computing shortest paths  
- Parsing road network files for automated graph construction  

---