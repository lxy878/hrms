$(function(){
    loadLeaveTable()

    $("input[type=date], #leaveFor").on("change", function(){
        setDays()
    })

    $("#applyLeave").on("click", function(){
        const data = {uId: $("#username").attr("uId"), }
        const children = $("#leaveForm").children(".data")
        for(let c of children){
            data[$(c).attr("name")] = $(c).val()
        }
        $.ajax({
            url: 'http://localhost:8080/submitLeave',
            type:"post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
            loadLeaveTable()
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})

function loadLeaveTable(){
    const uId = $("#username").attr("uId")
    $.ajax({
        url: `http://localhost:8080/getLeaves/${uId}`,
        type:"get",
        contentType: "application/json",
        cache: false
    }).done(function(leaves){
        console.log(leaves)
        const table = $("#leaveTbody")
        table.empty()
        for(let l of leaves){
            addLeave(l, table)
        }
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function addLeave({leaveApplied, leaveBalance,leaveType, openBalance, yearlyAllowance, id}, table){
    const row = `<tr leaveId=${id}>
        <td>${leaveType}</td>
        <td>${yearlyAllowance}</td>
        <td>${openBalance}</td>
        <td>${leaveApplied}</td>
        <td>${leaveBalance}</td>
    </tr>`
    
    table.append(row);
}

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