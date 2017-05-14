/**
 * Created by forestnewark on 5/10/17.
 */

$('#teacherSubmitStudentButton').click(function(){
    var studentFirstName = $('#registerFirstNameStudent').val();
    var studentLastName = $('#registerLastNameStudent').val();
    var parentFirstName = $('#registerFirstNameParent').val();
    var parentLastName = $('#registerLastNameParent').val();
    var parentEmail = $('#registerParentEmail').val();


    var formData = new FormData();
    formData.append('studentFirstName', studentFirstName);
    formData.append('studentLastName', studentLastName);
    formData.append('parentFirstName', parentFirstName);
    formData.append('parentLastName',parentLastName);
    formData.append('parentEmail', parentEmail);

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
              if(!$('#addStudent').is(':visible')){
                $('.student').css('background','#faf0a1');
                $('a').css({'-webkit-box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)', '-moz-box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)', 'box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)'});
                $('input').css({
                  'color':'#333',
                  'transform': 'translateY(-10px)'
                });
              } else {
                $('.student a').css({'-webkit-box-shadow' : 'none', '-moz-box-shadow' : 'none', 'box-shadow' : 'none'});
              }

              $('#registerFirstNameStudent').val("");
              $('#registerLastNameStudent').val("");
              $('#registerFirstNameParent').val("");
              $('#registerLastNameParent').val("");
              $('#registerParentEmail').val("");



            });
        }
    });
});
