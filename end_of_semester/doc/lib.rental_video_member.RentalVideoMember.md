# lib.rental_video_member.RentalVideoMember
`public class RentalVideoMember`  
会員一人分の情報の管理を行うクラス。

## fields
- `static private int newestId`
  - 各会員に固有の会員番号を生成するために用いる静的な
    フィールド。
- `public final int id`
  - 各会員に固有の会員番号を保持するフィールド。
- `public String name`
  - 会員名を保持するフィールド。
- `public HashMap<String, Integer> holdingVideos;`
  - 借りているビデオのタイトルとそのビデオの本数を対応
    付けて保持するフィールド

## methods
- `public RentalVideoMember()`
  - コンストラクタ。内部でIDを生成する。会員名はIDと同じとなる。
- `public RentalVideoMember(String name)`
  - コンストラクタ。内部でIDを生成し、会員名は引数で指定した文字列となる。
- `public void borrowVideo(String title, int num)`
  - ビデオを借りる動作を行う。引数はそれぞれ借りるビデオのタイトルと
    本数を指定する。
- `public boolean returnVideo(String title, int num)`
  - ビデオを返却する動作を行う。引数はそれぞれ返却するビデオのタイトルと
    本数を指定する。
- `public boolean isAbleToReturnVideo(String title, int num)`
  - 同様のシグニチャの`returnVideo(String title, int num)`を正常に
    実行できるかどうかを判定する。
- `public String getFormattedId()`
  - 会員番号を10桁の数字列の形に整形した文字列を返す。
- `public ArrayList<Pair<String, Integer>> getVideoList()`
  - 借りているビデオの情報を返す。
