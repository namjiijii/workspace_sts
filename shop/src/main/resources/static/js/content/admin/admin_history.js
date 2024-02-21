
//부트스트랩이 제공하는 모달 태그를 선택하는 방법
const buy_detail_modal = new bootstrap.Modal('#buy-detail-modal');

// 모달 열기
// buy_detail_modal.show();
// 모달 닫기
// buy_detail_modal.hide();

function showModal(buyCode){
    

    fetch('/admin/adminDetailSelect', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           buyCode : buyCode
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
        }
     
        // return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!
        const bodyTable = document.querySelector('.table-in-tbody');
        const headTable = document.querySelector('.head-table');
        bodyTable.innerHTML = '';
        headTable.innerHTML = '';
        console.log(data);
        let head=``;

        head += `<colgroup>`
        head += `    <col width="20%">`
        head += `    <col width="30%">`
        head += `    <col width="20%">`
        head += `    <col width="30%">`
        head += `</colgroup>`
        head += `<tr>`
        head += `    <td >구매 번호</td>`
        head += `    <td>${data.buyCode}</td>`
        head += `    <td >구매자ID</td>`
        head += `    <td>${data.memberId}</td>`
        head += `</tr>`
        head += `<tr>`
        head += `    <td>구매 금액</td>`
        head += `    <td>${data.buyPrice}</td>`
        head += `    <td>구매 일시</td>`
        head += `    <td>${data.buyDate}</td>`
        head += `</tr>`
        
        


        let body = ``;
        
        body += `<th:block>`
        for(const detailBuy of data.detailBuyList){
            body +=     `<tr>`            
            body +=         `<td>1</td>`
            body +=         `<td>`
            body +=         `<img width="60px" src="/upload/${detailBuy.itemVO.imgList[0].attachedFileName}">`
            body +=         `${detailBuy.itemVO.itemName}`
            body +=         `</td>`
            body +=         `<td>${detailBuy.buyCnt}</td>`
            body +=         `<td>${detailBuy.totalPrice}</td>`
            body +=     `</tr>`
        }
        
        body += `</th:block>`
        headTable.insertAdjacentHTML('afterbegin',head)
        bodyTable.insertAdjacentHTML('afterbegin',body);

        buy_detail_modal.show();
    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
}



