// mobile menu
$(document).ready(function(){
  $('.mobile-toggle').click(function(){
    $('.menu').slideToggle('medium', function(){
  });
});


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
      // $('.profile').css({'background':'#faf0a1'});
      $('.profile').css({'background':'red'});

    });
  });
});

// Add Student

$(document).ready(function(){
  $('.student').click(function(){

    $('#addStudent').slideToggle();


  });
});
