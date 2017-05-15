/**
 * Created by forestnewark on 5/1/17.
 */
var selectTemplate = $("#messageSelect");


$(document).ready(function() {


    var inputSelector = $('.input-wrapper');



    var searchField = inputSelector.find("input[name='students']");

    var userId;
    var idCount = 1;

    var options = {
        url: "/getAllStudents",

        getValue: function(element) {
            userId = element.id;
            return element.studentFirstName + ' ' + element.studentLastName;
        },
        template: {
            type: "custom",
            method: function(value, item) {
                return item.studentFirstName +" " + item.studentLastName + " (" + item.grade +"th)";
                // return "<img src='" + item.icon + "' /> | " + item.type + " | " + value;
            }
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

                var deleteButtonTest = document.createElement("a")
                deleteButtonTest.setAttribute("class", "deletebutton");
                deleteButtonTest.setAttribute("id","studentNameButton_"+idCount);
                deleteButtonTest.setAttribute("data-countId",idCount);

                var deleteIcon = document.createElement("i");
                deleteIcon.setAttribute("class","fa fa-times");

                deleteButtonTest.appendChild(deleteIcon);


                $("#studentNameArea").append(input).append(deleteButtonTest);


                // $("#studentNameArea").append(input).append("<a class='deletebutton' id='studentNameButton_"+ idCount + "' data-countId='"+idCount+"'><span><i class='fa fa-times' aria-hidden='true'></i></span></a>");

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

    $("#studentNameArea").on("click", ".deletebutton", function(){

        var controlNumber =$(this).attr('data-countId');

        $("#studentName_"+controlNumber).remove();
        $("#studentNameButton_"+controlNumber).remove();
        $("#studentId_"+controlNumber).remove();

    });

    updateTemplates();

    var message = selectTemplate.find(':selected').data('message');
    $('#messageTextArea').val(message);

});


selectTemplate.change(function () {

    var message = $(this).find(':selected').data('message');
    $('#messageTextArea').val(message);

});


function updateTemplates() {

    var templateItems;
    $.ajax({
        type: 'get',
        url: '/getAllMessageTemplates',
        dataType: 'json',
        success: function (data) {
            console.log(data);
            for(var i = 0; i < data.length;i++){
                templateItems = templateItems + '<option value="'+data[i].messageName +'" data-message="'+data[i].englishMessage+'"> '+ data[i].messageName + '</option>';
            }
            selectTemplate.append(templateItems);
        }
    });
}