/**
 * Created by forestnewark on 5/11/17.
 */

$('#teacherAddTemplate').click(function(){

    var templateName = $('#addTemplateName').val();
    var templateBody = $('#messageTemplateArea').val();

    var formData = new FormData();
    formData.append('templateName',templateName);
    formData.append('templateBody',templateBody);

    $.ajax({
        url: "/teacherAddTemplate",
        type: 'post',
        cache: false,
        contentType: false,
        processData: false,
        data: formData,
        success: function (data) {
            alertify.success("Successfully Added Template");
            $('#addTemplate').slideToggle(function(){
                if(!$('#addTemplate').is(':visible'))
                    $('.template').css('background','#faf0a1');
            });
            updateTemplates();
        }
    });

});

//
// $('#teacherAddTemplate').click(function(){
//     var templateItems;
//     $.ajax({
//         type: "GET",
//         url:"/getAllMessageTemplates",
//         dataType: "json",
//         success: function (data) {
//             $.each(data,function(i,item)
//             {
//                 templateItems = templateItems + '<option> '+ item[i].messageName + '<option> ';
//             });
//             $("#messageSelect").append(listitems);
//         }
//     });
// });
//


