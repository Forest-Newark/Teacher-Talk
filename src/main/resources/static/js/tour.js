/**
 * Created by forestnewark on 5/9/17.
 */
var tour = {
    id: "hello-hopscotch",
    steps: [
        {
            title: "Welcome to Teacher Talk",
            content: "This is your main page as a teacher that allows you to send messages",
            target: document.getElementById("teacherTalkTitle"),
            placement: "bottom"
        },
        {
            title: "Add Students",
            content: "Start by typing a students name here. This list will populate with all students who are currently registered.",
            target: document.getElementById("student"),
            placement: "right"
        },
        {
            title: "Select Message Template",
            content: "Choose one of the provided templates to get started. You will get a chance to see and edit the body of your message.",
            target: document.getElementById("messageSelect"),
            placement: "right"
        },
        {
            title: "Message Area",
            content: "This is the body of your message. Feel free to edit it or send it as is",
            target: document.getElementById("messageTextArea"),
            placement: "top"
        },
        {
            title: "Send Message",
            content: "Hit send and teacher talk takes care of the rest.",
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

