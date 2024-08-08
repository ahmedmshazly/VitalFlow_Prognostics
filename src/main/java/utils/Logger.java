import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private String logFilePath;
    private String task;
    private String logType;
    private String message;
    private String timestamp;

    public Logger(String logFilePath, String task, String logType, String message) {
        this.logFilePath = logFilePath;
        this.task = task;
        this.logType = logType;
        this.message = message;
        updateTimestamp();
    }

    //getters
    public String getLogFilePath() {
        return this.logFilePath;
    }

    public String getTask() {
        return this.task;
    }

    public String getLogType() {
        return this.logType;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getMessage(){
        return this.message;
    }

    //setters
    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public void setMessage(String message){
        this.message = message;
    }

    //other methods
    private void updateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    //method to write log messages to log file 
    private void writeLogMessage(String logFilePath, String logType, String message) {//logttype can be ERROR/WARNING/SUCCESS
        updateTimestamp();
        String logMessage = String.format("%s, %s, %s, %s", this.timestamp, this.task, logType, message);

        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(logMessage + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    
    }

    public static void main(String[] args) {
        Logger logger = new Logger("logs.txt", "User registration", "SUCCESS", "Registration successful");
        logger.writeLogMessage(logger.getLogFilePath(),logger.getLogType(),logger.getMessage());
    }
}