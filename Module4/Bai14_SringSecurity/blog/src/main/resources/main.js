function main() {
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + token
        },
        type: "GET",
        url: "http://localhost:8000/api/posts",
        success: function (posts) {
            console.log(posts)
            showAll(posts)
        }
    })

}

function showAll(posts) {
    let str = `<input type="text" placeholder="content" id = "contentI">
<input type="file" value="upload" accept=".jpg" id="fileButton" onchange="upload(event)">
<input type="hidden" value="${JSON.parse(localStorage.getItem(storageKeyId))}" id="id">
<input type="hidden" value="${JSON.parse(localStorage.getItem(storageKeyImg))}" id="img">
<button onclick="save()">Add</button>
`
    for (let i = 0; i < posts.length; i++) {
        str += `<p>id : ${posts[i].id} ,content: ${posts[i].content} ,author: ${posts[i].user.username} , img :</p><img src="${posts[i].img}" height="50px" width="50px">`
    }
    document.getElementById("content").innerHTML = str;
}

function save() {
    let content = document.getElementById("contentI").value;
    let img = document.getElementById("img").value;
    let idP = document.getElementById("id").value;
    let post = {
        content: content,
        img: img,
        user : {
            id: idP
        }
    }
    console.log(post)
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + JSON.parse(localStorage.getItem(storageKey)),
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8000/api/posts",
        data: JSON.stringify(post),
        success: function (){
            main()
            document.getElementById("contentI").value = ""
            document.getElementById("img").value = ""
        },
        error: function (error) {
            console.log(error)
        }
    })
}