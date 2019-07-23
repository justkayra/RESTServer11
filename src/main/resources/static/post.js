
function ping(){
    document.getElementById('extractSearchContractCustomerFlow').getElementsByTagName('form')[0].submit();
}

function submitX(){
    $.ajax({
        type: "POST",
        url: "/post",
        data: "{}",
        dataType: "json",
        success: function(data, textStatus) {
            window.location.href = '/get';            
        }
    });
}