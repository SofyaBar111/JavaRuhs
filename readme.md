# Crypto CLI Tool

This program allows you to encrypt, decrypt, and perform brute-force decryption on text files. You can run the program from the command line and specify various commands and arguments.

## Run the Program

You can run the program using the command line. Depending on your needs, you can use different commands and arguments.

### Commands

- `-e` Encrypt
- `-d` Decrypt
- `-bf` Brute force

### Arguments

- `-k` Key (used for encryption and decryption)
- `-f` File path (path to the input file)
- `-sf` Static file path (used for brute force to specify the file for static analysis)

### Examples

1. **Encrypt a file with a key**

   ```sh
   java -jar your-program.jar -e -k 1 -f "/path/to/file.txt"
   java -jar your-program.jar -d -k 5 -f "/path/to/file [ENCRYPTED].txt"
   java -jar your-program.jar -bf -f "/path/to/file [ENCRYPTED].txt"

### Notes
Arguments can be provided in any order.
If using -e or -d, you must provide both -k and -f arguments.
If using -bf, you must provide the -f argument, and -sf is optional.

### Example Commands
**Encrypt a file with a key in any order:**
```
java -jar your-program.jar -e -f "/path/to/file.txt" -k 1
Decrypt a file with a key:
```
**Decrypt a file with a key:**
```
java -jar your-program.jar -d -k 5 -f "/path/to/file [ENCRYPTED].txt"
Perform brute-force decryption:
```
**Perform brute-force decryption:**
```
java -jar your-program.jar -bf -f "/path/to/file [ENCRYPTED].txt"
```
