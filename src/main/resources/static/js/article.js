const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
        fetch('/article/api/', { //fetch 백엔드에 리퀘스트
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                articleTitle: document.getElementById('articleTitle').value, //키:밸류
                articleContent: document.getElementById('articleContent').value
            })
        })
            .then(() => {
                alert('등록 완료되었습니다.'); //팝업
                location.replace('/article'); //다른 주소를 호출하겠다 ( 현재는 전체 목록으로 호출 )
            });
    });
}
