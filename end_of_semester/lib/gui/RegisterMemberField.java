package lib.gui;

import javax.swing.*;

import lib.util.exception.ExistenceException;
import lib.rental_video_member.MembersList;
import lib.rental_video_member.RentalVideoMember;

import java.awt.*;

public class RegisterMemberField {
    public RegisterMemberField(JTextArea referenceToResultField, MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Member Registration");
        this.userName = new JTextField("username");
        this.button = new JButton("Register");
        this.resultField = referenceToResultField;
        this.members = referenceToMembers;

        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        subPane.setLayout(new GridLayout(0, 1));

        pane.add(fieldTitle);
        subPane.add(userName);
        subPane.add(button);
        pane.add(subPane);

        // action
        button.addActionListener((e) -> {
            String resultStatus = "Member registration...\n\n";

            // check the input
            String inputText = userName.getText();
            if (inputText.equals("username")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input new username into the blank.\n"
                        + "\t  (Hint : username is some kind of character string,\n"
                        + "\t   and username can be duplicated, because ID would be provided.)\n";
                resultField.setText(resultStatus);
                return;
            }

            // process
            try {
                int providedId = members.registerMember(inputText);
                RentalVideoMember member = members.searchById(providedId);
                resultStatus += "\t The operation has been completed successfully.\n\n";
                resultStatus += "\t < Registered information >\n";
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
                // this exception mustn't occurs here.
                System.err.println(error.getMessage());
            }
        });
    }

    /// fields
    public JPanel pane;
    public JPanel subPane;
    public final JLabel fieldTitle;
    public JTextArea resultField; // this field references the JTextArea object declared at other place.
    public JTextField userName;
    public JButton button;

    public MembersList members; // this field references the Members object declared at other place.
}
