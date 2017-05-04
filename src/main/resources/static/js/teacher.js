/**
 * Created by forestnewark on 5/1/17.
 */



window.addEventListener("awesomplete-selectcomplete", function(e){

    var studentName = e.text;
    alert(studentName);

    var input = document.createElement("input");
    input.setAttribute("value", studentName);
    input.setAttribute("readonly","readonly");
    $("#studentNameArea").append(input);



    //
    // alert('event listener ' + studentId);

}, false);


$(function(){
    $('#studentAutoComplete').change(function () {
           // alert('here is an alert');

            // var index = 1;
            //
            // var input = document.createElement("input");
            //
            //
            //
            //
            //  $('input[name=studentSearchBox]').val('');
            //
            // // input.attr("id", "student_" + index);
            // input.setAttribute("value", studentName);
            // input.setAttribute("readonly","readonly");
            //
            // //input.attr("placeholder", studentId);
            // $("#studentNameArea").append(input);

    });
});


$(document).ready(function() {
    var message = $("#messageSelect").find(':selected').data('message');
    $('#messageTextArea').val(message);



});


$("#messageSelect").change(function () {

    var message = $(this).find(':selected').data('message');
    $('#messageTextArea').val(message);

});


// $("#addStudent").click(function() {
//
//    var index = $('#studentNameArea select').length + 1;
//
//     //Clone the DropDownList
//     var ddl = $("#studentddl").clone();
//
//     //Set the ID and Name
//     ddl.attr("id", "studentddl_" + index);
//     ddl.attr("name", "studentddl_" + index);
//
//     $("#studentNameArea").append(ddl);
//
//
//
// });


