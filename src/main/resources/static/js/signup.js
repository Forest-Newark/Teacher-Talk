// Parent Page Drop Down for second point of contact
  $('.addContact').click(function(){
    $(this).next('.contactInfo').slideToggle();
  });

  // $('input').focus(function() {
  //     $(this).next().css('color','#00b074');
  //     $(this).next().css('transform','translateY(-27px)');
  // }).blur(function() {
  //     if($(this).val() == '') {
  //       $(this).next().css('color','#333');
  //       $(this).next().css('transform','translateY(-10px)');
  //     }
  // });


  $('input').focus(function() {
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
