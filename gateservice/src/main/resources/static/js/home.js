$(function(){
    getAttendance()
    leaveApproveCheck()
    getHolidays()
    getEmployeesWithBirthday()
})

function getEmployeesWithBirthday(){
    $.ajax({
        url: `http://localhost:8080/getEmployeesWithBirthday`,
        type: 'GET',
        contentType: 'application/json',
        cache: false
    }).done(function(data){
        console.log(data)
        const birthdays = $('#birthdays')
        let days = ""
        for(let b of data){
            days += setBirthday(b)
        }
        birthdays.append(days)
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function getHolidays(){
    $.ajax({
        url: `http://localhost:8080/getHolidays`,
        type: 'GET',
        contentType: 'application/json',
        cache: false
    }).done(function(data){
        const event = $("#events")
        let holidays = ""
        for(let h of data){
            holidays += setEvent(h)
        }
        event.append(holidays)
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

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

function setBirthday({name, birthDate}){
    const parts = birthDate.split("-")
    return `<p>${name}'s Birthdate: ${parts[1]}/${parts[2]}</p>`
}

function setEvent({name, date, description}){
    date = date.replace('-','/')
    return `<div class="w3-card w3-round w3-white">
                <div class="w3-container">
                <p><strong>${name}, ${date}</strong></p>
                <p>${description}</p>
                </div>
            </div><br>`
}

function addAttendanceToTable(list){
    const table = $("#attendance-table")
    for(let l of list){
        const row = `<tr><td>${l.attendanceDate}</td><td>${l.inTime}</td><td>${l.outTime}</td><td>${l.attendance}</td></tr>`
        table.append(row)
    }
}