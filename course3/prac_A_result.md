## Q.3-1
### explanation
```java
    MyPoint p; // MyPoint クラスは講義の WWW ページにあるクラス
    p.setPoint(4, 23);
```
- 上記の部分ではpを宣言した後に初期化をしていない。
- pにMyPointのインスタンスへの参照が割り当てられる前
  にメソッドを呼び出そうとするため、正しく動作しない。

## Q.3-2
### explanation
```java
    MyPoint p = new MyPoint( ); // MyPoint クラスは講義の WWW ページにあるクラス
    p.y = 2021; 
```
- p.yはprivateなのでクラス外から呼び出すことはできない。

## Q.3-3
### explanation
```java
    int[] a;
    a[0] = 1; 
```
- 初期化していない。

## Q.3-4
### explanation
```java
    int[] a = new int[23];
    a[23] = 4; 
```
- 配列外参照である。
- `a`は0-indexedであり、最後の要素は`a[22]`となる。

## Q.3-5
### explanation
```java
    String[] fruits = new String[] {"apple", "banana", "orange"};
```

## Q.3-6
### explanation
```stdout
Hello!-4
Hello!-423
Hello!19
```
- 1行目については、Helloの後に文字列に変換された-4が
  結合されて出力されるため、`Hello!-4`となる。
- 2行目については、Helloの後に文字列に変換された-4が
  結合されて、さらに同様に23が結合されて出力されるため、
  `Hello!-423`となる。
- 3行目については文字列への変換の前に`(i + 23)`の計算が行われ、
  Helloの後に文字列に変換された19が
  結合されて出力されるため、`Hello!19`となる。
