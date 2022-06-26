$(function(){
    $("input[type=date], #leaveFor").on("change", function(){
        setDays()
    })
    
    // $("#leaveFor").on("change", function(){
    //     setDays()
    // })

    $("#applyAttendance").on("click", function(){
        const data = {uId: $("#username").attr("uId"), }
        const children = $("#leaveForm").children(".data")
        for(let c of children){
            data[$(c).attr("name")] = $(c).val()
        }
        console.log(data)
        $.ajax({
            url: 'http://localhost:8080/submitLeave',
            type:"post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})

function setDays(){
    const days= countDays($("#fromDate").val(), $("#toDate").val(), $("#leaveFor").val())
    $("#days").attr("value", days);
    if(days <= 0) {
        $("#applyAttendance").prop("disabled", true)
        return 
    }
    $("#applyAttendance").prop("disabled", false)
}

function countDays(fromDate, toDate, leaveFor){
    let days = 0
    if(fromDate && toDate && leaveFor){
        const from = new Date(fromDate)
        const to = new Date(toDate)
        const n = to.getDate() - from.getDate()+1
        days =  n*parseFloat(leaveFor)
    }
    return days
}