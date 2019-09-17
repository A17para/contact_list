function WindowCloseConfirm() {

  //ret変数に確認ダイアログの結果を代入する。
    crose_confirm = confirm('ウィンドウは、表示中のWebページにより閉じられようとしています。\nこのウィンドウを閉じますか？');
    //確認ダイアログの結果がOKの場合ウィンドウを閉じる。
    if (crose_confirm == true){
    	window.open('about:blank','_self').close();
    }

}

function EntryConfirm() {

	  //ret変数に確認ダイアログの結果を代入する。
	    entry_confirm = confirm('入力したデータを登録しますか？');
	    if (entry_confirm == true){
	    	alert("入力データを登録しました");
	    }
	}

function UpdateConfirm() {

	  //ret変数に確認ダイアログの結果を代入する。
	    update_confirm = confirm('登録データを編集しますか？');
	    if (update_confirm == true){
	    	alert("登録データを編集しました");
	    }
	}

function DeletingConfirm() {

	  //ret変数に確認ダイアログの結果を代入する。
	    deleting_confirm = confirm('選択したデータを削除しますか？');
	    //確認ダイアログの結果がOKの場合チェックidを送信する。
	    if (deleting_confirm == true){
	    	var checkedId =[];
	    	$('input[name=id]:checked').each (function(){
	    		checkedId.push($(this).val());
	    	});
			$('#getDelId').val(checkedId);
	    	}
	    }

