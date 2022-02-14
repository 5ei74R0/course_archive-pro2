package lib.gui;

import javax.swing.*;

import lib.util.exception.ExistenceException;
import lib.rental_video_member.RentalVideoMember;
import lib.rental_video_member.MembersList;

import java.awt.*;

public class SearchMemberByIdField {
    public SearchMemberByIdField(JTextArea referenceToResultField, MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Search Member by User ID");
        this.userId = new JTextField("user ID");
        this.button = new JButton("Search");
        this.resultField = referenceToResultField;
        this.members = referenceToMembers;

        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        subPane.setLayout(new GridLayout(0, 1));

        pane.add(fieldTitle);
        subPane.add(userId);
        subPane.add(button);
        pane.add(subPane);

        // action
        button.addActionListener((e) -> {
            String resultStatus = "Searching the member by ID...\n\n";

            // check the input
            String inputText = userId.getText();
            if (inputText.equals("user ID")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input some ID.\n"
                        + "\t  (Hint : ID is some kind of integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            int id = 0;
            try {
                id = Integer.parseInt(inputText);
            } catch (NumberFormatException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input text could not be parsed to integer.\n";
                resultStatus += "\t [Instruction] Please input some ID.\n"
                        + "\t  (Hint : ID is some kind of integer.)\n";
                resultField.setText(resultStatus);
                return;
            }

            // process
            try {
                RentalVideoMember member = members.searchById(id);
                resultStatus += "\t The operation has been completed successfully.\n\n";
                resultStatus += "\t [username] " + member.name + "\n";
                resultStatus += "\t [user ID ] " + member.getFormattedId() + "\n";
                resultStatus += "\t [Holding Videos]\n";
                if (member.getVideoList().isEmpty()) {
                    resultStatus += "\t - no video has been borrowed.\n\n";
                } else {
                    for (var pair : member.getVideoList()) {
                        resultStatus += "\t - [title] " + pair.first + ", [number of videos] "
                                + Integer.toString(pair.second) + "\n\n";
                    }
                }
                resultField.setText(resultStatus);
            } catch (ExistenceException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] " + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input existing ID.\n"
                        + "\t (Hint : You can also search the member by username, and this way may be comfortable to you!\n"
                        + "\t  Do you really have to search by ID instead of username?)\n";
                resultField.setText(resultStatus);
            }
        });
    }

    /// fields
    public JPanel pane;
    public JPanel subPane;
    public final JLabel fieldTitle;
    public JTextArea resultField; // this field references the JTextArea object declared at other place.
    public JTextField userId;
    public JButton button;

    public MembersList members; // this field references the Members object declared at other place.
}
