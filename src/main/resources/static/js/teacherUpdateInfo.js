/**
 * Created by forestnewark on 5/10/17.
 */

$('#teacherUpdateInfoButton').click(function(){
    var teacherFirstName = $('#registerFirstName').val();
    var teacherLastName = $('#registerLastName').val();
    var teacherEmail = $('#registerEmail').val();
    var teacherPassword =$('#registerPassword').val();
    var teacherPhoneNumber = $('#registerPhoneNumber').val();
    var teacherSchoolName = $('#registerSchoolName').val();
    var teacherSubject = $('#registerSubjectArea').val();



    var formData = new FormData();
    formData.append('firstName', teacherFirstName);
    formData.append('lastName',teacherLastName);
    formData.append('email',teacherEmail);
    formData.append('password',teacherPassword);
    formData.append('phoneNumber',teacherPhoneNumber);
    formData.append('subjectArea',teacherSubject);
    formData.append('schoolName',teacherSchoolName);

    $.ajax({
        url: "/teacherUpdateInfo",
        type: 'post',
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function (data) {
            alertify.success("Successfully Updated Info");
            $('#updateProfile').slideToggle(function(){
                if(!$('#updateProfile').is(':visible'))
                    $('.profile').css('background','#faf0a1');
            });
        }
    });
});

