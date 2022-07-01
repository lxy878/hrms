$(function(){
    getAttendance()
    leaveApproveCheck()
})

function leaveApproveCheck(){
    const role = $("#role").attr("role")
    const uId = $("#username").attr("uid")
    if(role !== "admin"){
        return
    }

    $.ajax({
        url: `http://localhost:8080/checkLeaves/${uId}`,
        type: 'GET',
        contentType: 'application/json',
        cache: false
    }).done(function(data){
        console.log(data)
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}
function getAttendance(){
    const uId = $("#username").attr("uid")
    $.ajax({
        url: `http://localhost:8080/getAttendance/${uId}`,
        type: 'GET',
        contentType: 'application/json',
        cache: false
    }).done(function(data){
        addAttendanceToTable(data)
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}
function addAttendanceToTable(list){
    const table = $("#attendance-table")
    for(let l of list){
        const row = `<tr><td>${l.attendanceDate}</td><td>${l.inTime}</td><td>${l.outTime}</td><td>${l.attendance}</td></tr>`
        table.append(row)
    }
}