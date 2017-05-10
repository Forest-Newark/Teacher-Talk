/**
 * Created by forestnewark on 5/1/17.
 */

$(document).ready(function() {
    var userId;
    var idCount = 1;
    var searchField = $("#student");

    var options = {
        url: "/getAllStudents",

        getValue: function(element) {
            userId = element.id;
            return element.studentFirstName + ' ' + element.studentLastName;
        },

        list: {
            onChooseEvent: function() {
                var studentId = searchField.getSelectedItemData().id;
                var studentFirstName = searchField.getSelectedItemData().studentFirstName;
                var studentLastName = searchField.getSelectedItemData().studentLastName;
                


                //Create Student name box (currently input field)
                var input = document.createElement("input");
                input.setAttribute("value",studentFirstName + ' ' + studentLastName);
                input.setAttribute("readonly","readonly");
                input.setAttribute('id','studentName_' + idCount);





                $("#studentNameArea").append(input).append("<a class='deletebutton' id='studentNameButton_"+ idCount + "' data-countId='"+idCount+"'><span>X</span></a>");

                var hiddenInput = document.createElement("input");
                hiddenInput.setAttribute("id","studentId_" + idCount);
                hiddenInput.setAttribute("type","hidden");
                hiddenInput.setAttribute("value", studentId);
                hiddenInput.setAttribute("name","studentId_" + idCount);
                $("#studentIdArea").append(hiddenInput);
                idCount++;
                searchField.val('');

            },
            match: {
                enabled: true
            }
        }
    };

    searchField.easyAutocomplete(options);

});



$(document).ready(function(){
    $("#studentNameArea").on("click", ".deletebutton", function(){

        var controlNumber =$(this).attr('data-countId');

        $("#studentName_"+controlNumber).remove();
        $("#studentNameButton_"+controlNumber).remove();
        $("#studentId_"+controlNumber).remove();

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



