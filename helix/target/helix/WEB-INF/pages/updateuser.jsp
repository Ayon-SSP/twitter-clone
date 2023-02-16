<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<script src="https://code.jquery.com/jquery-3.5.0.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>
<link rel="shortcut icon" href="https://abs.twimg.com/favicons/twitter.2.ico" type="image/x-icon">
<body>

<form method="post" enctype="multipart/form-data" id="fileUploadForm">
    <input type="file" id="file" name="file"/><br/><br/>
    <input type="button" value="Submit" id="button_upload"/>
</form>

<span id="result">
<img id="user-image" class="preview" style="display:none" height="100px" width="100px">
</span>

<script>
$(document).ready(function(){

    $("#button_upload").click(function(){

        var fd = new FormData();
        var files = $('#file')[0].files[0];
        fd.append('file',files);

        $.ajax({
            url: '/user/profile-image/upload',
            type: 'post',
            data: fd,
            contentType: false,
            processData: false,
            success: function(response){
                if(response != 0){
                    $("#user-image").attr("src",response);
                    $(".preview").show(); // Display image element
                }else{
                    alert('file not uploaded');
                }
            },
        });
    });
});
</script>

</body>
</html>