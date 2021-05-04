$(document).ready(() => {
    getAllBillionaires();
});

function getAllBillionaires() {
    $.ajax({
        url: "/rest/billionaires/",
        method: "GET",
        success: response => {
            displayBillionaires(response);
        },
        error: err => {
            let responseObj = err.responseJSON;
            alert(`ERROR: " ${responseObj.message} " TIME ${responseObj.time}`);
        }
    })
}

function displayBillionaires(billionaires) {
    if (billionaires.length > 0) {
        let placeholder = "";
        $.each(billionaires, (index, billionaire) => {
            placeholder +=
                `<tr>
                <td>${(index + 1)}</td>;
                <td>${billionaire.firstName}</td>
                <td>${billionaire.lastName}</td>
                <td>${billionaire.career}</td>
                <td><button class='update-billionaire' value="${billionaire.id}">Update</button></td>
                <td><button class='delete-billionaire' value="${billionaire.id}">Delete</button></td>
            </tr>`;
        });
        $("#billionaire-placeholder tbody").html(placeholder);
    } else {
        $("#billionaire-div").html("<p>No billionaires in the system.</p>");
    }
}

$("#add").on("click", () => {
    window.location.href = "/addBillionaire.html";
});

$("#billionaire-placeholder").on("click", ".delete-billionaire", function () {
    if (confirm("Click okay if the billionaire lost his or her fortune")) {


        let id = this.value;
        console.log(id);
        $.ajax({
            url: `/rest/billionaires/delete/${id}`,
            method: "DELETE",
            success: message => {
                alert(`SUCCESS: ${message}`);
                getAllBillionaires();
            },
            error: err => {
                let responseObj = err.responseJSON;
                alert(`ERROR: "${responseObj.message}" TIME: ${responseObj.time}`);
            }
        });
    }
});

$("#billionaire-placeholder").on("click", ".update-billionaire", function () {
    let id = this.value;
    window.location.href = `/updateBillionaire.html?uid=${id}`;
});