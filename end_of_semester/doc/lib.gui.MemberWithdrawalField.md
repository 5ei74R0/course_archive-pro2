# lib.gui.MemberWithdrawalField
`public class MemberWithdrawalField`  
GUIのパーツの一つを成し、退会処理を管理するクエリのフィールドを形成するクラス。

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
- `public MemberWithdrawalField(JTextArea referenceToResultField, MembersList referenceToMembers)`
  - コンストラクタ。GUIパーツの配置を決め、ボタンのアクションを設定する。
