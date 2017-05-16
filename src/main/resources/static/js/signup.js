// Parent Page Drop Down for second point of contact and students
$(document).ready(function(){

  $('.addContact').click(function(){
    $(this).next('.contactInfo').slideToggle();
  });
  $('.addStudent2').click(function(){
    $('.addStudent2').text('Second Student');
  });
  $('.addStudent3').click(function(){
    $('.addStudent3').text('Third Student');
  });
});




// Input Form Login Page

$(document).ready(function(){
    var inputSelector = $('.input-wrapper');
    var loginEmailValue= inputSelector.find("input[name='loginEmail']").val();
    var passwordValue= inputSelector.find("input[name='loginPassword']").val();

    if(loginEmailValue.length > 0){
        $('#loginEmail').css({'border': '1px solid #00b074'});
        $('#emailLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(passwordValue !== ""){
        $('#loginPassword').css({'border': '1px solid #00b074'});
        $('#passwordLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

});


$('.input-wrapper > input').focus(function() {
    $(this).css({'border': '1px solid #00b074'});
    $(this).next().css({
        'color':'#00b074',
        'transform': 'translateY(-27px)',
    });
}).blur(function() {
    if($(this).val() == '') {
        $(this).css({'border': '1px solid #ececec'});
        $(this).next().css({
            'color':'#333',
            'transform': 'translateY(-10px)',
        });
    };
});




// Input Form Teacher Page

$(document).ready(function(){
    var inputSelector = $('.input-wrapper');

    var teacherFirstNameValue= inputSelector.find("input[name='registerFirstName']").val();
    var teacherLastNameValue= inputSelector.find("input[name='registerLastName']").val();
    var teacherEmailValue= inputSelector.find("input[name='registerEmail']").val();
    var teacherPasswordValue= inputSelector.find("input[name='registerPassword']").val();
    var teacherPhoneNumberValue= inputSelector.find("input[name='registerPhoneNumber']").val();
    var teacherSchoolNameValue= inputSelector.find("input[name='registerSchoolName']").val();
    var teacherSubjectAreaValue= inputSelector.find("input[name='registerSubjectArea']").val();

    //firstName
    if(teacherFirstNameValue !== ""){
        $('#registerFirstName').css({'border': '1px solid #00b074'});
        $('#firstNameLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherLastNameValue !== ""){
        $('#registerLastName').css({'border': '1px solid #00b074'});
        $('#lastNameLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherEmailValue.length > 0){
        $('#registerEmail').css({'border': '1px solid #00b074'});
        $('#emailLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherPasswordValue !== ""){
        $('#registerPassword').css({'border': '1px solid #00b074'});
        $('#passwordLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherPhoneNumberValue.length > 0){
        $('#registerPhoneNumber').css({'border': '1px solid #00b074'});
        $('#phoneNumberLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherSchoolNameValue !== ""){
        $('#registerSchoolName').css({'border': '1px solid #00b074'});
        $('#schoolNameLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if(teacherSubjectAreaValue !== ""){
        $('#registerSubjectArea').css({'border': '1px solid #00b074'});
        $('#subjectAreaLabel').css({
            'color':'#00b074',
            'transform': 'translateY(-27px)'
        });
    }


});






// Input Form Parent Page

$(document).ready(function() {
    var inputSelector = $('.input-wrapper');

    // Parent Registration
    var parentPrimaryFirstNameValue = inputSelector.find("input[name='registerParentPrimaryFirstName']").val();
    var parentPrimaryLastNameValue = inputSelector.find("input[name='registerParentPrimaryLastName']").val();
    var parentPrimaryEmailValue = inputSelector.find("input[name='registerParentPrimaryEmail']").val();
    var parentPrimaryPasswordValue = inputSelector.find("input[name='registerPassword']").val();
    var parentPrimaryPhoneNumberValue = inputSelector.find("input[name='registerPhoneNumber']").val();

    // Add Additional Parent
    var parentSecondaryFirstNameValue = inputSelector.find("input[name='registerParentSecondaryFirstName']").val();
    var parentSecondaryLastNameValue = inputSelector.find("input[name='registerParentSecondaryLastName']").val();
    var parentSecondaryEmailValue = inputSelector.find("input[name='registerParentSecondaryEmail']").val();


    // Student Registration
    var studentPrimaryFirstNameValue = inputSelector.find("input[name='registerStudentPrimaryFirstName']").val();
    var studentPrimaryLastNameValue = inputSelector.find("input[name='registerStudentPrimaryLastName']").val();
    var studentPrimarySchoolValue = inputSelector.find("input[name='registerStudentPrimarySchool']").val();
    var studentPrimaryNotesValue = inputSelector.find("input[name='registerStudentPrimaryNotes']").val();


    // Add Second Student
    var studentSecondaryFirstNameValue = inputSelector.find("input[name='registerStudentSecondaryFirstName']").val();
    var studentSecondaryLastNameValue = inputSelector.find("input[name='registerStudentSecondaryLastName']").val();
    var studentSecondarySchoolValue = inputSelector.find("input[name='registerStudentSecondarySchool']").val();
    var studentSecondaryNotesValue = inputSelector.find("input[name='registerStudentSecondaryNotes']").val();


    // Add Third Student
    var studentTertiaryFirstNameValue = inputSelector.find("input[name='registerStudentTertiaryFirstName']").val();
    var studentTertiaryLastNameValue = inputSelector.find("input[name='registerStudentTertiaryLastName']").val();
    var studentTertiarySchoolValue = inputSelector.find("input[name='registerStudentTertiarySchool']").val();
    var studentTertiaryNotesValue = inputSelector.find("input[name='registerStudentTertiaryNotes']").val();



    if (parentPrimaryFirstNameValue !== "") {
        $('#registerParentPrimaryFirstName').css({'border': '1px solid #00b074'});
        $('#parentPrimaryFirstNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentPrimaryLastNameValue !== "") {
        $('#registerParentPrimaryLastName').css({'border': '1px solid #00b074'});
        $('#parentPrimaryLastNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentPrimaryEmailValue !== "") {
        $('#registerParentPrimaryEmail').css({'border': '1px solid #00b074'});
        $('#parentPrimaryEmailLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentPrimaryPasswordValue !== "") {
        $('#registerPassword').css({'border': '1px solid #00b074'});
        $('#parentPasswordLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentPrimaryPhoneNumberValue !== "") {
        $('#registerPhoneNumber').css({'border': '1px solid #00b074'});
        $('#parentPhoneNumberLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentSecondaryFirstNameValue !== "") {
        $('#registerParentSecondaryFirstName').css({'border': '1px solid #00b074'});
        $('#parentSecondaryFirstNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentSecondaryLastNameValue !== "") {
        $('#registerParentSecondaryLastName').css({'border': '1px solid #00b074'});
        $('#parentSecondaryLastNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (parentSecondaryEmailValue !== "") {
        $('#registerParentSecondaryEmail').css({'border': '1px solid #00b074'});
        $('#parentSecondaryEmailLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentPrimaryFirstNameValue !== "") {
        $('#registerStudentPrimaryFirstName').css({'border': '1px solid #00b074'});
        $('#studentPrimaryFirstNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentPrimaryLastNameValue !== "") {
        $('#registerStudentPrimaryLastName').css({'border': '1px solid #00b074'});
        $('#studentPrimaryLastNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentPrimarySchoolValue !== "") {
        $('#registerStudentPrimarySchool').css({'border': '1px solid #00b074'});
        $('#studentPrimarySchoolLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentPrimaryNotesValue !== "") {
        $('#registerStudentPrimaryNotes').css({'border': '1px solid #00b074'});
        $('#studentPrimaryNotesLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentSecondaryFirstNameValue !== "") {
        $('#registerStudentSecondaryFirstName').css({'border': '1px solid #00b074'});
        $('#studentSecondaryFirstNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentSecondaryLastNameValue  !== "") {
        $('#registerStudentSecondaryLastName').css({'border': '1px solid #00b074'});
        $('#studentSecondaryLastNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentSecondarySchoolValue  !== "") {
        $('#registerStudentSecondarySchool').css({'border': '1px solid #00b074'});
        $('#studentSecondarySchoolLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentSecondaryNotesValue !== "") {
        $('#registerStudentSecondaryNotes').css({'border': '1px solid #00b074'});
        $('#studentSecondaryNotesLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentTertiaryFirstNameValue !== "") {
        $('#registerStudentTertiaryFirstName').css({'border': '1px solid #00b074'});
        $('#studentTertiaryFirstNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentTertiaryLastNameValue !== "") {
        $('#registerStudentTertiaryLastName').css({'border': '1px solid #00b074'});
        $('#studentTertiaryLastNameLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentTertiarySchoolValue !== "") {
        $('#registerStudentTertiarySchool').css({'border': '1px solid #00b074'});
        $('#studentTertiarySchoolLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }

    if (studentTertiaryNotesValue !== "") {
        $('#registerStudentTertiaryNotes').css({'border': '1px solid #00b074'});
        $('#studentTertiaryNotesLabel').css({
            'color': '#00b074',
            'transform': 'translateY(-27px)'
        });
    }
});
