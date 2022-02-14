package lib.gui;

import javax.swing.*;

import lib.util.exception.ExistenceException;
import lib.util.exception.ForbiddenActionException;
import lib.rental_video_member.MembersList;

import java.awt.*;

public class MemberWithdrawalField {
    public MemberWithdrawalField(JTextArea referenceToResultField, MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Member Withdrawal");
        this.userName = new JTextField("user ID");
        this.button = new JButton("Withdraw");
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
            String resultStatus = "Member Withdrawal...\n\n";
            String inputText = userName.getText();
            if (inputText.equals("user ID")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input user ID into the blank.\n"
                        + "\t  (Hint : user ID is some kind of integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            int id = 0;
            try {
                id = Integer.parseInt(inputText);
            } catch (NumberFormatException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input text could not be parsed to integer.\n";
                resultStatus += "\t [Instruction] Please input user ID into the blank.\n"
                        + "\t  (Hint : user ID is some kind of integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            try {
                members.withdraw(id);
            } catch (ExistenceException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] " + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input user ID into the left blank.\n"
                        + "\t  (Hint : user ID is some kind of integer.)\n"
                        + "\t   Why don't you check the current information of the member?)\n";
                resultField.setText(resultStatus);
                return;
            } catch (ForbiddenActionException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] " + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input user ID into the left blank.\n"
                        + "\t  (Hint : user ID is some kind of integer.)\n"
                        + "\t   Why don't you check the current information of the member?)\n";
                resultField.setText(resultStatus);
                return;
            }
            resultStatus += "\t The operation has been completed successfully.\n\n";
            resultField.setText(resultStatus);
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
