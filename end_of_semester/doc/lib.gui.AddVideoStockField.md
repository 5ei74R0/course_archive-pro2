# lib.gui.AddVideoStockField
`public class AddVideoStockField`  
GUIのパーツの一つを成し、ビデオ在庫の追加を管理するクエリのフィールドを形成するクラス。
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
- `public JTextField numOfVideo`
  - ビデオの本数を入力するテキストボックス
- `public JButton button`
  - ボタン
- `public VideoArchive videoArchive`
  - `RentalVideoSystem`が保持する`videoArchive`を参照する。
- `public MembersList members`
  - `RentalVideoSystem`が保持する`members`を参照する。

## methods
- `public AddVideoStockField(referenceToResultField, VideoArchive referenceToVideoArchive,MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
