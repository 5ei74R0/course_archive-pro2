package lib.gui;

import javax.swing.*;
import java.awt.*;

import lib.util.exception.ExistenceException;
import lib.video.VideoArchive;
import lib.video.Video;
import lib.rental_video_member.MembersList;

public class AddVideoStockField {
    public AddVideoStockField(JTextArea referenceToResultField, VideoArchive referenceToVideoArchive,
            MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Add the Video Stock");
        this.videoTitle = new JTextField("video title");
        this.numOfVideo = new JTextField("1");
        this.button = new JButton("Go");
        this.resultField = referenceToResultField;
        this.videoArchive = referenceToVideoArchive;
        this.members = referenceToMembers;

        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        subPane.setLayout(new GridLayout(0, 2));

        pane.add(fieldTitle);
        subPane.add(videoTitle);
        subPane.add(numOfVideo);
        pane.add(subPane);
        pane.add(button);

        // action
        button.addActionListener((e) -> {
            String resultStatus = "Add video stock...\n\n";

            // check the input
            int num = 1;
            try {
                num = Integer.parseInt(numOfVideo.getText());
            } catch (NumberFormatException error) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input text could not be parsed to integer.\n";
                resultStatus += "\t [Instruction] Please input some kind of title into the left blank\n"
                        + "\t and number of additional videos into the right blank.\n"
                        + "\t  (Hint : title is some kind of character string,\n"
                        + "\t   and number of additional videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            if (num < 0) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] Input number is not a positive integer.\n";
                resultStatus += "\t [Instruction] Please input some kind of title into the left blank\n"
                        + "\t and number of additional videos into the right blank.\n"
                        + "\t  (Hint : title is some kind of character string,\n"
                        + "\t   and number of additional videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            String inputText = videoTitle.getText();
            if (inputText.equals("video title")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input some kind of title into the left blank\n"
                        + "\t and number of additional videos into the right blank.\n"
                        + "\t  (Hint : title is some kind of character string,\n"
                        + "\t   and number of additional videos is some kind of positive integer.)\n";
                resultField.setText(resultStatus);
                return;
            }
            videoArchive.addVideo(inputText, num);
            try {
                resultStatus += "\t The operation has been completed successfully.\n\n";
                Video video = videoArchive.getVideo(inputText);
                resultStatus += "\t < Information of the added video >\n";
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
    public JTextField videoTitle;
    public JTextField numOfVideo;
    public JButton button;

    public VideoArchive videoArchive; // this field references the VideoArchive object declared at other place.
    public MembersList members; // this field references the MembersList object declared at other place.
}
