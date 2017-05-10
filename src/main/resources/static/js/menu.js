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

    if(!$('#addStudent').is(':visible')){
      $('.student').css('background','#fff');
      $('.student a').css({'-webkit-box-shadow' : 'none', '-moz-box-shadow' : 'none', 'box-shadow' : 'none'});
    }

    $('#addStudent').slideToggle(function(){
      if(!$('#addStudent').is(':visible')){
        $('.student').css('background','#faf0a1');
        $('a').css({'-webkit-box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)', '-moz-box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)', 'box-shadow' : '0 2px 3px rgba(0, 0, 0, 0.1)'});
      } else {
        $('.student a').css({'-webkit-box-shadow' : 'none', '-moz-box-shadow' : 'none', 'box-shadow' : 'none'});
      }
    });
  });
});

// Add Template
$(document).ready(function(){
  $('.template').click(function(){
    if(!$('#addTemplate').is(':visible'))
      $('.template').css('background','#fff')
    $('#addTemplate').slideToggle(function(){
      if(!$('#addTemplate').is(':visible'))
        $('.template').css('background','#faf0a1')
    });
  });
});
