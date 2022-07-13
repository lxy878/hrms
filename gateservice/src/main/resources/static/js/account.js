$(function(){

    changePassword()
})



function changePassword(){
    $("#submit").on('click', function(){
        const passwords = $("#setPassword").children(".data") 

        const data = {uId: $("#username").attr("uId")}
        for(let p of passwords){
            data[$(p).attr("name")] = $(p).val()
        }
        $.ajax({
            url: 'http://localhost:8080/changePassword',
            type: 'POST',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            alert(data.message)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
}