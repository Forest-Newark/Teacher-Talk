/**
 * Created by forestnewark on 5/1/17.
 */




$(document).ready(function() {
    alert( "ready!" );
    var message = $("#messageSelect").find(':selected').data('message');
    $('#messageTextArea').val(message);



});


$("#messageSelect").change(function () {

    var message = $(this).find(':selected').data('message');
    $('#messageTextArea').val(message);

});


$("#addStudent").click(function() {

   var index = $('#studentNameArea select').length + 1;

    //Clone the DropDownList
    var ddl = $("#studentddl").clone();

    //Set the ID and Name
    ddl.attr("id", "studentddl_" + index);
    ddl.attr("name", "studentddl_" + index);

    $("#studentNameArea").append(ddl);



});


