# CfgLeftRecElim-Task-5

## German University in Cairo
### Department of Computer Science
### Assoc. Prof. Haythem O. Ismail

### CSEN1002 Compilers Lab, Spring Term 2024
**Task 5: Context-Free Grammars Left-Recursion Elimination**

## Overview
This project involves implementing the context-free grammar (CFG) left-recursion elimination algorithm. A CFG is a quadruple (V, Σ, R, S) where V and Σ are disjoint alphabets (containing variables and terminals, respectively), R ⊆ V × (V ∪ Σ)* is a set of rules, and S ∈ V is the start variable.

## Objective
Implement the algorithm to eliminate left recursion from a given CFG. The project includes:
- Defining a class constructor `CfgLeftRecElim`.
- Implementing methods `toString` and `eliminateLeftRecursion`.

## Requirements

1. **Assumptions:**
   - The set V of variables consists of upper-case English letters.
   - The start variable is the symbol S.
   - The set Σ of terminals consists of lower-case English letters (excluding 'e').
   - The letter "e" represents ε.
   - Consider CFGs with no cycles and no ε-rules.

2. **Implementation:**
   - **Class Constructor `CfgLeftRecElim`:**
     - Takes a single parameter, a string description of a CFG in the format `V#T#R`.
     - Example CFG: G1 = ({S, T, L}, {a, b, c, d, i}, R, S)
       - R: S → ScTi | La | Ti | b
              T → aSb | LabS | i
              L → SdL | Si
       - Encoded as: `S; T;L#a;b;c;d;i#S/ScTi,La,Ti,b;T/aSb,LabS,i;L/SdL,Si`

   - **Method `toString`:**
     - Returns a string representation of the CFG, using the same format as the input to the constructor.

   - **Method `eliminateLeftRecursion`:**
     - Eliminates left recursion in the constructed CFG, introducing new variables as needed.
     - Example: After eliminating left recursion in G1, the string returned by `toString` is:
       ```
       S;T;L;S';L'#a;b;c;d;i#S/LaS',TiS',bS';T/aSb,LabS,i;
       L/aSbiS'dLL',iiS'dLL',bS'dLL',aSbiS'iL',iiS'iL',bS'iL';S'/cTiS',e;
       L'/aS'dLL',abSiS'dLL',aS'iL',abSiS'iL',e
       ```

For any further details or clarifications, refer to the lab manual or contact the course instructor.
