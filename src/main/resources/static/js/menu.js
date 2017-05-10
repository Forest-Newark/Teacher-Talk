// mobile menu
$(document).ready(function(){
  $('.mobile-toggle').click(function(){
    $('.menu').slideToggle('medium', function(){
  });
});



$(window).resize(function(){
  if ($(window).width() > 767)
    $('.menu').css({'display': 'block !important'});
})

//////////////////////////
// Teacher Message Page
// Header Slide Toggles
/////////////////////////

// Profile

$(document).ready(function(){
  $('.profile').click(function(){

    if(!$('#updateProfile').is(':visible'))
      $('.profile').css({'background':'#fff'});

    $('#updateProfile').slideToggle(function(){
      if(!$('#updateProfile').is(':visible'))
      $('.profile').css({'background':'#faf0a1'});
    });
  });
});

// Add Student
