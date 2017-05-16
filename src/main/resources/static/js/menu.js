// mobile menu
$(document).ready(function(){
  $('.mobile-toggle').click(function(){
    $('.menu').slideToggle();
  });
});


//////////////////////////
// Teacher Message Page
// Header Slide Toggles
/////////////////////////

// Menu Drop in Each Section
$(document).ready(function(){
  $('.menu-section').click(function(){

    $(this).find('i').toggleClass('fa-angle-down fa-angle-up');

      $(this).next().slideToggle(function(){
        if($(this).is(':hidden')){
          $('.menu-section a:focus').css('background', 'transparent')
        }
      });
  });
});
