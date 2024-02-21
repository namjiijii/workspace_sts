/////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////-- 함수 선언 영역/////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////




//search 버튼 클릭 시 주소록 검색 팝업 창 띄우기
    

function searchAddress(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            document.querySelector('#postCode').value = data.zonecode;
            
            
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            document.querySelector('#memberAddr').value = roadAddr;

        }
    }).open();
}

//join버튼 클릭 시 from 태그를 submit
function join(){
    //0. submit 전에 유효성 검사
    //-1) ID를 입력했는지 확인
    
    const idInput = document.querySelector('#memberId');
    if(idInput.value == ''){
      alert('ID는 필수입력 사항입니다.');
      return ;
    }
    //-2) ID 입력 문자의 길이가 20을 초과하는지 검사
    
    
    if(idInput.value.length > 20){
      alert('ID는 20글자 내로 작성하세요.');
      return ;
    }
    
    // const pwInput1 = document.querySelector('#memberPw1');
    // const pwInput2 = document.querySelector('#memberPw2');

    const pwInputs = document.querySelectorAll('input[type="password"]');
    //-3) PW가 서로 일치하는지 확인
    // if(pwInput1.value != pwInput2){
    //   alert('비밀번호가 다릅니다.');
    //   return ;
    // }
    if(pwInputs[0].value != pwInputs[1].value){
      alert('입력한 두 비밀번호가 다릅니다.\n비밀번호를 다시 입력해주세요');
      return;
    }
    //문자 + 숫자 + 특수문자가 포함된 4~12자리의 글자
    const regExp = /^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    //test 함수의 매개변수로 들어온 문자가 정규식 조건에 부합하면 return true
    const expResult = regExp.test(pwInputs[0].value);
  //   if(!expResult){
  //     alert('비밀번호는 문자, 숫자, 특수문자를 \n포함한 4~12글자로 가능합니다');
  //     return;
  //   }


    //1 submit 시킬 form 태그를 선택 후 submit 함수 실행
    document.querySelector('#join-form').submit();
}

//클릭 시 로그인 페이지로 이동
function loginForm(){
    location.href='/member/loginForm';
}


//로그아웃 함수
function logout(){
  const result = confirm('로그아웃 하시겠습니까?')

  if(result){
    location.href='/member/logout';
  }
  
}


/////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////-- 이벤트 선언 영역/////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////



//회원가입 모달창이 닫힐 때 실행되는 이벤트
//1. 모달창을 선택한다
const joinModal = document.querySelector('#join-modal');
//2. 선택한 태그에 이벤트 달아주기
//hidden.bs.modal : 모달창이 닫힐 때 실행
joinModal.addEventListener('hidden.bs.modal', function(){
  document.querySelector('#join-form').reset();
});
//매개 변수가 하나일때 ()를 지울 수 있음
//   let aaa3 = (event) =>{

//   }


