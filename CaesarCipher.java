import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Encrypt
                System.out.println("Enter message to encrypt:");
                scanner.nextLine(); // Consume newline character
                String messageToEncrypt = scanner.nextLine();
                System.out.println("Enter the key for encryption:");
                int encryptionKey = scanner.nextInt();
                String encryptedMessage = encrypt(messageToEncrypt, encryptionKey);
                System.out.println("Encrypted message: " + encryptedMessage);
                break;

            case 2:
                // Decrypt
                System.out.println("Choose decryption method:");
                System.out.println("1. Decrypt with key");
                System.out.println("2. Bruteforce decryption");

                int decryptChoice = scanner.nextInt();

                switch (decryptChoice) {
                    case 1:
                        // Decrypt with key
                        System.out.println("Enter message to decrypt:");
                        scanner.nextLine(); // Consume newline character
                        String messageToDecrypt = scanner.nextLine();
                        System.out.println("Enter the key for decryption:");
                        int decryptionKey = scanner.nextInt();
                        String decryptedMessage = decrypt(messageToDecrypt, decryptionKey);
                        System.out.println("Decrypted message: " + decryptedMessage);
                        break;

                    case 2:
                        // Bruteforce decryption
                        System.out.println("Enter message to bruteforce decrypt:");
                        scanner.nextLine(); // Consume newline character
                        String messageToBruteforce = scanner.nextLine();
                        bruteforceDecrypt(messageToBruteforce);
                        break;

                    default:
                        System.out.println("Invalid choice for decryption method.");
                }
                break;

            default:
                System.out.println("Invalid choice for operation.");
        }

        scanner.close();
    }

    private static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) ((ch - base + key) % 26 + base);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(ch);
            }
        }

        return encryptedMessage.toString();
    }

    private static String decrypt(String message, int key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char decryptedChar = (char) ((ch - base - key + 26) % 26 + base);
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(ch);
            }
        }

        return decryptedMessage.toString();
    }

    private static void bruteforceDecrypt(String message) {
        System.out.println("Bruteforce decryption results:");
        for (int i = 1; i < 26; i++) {
            String decryptedMessage = decrypt(message, i);
            System.out.println("Key " + i + ": " + decryptedMessage);
        }
    }
}
