$(function(){
	  // 初期状態のボタンは有効
	  $("#edit").prop("disabled", false);
	    // チェックボックスの状態が変わったら（クリックされたら）
	    $('input:checkbox[name="id"]').on('change', function () {
	        // チェックされているチェックボックスの数
	        if ($("[name='id']").filter(":checked").length <2) {
	          // チェックの数が２未満ならボタン有効
	          $("#edit").prop("disabled", false);
	        } else {
	          // それ以外ならボタン無効
	          $("#edit").prop("disabled", true);
	        }
	    });
	});


