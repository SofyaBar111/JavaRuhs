# Encryption Program

## Description

This project is a Java encryption program implementing a modified Caesar cipher. Key functionalities include encryption, decryption, and brute force (key guessing). The program also provides tools for frequency analysis and supports various languages.

## Contents

- `CLI`: Command-line interface for interacting with the program.
- `Cypher`: Class for encrypting and decrypting text.
- `FrequencyAnalysis`: Class for frequency analysis of characters.
- `FileManager`: Class for file operations.
- `ArgumentsParser`: Class for parsing command-line arguments.
- `RunOptions`: Class for storing execution parameters.
- `Main`: Main class of the program that performs operations based on provided arguments.

## Usage

### Commands

- `-e` : Encrypt text
- `-d` : Decrypt text
- `-bf`: Brute force (key guessing)

### Command Examples

- Encrypt the file `input.txt` with key `5`:

    ```bash
    java -cp target/your-project.jar ua.com.javarush.gnew.Main -e -f path/to/input.txt -k 5
    ```

- Decrypt the file `input.txt` with key `5`:

    ```bash
    java -cp target/your-project.jar ua.com.javarush.gnew.Main -d -f path/to/input.txt -k 5
    ```

- Brute force with frequency analysis based on the file `static.txt`:

    ```bash
    java -cp target/your-project.jar ua.com.javarush.gnew.Main -bf -f path/to/input.txt -sf path/to/static.txt
    ```

## Testing

To run tests, use Maven:

```bash
mvn test
```

## Tests include verification of: ## 
```
CLI functionality
```
```
Argument parsing correctness
```
```
Encryption and decryption functionality
```
```
Frequency analysis
```
```
File operations
```
## Class Descriptions ##

- CLI: Manages user input through the command line. Requests commands and file paths.

- Cypher: Implements the encryption and decryption algorithm. Determines the alphabet and applies encryption.

- FrequencyAnalysis: Analyzes the frequency of characters in text. Determines the decryption key based on frequency analysis.

- FileManager: Handles reading from and writing to files.

- ArgumentsParser: Parses command-line arguments and creates a RunOptions object.

- RunOptions: Stores execution parameters.

- Main: Executes the main logic of the program based on command-line arguments. Performs encryption, decryption, or brute force.
