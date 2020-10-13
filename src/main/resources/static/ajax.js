
function deleteCity(cityId){
    let check = confirm("Are you sure want to delete?");
    if(check){
        console.log("cityId" +cityId)
        let htmlElement = document.getElementById("city" + cityId);
        let json = {"id": cityId};
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "DELETE",
            data: JSON.stringify(json),
            url: "/delete",
            success: function (currentPost) {
                htmlElement.remove();
                alert("Deleted Successfully!");
            }
        });
    }
}