let stompClient = null;
let username = null;
let roomKey = null;
function joinRoom(event) {
   event.preventDefault();
   username = document.getElementById('username').value;
   roomKey = document.getElementById('roomKey').value;
   document.getElementById('entry-form').style.display = 'none';
   document.getElementById('chat-ui').style.display = 'block';
   connectToRoom(roomKey);
}
function connectToRoom(roomKey) {
   const socket = new SockJS('/chat');
   stompClient = Stomp.over(socket);
   stompClient.connect({}, function () {
       stompClient.subscribe(`/topic/${roomKey}`, function (message) {
           showMessage(JSON.parse(message.body));
       });
       // Optional: broadcast join message
       stompClient.send(`/app/chat/${roomKey}`, {}, JSON.stringify({
           sender: username,
           content: `${username} joined the room`,
           type: "JOIN"
       }));
   });
}
function sendMessage() {
   const content = document.getElementById('message').value;
   stompClient.send(`/app/chat/${roomKey}`, {}, JSON.stringify({
       sender: username,
       content: content,
       type: "CHAT"
   }));
   document.getElementById('message').value = '';
}
function showMessage(message) {
   const chatBox = document.getElementById('chat-box');
   const msgDiv = document.createElement('div');
   msgDiv.classList.add('message-card');
   msgDiv.textContent = `${message.sender}: ${message.content}`;
   chatBox.appendChild(msgDiv);
}
