/**
 * Created by forestnewark on 5/10/17.
 */

$('#teacherSubmitStudentButton').click(function(){
    var studentFirstName = $('#registerFirstNameStudent').val();
    // var studentLastName = $('#registerLastNameStudent').val();


    var formData = new FormData();
    formData.append('studentFirstName', studentFirstName);

    $.ajax({
        url: "/teacherAddStudent",
        type: 'post',
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function (data) {
            alertify.success("Successfully added student: " + studentFirstName);
            $('#addStudent').slideToggle(function() {
                if (!$('#addStudent').is(':visible'))
                    $('.student').css('background', '#faf0a1');

            })
        }
    });
});

