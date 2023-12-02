# Logger Tool

## English

### Description
The Logger tool is a simple utility class for Android applications to write log messages to a file in the "Logs" directory on external storage. It is designed to provide an easy way to log information with timestamps.

### Usage

1. **Include Logger in your project:**
   - Copy the `Logger.java` file into your Android project's source code.

2. **Initialize Logger:**
   ```java
   // Example usage in an Android activity
   File logDir = Environment.getExternalStoragePublicDirectory("Logs");
   Logger logger = new Logger(logDir);
   ```

3. **Write Log Messages:**
   ```java
   // Call the write method to log a message
   String logFileName = "exampleLog";
   String logMessage = "This is a log message.";
   logger.write(logFileName, logMessage);
   ```

4. **Additional Notes:**
   - Customize the log file name as needed.
   - Ensure appropriate permissions to read and write files on the device.

## Português

### Descrição
A ferramenta Logger é uma classe de utilidade simples para aplicativos Android, projetada para escrever mensagens de log em um arquivo no diretório "Logs" no armazenamento externo. Ela foi criada para oferecer uma maneira fácil de registrar informações com carimbos de data e hora.

### Uso

1. **Inclua o Logger no seu projeto:**
   - Copie o arquivo `Logger.java` para o código-fonte do seu projeto Android.

2. **Inicialize o Logger:**
   ```java
   // Exemplo de uso em uma atividade Android
   File logDir = Environment.getExternalStoragePublicDirectory("Logs");
   Logger logger = new Logger(logDir);
   ```

3. **Escreva Mensagens de Log:**
   ```java
   // Chame o método write para registrar uma mensagem
   String nomeArquivoLog = "exemploLog";
   String mensagemLog = "Esta é uma mensagem de log.";
   logger.write(nomeArquivoLog, mensagemLog);
   ```

4. **Notas Adicionais:**
   - Personalize o nome do arquivo de log conforme necessário.
   - Certifique-se de ter as permissões adequadas para ler e escrever arquivos no dispositivo.