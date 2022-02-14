import javax.swing.*;
import java.awt.*;

import lib.video.VideoArchive;
import lib.gui.*;
import lib.rental_video_member.MembersList;

// main process of rental video system
public class RentalVideoSystem {
    public RentalVideoSystem() {
        this.videoArchive = new VideoArchive();
        this.members = new MembersList();
    }

    /// fields
    private VideoArchive videoArchive;
    private MembersList members;

    // parts
    private SearchMemberByIdField searchMemberByIdField;
    private SearchMemberByNameField searchMemberByNameField;
    private SearchVideoByNameField searchVideoByNameField;
    private LendVideoField lendVideoField;
    private ReturnVideoField returnVideoField;
    private AddVideoStockField addVideoStockField;
    private ReduceVideoStockField reduceVideoStockField;
    private RegisterMemberField registerMemberField;
    private MemberWithdrawalField memberWithdrawalField;

    public Component createComponents() {
        // position
        var mainPane = new JPanel();
        mainPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPane.setLayout(new GridLayout(0, 1));

        // query field
        var queryField = new JPanel();
        queryField.setLayout(new GridLayout(3, 3));

        // result field
        var resultFieldWrapper = new JPanel();
        resultFieldWrapper.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        resultFieldWrapper.setLayout(new GridLayout(1, 1));
        var resultField = new JTextArea();
        resultField.setText("The result of each query would be rendered here.\n"
                + "you can edit this area, but rewriting this area makes no effect to the system.");
        var resultFieldScrollablePane = new JScrollPane(resultField);
        resultFieldScrollablePane.createHorizontalScrollBar();
        resultFieldScrollablePane.createVerticalScrollBar();
        resultFieldScrollablePane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        resultFieldScrollablePane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        resultFieldWrapper.add(resultFieldScrollablePane);

        // search member by name
        searchMemberByNameField = new SearchMemberByNameField(resultField, members);
        queryField.add(searchMemberByNameField.pane);

        // search member by id
        searchMemberByIdField = new SearchMemberByIdField(resultField, members);
        queryField.add(searchMemberByIdField.pane);

        // search video by name
        searchVideoByNameField = new SearchVideoByNameField(resultField, videoArchive, members);
        queryField.add(searchVideoByNameField.pane);

        // lend the video
        lendVideoField = new LendVideoField(resultField, videoArchive, members);
        queryField.add(lendVideoField.pane);

        // add stock of video
        addVideoStockField = new AddVideoStockField(resultField, videoArchive, members);
        queryField.add(addVideoStockField.pane);

        // register
        registerMemberField = new RegisterMemberField(resultField, members);
        queryField.add(registerMemberField.pane);

        // return the video
        returnVideoField = new ReturnVideoField(resultField, videoArchive, members);
        queryField.add(returnVideoField.pane);

        // reduce stock of video
        reduceVideoStockField = new ReduceVideoStockField(resultField, videoArchive, members);
        queryField.add(reduceVideoStockField.pane);

        // withdraw
        memberWithdrawalField = new MemberWithdrawalField(resultField, members);
        queryField.add(memberWithdrawalField.pane);

        mainPane.add(queryField);
        mainPane.add(resultFieldWrapper);
        return mainPane;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rental Video System");
        RentalVideoSystem app = new RentalVideoSystem();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
