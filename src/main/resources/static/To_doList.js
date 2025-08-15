document.addEventListener("DOMContentLoaded", () => {
    const successButtons = document.querySelectorAll(".check-success");

    successButtons.forEach((button, index) => {
        button.addEventListener('click', async (event) => {
            event.preventDefault();

            // 같은 index 위치의 hidden input에서 id 가져오기
            const todoItems = document.querySelectorAll(".todo-item");
            const todoIdInput = todoItems[index].querySelector(".todo-id");

            if (!todoIdInput) {
                console.error("todo-id를 찾을 수 없습니다.");
                return;
            }

            const id = todoIdInput.value;

            fetch(`/api/todos/changedisSuccessed/${id}`, {
                method: 'PATCH',
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({isSuccessed: 1})
            })
                .then(() => {
                    alert("수정이 완료되었습니다.");
                    location.reload();
                })
                .catch(err => {
                    console.error("에러 발생:", err);
                });
        });
    });

    const deleteButtons = document.querySelectorAll(".delete-button");

    deleteButtons.forEach((button, index) => {
        button.addEventListener('click', async (event) => {
            event.preventDefault();

            // 같은 index 위치의 hidden input에서 id 가져오기
            const todoItems = document.querySelectorAll(".todo-item");
            const todoIdInput = todoItems[index].querySelector(".todo-id");

            if (!todoIdInput) {
                console.error("todo-id를 찾을 수 없습니다.");
                return;
            }

            const id = todoIdInput.value;

            fetch(`/api/todos/${id}`, {
                method: 'DELETE',
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(() => {
                    alert("삭제되었습니다.")
                    location.reload();
                })
                .catch(err => {
                    console.error("에러 발생", err);
                });
        });
    });

    const form = document.getElementById("add-todo-form");

    form.addEventListener('submit', async (event) => {

    event.preventDefault(); // 기본 동작 막기 (중요!)

    try {
        const response = await fetch("/api/todos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value,
                isSuccessed: parseInt(document.getElementById('isSuccessed')?.value ?? 0),
                startTime: document.getElementById('startTime').value,
                endTime: document.getElementById('endTime').value,
                category: document.getElementById('category').value,
                priority: parseInt(document.getElementById('priority').value)
            })
        });

        if (!response.ok) {
            throw new Error("서버 에러");
        }

        alert("등록이 완료되었습니다.");
        location.href="/articles";

    } catch (err) {
        alert("에러 발생: " + err.message);
    }
});
});

const updateform = document.getElementById('update-button');

if(updateform) {

    updateform.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

            fetch(`/api/todos/${id}`, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    title : document.getElementById('title').value,
                    content : document.getElementById('content').value,
                    startTime : document.getElementById('startTime').value,
                    endTime : document.getElementById('endTime').value,
                    category : document.getElementById('category').value,
                    priority : parseInt(document.getElementById('priority').value)
                })

            }).then(()=> {
                alert("수정이 완료되었습니다.");
                location.href = "/articles";
            });
    });
}
