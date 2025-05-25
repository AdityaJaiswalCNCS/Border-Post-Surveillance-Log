import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BorderLogGUI {
    public static void main(String[] args) {
        // Login frame (unchanged)
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

        // Login button action (unchanged)
        loginButton.addActionListener(e -> {
            String enteredUserId = userField.getText().trim();
            String enteredPassword = new String(passwordField.getPassword()).trim();

            if ("DEFENCE".equals(enteredUserId) && "123".equals(enteredPassword)) {
                loginFrame.setVisible(false);
                openMainApplication();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "❌ Invalid ID or Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static void openMainApplication() {
        JFrame frame = new JFrame("🇮🇳 BORDER POST SURVEILLANCE LOG");
        frame.setSize(1300, 800); // Wider window for side-by-side layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with tricolor background
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                
                // Saffron (top third)
                g2d.setColor(new Color(255, 153, 51));
                g2d.fillRect(0, 0, getWidth(), getHeight()/3);
                
                // White (middle third)
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, getHeight()/3, getWidth(), getHeight()/3);
                
                // Green (bottom third)
                g2d.setColor(new Color(19, 136, 8));
                g2d.fillRect(0, 2*(getHeight()/3), getWidth(), getHeight()/3);
                
                // Ashoka Chakra (blue wheel)
                int centerX = getWidth()/2;
                int centerY = getHeight()/2;
                int radius = 50;
                g2d.setColor(new Color(0, 56, 147));
                g2d.fillOval(centerX-radius, centerY-radius, 2*radius, 2*radius);
                
                // Spokes
                g2d.setColor(Color.WHITE);
                for(int i=0; i<24; i++) {
                    double angle = Math.PI * i / 12;
                    int x2 = centerX + (int)(radius * Math.sin(angle));
                    int y2 = centerY - (int)(radius * Math.cos(angle));
                    g2d.drawLine(centerX, centerY, x2, y2);
                }
            }
        };
        bgPanel.setLayout(new BorderLayout());
        frame.add(bgPanel);

        // Input form panel (left side)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBackground(new Color(30, 30, 30, 200)); // Semi-transparent dark
        inputPanel.setPreferredSize(new Dimension(600, 750));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Output panel (right side)
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBackground(new Color(255, 255, 255, 150)); // Semi-transparent white
        outputPanel.setPreferredSize(new Dimension(650, 750));
        outputPanel.setBorder(BorderFactory.createCompoundBorder(
    BorderFactory.createLineBorder(new Color(0, 56, 147)),
    BorderFactory.createEmptyBorder(10, 10, 10, 10)
));


        // National Emblem image
        try {
            ImageIcon emblemIcon = new ImageIcon("emblem.png");
            JLabel emblemLabel = new JLabel(emblemIcon);
            emblemLabel.setBounds(1250, 10, 64, 64);
            bgPanel.add(emblemLabel, BorderLayout.NORTH);
        } catch (Exception ex) {
            System.out.println("Emblem not found.");
        }

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
        postField.setBounds(230, 20, 350, 25);
        timeLabel.setBounds(20, 60, 250, 25);
        timeField.setBounds(230, 60, 350, 25);
        descLabel.setBounds(20, 100, 250, 25);
        descArea.setBounds(230, 100, 350, 60);
        officerNameLabel.setBounds(20, 180, 200, 25);
        officerNameField.setBounds(230, 180, 350, 25);
        officerIdLabel.setBounds(20, 220, 200, 25);
        officerIdField.setBounds(230, 220, 350, 25);
        locationLabel.setBounds(20, 260, 200, 25);
        locationField.setBounds(230, 260, 350, 25);
        weatherLabel.setBounds(20, 300, 200, 25);
        weatherField.setBounds(230, 300, 350, 25);
        witnessLabel.setBounds(20, 340, 200, 25);
        witnessField.setBounds(230, 340, 350, 25);
        vehicleLabel.setBounds(20, 380, 200, 25);
        vehicleField.setBounds(230, 380, 350, 25);
        vehicleIdLabel.setBounds(20, 420, 200, 25);
        vehicleIdField.setBounds(230, 420, 350, 25);

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
            inputPanel.add(label);
        }

        // Add components
        JComponent[] fields = {
            postField, timeField, officerNameField, officerIdField,
            locationField, weatherField, witnessField, vehicleField,
            vehicleIdField, descArea
        };

        for (JComponent field : fields) {
            field.setBackground(new Color(46, 46, 46));
            field.setForeground(textColor);
            field.setFont(new Font("Arial", Font.PLAIN, 13));
            field.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 51))); // Saffron border
            inputPanel.add(field);
        }

        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setBorder(BorderFactory.createLineBorder(new Color(255, 153, 51)));

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

        // Buttons with tricolor styling
        JButton addButton = createTricolorButton("➕ Add Log");
        JButton viewButton = createTricolorButton("📖 View Logs");
        JButton deleteButton = createTricolorButton("🗑 Delete Log");
        JButton modifyButton = createTricolorButton("✏ Modify Log");
        JButton searchButton = createTricolorButton("🔍 Search Logs");
        
        addButton.setBounds(50, 480, 120, 30);
        viewButton.setBounds(180, 480, 120, 30);
        deleteButton.setBounds(310, 480, 120, 30);
        modifyButton.setBounds(50, 520, 120, 30);
        searchButton.setBounds(180, 520, 120, 30);
        
        inputPanel.add(addButton);
        inputPanel.add(viewButton);
        inputPanel.add(deleteButton);
        inputPanel.add(modifyButton);
        inputPanel.add(searchButton);

        // Output area
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(17, 17, 17));
        outputArea.setForeground(new Color(0, 255, 0)); // Green text
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(19, 136, 8))); // Green border
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add both panels to the main frame
        bgPanel.add(inputPanel, BorderLayout.WEST);
        bgPanel.add(outputPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        // Action listeners (same as before)
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
                clearFields(postField, timeField, descArea, officerNameField, officerIdField, locationField, weatherField, witnessField, vehicleField, vehicleIdField);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        viewButton.addActionListener(e -> {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM logs");
                outputArea.setText("");
                while (rs.next()) {
                    outputArea.append("ID: " + rs.getInt("id") + "\n");
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

        deleteButton.addActionListener(e -> {
            String logId = JOptionPane.showInputDialog(frame, "Enter Log ID to delete:");
            if (logId == null || logId.trim().isEmpty()) {
                return;
            }

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM logs WHERE id = ?");
                ps.setInt(1, Integer.parseInt(logId));
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "✅ Log deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    viewButton.doClick();
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ No log found with ID: " + logId, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Please enter a valid numeric ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        modifyButton.addActionListener(e -> {
            String logId = JOptionPane.showInputDialog(frame, "Enter Log ID to modify:");
            if (logId == null || logId.trim().isEmpty()) {
                return;
            }

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM logs WHERE id = ?");
                ps.setInt(1, Integer.parseInt(logId));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    postField.setText(rs.getString("post_name"));
                    timeField.setText(rs.getString("incident_time"));
                    descArea.setText(rs.getString("description"));
                    officerNameField.setText(rs.getString("officer_name"));
                    officerIdField.setText(rs.getString("officer_id"));
                    locationField.setText(rs.getString("location"));
                    weatherField.setText(rs.getString("weather_condition"));
                    witnessField.setText(rs.getString("witness_name"));
                    vehicleField.setText(rs.getString("vehicle_number"));
                    vehicleIdField.setText(rs.getString("vehicle_id"));

                    addButton.setText("🔄 Update Log");
                    addButton.removeActionListener(addButton.getActionListeners()[0]);
                    addButton.addActionListener(ev -> {
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

                        try (Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                            PreparedStatement ps2 = con2.prepareStatement(
                                    "UPDATE logs SET post_name=?, incident_time=?, description=?, officer_name=?, officer_id=?, location=?, weather_condition=?, witness_name=?, vehicle_number=?, vehicle_id=? WHERE id=?");
                            ps2.setString(1, post);
                            ps2.setString(2, time);
                            ps2.setString(3, desc);
                            ps2.setString(4, officerName);
                            ps2.setString(5, officerId);
                            ps2.setString(6, location);
                            ps2.setString(7, weather);
                            ps2.setString(8, witness);
                            ps2.setString(9, vehicle);
                            ps2.setString(10, vehicleId);
                            ps2.setInt(11, Integer.parseInt(logId));
                            ps2.executeUpdate();
                            
                            JOptionPane.showMessageDialog(frame, "✅ Log updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            clearFields(postField, timeField, descArea, officerNameField, officerIdField, locationField, weatherField, witnessField, vehicleField, vehicleIdField);
                            
                            addButton.setText("➕ Add Log");
                            addButton.removeActionListener(addButton.getActionListeners()[0]);
                            addButton.addActionListener(addButton.getActionListeners()[0]);
                            
                            viewButton.doClick();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(frame, "❌ Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(frame, "❌ No log found with ID: " + logId, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "❌ Please enter a valid numeric ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        searchButton.addActionListener(e -> {
            String searchTerm = JOptionPane.showInputDialog(frame, "Enter search term (Post Name, Officer Name, Vehicle Number, etc.):");
            if (searchTerm == null || searchTerm.trim().isEmpty()) {
                return;
            }

            searchTerm = "%" + searchTerm.trim().toUpperCase() + "%";
            
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/border_security", "root", "")) {
                PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM logs WHERE " +
                    "UPPER(post_name) LIKE ? OR " +
                    "UPPER(officer_name) LIKE ? OR " +
                    "UPPER(vehicle_number) LIKE ? OR " +
                    "UPPER(vehicle_id) LIKE ? OR " +
                    "UPPER(location) LIKE ? OR " +
                    "UPPER(witness_name) LIKE ?");
                
                for (int i = 1; i <= 6; i++) {
                    ps.setString(i, searchTerm);
                }
                
                ResultSet rs = ps.executeQuery();
                outputArea.setText("");
                
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    outputArea.append("ID: " + rs.getInt("id") + "\n");
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
                
                if (!found) {
                    outputArea.setText("No logs found matching: " + searchTerm.replace("%", ""));
                }
            } catch (SQLException ex) {
                outputArea.setText("❌ Error: " + ex.getMessage());
            }
        });
    }

    private static JButton createTricolorButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                
                // Saffron (top)
                g2.setColor(new Color(255, 153, 51));
                g2.fillRect(0, 0, getWidth(), getHeight()/3);
                
                // White (middle)
                g2.setColor(Color.WHITE);
                g2.fillRect(0, getHeight()/3, getWidth(), getHeight()/3);
                
                // Green (bottom)
                g2.setColor(new Color(19, 136, 8));
                g2.fillRect(0, 2*(getHeight()/3), getWidth(), getHeight()/3);
                
                g2.dispose();
                
                super.paintComponent(g);
            }
        };
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 56, 147), 2));
        return button;
    }

    private static void clearFields(JTextField postField, JTextField timeField, JTextArea descArea,
                                  JTextField officerNameField, JTextField officerIdField, JTextField locationField,
                                  JTextField weatherField, JTextField witnessField, JTextField vehicleField,
                                  JTextField vehicleIdField) {
        postField.setText("");
        timeField.setText("");
        descArea.setText("");
        officerNameField.setText("");
        officerIdField.setText("");
        locationField.setText("");
        weatherField.setText("");
        witnessField.setText("");
        vehicleField.setText("");
        vehicleIdField.setText("");
    }
}
