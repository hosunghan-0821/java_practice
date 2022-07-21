public class Transport_Bus extends Transport {

    private static int u_num =1 ;
    //현재 승객 수;
    int client_inBus=0;

    //생성자
    public Transport_Bus() {
        super();
        this.setNum(u_num);
        u_num++;
        this.setMax_client(30);
        this.change_status(Transport.ON_SERVICE);
        this.setFee(1000);
    }

    @Override
    public void start_service() {
    }
    //상위 Transport Class의 승객 받기 함수 override
    @Override
    public void take_passenger(int num) {
        if(this.getStatus().equals(Transport.ON_SERVICE)){

            if(this.client_inBus+num>this.getMax_client()){
                System.out.println("승객이 탑승합니다 "+(this.client_inBus+num)+"명");
                System.out.println("최대 승객수를 초과했습니다.");
                return;
            }
            System.out.println("승객이 탑승합니다 "+num+"명");

            this.client_inBus+=num;
            System.out.println("\n탑승 승객 수 : "+num);
            System.out.println("잔여 승객 수 : "+ (this.getMax_client()-this.client_inBus));
            System.out.println("요금 확인 : "+this.getFee()*num);
        }
        else{
            System.out.println("현재 버스는 운행중이 아닙니다.");
            System.out.println("현재 버스 상태 : "+this.getStatus());
        }

    }

    //상태 변경하기
    @Override
    public void change_status(String status) {
        this.setStatus(status);
        if(status.equals(Transport.OFF_SERVICE)){
            this.client_inBus=0;
        }

    }

    //주유량 감소 함수
    public void reduce_gas(int gas){
        this.setFuel(this.getFuel()-gas);
        System.out.println("기름 "+gas+ "만큼 소비했습니다. ");
        System.out.println("현재 주유량 : "+this.getFuel());
        if(this.getFuel()<10){
            this.setStatus(Transport.OFF_SERVICE);
            System.out.println("상태 : "+this.getStatus()+"행");
            System.out.println("***주유가 필요합니다***");
        }
    }

    //주유량 증가 함수
    public void add_gas(int gas){
        this.setFuel(this.getFuel()+gas);
        System.out.println("기름 "+gas+ "만큼 주유합니다. ");
        System.out.println("상태 = "+this.getStatus()+"행");
        System.out.println("현재 주유량 : "+this.getFuel());
    }

    //운행 종료
    public void close_service(){
        change_status(Transport.Off_SERVICE_TAXI);
    }


}
