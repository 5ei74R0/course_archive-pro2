# プログラミング第2 最終課題レポート

## GUI外観
![gui](./_img/gui.png)

## 使用方法の説明
- プログラムは`RentalVideoSystem.java`と`lib/`下のファイル群から構成され、
  `RentalVideoSystem.java`内部の`main`関数が主体となって動作する。  
- 基本的に、GUI上部の9つのクエリを利用してレンタルビデオシステムに対して操作を行い、
  その結果をGUI下部のテキストフィールドで表示するように設計されている。ここから各クエリの説明を行う。

### Search Member by UserName
登録された会員を会員名で検索し、情報を列挙する。検索は全文一致のみをサポートし、複数の会員が
一致していればそれら全ての情報を列挙する。(会員登録の際にそれぞれに固有の会員番号が割り振られる
ため、会員名の重複は許している。)  
また、不正な入力に対して例外処理を通して簡単なフィードバックを行う。
- **クエリフィールド外観**  
  ![gui_search_member_by_username](./_img/gui_search_member_by_username.png)
- **動作例**  
  - まず何も入力せずテキストボックスに"username"と表示されたままボタンを押下すると、次の画像に示すような
    エラーメッセージ、ヒントを返す。(少しヘンな文になってるのはご愛嬌ということに..)  
    ![gui_search_member_by_username_result1](./_img/gui_search_member_by_username_result1.png)
  - テキストボックスに"username"以外の何らかの文字列を入力すると、それを会員名とする会員を全員列挙する。
    ここで、会員名が同じ会員が複数いても良い。なぜなら、会員登録の際にそれぞれに固有の会員番号が割り振られるからである。
    次に示す図は会員名が"a"である会員が複数人登録されている場合にボタンを押下した出力である。  
    ![gui_search_member_by_username_result2](./_img/gui_search_member_by_username_result2.png)  
    図を見ると分かるように、検索に一致した会員の情報が列挙されており、それぞれの会員の情報として、会員名、会員番号、
    さらに現在借りているビデオのタイトルとそのビデオの本数が列挙される。  
  - さらに存在しない会員番号を入力した場合、次の画像のようにフィードバックを行う。  
    ![gui_search_member_by_username_result31](./_img/gui_search_member_by_username_result31.png)  
    ![gui_search_member_by_username_result32](./_img/gui_search_member_by_username_result32.png)  

### Search Member by User ID
登録された会員を会員番号で検索し、情報を表示する。ここで会員番号は各会員に1対1対応するため、検索した会員番号に
一致する会員は一人に定まる。  
また、不正な入力に対して例外処理を通して簡単なフィードバックを行う。
- **クエリフィールド外観**  
  ![gui_search_member_by_user_id](./_img/gui_search_member_by_user_id.png)
- **動作例**  
  - まず何も入力せずテキストボックスに"username"と表示されたままボタンを押下すると、次の画像に示すような
    エラーメッセージ、ヒントを返す。  
    ![gui_search_member_by_user_id_result1](./_img/gui_search_member_by_user_id_result1.png)  
  - テキストボックスに整数以外が入力された場合、次の画像のようなエラーメッセージ、ヒントを返す。  
    ![gui_search_member_by_user_id_result21](./_img/gui_search_member_by_user_id_result21.png)  
    ![gui_search_member_by_user_id_result22](./_img/gui_search_member_by_user_id_result22.png)  
  - テキストボックスに整数が入力された場合、次の画像のように検索に一致した会員の情報を表示する。  
    ![gui_search_member_by_user_id_result21](./_img/gui_search_member_by_user_id_result31.png)  
    ![gui_search_member_by_user_id_result22](./_img/gui_search_member_by_user_id_result32.png)  
    図を見ると分かるように、検索に一致した会員の情報が列挙されており、それぞれの会員の情報として、会員名、会員番号、
    さらに現在借りているビデオのタイトルとそのビデオの本数が列挙される。  
  - また、この時会員番号の入力方法として上記のように整数を入力しても良いが、以下のように10桁の会員番号の形で
    入力しても良い。  
    ![gui_search_member_by_user_id_result41](./_img/gui_search_member_by_user_id_result41.png)  
    ![gui_search_member_by_user_id_result42](./_img/gui_search_member_by_user_id_result42.png)  
  - さらに存在しない会員番号を入力した場合、次の画像のように原因、ヒント、提案を提示する。  
    ![gui_search_member_by_user_id_result51](./_img/gui_search_member_by_user_id_result51.png)  
    ![gui_search_member_by_user_id_result52](./_img/gui_search_member_by_user_id_result52.png)  
  - なお、IDは内部的にはint型なので、先頭の桁によってはオーバーフローし、上述の整数型へのパースに失敗するパターン
    と同じ挙動を示す。  

### Search Video by Title
システムが管理しているビデオをタイトルで検索し、情報を列挙する。検索は全文一致のみをサポートし、
不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_search_video_by_title](./_img/gui_search_video_by_title.png)  
- **動作例**  
  - まず何も入力せずテキストボックスに"video title"と表示されたままボタンを押下すると、次の画像に示すような
    エラーメッセージ、ヒントを返す。  
    ![gui_search_video_by_title_result1](./_img/gui_search_video_by_title_result1.png)  
  - テキストボックスに"video title"以外の何らかの文字列を入力すると、それをタイトルとするビデオを検索する。
    次に示す図は"titanic"を検索した例である。
    ![gui_search_video_by_title_result21](./_img/gui_search_video_by_title_result21.png)  
    ![gui_search_video_by_title_result22](./_img/gui_search_video_by_title_result22.png)  
  - さらに存在しないタイトルを入力した場合、次の画像に示すようなエラーメッセージ、ヒントを返す。  
    ![gui_search_video_by_title_result31](./_img/gui_search_video_by_title_result31.png)  
    ![gui_search_video_by_title_result32](./_img/gui_search_video_by_title_result32.png)  

### Lend the Video
貸し出しを行う。左上の欄にビデオタイトル、右上の欄に会員番号、左下の欄に貸し出したいビデオの本数を
入力して操作する。また、不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_lend_the_video](./_img/gui_lend_the_video.png)  
- **動作例**  
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、次の画像に示すような
    エラーメッセージ、ヒントを返す。  
    ![gui_lend_the_video_result1](./_img/gui_lend_the_video_result1.png)  
  - 様々なケースがあるのでここで例示はしないが、入力の不正はエラー処理されてフィードバックが行われる。
  - 入力に不正がなく、存在するビデオのタイトル、存在する会員番号、貸し出しが成立するビデオ本数が指定
    された場合は次の画像のように処理後の状態を表示する。  
    ![gui_lend_the_video_result21](./_img/gui_lend_the_video_result21.png)  
    ![gui_lend_the_video_result22](./_img/gui_lend_the_video_result22.png)  
  - 入力に不正がないが、貸し出し本数の問題などで正常に貸し出しが成立しない場合は次の画像のようにフィードバックを返す。  
    ![gui_lend_the_video_result31](./_img/gui_lend_the_video_result31.png)  
    ![gui_lend_the_video_result32](./_img/gui_lend_the_video_result32.png)  

### Return the Video
返却を管理する。左上の欄にビデオタイトル、右上の欄に会員番号、左下の欄に貸し出したいビデオの本数を
入力して操作する。また、不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_return_the_video](./_img/gui_return_the_video.png)  
- **動作例**  
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、これまでの機能と同様に
    エラーメッセージ、ヒントを返す。  
  - 様々なケースがあるのでここで例示はしないが、入力の不正はエラー処理されてフィードバックが行われる。  
  - 入力に不正がなく、存在するビデオのタイトル、ビデオを該当するビデオを借りている会員の会員
    番号、返却が成立するビデオ本数が指定された場合は次の画像のように処理後の状態を表示する。  
    ![gui_return_the_video_result11](./_img/gui_return_the_video_result11.png)  
    ![gui_return_the_video_result12](./_img/gui_return_the_video_result12.png)  
  - 入力に不正がないが、返却本数の問題などで正常に貸し出しが成立しない場合は次の画像のようにフィードバックを返す。  
    ![gui_return_the_video_result21](./_img/gui_return_the_video_result21.png)  
    ![gui_return_the_video_result22](./_img/gui_return_the_video_result22.png)  

### Add the Video Stock
ビデオ在庫の追加を行う。左の欄にビデオタイトル、右の欄に追加する本数を入力して操作する。また、
不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_add_the_video_stock](./_img/gui_add_the_video_stock.png)  
- **動作例** 
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、これまでの機能と同様に
    エラーメッセージ、ヒントを返す。  
  - 様々なケースがあるのでここで例示はしないが、入力の不正はエラー処理されてフィードバックが行われる。  
  - 入力に不正がなく、存在するビデオのタイトル、在庫の追加が成立するビデオ本数が指定された場合は次の
    画像のように処理後の状態を表示する。  
    ![gui_add_the_video_stock_result11](./_img/gui_add_the_video_stock_result11.png)  
    ![gui_add_the_video_stock_result12](./_img/gui_add_the_video_stock_result12.png)  
  - 入力に不正がないが、負の本数を与えられるなどの問題で正常に在庫の追加が成立しない場合は次の画像
    のようにフィードバックを返す。  
    ![gui_add_the_video_stock_result21](./_img/gui_add_the_video_stock_result21.png)  
    ![gui_add_the_video_stock_result22](./_img/gui_add_the_video_stock_result22.png)  

### Reduce the Video Stock
ビデオ在庫の削減を行う。左の欄にビデオタイトル、右の欄に減らす本数を入力して操作する。また、
不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_reduce_the_video_stock](./_img/gui_reduce_the_video_stock.png)  
- **動作例** 
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、これまでの機能と同様に
    エラーメッセージ、ヒントを返す。  
  - 様々なケースがあるのでここで例示はしないが、入力の不正はエラー処理されてフィードバックが行われる。  
  - 入力に不正がなく、存在するビデオのタイトル、在庫の削減が成立するビデオ本数が指定された場合は次の
    画像のように処理後の状態を表示する。  
    ![gui_reduce_the_video_stock_result11](./_img/gui_reduce_the_video_stock_result11.png)  
    ![gui_reduce_the_video_stock_result12](./_img/gui_reduce_the_video_stock_result12.png)  
  - 入力に不正がないが、手元にある在庫量以上の本数が与えられるなどの問題で正常に在庫の削減が成立しない場合は次の画像
    のようにフィードバックを返す。  
    ![gui_reduce_the_video_stock_result21](./_img/gui_reduce_the_video_stock_result21.png)  
    ![gui_reduce_the_video_stock_result22](./_img/gui_reduce_the_video_stock_result22.png)  

### Member Registration
新たに会員の登録を行う。会員名を入力して操作する。この時会員番号は自動的に固有の番号が割り当てられ、
また不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_member_registration](./_img/gui_member_registration.png)  
- **動作例** 
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、これまでの機能と同様に
    エラーメッセージ、ヒントを返す。  
  - 登録が成立すると、次の画像のように登録時の情報を表示する。  
    ![gui_member_registration_result11](./_img/gui_member_registration_result11.png)  
    ![gui_member_registration_result12](./_img/gui_member_registration_result12.png)  

### Member Withdrawal
会員の退会手続きを行う。会員番号を入力して操作する。また不正な入力に対して例外処理を通して簡単なフィードバックを行う。  
- **クエリフィールド外観**  
  ![gui_member_withdrawal](./_img/gui_member_withdrawal.png)  
- **動作例** 
  - まず何も入力せずテキストボックスデフォルト表示のままボタンを押下すると、これまでの機能と同様に
    エラーメッセージ、ヒントを返す。  
  - 存在しない会員番号を入力するなどの入力の不正はエラー処理されてフィードバックが行われる。  
  - 退会が成立すると、次の画像のようにフィードバックを行う。  
    ![gui_member_withdrawal_result11](./_img/gui_member_withdrawal_result11.png)  
    ![gui_member_withdrawal_result12](./_img/gui_member_withdrawal_result12.png)  
  - 会員がまだ返却していないビデオが存在する場合は退会が成立せず、次の画像のようにフィードバックを返す。  
    ![gui_member_withdrawal_result21](./_img/gui_member_withdrawal_result21.png)  
    ![gui_member_withdrawal_result22](./_img/gui_member_withdrawal_result22.png)  

## 設計の説明
以降のページにドキュメンテーションとして各クラスの説明を行う。

### ディレクトリ構成
各クラスの説明に移る前にディレクトリ構成を簡単に図示しておく。
```plane
ProjectRoot/
    +- RentalVideoSystem.java
    +- lib/
        +- util/
            +- Pair.java
            +- exception/
                +- ExistenceException.java
                +- ForbiddenActionException.java
        +- rental_video_member/
            +- RentalVideoMember.java
            +- MembersList.java
        +- video/
            +- Video.java
            +- VideoArchive.java
        +- gui/
            +- AddVideoStockField.java
            +- ReduceVideoStockField.java
            +- RegisterMemberField.java
            +- MemberWithdrawalField.java
            +- LendVideoField.java
            +- ReturnVideoField.java
            +- SearchMemberByIdField.java
            +- SearchMemberByNameField.java
            +- SearchVideoByNameField.java
```
