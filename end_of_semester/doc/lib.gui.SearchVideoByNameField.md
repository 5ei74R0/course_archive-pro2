# lib.gui.SearchVideoByNameField
`public class SearchVideoByNameField`  
GUIのパーツの一つを成し、ビデオをタイトルによって検索するクエリのフィールドを形成するクラス。

## fields
- `public JPanel pane`
  - GUIパーツの基盤
- `public JPanel subPane`
  - GUIパーツの基盤
- `public final JLabel fieldTitle`
  - クエリフィールドの役割を明示するラベル
- `public JTextArea resultField`
  - `RentalVideoSystem`が保持する`resultField`を参照する。
- `public JTextField videoTitle`
  - ビデオタイトルを入力するテキストボックス
- `public JButton button`
  - ボタン
- `public VideoArchive videoArchive`
  - `RentalVideoSystem`が保持する`videoArchive`を参照する。
- `public MembersList members`
  - `RentalVideoSystem`が保持する`members`を参照する。

## methods
- `public SearchVideoByNameField(JTextArea referenceToResultField, VideoArchive referenceToVideoArchive, MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
