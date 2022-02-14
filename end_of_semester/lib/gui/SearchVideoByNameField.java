package lib.gui;

import javax.swing.*;
import java.awt.*;

import lib.util.exception.ExistenceException;
import lib.video.VideoArchive;
import lib.video.Video;
import lib.rental_video_member.MembersList;

public class SearchVideoByNameField {
    public SearchVideoByNameField(JTextArea referenceToResultField, VideoArchive referenceToVideoArchive,
            MembersList referenceToMembers) {
        this.pane = new JPanel();
        this.subPane = new JPanel();
        this.fieldTitle = new JLabel("Search Video by Title");
        this.videoTitle = new JTextField("video title");
        this.button = new JButton("Search");
        this.resultField = referenceToResultField;
        this.videoArchive = referenceToVideoArchive;
        this.members = referenceToMembers;

        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.setLayout(new GridLayout(0, 1));
        subPane.setLayout(new GridLayout(0, 1));

        pane.add(fieldTitle);
        subPane.add(videoTitle);
        subPane.add(button);
        pane.add(subPane);

        // action
        button.addActionListener((e) -> {
            String resultStatus = "Searching the video by the title...\n\n";
            String inputText = videoTitle.getText();
            // check the input
            if (inputText.equals("video title")) {
                resultStatus += "\t ERROR : The operation has not been done.\n\n"
                        + "\t [Inferred Reason] No input was detected.\n";
                resultStatus += "\t [Instruction] Please input title of the video.\n"
                        + "\t  (Hint : title is some kind of character string.)\n";
                resultField.setText(resultStatus);
                return;
            }
            // process
            try {
                Video video;
                video = videoArchive.getVideo(inputText);
                resultStatus += "\t The operation has been completed successfully.\n\n";
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
                resultStatus += "\t ERROR : The operation has not been done.\n\n" + "\t [Inferred Reason] "
                        + error.getMessage() + "\n";
                resultStatus += "\t [Instruction] Please input existing video-title.\n"
                        + "\t  (Hint : title is some kind of character string.)\n";
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
    public JButton button;

    public VideoArchive videoArchive; // this field references the VideoArchive object declared at other place.
    public MembersList members; // this field references the MembersList object declared at other place.
}
