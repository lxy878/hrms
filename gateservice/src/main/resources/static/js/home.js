$(function(){
    $("#t").on('click', function(){
        const uId = $("#username").attr("uid")
        $.ajax({
            url: `http://localhost:8080/getAttendance/${uId}`,
            type: 'GET',
            contentType: 'application/json',
            cache: false
        }).done(function(data){
            console.log(data)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})