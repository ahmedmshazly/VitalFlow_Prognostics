package main.java.control;

import main.java.entities.User;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private Map<String, User> activeSessions = new HashMap<>();

    public void startSession(String email, User user) {
        activeSessions.clear(); // Ensure only one session is active at a time
        activeSessions.put(email, user);
        System.out.println("Session started for: " + email);
    }

    public void endSession() {
        if (!activeSessions.isEmpty()) {
            String email = activeSessions.keySet().iterator().next(); // Get the first (and only) key
            System.out.println("Session ended for: " + email);
            activeSessions.remove(email);
        } else {
            System.out.println("No active session to end.");
        }
    }

    public boolean isAnySessionActive() {
        return !activeSessions.isEmpty();
    }

    public User getUserFromSession(String email) {
        return activeSessions.get(email);
    }
}
