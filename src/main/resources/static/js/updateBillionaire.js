$(document).ready(() => {
    const id = new URL(document.URL).searchParams.get("uid");
    $.ajax({
        url: `/rest/billionaires/${id}`,
        method: "GET",
        success: billionaire => {
            fillInputs(billionaire);
        },
        error: err => {
            const errorObj = err.responseJSON;
            alert(`ERROR: "${errorObj.message}" \nTIME: ${errorObj.time}`);
        }
    })
});

function fillInputs(data) {
    $("#firstName-update").val(data.firstName);
    $("#lastName-update").val(data.lastName);
    $("#career-update").val(data.career);
}

$("#update-billionaire-submit").on("click", () => {
    const id = new URL(document.URL).searchParams.get("uid");
    $.ajax({
        url: `/rest/billionaires/update/${id}`,
        method: "PUT",
        data: JSON.stringify(newBillionaireObj()),
        contentType: "application/json",
        success: response => {
            alert(`SUCCESS: ${response}`);
            window.location.href = "/";
        },
        error: err => {
            const errorObj = err.responseJSON;
            alert(`ERROR: "${errorObj.message}" \nTIME: ${errorObj.time}`);
        }
    });
});

const newBillionaireObj = () => {
    return {
        firstName: $("#firstName-update").val(),
        lastName: $("#lastName-update").val(),
        career: $("#career-update").val()
    };
};