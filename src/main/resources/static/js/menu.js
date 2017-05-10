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

// Profile
$(document).ready(function(){
  $('.profile').click(function(){

    if(!$('#updateProfile').is(':visible'))
      $('.profile').css('background','#fff');

    $('#updateProfile').slideToggle(function(){
      if(!$('#updateProfile').is(':visible'))
      $('.profile').css('background','#faf0a1');
    });
  });
});

// Add Student
$(document).ready(function(){
  $('.student').click(function(){

    if(!$('#addStudent').is(':visible'))
      $('.student').css('background','#fff');

    $('#addStudent').slideToggle(function(){
      if(!$('#addStudent').is(':visible'))
      $('.student').css('background','#faf0a1');
    });
  });
});
