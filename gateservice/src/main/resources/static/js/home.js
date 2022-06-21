$(function(){
    getAttendance()
})

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