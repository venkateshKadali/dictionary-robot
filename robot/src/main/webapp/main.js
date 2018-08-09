var url = "http://localhost:8083/robot/webresources/dict/getDefinition";
$(document).ready(function() {
	$('#button').on('click', function() {
		$('#defi').text('');
		$.ajax({
			type : 'POST',
			url : url,
			crossDomain : true,
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify({
				term : $('#term').val()
			}),
			success : function(data) {
				$('#defi').text(data.definition);

			},
			error : function(data) {
				alert(data);
			}
		});
	});
});
