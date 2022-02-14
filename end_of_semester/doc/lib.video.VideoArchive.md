# lib.video.VideoArchive
`public class VideoArchive`  
システムが管理する全てのビデオの情報を管理するクラス。

## fields
- `private HashMap<String, Video> container`
  - ビデオのタイトルと`lib.video.Video`を対応付けて格納するフィールド。

## methods
- `public VideoArchive()`
  - コンストラクタ。内部では`this.container`を初期化する。
- `public void addVideo(String title, int num)`
  - ビデオの追加を管理する。新規のビデオの追加、在庫の追加両方を扱う。
- `public void reduceVideo(String title, int num) throws ExistenceException, ForbiddenActionException`
  - ビデオの在庫の削減を管理する。また、ビデオの不在などに起因する例外を投げる。
- `public void lendVideo(int borrowerId, String title, int num) throws ExistenceException, ForbiddenActionException`
  - ビデオの貸し出しの処理を行う。また、ビデオの不在、在庫不足などに起因する例外を投げる。
- `public void returnVideo(int borrowerId, String title, int num) throws ExistenceException, ForbiddenActionException`
  - ビデオの返却を管理する。また、貸し出し本数との不整合などに起因する例外を投げる。
- `public Video getVideo(String title) throws ExistenceException`
  - ビデオをタイトルで検索し、該当するオブジェクトを参照する`lib.video.Video`型の変数を返す。
    また、該当するビデオの不在に起因する例外を投げる。
