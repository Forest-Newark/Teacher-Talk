//Get the modal
var modal = document.getElementById('modal');

//Get the button that opens the modal
var btn = document.getElementById('openModal');


//Get the element that closes the modal
var close = document.getElementsByClassName('close')[0];

//When the user clicks on the button, open the modal
btn.onclick = function() {
  console.log(btn);
    modal.style.display = "block";
}

//When the user click on close
close.onclick = function() {
  modal.style.display='none';
}

//When the user clicks anywhere outside of the modal, close it
window.onclick=function(event) {
  if(event.target == modal) {
    modal.style.display = 'none';
  }
}
