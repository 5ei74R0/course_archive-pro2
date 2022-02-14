# lib.gui.SearchMemberByIdField
`public class SearchMemberByIdField`  
GUIのパーツの一つを成し、会員を会員番号によって検索するクエリのフィールドを形成するクラス。

## fields
- `public JPanel pane`
  - GUIパーツの基盤
- `public JPanel subPane`
  - GUIパーツの基盤
- `public final JLabel fieldTitle`
  - クエリフィールドの役割を明示するラベル
- `public JTextArea resultField`
  - `RentalVideoSystem`が保持する`resultField`を参照する。
- `public JTextField userId`
  - 会員番号を入力するテキストボックス
- `public JButton button`
  - ボタン
- `public MembersList members`
  - `RentalVideoSystem`が保持する`members`を参照する。

## methods
- `public SearchMemberByIdField(JTextArea referenceToResultField, MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
