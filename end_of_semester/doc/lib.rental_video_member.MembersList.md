# lib.rental_video_member.MembersList
`public class MembersList`  
システムが管理する会員全員の情報を管理するクラス。
- 会員名、会員番号どちらでもある程度高速な検索を可能にするため、
  2つの`HashMap`を持つ。

## fields
- `private HashMap<String, ArrayList<RentalVideoMember>> nameIndexedDict`
  - 会員名でインデックスが作成されている連想配列。会員名は重複し得るので、
    `RentalVideoMember`の動的配列が格納されている。
- `private HashMap<Integer, RentalVideoMember> idIndexedDict`
  - 会員番号でインデックスが作成されている連想配列。会員番号は重複しない
    ので、`RentalVideoMember`そのものが格納されている。

## methods
- `public MembersList()`
  - コンストラクタ。`this.nameIndexedDict`と`this.idIndexedDict`
    を初期化する。
- `public int registerMember(String name)`
  - 会員登録を行う。
- `public void withdraw(int id) throws ExistenceException, ForbiddenActionException`
  - 退会処理を行う。該当する会員の不在などに対して例外を投げる。
- `public RentalVideoMember searchById(int id) throws ExistenceException`
  - 会員番号による検索を行う。該当する会員の不在などに対して例外を投げる。
- `public ArrayList<RentalVideoMember> searchByName(String name) throws ExistenceException`
  - 会員名による検索を行う。該当する会員の不在などに対して例外を投げる。
