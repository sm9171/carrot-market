# 개발 요구사항

## 1) 회원가입

### 1.1) 랜딩페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 32 17" src="https://user-images.githubusercontent.com/18053020/211231216-87b9a185-f58f-47d0-8bc2-453ffadf613b.png">
- 로그인을 하지 않았으면 랜딩페이지로 아래와 같은 화면 노출
- 시작하기를 누르면 회원가입 페이지로 넘어갑니다.

### 1.2) 회원가입 화면
- <img width="200" alt="스크린샷 2022-01-10 오후 12 32 28" src="https://user-images.githubusercontent.com/18053020/211232464-552445e8-a88f-4cfd-8b15-fc6870eff15c.png"> 
- 이메일, 비밀번호, 이름, 핸드폰번호, 닉네임을 입력받으면 가입완료!
- 가입완료시 메인으로 리다이렉트

### 1.3) 로그인 화면
- 아이디, 비밀번호를 입력한 후 로그인을 누르면 정보확인 후 메인 페이지로 접속
- 회원정보가 잘못되면 아이디, 비밀번호가 올바르지 않다는 오류 팝업창
    - 추가기능 : 비밀번호 찾기나 아이디 찾기 등의 기능
    - 추가기능 : 회원가입시 이메일 인증과정(계정 활성화/비활성화 기능)
    - 당근마켓의 처음 버전은 판교장터로, 직장 메일이나 학교 메일만 가입 가능하게 추가적으로 설정해도 되고, 구글 오어스로 회사 구글계정 사용자만 로그인되게 해도 될듯

### 1.4) (추가기능) 토큰만료 화면
- 로그인을 하면 로그아웃을 하거나 한 달이상의 시간이 지나기 전에는 회원정보를 들고있어 메인 url에 접속하면 다음의 페이지가 랜딩페이지가

## 2) 상품등록

### 2.1) 상품등록 페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 33 00" src="https://user-images.githubusercontent.com/18053020/211231613-bfaa6a71-84e3-4d3b-bc9c-129a9246a9fb.png">
- <img width="200" alt="스크린샷 2022-01-10 오후 12 33 34" src="https://user-images.githubusercontent.com/18053020/211231680-26a45f3b-c76b-44af-8c6b-2980f1ff9b23.png">
- 다음의 메인페이지에서 + 버튼을 누르면
- 아래 사진의 새로운 판매글 작성 페이지가 나타납니다.
- 사진을 업로드할 수 있으며, 제목, 카테고리, 가격(원), 본문을 입력받습니다.
    - 사진은 실제 모바일 앨범에서 선택하는 것이 아닌, desktop에서 jpeg, png 등 이미지 파일을 업로드하도록 작성(MultipartFile 표준 사용하면 될듯)
- 사진의 크기가 20MB 이하의 파일만 받도록 설정
- (추가기능) 사진의 용량을 줄여서 저장하는 기능

### 2.2) 카테고리 페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 33 40" src="https://user-images.githubusercontent.com/18053020/211231736-84a215b8-e465-4c80-8c35-ceb83d60018d.png">
- 카테고리를 누르면 팝업창이 떠서 다음의 카테고리 중 하나를 선택할 수 있습니다.
- 카테고리는 아래 정도만
    - ‘디지털기기’, ‘생활가전’, ‘가구/인테리어’, ‘유아동’, ‘생활/가공식품’, ‘유아도서’, ‘스포츠/레저’, ‘여성잡화’, ‘여성의류’, ‘남성패션/잡화’, ‘게임/취미’, ‘뷰티/미용’, ‘반려동물용품’, ‘도서/티켓/음반’, ‘식물’, ‘기타 중고물품’, ‘중고차’
- 내용을 모두 입력하면 완료 버튼이 활성화 되어 글을 입력할 수 있습니다. (사진은 업로드하지 않아도 완료 버튼이 활성화되어 글 입력이 가능)
- 검증은 프론트, 서버에서 더블체크

### 2.3) 상품 상세 페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 34 18" src="https://user-images.githubusercontent.com/18053020/211231763-990f5b55-0f65-42ef-b505-175a7afd55d9.png">
- 랜딩페이지(메인페이지)에서 상품을 클릭하면 다음과 같은 상품페이지를 볼 수 있습니다.
- 보여지는 정보는
    - 상품사진, 판매자 프로필사진, 판매자 닉네임, 게시물 제목, 게시물 가격, 게시물 카테고리, 게시물 게시시간, 본문, 관심(하트 숫자), 동일판매자가 판매중인 상품, 글 조회수
    - img, seller profile, seller nick, title, price, category, time, contents, like, seller's other goods, views
    - 조회수때문에 Redis 필요
- 이미지는 없을수도 있음
- 게시시간 표시
    - 표시방식 : n분전, n일전, n시간 전
    - 1시간 전에는 n분전, 하루 전에는 n시간 전, 한 달 전에는 n일전, 1년 전에는 n달 전, 1년 이후에는 n년 전으로 나타납니다.
- 거래가 완료된 상품은 제목 앞에 ‘거래완료’라는 문구가 붙습니다.
- 동일한 판매자의 다른 상품을 보기 위해서 이 판매자가 판매중인 다른 상품 보기 버튼이 있습니다
    - 개인적으로 이 기능을 상당히 좋아합니다. 중고물품 거래(ex 특히 게임기, 인두기, 버니어캘리퍼스 같은 물품 판매하시는 분들 보면 상당히 관심분야가 비슷하다는걸 느낍니다)
- 해당 화면에서 ... 버튼을 클릭하면 다음과 같이 게시물 수정 및 게시물 삭제 버튼이 표시되어야함
    - 수정 -> 수정페이지 이동, 게시글 등록과 같은 화면이 뜨지만 글을 입력할 때 입력했던 입력값이 바로 보여짐
    - 삭제 -> 확인팝업 출력 후 삭제, 클릭하면 다음과 같은 화면 한번 거쳐서 삭제

### 2.4) 이 판매자의 다른 판매상품
- seller's other goods
- (상품 상세페이지에서 접근 가능) 판매 상품의 모두보기를 클릭하면 아래의 화면이 출력됩니다
- 댓글이나 관심(하트 수)가 0이면 해당 아이콘은 표시되지 않습니다.
- 거래가 완료된 상품은 표시되나 거래완료라는 상태가 함께 출력됩니다
    - 여기서는 거래 완료 여부와 상관없이 노출 되어야 함
- 이 페이지에서 하트를 누르면 관심 물품으로 등록됨

## 3) 마이페이지

### 3.1) 마이 페이지(나의 당근 페이지) 메인 (줄여서 마페메)
- <img width="200" alt="스크린샷 2022-01-10 오후 12 34 34" src="https://user-images.githubusercontent.com/18053020/211231953-736057c0-a82c-4580-ada1-24dd18177e34.png">
- 랜딩페이지에서 나의 당근을 클릭하면 아래와 같은 페이지가 표시
- 프로필 화면에는 사진을 넣기 전에는 위와 같은 기본프사가 보이고, 별도 사진을 등록하면 사진이 표시
- 프로필 수정, 판매내역, 관심목록, Logout 으로 가는 기능이 존재해야함

### 3.2) 프로필 수정 페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 34 40" src="https://user-images.githubusercontent.com/18053020/211231915-b9122f5f-1ab0-4ed8-b78f-2d24232530d5.png">
- 마페메 에서 프로필 수정 버튼을 누르면 아래 화면 표시
- 이 페이지에서는 닉네임을 수정 가능
- 프로필 사진을 업로드기능
    - 프로필 사진은 중간 부분의 1:1 비율로 업로드
    - desktop에서 이미지 파일을 업로드하는 형태로 Multipart

### 3.3) 판매내역 페이지
- <img width="200" alt="스크린샷 2022-01-10 오후 12 34 26" src="https://user-images.githubusercontent.com/18053020/211231832-4316541f-fc5b-4ccb-8efd-63b4eb5880dd.png">
- 마페메 에서 판매내역 버튼을 누르면 아래 화면 표시
- 판매중인 상품 및 거래완료 상품을 확인
- 해당 화면에서 바로 예약중으로 변경 or 거래완료로 변경하며 상태변경이 가능
- 거래완료로 변경할 경우 해당 상품은 거래완료 탭으로 이동됨
- 거래완료에서도 판매중이나 예약중으로 상태변경이 가능합니다.
- 판매 상품을 클릭하면 다음과 같이 상품 상세페이지로 이동
- 판매자인 경우에만 판매물품의 상태변화가 가능
    - 판매중, 예약중, 거래완료 status

### 3.4) 관심목록
- <img width="200" alt="스크린샷 2022-01-10 오후 12 35 45" src="https://user-images.githubusercontent.com/18053020/211232092-4d5e4ef6-9f04-4075-a03b-6028f10826d3.png">
- 관심목록을 클릭하면 좋아요 누른 상품이 나타납니다.

## 4) 댓글기능

### 4.1) 댓글달기 기능
- <img width="200" alt="스크린샷 2022-01-10 오후 12 36 49" src="https://user-images.githubusercontent.com/18053020/211232153-c62972b5-40b0-4b06-bd06-114db267d9bf.png">
- <img width="200" alt="스크린샷 2022-01-10 오후 12 36 57" src="https://user-images.githubusercontent.com/18053020/211232216-671f9e12-b549-48cd-96df-d5d97e813ee7.png">
- 상품 페이지에서 댓글 보기 및 댓글 남기기 기능을 사용할 수 있습니다.
- 하단의 댓글 보기를 클릭하면
    - 다음과 같이 닉네임, 시간, 댓글을 볼 수 있습니다.
    - 시간은 n분 전, n시간 전, n일 전, n달 전, n년 전의 5가지 형태로 나타나며, 글을 쓴지 1시간 전에는 n분 전으로, 1일 전에는 n 시간 전으로, 1달 전에는 n일 전으로, 1년부터는 n년 전으로 표시
    - 댓글은 시간이 빠른순서로 표시
- 자신이 쓴 댓글에는 Edit 버튼이 떠서 수정이 가능, 삭제도 가능
- (App) ← 버튼을 누르면 무조건 이전 product page로 돌아갑니다.
- 댓글 남기기를 클릭하면 다음과 같이 댓글을 남길 수 있습니다.

### 4.2) 댓글 수정 기능
- Edit 버튼을 클릭할 경우 기존에 자신이 남겼던 글이 default 값으로 써져있으며 수정 후 작성완료를 누르면 수정됩니다.
- 작성완료할 경우 댓글 보기 페이지로 넘어갑니다.
- 대댓글 기능은 여유가 되실경우 추가해주시기 바랍니다.
- 실제 거래는 댓글기능을 통해 판매자와 구매자가 거래 장소 및 시간을 정한 후 직거래 및 현금거래를 한다고 가정합니다. 모든 소통은 댓글을 통해서만 이루어집니다.

### 4.3) 댓글 삭제기능
- 자신이 작성한 댓글만 삭제가 가능해야함
- 글 작성자는 댓글을 작성하지 않았지만 : 댓글을 삭제할수 없다
- 댓글이 달린 글은 삭제할 수 없다 : 사기피해 방지를 위해서
    - 이부분은 정책적인 결정 사항이라 바꿀 수 있어야함

## 5) 추가기능

### 5.1) 글 보호잠금 기능 / 사기피해예방
- 글 보호 기능(중고거래 사기방지) : 일정 기간동안 작성자조차 글 삭제가 불가능해집니다
    - 1명이 글 보호를 누르면 3시간동안 글이 보호
    - 3명 이상이 글 보호시간이 3주간 보호
    - 5명 이상이 글 보호 요청을 눌렀을 경우 1년간 보호
    - CS 직원이 확인해주고 보호잠금 해제 가능

### 5.2) 유효한 이메일인지 확인 / 업자 필터
- 회원가입 인증
    - Email 인증 : 유효한 이메일인지 확인(장물아비, 도배업자 퇴치용)
    - 지역인증 : 지역에 그 사람이 살고있는지 유효기간마다 인증하도록
        - 지역 인증이 한 달 동안만 유효

### 5.3) 중고매물 검색기능
- 검색 기능
    - 검색한 값을 제목이나 본문에 포함하고 있는 상품을 보여주는건 어떨까요?
    - 어떤 상품을 상단에 노출하는지에 대한 로직 추가
        - (판매중인 상품, 좋아요순, 댓글 많은순)
    - 검색에 Filtering 기능 : 카테고리 제한 설정, 가격범위(상한필터, 하한필터, 상하한필터)

### 5.4) 알람 기능 (키워드, 관심상품, 내 작성글)
- 알림기능을 추가해보는건 어떨까요?
- 알람 아이콘은 메인 페이지의 맨 위 상단의 검색 아이콘과 카테고리 아이콘 사이에 위치
- 키워드 알람
    - 키워드를 등록하면 알람이 발생한다
    - 키워드는 제목, 본문, 제목or본문에 걸 수 있다
- 관심 상품 상태 변경 알람(좋아요 누른 상품)
    - 판매중 -> 예약중/판매완료 혹은 반대로 변경시 알림
- 이외 중고나라, 당근마켓 알람 기능
    - 내 판매중 상품에 댓글, 좋아요 내가 댓글을 단 상품에 댓글이 달렸을 때
    - 네이버 카페에도 유사한 시스템이 있음
- (의견) : 서비스가 커져서 마케팅팀이 주도하는 이벤트 또한 대비할 수 있음

### 5.5) 대댓글 기능
- 댓글의 댓글, depth 2단계까지는 대부분 지원하는듯 합니다
- 댓글의 댓글의 댓글의 .... 댓글 이렇게 무한히 가면 시스템적으로 구현은 가능할까? (물론 돈버는것과 관계는 없겠지만..)

### 5.6) 뱃지 기능
- 첫 거래 완료, 10번 거래 완료, 무료 나눔 완료 등 특정 이벤트를 수행하면 관련 뱃지를 지급
- 사용자들이 서비스에 더 애착을 갖을 수 있도록

### 5.7) 매너온도 기능
- 거래가 완료되면 서로 상대방의 매너에 대해 평가
- 따뜻한 사람이면 온도가 높아지고 비매너의 행동을 하면 온도 떨어트리기
- 거래완료 버튼을 누르면 >> 매너온도를 선택하는 버튼 or 판매완료 페이지에서 연락 온 사람들중 실제로 거래한사람을 선택해고 매너를 평가
    - 매너온도 기능은 기능 추가보다, 이전에 필요한 기능들이 많음
    - 메너온도 기능을 위해 존재해야하는 시스템
        - 채팅기능
        - 대댓글기능

### 5.8) 채팅 기능 추가
- 1:1 채팅기능이 있어서 거래약속(직거래) 혹은 택배거래를 진행할수 있도록
- server pass 가 아니라, peer-to-peer 로 가야할듯 (WebSocket 기술을 사용해보자)
- 가보지않은길이라 모름..
    - Web 환경에서 구현과 App 환경에서 구현에 차이가 있을지??
    - 일단 WebSocket 이 뭔지부터 알아봐야함
    - 서버의 역할은 오직 Broker (중개인 역할)

### 5.9) 글 끌어올림 기능
- 글을 올리고 하루이상 지난시점부터
- 게시글 끌어올리기 기능이 추가된다