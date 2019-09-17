$(function(){
	  //編集ボタンのデフォルトは有効
	  $("#edit").prop("disabled", false);
	    // チェックボックスの状態が変わったら（クリックされたら）
	    $('input[name="id"]').change(function () {
	        // checkedが２つ以上ならボタンを禁止
	        if ($("[name='id']").filter(":checked").length <2) {
	        		$("#edit").prop("disabled", false);
	        } else {
	        		$("#edit").prop("disabled", true);
	        }
	    });
	});


