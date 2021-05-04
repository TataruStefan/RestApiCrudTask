$("#add-billionaire").on("click", () => {

    $.ajax({
        method: "POST",
        url: "/rest/billionaires/add",
        data: JSON.stringify(userObject()),
        contentType: "application/json",
        success: response => {
            alert(`SUCCESS: ${response}`);
            window.location.href = "/";
        },
        error: err => {
            let errorObj = err.responseJSON;
            alert(`ERROR: "${errorObj.message}" \nTIME: ${errorObj.time}`);
        }
    });

});

const userObject = () => {
    return {
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        career: $("#career").val()
    };
};