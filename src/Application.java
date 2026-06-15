void main() throws IOException {

    System.out.println("Hola usil");
    Editor editor = new Editor();

    LoggingListener logger = new LoggingListener("log.txt", "Hola Logging");
    editor.events.subscribe("open", logger);

    EmailAlertsListener emailAlerts = new EmailAlertsListener("rjru@gmail.com", "Esto debe cambiar");
    editor.events.subscribe("save", emailAlerts);

    editor.openFile("C:/Users/rjru/Documents/PatronObserver/doc.txt");
    editor.saveFile();
    editor.openFile("C:/Users/rjru/Documents/PatronObserver/doc.txt");
    editor.saveFile();

}
