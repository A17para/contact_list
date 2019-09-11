function WindowCloseConfirm() {

  //ret変数に確認ダイアログの結果を代入する。
    ret = confirm('ウィンドウは、表示中のWebページにより閉じられようとしています。\nこのウィンドウを閉じますか？');
    //確認ダイアログの結果がOKの場合ウィンドウを閉じる。
    if (ret == true){
    	window.open('about:blank','_self').close();
    }

}

function EntryConfirm() {

	  //ret変数に確認ダイアログの結果を代入する。
	    ret = confirm('入力したデータを登録しますか？');
//	    if (ret == true){
//	    }

	}

function DeletingConfirm() {

	  //ret変数に確認ダイアログの結果を代入する。
	    ret = confirm('選択したデータを削除しますか？');
	    //確認ダイアログの結果がOKの場合チェックidを送信する。
	    if (ret == true){
	    	var checkedId =[];
	    	$('input[name=id]:checked').each (function(){
	    		checkedId.push($(this).val());
	    	});
//	    	デバッグ用コード
//	    	var delId = document.getElementById('getDelId');
//	    	delId.value = checkedId;
//	    	document.getElementById('getDelId').value=checkedId;
			$('#getDelId').val(checkedId);
//			var chkids = $('#getDelId').val();


	    	}
	    }

