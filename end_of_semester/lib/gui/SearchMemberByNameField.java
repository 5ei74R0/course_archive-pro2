package lib.gui;

import javax.swing.*;

import lib.util.exception.ExistenceException;
import lib.rental_video_member.RentalVideoMember;
import lib.rental_video_member.MembersList;

import java.awt.*;
import java.util.ArrayList;

public class SearchMemberByNameField {
    public SearchMemberByNameField(JTextArea referenceToResultField, MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Search Member by UserName");
        this.userName = new JTextField("username");
        this.button = new JButton("Search");
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
            String resultStatus = "Searching the member by username...\n\n";
            String inputText = userName.getText();
            if (inputText.equals("username")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input some username.\n"
                        + "\t  (Hint : username is some kind of character string.)\n";
                resultField.setText(resultStatus);
                return;
            }
            try {
                ArrayList<RentalVideoMember> memberList = members.searchByName(inputText);
                resultStatus += "\t The operation has been completed successfully.\n\n";
                for (var member : memberList) {
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
                }
                resultField.setText(resultStatus);
            } catch (ExistenceException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n" + "\t [Inferred Reason] "
                        + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input existing username.\n"
                        + "\t (Hint : You can also search the member by ID, and this way may be comfortable to you!\n"
                        + "\t  Do you really have to search by username instead of ID?)\n";
                resultField.setText(resultStatus);
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
