# lib.util.exception
本プログラムを作成する上で頻発するビデオの不足や該当するオブジェクト
の不在などによる例外を明示的に扱うクラスを格納するパッケージ。

## 内包するクラス
- `lib.util.exception.ExistenceException`
  - 該当するオブジェクトの不在に関連する例外を扱うためのクラス。
- `lib.util.exception.ForbiddenActionException`
  - ビデオの不足や、現実的に起こり得ない状態を作ってしまうような
    状況を避けるための例外を扱うクラス。
