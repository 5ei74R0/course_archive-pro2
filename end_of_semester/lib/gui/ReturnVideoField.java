package lib.gui;

import javax.swing.*;
import java.awt.*;

import lib.util.exception.ExistenceException;
import lib.util.exception.ForbiddenActionException;
import lib.rental_video_member.MembersList;
import lib.rental_video_member.RentalVideoMember;
import lib.video.VideoArchive;
import lib.video.Video;

public class ReturnVideoField {
    public ReturnVideoField(JTextArea referenceToResultField, VideoArchive referenceToVideoArchive,
            MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Return the Video");
        this.videoTitle = new JTextField("video title");
        this.userId = new JTextField("user ID");
        this.numOfVideo = new JTextField("1");
        this.button = new JButton("Go");
        this.resultField = referenceToResultField;
        this.resultField = referenceToResultField;
        this.videoArchive = referenceToVideoArchive;
        this.members = referenceToMembers;

        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        subPane.setLayout(new GridLayout(0, 2));

        pane.add(fieldTitle);
        subPane.add(videoTitle);
        subPane.add(userId);
        subPane.add(numOfVideo);
        subPane.add(button);
        pane.add(subPane);

        // action
        button.addActionListener((e) -> {
            String resultStatus = "Return the video...\n\n";

            // check the input
            int num = 1;
            try {
                num = Integer.parseInt(numOfVideo.getText());
            } catch (NumberFormatException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input text could not be parsed to integer.\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of additional videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            if (num < 0) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input number is not positive.\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of additional videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            String inputTitle = videoTitle.getText();
            if (inputTitle.equals("video title")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            if (userId.getText().equals("user ID")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            int inputUserId = 0;
            try {
                inputUserId = Integer.parseInt(userId.getText());
            } catch (NumberFormatException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input text could not be parsed to integer.\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }

            // process
            try {
                RentalVideoMember member = members.searchById(inputUserId);
                videoArchive.returnVideo(inputUserId, inputTitle, num);
                member.returnVideo(inputTitle, num);
                Video video = videoArchive.getVideo(inputTitle);
                resultStatus += "\t The operation has been completed successfully.\n\n";
                resultStatus += "\t < Information of the returned video >\n";
                resultStatus += "\t [Title] " + video.title + "\n";
                resultStatus += "\t [stock] " + video.getStockStatus() + "\n";
                resultStatus += "\t [borrowers]\n";
                if (video.getBorrowerList().isEmpty()) {
                    resultStatus += "\t - no borrower.\n\n";
                } else {
                    for (var pair : video.getBorrowerList()) {
                        try {
                            resultStatus += "\t - [user ID] " + members.searchById(pair.first).getFormattedId()
                                    + ", [username] " + members.searchById(pair.first).name + ", [number of videos] "
                                    + Integer.toString(pair.second) + "\n\n";
                        } catch (ExistenceException error) {
                            // this exception mustn't occurs here.
                            System.err.println(error.getMessage());
                        }
                    }
                }
                resultStatus += "\t < borrower's current status >\n";
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
                resultStatus += "\t ERROR : The operation has not been done.\n\n" + "\t [Inferred Reason] "
                        + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of videos is some kind of positive integer.\n"
                        + "\t   Why don't you check the current information of the video and member?)";
                resultField.setText(resultStatus);
            } catch (ForbiddenActionException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n" + "\t [Inferred Reason] "
                        + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input some kind of video title into the left blank\n"
                        + "\t , and user ID of borrower into the right blank.\n"
                        + "\t , and number of videos into the bottom blank.\n"
                        + "\t  (Hint : video title is some kind of character string,\n"
                        + "\t   and user ID is some kind of integer,\n"
                        + "\t   and number of videos is some kind of positive integer.\n"
                        + "\t   Why don't you check the current information of the video and member?)";
                resultField.setText(resultStatus);
            }
        });
    }

    /// fields
    public JPanel pane;
    public JPanel subPane;
    public final JLabel fieldTitle;
    public JTextArea resultField; // this field references the JTextArea object declared at other place.
    public JTextField videoTitle;
    public JTextField userId;
    public JTextField numOfVideo;
    public JButton button;

    public VideoArchive videoArchive; // this field references the VideoArchive object declared at other place.
    public MembersList members; // this field references the Members object declared at other place.
}
