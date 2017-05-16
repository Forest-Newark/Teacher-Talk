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

  $(".menu-section").mouseover(function(){
        $(this).css({
          background: '#fff',
          transition: 'background .5s'
        });
  });
  $(".menu-section").mouseout(function(){
        $(this).css({
          background: 'transparent',
          transition: 'background .5s'
        });
  });

  $('.menu-section').click(function(){

    $('.menu-section a:focus').css('background', '#fff');

    $(this).find('i').toggleClass('fa-angle-down fa-angle-up');

      $(this).next().slideToggle(function(){
        if($(this).is(':hidden')){
          $('.menu-section a:focus').css('background', 'transparent');
        }
        // else {
        //   $('.menu-section a:focus').css('background', '#fff');
        // }
      });
  });
});
