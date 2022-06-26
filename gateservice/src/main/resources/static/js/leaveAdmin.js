$(function(){
    loadLeaveTable()
})

function loadLeaveTable(){
    $.ajax({
        url: `http://localhost:8080/getEmpLeaves`,
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

function addLeave({
    action, appliedDate, days, empName, 
    fromDate, id, leaveType, processName, 
    status, toDate}, table){
    let buttons = action
    if(action === null){
        buttons = `<button class="button" value="approved" style="background-color: lightgreen">Approve</button> 
        <button class="button" value="denied" style="background-color: deeppink">Deny</button>`
    }
    const row = `<tr leaveId=${id}>
        <th>${appliedDate}</th>
        <th>${leaveType}</th>
        <th>${empName}</th>
        <th>${fromDate}</th>
        <th>${toDate}</th>
        <th>${days}</th>
        <th>${processName}</th>
        <th>${status}</th>
        <th>${buttons}</th>
  </tr>`
    
    table.append(row);
}