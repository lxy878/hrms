$(function(){
    
    $("input[type=date]").on("change", function(){
        setDays()
    })

    $("#applyResignation").on("click", function(){
        const data = {uId: $("#username").attr("uId"), }
        const children = $("#resignationForm").children(".data")
        for(let c of children){
            data[$(c).attr("name")] = $(c).val()
        }
        console.log(data)
        $.ajax({
            url: 'http://localhost:8080/submitResignation',
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
    const days= countDays($("#appliedDate").val(), $("#lastWorkingDate").val())
    $("#recoveryDays").attr("value", days);
    if(days <= 0) {
        $("#applyResignation").prop("disabled", true)
        return 
    }
    $("#applyResignation").prop("disabled", false)
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