function getBooks() {
    $.get("/api/books", function(data) {
        var htmlToInsert = "";

        $.each(data, function(index, value) {
            htmlToInsert += "<div>";
            htmlToInsert += value.bookName;
            htmlToInsert += "</div>";
        });

        $("#book-list").html(htmlToInsert);
    });
}


$("#book").on("paste keyup", function() {
    if ($("#book").val().length >=3) {
        $.get("/api/books/" + $("#book").val(), function(data) {
            var htmlToInsert = "";

            $.each(data, function(index, value) {
                htmlToInsert += "<div>";
                htmlToInsert += value.bookName;
                htmlToInsert += "</div";
            });

            $("#book-list").html(htmlToInsert);
        });
    }
});

function getAuthors() {
    $.get("/api/_admin/allAuthors", function(data) {
        var htmlToInsert = "";

        $.each(data, function(index, value) {
            htmlToInsert += "<div>";
            htmlToInsert += value.name + " " + value.surname ;
            htmlToInsert += "</div>";
        });

        $("#author-list").html(htmlToInsert);
    });
}

$("#author").on("paste keyup", function() {
    if ($("#author").val().length >=3) {
        $.get("/api/_admin/allAuthors/" + $("#author").val(), function(data) {
            var htmlToInsert = "";

            $.each(data, function(index, value) {
                htmlToInsert += "<div>";
                htmlToInsert += value.name +  " " + value.surname;
                htmlToInsert += "</div";
            });

            $("#author-list").html(htmlToInsert);
        });
    }
});

function openModal() {
    document.getElementById("modal").style.display = "block";
}

function closeModal() {
    document.getElementById("modal").style.display = "none";
}
