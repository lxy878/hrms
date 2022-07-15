$(function(){
    $("#submit").on('click', function(){
        const empInf = $("#newEmp").children(".data") 
        const addrInf = $('#address').children(".data")

        const data = {address:{}}
        for(let e of empInf){
            data[$(e).attr("name")] = $(e).val()
        }
        for(let a of addrInf){
            data['address'][$(a).attr("name")] = $(a).val()
        }
        
        $.ajax({
            url: 'http://localhost:8080/addEmp',
            type: 'POST',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
            reset()
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})

function reset(){
    const empInf = $("#newEmp").children(".data") 
    const addrInf = $('#address').children(".data")

    for(let e of empInf){
        $(e).val("")
    }
    for(let a of addrInf){
        $(a).val("")
    }
}