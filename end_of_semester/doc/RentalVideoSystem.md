# RentalVideoSystem
本プログラムの中心となるクラス。このクラスの`main`関数から処理が始まる。
基本的にはこのクラスはGUIの部品を一つの画面にまとめ、ビデオを格納する
データ構造と会員情報を格納するデータ構造の実体を保持する役割を持つ。  

## fields
- `private VideoArchive videoArchive`
  - ビデオの情報を保持、管理する。型は後述するパッケージに実装された
    `lib.video.VideoArchive`である。  
- `private MembersList members`
  - 会員の情報を保持、管理する。型は後述するパッケージに実装された
    `lib.rental_video_member.MembersList`である。
- `private SearchMemberByIdField searchMemberByIdField`
  - GUIのパーツの一つを成す。具体的には会員を会員番号によって検索するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.SearchMemberByIdField`である。  
- `private SearchMemberByNameField searchMemberByNameField`
  - GUIのパーツの一つを成す。具体的には会員を会員名によって検索するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.SearchMemberByNameField`である。
- `private SearchVideoByNameField searchVideoByNameField`
  - GUIのパーツの一つを成す。具体的にはビデオをタイトルによって検索するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.SearchVideoByNameField`である。
- `private LendVideoField lendVideoField`
  - GUIのパーツの一つを成す。具体的にはビデオの貸し出しを管理するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.LendVideoField`である。
- `private ReturnVideoField returnVideoField`
  - GUIのパーツの一つを成す。具体的にはビデオの返却を管理するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.ReturnVideoField`である。
- `private AddVideoStockField addVideoStockField`
  - GUIのパーツの一つを成す。具体的にはビデオ在庫の追加を管理するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.AddVideoStockField`である。
- `private ReduceVideoStockField reduceVideoStockField`
  - GUIのパーツの一つを成す。具体的にはビデオ在庫の削減を管理するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.ReduceVideoStockField`である。
- `private RegisterMemberField registerMemberField`
  - GUIのパーツの一つを成す。具体的には会員登録を行うクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.RegisterMemberField`である。
- `private MemberWithdrawalField memberWithdrawalField`
  - GUIのパーツの一つを成す。具体的には退会処理を管理するクエリ
    のフィールドを形成する。型は後述するパッケージに実装された
    `lib.gui.MemberWithdrawalField`である。

## methods
- `public RentalVideoSystem()`
  - コンストラクタ。内部で`this.videoArchive`及び`this.members`
    のコンストラクタを呼び、状態の初期化を行う。
- `public Component createComponents()`
  - GUIの部品の配置を行う。内部では`JPanel queryField`、
    `JPanel resultField`を作成。
    `searchMemberByIdField`、`searchMemberByNameField`、
    `searchVideoByNameField`、`lendVideoField`、
    `returnVideoField`、`addVideoStockField`、
    `reduceVideoStockField`、`registerMemberField`、
    `memberWithdrawalField`の初期化を行い、それぞれの`~.pane`を
    `queryField`に配置して、`mainPane`上部に`queryField`を、
    下部に`resultField`を配置することでアプリケーション本体のGUIを
    設計する。なお、上の9つのクエリフィールドを形成するクラスは
    `resultField`や`videoArchive`、`members`といった変数を
    参照して、アプリケーションのGUIに変更を伝えられるようになっている。
- `public static void main(String[] args)`
  - 本プログラムの主軸となる関数。内部で`RentalVideoSystem`クラス
    のオブジェクトを作成、GUIアプリケーションを開始、停止する。
