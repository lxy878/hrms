$(function(){
   getEmp()

})

function getEmp(){
    const uId = $("#username").attr("uId")
    $.ajax({
        url: `http://localhost:8080/getEmployee/${uId}`,
        type: 'GET',
        contentType: 'application/json',
        cache: false
    }).done(function(data){
        console.log(data)
        fillInfo(data, "empInfo")
        fillInfo(data.address, "address")
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function fillInfo(data, parent){
    for(let key in data){
        if(key === "email") continue
        $(`#${parent} input[name=${key}]`).val(data[key])
    }
}

function update(){
    $("#update").on('click', function(){
        const empInf = $("#empInfo").children(".data") 
        const addrInf = $('#address').children(".data")

        const data = {address:{}}
        for(let e of empInf){
            data[$(e).attr("name")] = $(e).val()
        }
        for(let a of addrInf){
            data['address'][$(a).attr("name")] = $(a).val()
        }

        $.ajax({
            url: 'http://localhost:8080/',
            type: 'POST',
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
}