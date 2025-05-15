import javax.swing.*;
import javax.swing.text.JTextComponent; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BorderLogGUI {
    public static void main(String[] args) {
        // Login frame
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("User ID:");
        JTextField userField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());  // Empty cell
        loginPanel.add(loginButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

        // Login button action
        loginButton.addActionListener(e -> {
            String enteredUserId = userField.getText().trim();
            String enteredPassword = new String(passwordField.getPassword()).trim();

            // Check if the ID and password are correct
            if ("DEFENCE".equals(enteredUserId) && "123".equals(enteredPassword)) {
                // Close login frame and open main application
                loginFrame.setVisible(false);
                openMainApplication();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "❌ Invalid ID or Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Main application
    private static void openMainApplication() {
        JFrame frame = new JFrame("🇮🇳 BORDER POST SURVEILLANCE LOG");
        frame.setSize(700, 820);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tricolor background panel
        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, Color.decode("#FF9933"), 0, getHeight() / 2, Color.WHITE);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight() / 2);

                GradientPaint gp2 = new GradientPaint(0, getHeight() / 2, Color.WHITE, 0, getHeight(), Color.decode("#138808"));
                g2.setPaint(gp2);
                g2.fillRect(0, getHeight() / 2, getWidth(), getHeight());
            }
        };
        bgPanel.setLayout(null);
        bgPanel.setBounds(0, 0, 700, 820);
        frame.add(bgPanel);

        // National Emblem image
        try {
            ImageIcon emblemIcon = new ImageIcon("emblem.png");
            JLabel emblemLabel = new JLabel(emblemIcon);
            emblemLabel.setBounds(600, 10, 64, 64);
            bgPanel.add(emblemLabel);
        } catch (Exception ex) {
            System.out.println("Emblem not found.");
        }

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#1e1e1e"));
        panel.setBounds(30, 30, 620, 480);
        bgPanel.add(panel);

        // Labels and fields
        JLabel postLabel = new JLabel("Post Name:");
        JLabel timeLabel = new JLabel("Time (YYYY-MM-DD HH:MM:SS):");
        JLabel descLabel = new JLabel("Incident Description:");
        JLabel officerNameLabel = new JLabel("Officer Name:");
        JLabel officerIdLabel = new JLabel("Officer ID:");
        JLabel locationLabel = new JLabel("Location:");
        JLabel weatherLabel = new JLabel("Weather Condition:");
        JLabel witnessLabel = new JLabel("Witness Name:");
        JLabel vehicleLabel = new JLabel("Vehicle Number:");
        JLabel vehicleIdLabel = new JLabel("Vehicle ID:");

        JTextField postField = new JTextField();
        JTextField timeField = new JTextField();
        JTextArea descArea = new JTextArea();
        JTextField officerNameField = new JTextField();
        JTextField officerIdField = new JTextField();
        JTextField locationField = new JTextField();
        JTextField weatherField = new JTextField();
        JTextField witnessField = new JTextField();
        JTextField vehicleField = new JTextField();
        JTextField vehicleIdField = new JTextField();

        // Set positions
        postLabel.setBounds(20, 20, 200, 25);
        postField.setBounds(230, 20, 360, 25);
        timeLabel.setBounds(20, 60, 250, 25);
        timeField.setBounds(230, 60, 360, 25);
        descLabel.setBounds(20, 100, 250, 25);
        descArea.setBounds(230, 100, 360, 60);
        officerNameLabel.setBounds(20, 180, 200, 25);
        officerNameField.setBounds(230, 180, 360, 25);
        officerIdLabel.setBounds(20, 220, 200, 25);
        officerIdField.setBounds(230, 220, 360, 25);
        locationLabel.setBounds(20, 260, 200, 25);
        locationField.setBounds(230, 260, 360, 25);
        weatherLabel.setBounds(20, 300, 200, 25);
        weatherField.setBounds(230, 300, 360, 25);
        witnessLabel.setBounds(20, 340, 200, 25);
        witnessField.setBounds(230, 340, 360, 25);
        vehicleLabel.setBounds(20, 380, 200, 25);
        vehicleField.setBounds(230, 380, 360, 25);
        vehicleIdLabel.setBounds(20, 420, 200, 25);
        vehicleIdField.setBounds(230, 420, 360, 25);

        // Label styles
        Font labelFont = new Font("Arial", Font.BOLD, 13);
        Color textColor = Color.WHITE;

        JLabel[] labels = {
            postLabel, timeLabel, descLabel, officerNameLabel, officerIdLabel,
            locationLabel, weatherLabel, witnessLabel, vehicleLabel, vehicleIdLabel
        };

        for (JLabel label : labels) {
            label.setForeground(textColor);
            label.setFont(labelFont);
            panel.add(label);
        }

        // Add components
        JComponent[] fields = {
            postField, timeField, officerNameField, officerIdField,
            locationField, weatherField, witnessField, vehicleField,
            vehicleIdField, descArea
        };

        for (JComponent field : fields) {
            field.setBackground(Color.decode("#2e2e2e"));
            field.setForeground(textColor);
            field.setFont(new Font("Arial", Font.PLAIN, 13));
            panel.add(field);
        }

        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);

        // Auto-uppercase
        KeyAdapter upperCaseAdapter = new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextComponent tc = (JTextComponent) e.getSource();
                tc.setText(tc.getText().toUpperCase());
            }
        };
        JTextComponent[] upperFields = {
            postField, timeField, descArea, officerNameField, officerIdField,
            locationField, weatherField, witnessField, vehicleField, vehicleIdField
        };
        for (JTextComponent comp : upperFields) {
            comp.addKeyListener(upperCaseAdapter);
        }

        // Buttons
        JButton addButton = new JButton("➕ Add Log");
        JButton viewButton = new JButton("📖 View Logs");
        addButton.setBounds(150, 460, 140, 25);
        viewButton.setBounds(320, 460, 140, 25);
        panel.add(addButton);
        panel.add(viewButton);

        // Output area
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(Color.decode("#111111"));
        outputArea.setForeground(Color.GREEN);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(30, 530, 620, 250);
        bgPanel.add(scrollPane);

        frame.setVisible(true);

        // Add log
        addButton.addActionListener(e -> {
            String post = postField.getText().trim();
            String time = timeField.getText().trim();
            String desc = descArea.getText().trim();
            String officerName = officerNameField.getText().trim();
            String officerId = officerIdField.getText().trim();
            String location = locationField.getText().trim();
            String weather = weatherField.getText().trim();
            String witness = witnessField.getText().trim();
            String vehicle = vehicleField.getText().trim();
            String vehicleId = vehicleIdField.getText().trim();

            if (post.isEmpty() || time.isEmpty() || desc.isEmpty() || officerName.isEmpty() || officerId.isEmpty()
                    || location.isEmpty() || weather.isEmpty() || witness.isEmpty() || vehicle.isEmpty() || vehicleId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "❌ All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO logs(post_name, incident_time, description, officer_name, officer_id, location, weather_condition, witness_name, vehicle_number, vehicle_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, post);
                ps.setString(2, time);
                ps.setString(3, desc);
                ps.setString(4, officerName);
                ps.setString(5, officerId);
                ps.setString(6, location);
                ps.setString(7, weather);
                ps.setString(8, witness);
                ps.setString(9, vehicle);
                ps.setString(10, vehicleId);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(frame, "✅ Log added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // View logs
        viewButton.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM logs");
                outputArea.setText("");
                while (rs.next()) {
                    outputArea.append("🛡 POST: " + rs.getString("post_name") + "\n");
                    outputArea.append("⏰ TIME: " + rs.getString("incident_time") + "\n");
                    outputArea.append("📜 DESC: " + rs.getString("description") + "\n");
                    outputArea.append("🚔 OFFICER: " + rs.getString("officer_name") + " (ID: " + rs.getString("officer_id") + ")\n");
                    outputArea.append("📍 LOCATION: " + rs.getString("location") + "\n");
                    outputArea.append("🌤 WEATHER: " + rs.getString("weather_condition") + "\n");
                    outputArea.append("👁‍🗨 WITNESS: " + rs.getString("witness_name") + "\n");
                    outputArea.append("🚗 VEHICLE: " + rs.getString("vehicle_number") + " | ID: " + rs.getString("vehicle_id") + "\n");
                    outputArea.append("------------------------------------------------------\n");
                }
            } catch (SQLException ex) {
                outputArea.setText("❌ Error: " + ex.getMessage());
            }
        });
    }
}
