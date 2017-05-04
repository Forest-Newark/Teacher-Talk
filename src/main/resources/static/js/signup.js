// Parent Page Drop Down for second point of contact
$(document).ready(function(){
  $('.addContact').click(function(){
    $(this).next('.contactInfo').slideToggle();
  });
});

$(document).ready(function(){
  $('#fname').focus(function() {
      $(this).next().css('color','green');
      $(this).next().css('transform','translateY(-27px)');
  }).blur(function() {
      if($('input').val() == '') {
        $('label').css('transform','translateY(-15px)');
      }
  });
});

  $('#lname').focus(function() {
      $(this).next().css('color','green');
      $(this).next().css('transform','translateY(-27px)');
  }).blur(function() {
      if($('input').val() == '') {
        $('label').css('transform','translateY(-15px)');
      }
  });

//
  // $(function() {
  //   $('input').on('change', function() {
  //     var input = $(this);
  //     if (input.val().length) {
  //       input.addClass('populated');
  //     } else {
  //       input.removeClass('populated');
  //     }
  //   });
  // });


// $('input').keyup(function(){
//   if($(this).val().length > 1){
//     $(input).setCustomValidity();
//   }
// })
  // $(document).ready(function(){
  //   $('input').on('change',function(){
  //     var input =$(this);
  //     console.log(input);
  //     if(input.val().length) {
  //       input.addClass('green-label');
  //       input.removeClass('gray-label');
  //     } else {
  //       input.removeClass('green-label');
  //       input.addClass('gray-label');
  //     }
  //   })
  // });

// $('input').click(function(){
//   $('.gray-label').hide();
//   $(this)
//     .css({'border-color':'#00b074'})

  // var input = $(this);
  // if(input.val().length){
  //   console.log('oka');
  //   $(this)
  //     .css({'border-color':'#111111'})
  // } else {
  //   console.log('erased');
  //   $(this)
  //     .css({'border-color':'#ececec'})
  // }
// });
