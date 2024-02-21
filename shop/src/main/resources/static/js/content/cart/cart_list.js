setFinalPrice();
//총 가격 계산 함수
function setFinalPrice(){
    //체크된 장바구니 상품의 총 가격을 모두 더해서 계산

    //클래스가 chk인 태그 중에서 체크가 된 태그만 선택
    const chks = document.querySelectorAll('.chk:checked');

    // const chkArr = [];
    // for(const chk of chks){
    //     if(chk.checked){
    //         chkArr.push(chk);
    //     }
    // }

    let finalPrice = 0;
    chks.forEach(function(chk, i){
        //chk 각각의 같은 행의 있는 총 가격 데이터를 찾아가기
        const strPrice = chk.closest('tr').children[5].textContent;
        
        //정규식을 사용해서 쉼표와 원화표시를 제거
        const regex = /[^0-9]/g;
        const price = parseInt(strPrice.replace(regex, ''));
        
        finalPrice = finalPrice + price;

    });
    document.querySelector('#finalPrice-span').textContent = finalPrice.toLocaleString();
}

//제목줄 체크박스 체크 및 해제 시 모든 체크박스 체크 및 해제
function checkAll(){
    const chkAll = document.querySelector('#chkAll');
    const chks = document.querySelectorAll('.chk');

    if(chkAll.checked){
        for(const chk of chks){
            chk.checked = true;
        }
    }
    else{
        for(const chk of chks){
            chk.checked = false;
        }
    }
    setFinalPrice();
}


//삭제버튼 클릭 시 장바구니에서 삭제
function deleteCart(cartCode){

    if(confirm('선택한 상품을 장바구니에서 삭제할까요 ?')){
        location.href= `/cart/deleteCart?cartCode=${cartCode}`;
    }
}

//장바구니 상품의 수량 변경
function updateCart(cartCode, cnt ,itemPrice){
    const cartCnt = cnt.closest('td').querySelector('input[type="number"]').value;
    fetch('/cart/updateCartCnt', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           cartCode : cartCode,
           cartCnt : cartCnt
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
        }
    
        return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        //return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!

        //총 가격
        //단가 * 수량
        //단가
        
        //수량
    
        
        const totalPrice = itemPrice * cartCnt

        cnt.closest('tr').querySelector('.totalPrice-span').textContent = '₩' + totalPrice.toLocaleString();
        setFinalPrice();
        alert('상품 수량 변경이 되었습니다.');
    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
}


//선택 삭제
function deleteCarts(){
    //만약에 체크된 상품이 하나도 없다면
    //alert으로 '삭제할 상품을 선택하세요'
    const chks = document.querySelectorAll('.chk:checked')
    
    if(chks.length == 0){
        alert('삭제 할 상품을 선택하세요')
        return ;
    }
    
    //컨트롤러로 넘겨 줄 cartCode들
    
    const cartCodes = [];
    for(const chk of chks){
        cartCodes.push(chk.value);
    }
    
    location.href=`/cart/deleteCarts?cartCodeList=${cartCodes}`;

}


function buys(){
    const chks = document.querySelectorAll('.chk:checked')
    

    if(chks.length == 0){
        alert('구매 할 상품을 선택하세요')
        return;
    }

    const cartCodesList = [];
    for(const chk of chks){
        cartCodesList.push(chk.value);
    }
    
    
    location.href=`/buy/buyCarts?cartCodeList=${cartCodesList}`;
    
}

