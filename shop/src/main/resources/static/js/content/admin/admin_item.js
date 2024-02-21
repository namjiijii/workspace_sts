const updateItemCode = document.querySelector('#updateItemCode').value;

if(updateItemCode != 0){
    detailItem(updateItemCode);
}
function detailItem(itemCode){
    
    fetch('/admin/selectItemDetail', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           itemCode : itemCode
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
        }
    
        //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!
        const detail_div = document.querySelector('.detail-div');

        detail_div.innerHTML = '';
        // console.log(data);
        console.log(data.itemDetail);
        let str = '';
        
        str += `
        <form action="/admin/updateItemDetail" method="post">
            <table class="detail-table table table-borderless align-middle">
            <input type="hidden" name="itemCode" value="${itemCode}">
                <colgroup>
                    <col width="25%">
                    <col width="25%">
                    <col width="25%">
                    <col width="25%">
                </colgroup>
                <tr class="mb-3" style="font-weight: bold;">
                    <td colspan="4">상품 기본정보</td>
                </tr>
                <tr>
                    <td>카테고리</td>
                    <td>
                        <select name="cateCode" class="form-select" aria-label="Default select example">`;
                    
                    for(const category of data.cateList){
                        if(category.cateCode == data.itemDetail.cateCode){
                            str +=`<option value="${category.cateCode}" selected>${category.cateName}</option>`
                        }
                        else{
                            str +=`<option value="${category.cateCode}">${category.cateName}</option>`
                        }
                        
                    };
        str +=         `</select>
                    </td>
                    <td>
                        상품수량
                    </td>
                    <td><input id="itemCnt" name="itemStock" class="form-control" min="0" max="100" type="number" style="width: 100px;" value="${data.itemDetail.itemStock}"></td>
                </tr>
                <tr>
                    <td>상품명</td>
                    <td colspan="3"><input name="itemName" class="form-control" id="itemName" type="text" value="${data.itemDetail.itemName}"></td>
                </tr>
                <tr>
                    <td>상품상태</td>`
                    if(data.itemDetail.itemStatus == 1){
                        str += `<td><input type="radio" name="itemStatus" checked value="1">준비 중</td>`;
                    }

                    else{
                        str += `<td><input type="radio" name="itemStatus" value="1">준비 중</td>`;
                    }
                    if(data.itemDetail.itemStatus == 2){
                        str += `<td><input type="radio" name="itemStatus" checked value="2">판매 중</td>`;
                    }

                    else{
                        str += `<td><input type="radio" name="itemStatus" value="2">판매 중</td>`;
                    }
                    if(data.itemDetail.itemStatus == 3){
                        str += `<td><input type="radio" name="itemStatus" value="3" checked>매진</td>`;
                    }

                    else{
                        str += `<td><input type="radio" name="itemStatus" value="3">매진</td>`;
                    }
                    
                str+=`</tr>
                <tr style="font-weight: bold;">
                    <td colspan="4"> 상품 이미지 정보</td>
                </tr>
                <tr>
                    <td colspan="4"> 메인 이미지</td>
                </tr>
                <tr>`;
                    for(const img of data.itemDetail.imgList){
                        if(img.isMain == 'Y'){
                            str += `<td colspan="4"><span onclick="showModal('${img.attachedFileName}')"> ${img.originFileName}</span></td>`;
                        }
                    }
                    
                str +=`</tr>
                <td colspan="4"> 상세 이미지</td>
                <tr>`;
                    let cnt =0 ;
                    data.itemDetail.imgList.forEach(function(img, idx){
                        if(img.isMain == 'N'){
                            if(cnt == 0){
                                str +=`<td colspan="4"><span onclick="showModal('${img.attachedFileName}')">${img.originFileName}</span></td>`
                                cnt++
                            }
                        }
                    })
                
        str += `</tr>
                <tr>
                    <td class="d-grid">
                        <input type="submit" class="btn btn-outline-success" value="변경">
                    </td>
                </tr>
                
            </table>  
            </form>
        `;


        detail_div.insertAdjacentHTML("afterbegin", str);

        
        
    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
}



//이미지 모달창 띄우기
function showModal(attachedFileName){
    const img_modal = new bootstrap.Modal('#img-modal');
    
    img_tag = document.querySelector('#img-modal img');
    img_tag.src= `/upload/${attachedFileName}`;

    img_modal.show();
    
}

