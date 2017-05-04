/**
 * Created by forestnewark on 5/1/17.
 */

$(document).ready(function() {
    var userId;
    var options = {
        url: "/getAllStudents",

        getValue: function(element) {
            userId = element.id;
            return element.studentFirstName + ' ' + element.studentLastName;
        },

        list: {
            onChooseEvent: function() {
                var studentId = $("#provider-json").getSelectedItemData().id;
                var studentFirstName = $("#provider-json").getSelectedItemData().studentFirstName;
                var studentLastName = $("#provider-json").getSelectedItemData().studentLastName;

                var input = document.createElement("input");
                input.setAttribute("value",studentFirstName + ' ' + studentLastName);
                input.setAttribute("readonly","readonly");


                var hiddenInput = document.createElement("input");
                hiddenInput.setAttribute("type","hidden");
                hiddenInput.setAttribute("value", studentId);
                $("#studentNameArea").append(input).append(hiddenInput);

            },
            match: {
                enabled: true
            }
        }
    };

    $("#provider-json").easyAutocomplete(options);

});




$(document).ready(function() {
    var message = $("#messageSelect").find(':selected').data('message');
    $('#messageTextArea').val(message);



});


$("#messageSelect").change(function () {

    var message = $(this).find(':selected').data('message');
    $('#messageTextArea').val(message);

});


