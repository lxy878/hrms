$(function(){
    loadResignations()

    $("#tbody").on("change", "input[type=date]", function(){
        setDays(this)
    })

    $("#tbody").on("click", "button",function(){
        const tr = $(this).parent().parent()
        const lastWorkingDate = tr.find("th[name=lastWorkingDate]").find("input").val()
        const recoveryDays = tr.find("th[name=recoveryDays]").text()
        console.log(lastWorkingDate, recoveryDays)
        
        const data = {
            resignationId: tr.attr("resignationId"),
            lastWorkingDate: lastWorkingDate,
            recoveryDays: recoveryDays
        }
        
        $.ajax({
            url: 'http://localhost:8080/approveResignation',
            type:"post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
            loadResignations()
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})

function loadResignations(){
    const uId = $("#username").attr("uId")
    $.ajax({
        url: `http://localhost:8080/getResignations/${uId}`,
        type:"get",
        contentType: "application/json",
        cache: false
    }).done(function(resignations){
        console.log(resignations)
        $("#tbody").empty()
        for(let r of resignations){
            addRow(r)
        }
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function addRow({id, appliedDate, empName, lastWorkingDate, recoveryDays, userRemark, status, action}){
    let button = action
    if(action === "pending"){
        button = `<button style="background-color: lightgreen">Approve</button>`
    }
    const row = `<tr resignationId=${id}>
        <th name="appliedDate">${appliedDate}</th>
        <th>${empName}</th>
        <th name="lastWorkingDate"><input type="date" value=${lastWorkingDate}></th>
        <th name="recoveryDays">${recoveryDays}</th>
        <th>${userRemark}</th>
        <th>${status}</th>
        <th>${button}</th>
    </tr>`
    $("#tbody").append(row)
}

function setDays(lastWorkingDate){
    const tr = $(lastWorkingDate).parent().parent()
    const appliedDate = tr.find("th[name=appliedDate]").text()
    console.log(appliedDate, $(lastWorkingDate).val())
    const days= countDays(appliedDate, $(lastWorkingDate).val())
    const recoveryDays = tr.find("th[name=recoveryDays]")
    recoveryDays.text(days);
}
// last working - resignation applied
function countDays(fromDate, toDate){
    let days = 0
    if(fromDate && toDate){
        const from = new Date(fromDate)
        const to = new Date(toDate)
        days = to.getDate() - from.getDate()+1
    }
    return days
}