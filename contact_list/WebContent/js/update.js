function getTableRecords(){
//	テーブルからチェックしたデータを取得
	var chkRec=$("input[name=id]:checked").parents("tr");
	if (chkRec.length == 0){
		alert('選択してください');
		$('form').submit(function(){
			return false;
		});
	}
	else{
	var id = $("input[name=id]:checked").val();
			document.getElementById('id').value=id;
	}
}