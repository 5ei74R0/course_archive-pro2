# lib.gui.SearchMemberByNameField
`public class SearchMemberByNameField`  
GUIのパーツの一つを成し、会員を会員名によって検索するクエリのフィールドを形成するクラス。

## fields
- `public JPanel pane`
  - GUIパーツの基盤
- `public JPanel subPane`
  - GUIパーツの基盤
- `public final JLabel fieldTitle`
  - クエリフィールドの役割を明示するラベル
- `public JTextArea resultField`
  - `RentalVideoSystem`が保持する`resultField`を参照する。
- `public JTextField userName`
  - 会員名を入力するテキストボックス
- `public JButton button`
  - ボタン
- `public MembersList members`
  - `RentalVideoSystem`が保持する`members`を参照する。

## methods
- `public SearchMemberByNameField(JTextArea referenceToResultField, MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
