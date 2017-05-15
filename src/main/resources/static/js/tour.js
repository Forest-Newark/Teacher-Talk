/**
 * Created by forestnewark on 5/9/17.
 */
var tour = {
    id: "hello-hopscotch",
    steps: [
        {
            title: "Welcome to Teacher Talk",
            number: "1",
            content: "This is your main page as a teacher that allows you to send messages",
            target: document.getElementById("teacherTalkTitle"),
            placement: "bottom"
        },
        {
            title: "Add Students",
            number: "2",
            content: "Start by typing a students name here. This list will populate with all students who are currently registered.",
            target: document.getElementById("student"),
            placement: "right"
        },
        {
            title: "Select Message Template",
            number: "3",
            content: "Choose one of the provided templates to get started. You will get a chance to see and edit the body of your message.",
            target: document.getElementById("messageSelect"),
            placement: "right"
        },
        {
            title: "Message Area",
            number: "4",
            content: "This is the body of your message. Feel free to edit it or send it as is",
            target: document.getElementById("messageTextArea"),
            placement: "top"
        },
        {
            title: "Send Message",
            number: "5",
            content: "Hit send and Teacher Talk takes care of the rest.",
            target: document.getElementById("messageSendButton"),
            placement: "top"
        }
    ]
};

// Start the tour!
var btn = document.getElementById('startTour');

btn.onclick = function() {
    hopscotch.startTour(tour);
};

// Toggle Eye
// Added By Lyndsey 5.13.17

$(document).ready(function(){
  $('.tourclick').click(function(){

    $(".message i").removeClass("fa-eye-slash");
    $(".message i").addClass("fa-eye");


    if(!$('#startTour').is(':visible'))
    // $(".message i").removeClass("fa-eye");
      $(".message i").addClass("fa-eye-slash");
      $('.fa-eye').css('color', 'transparent');
      $('.fa-eye-slash').css('color', '#fff');

    $('#startTour').slideToggle(function(){
      if(!$('#startTour').is(':visible'))
        $('.fa-eye').css('color', 'black');
    });
  });
  // Hide tour once it's started
  $('#startTour').click(function(){
    $('#startTour').slideToggle();
    $(".message i").removeClass("fa-eye-slash");
    $(".message i").addClass("fa-eye");
    $('.fa-eye').css('color', 'black');
  });
});
