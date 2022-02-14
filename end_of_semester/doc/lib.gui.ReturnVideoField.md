# lib.gui.ReturnVideoField
`public class ReturnVideoField`  
GUIのパーツの一つを成し、ビデオの返却を管理するクエリのフィールドを形成するクラス。

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
- `public JTextField userId`
  - 会員番号を入力するテキストボックス
- `public JTextField numOfVideo`
  - ビデオ本数を入力するテキストボックス
- `public JButton button`
  - ボタン
- `public VideoArchive videoArchive`
  - `RentalVideoSystem`が保持する`videoArchive`を参照する。
- `public MembersList members`
  - `RentalVideoSystem`が保持する`members`を参照する。

## methods
- `public ReturnVideoField(JTextArea referenceToResultField, VideoArchive referenceToVideoArchive, MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
