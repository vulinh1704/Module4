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
<input type="hidden" value="${localStorage.getItem(storageKeyId)}" id="id">
<input type="hidden" id="img">
<button onclick="save()">Add</button>
<button onclick="logout()">Logout</button>
<br>
<input type="text" placeholder="search by name author" id="search">
<button onclick="search()">Search</button>
`
    for (let i = 0; i < posts.length; i++) {
        if (posts[i].user.id !== Number(localStorage.getItem(storageKeyId))) {
            str += `<p>id : ${posts[i].id} ,content: ${posts[i].content} ,author: ${posts[i].user.username} , img :</p><img src="${posts[i].img}" height="50px" width="50px">`
        } else {
            str += `<p>id : ${posts[i].id} ,content: ${posts[i].content} ,author: ${posts[i].user.username} , img :</p><img src="${posts[i].img}" height="50px" width="50px">
            <button onclick="formEditP(${posts[i].id})">Edit</button> <button onclick="deleteP(${posts[i].id})">Delete</button>`
        }
    }
    document.getElementById("content").innerHTML = str;
}

function save() {
    let content = document.getElementById("contentI").value;
    let img = localStorage.getItem(storageKeyImg);
    let idP = document.getElementById("id").value;
    let post = {
        content: content,
        img: img,
        user: {
            id: idP
        }
    }
    console.log(post)
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem(storageKey),
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8000/api/posts",
        data: JSON.stringify(post),
        success: function () {
            main()
            document.getElementById("contentI").value = ""
            document.getElementById("img").value = ""
            localStorage.setItem(storageKeyImg, "");
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function search() {
    let name = document.getElementById("search").value;
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem(storageKey)
        },
        type: "GET",
        url: "http://localhost:8000/api/posts/" + name,
        success: function (posts) {
            console.log(posts)
            let str = `<input type="text" placeholder="content" id = "contentI">
                        <input type="file" value="upload" accept=".jpg" id="fileButton" onchange="upload(event)">
                        <input type="hidden" value="${JSON.parse(localStorage.getItem(storageKeyId))}" id="id">
                        <input type="hidden" id="img">
                        <button onclick="save()">Add</button>
                        <br>
                        <input type="text" placeholder="search by name author" id="search">
                        <button onclick="search()">Search</button>`
            for (let i = 0; i < posts.length; i++) {
                str += `<p>id : ${posts[i].id} ,content: ${posts[i].content} ,author: ${posts[i].user.username} , img :</p><img src="${posts[i].img}" height="50px" width="50px">`
            }
            document.getElementById("content").innerHTML = str;
        },
        error: function (error) {
            console.log(error)
        }
    })
}
function deleteP(id){
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem(storageKey)
        },
        type: "DELETE",
        url: "http://localhost:8000/api/posts/" + id,
        success: function () {
            main()
        },
        error: function (error) {
            console.log(error)
        }
    })
}
function formEditP(id){
   let str = ``;
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem(storageKey)
        },
        type: "POST",
        url: "http://localhost:8000/api/posts/" + id,
        success: function (post) {
           str += `<input type="text" value="${post.content}" id = "contentEdit">
                    <img src="${post.img}" width="50px" height="50px" id = "image">
                    <input type="file" value="upload" accept=".jpg" id="fileButtonEdit" onchange="upload(event)">
                    <button onclick="edit(${id})">Save</button>`
            document.getElementById("editF").innerHTML = str
        },
        error: function (error) {
            console.log(error)
        }
    })
}
function edit(idU) {
    let content = document.getElementById("contentEdit").value;
    let img = localStorage.getItem(storageKeyImg);
    let idP = document.getElementById("id").value;
    let post = {
        content: content,
        img: img,
        user: {
            id: idP
        }
    }
    console.log(post)
    $.ajax({
        headers: {
            Authorization: 'Bearer ' + localStorage.getItem(storageKey),
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8000/api/posts/"  + idU,
        data: JSON.stringify(post),
        success: function () {
            document.getElementById("editF").innerHTML = ""
            main()
            localStorage.setItem(storageKeyImg, "");
        },
        error: function (error) {
            console.log(error)
        }
    })
}

function logout(){
    localStorage.setItem(storageKey , "");
    localStorage.setItem(storageKeyId , "");
}