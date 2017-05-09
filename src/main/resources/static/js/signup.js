// Parent Page Drop Down for second point of contact and students
$(document).ready(function(){
  $('.addContact').click(function(){
    $(this).next('.contactInfo').slideToggle();
  });
});

// Input Form

$(document).ready(function(){
  if($('input').val()!==''){
    $(this).css({'border': '1px solid #00b074'});
    $(this).next().css({
      'color':'#00b074',
      'transform': 'translateY(-27px)',
    });
  }
});

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


// mobile menu
$(document).ready(function(){
  $('.mobile-toggle').click(function(){
    $('.menu').slideToggle();
  });
});

// Teacher Sign in Page Profile Image
$(document).ready(function(){
  $('.profile').click(function(){
    $('#updateProfile').slideToggle();
  });
});
