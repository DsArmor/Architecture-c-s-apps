var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/note/all', function (baseContent) {
            showNotes(JSON.parse(baseContent.body));
        });
        setInterval(sendTableUpdateRequest, 2000);
    });
}

function sendTableUpdateRequest() {
    stompClient.send("/app/note/all")
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function addNote() {
    stompClient.send("/app/note/add", {}, JSON.stringify({'name': $("#name").val(), 'note': $("#text-note").val()}));
}

function showNotes(notes) {
    console.log(notes)
    $("#messages").text('');
    for (let note of notes) {
        console.log(note);
        $("#messages").append("<tr><td>" + note["name"] + "</td><td>" + note["note"] +"</td></tr>")
    }
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { addNote(); });
});