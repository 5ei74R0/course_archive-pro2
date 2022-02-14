# lib.video.Video
`public class Video`  
ビデオ1作品分の情報を管理するクラス。

## fields
- `public final String title`
  - ビデオのタイトルを保持するフィールド。ビデオはタイトルで一意的に
    判別できることを仮定している。
- `private int totalNum`
  - システムが保持する該当作品の合計本数を保持するフィールド。
- `private int lentNum`
  - 貸し出されている本数を保持するフィールド。
- `private HashMap<Integer, Integer> currentBorrowers`
  - 貸し出した会員の情報を保持するフィールド。会員番号に貸し出し本数を
    対応付けて情報を格納する。

## methods
- `public Video(String title, int stockNum)`
  - コンストラクタ。引数でタイトルと在庫の本数を指定する。
- `public void addStock(int num)`
  - 在庫の追加を行う。引数には追加する本数を指定する。
- `public void reduceStock(int num) throws ForbiddenActionException`
  - 在庫の削減を行う。引数には減らす本数を指定する。在庫以上の削減など
    に対して適切に例外を投げる。
- `public int getTotalNum()`
  - システムが保持する該当作品の合計本数を返す。
- `public int getStockNum()`
  - 貸し出されていない在庫中の本数を返す。
- `public int getLentNum()`
  - 貸し出されている本数を返す。
- `public void lendVideo(int borrowerId, int num) throws ForbiddenActionException`
  - ビデオの貸し出しを行う。貸し出し先の会員番号と本数を引数にとる。
- `public int lentNumOfBorrower(int borrowerId)`
  - ある会員に対して貸し出した本数を返す。引数には会員番号を取る。
- `public void returnVideo(int borrowerId, int num) throws ExistenceException, ForbiddenActionException`
  - ビデオの返却を行う。引数には会員番号と本数を取る。また、貸し出していない会員の指定など
    に起因する例外を投げる。
- `public String getStockStatus()`
  - 在庫状況を`a / b`の形の文字列にして返す。
- `public ArrayList<Pair<Integer, Integer>> getBorrowerList()`
  - 貸出先の会員番号と貸し出し本数をペアにして列挙した動的配列を返す。
