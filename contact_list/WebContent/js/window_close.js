/**
 *
 */
function WindowCloseCheck() {

  //ret変数に確認ダイアログの結果を代入する。
    ret = confirm('ウィンドウは、表示中のWebページにより閉じられようとしています。\nこのウィンドウを閉じますか？');
    //確認ダイアログの結果がOKの場合外部リンクを開く
    if (ret == true){
    	window.open('about:blank','_self').close()
    }

}