# CheckList
## D1: OK
## D2: OK
## D3: OK
## D4: OK
## D5: OK

# Result
![Test Pass](allPass.png)
![Coverage 100%](coverage.png)
Component는 일종의 interface 역할로 구현했으나, range check하는 부분이 완전히 공통으로 쓸 수 있어서 일반 클래스로 수정 후 abstract 클래스 역할로 사용
따라서 모든 상속받은 클래스가 사용하는 method 3개에 대한 접근이 없어서 coverage 100% 달성 불가. 이외에는 coverage 100% 확인 
