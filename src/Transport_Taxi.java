public class Transport_Taxi extends Transport {

    private static int u_num = 1;
    //목적지
    private String destination;
    //목적지 까지의 거리
    private int destination_distance;
    //기본거리
    private int standard_distance = 1;
    //기본 요금
    private int standard_fee = 3000;
    //거리당 요금
    private int fee_per_distance = 1000;

    //승객수
    private int client_inTaxi;

    //현재승객의 요금
    private int fee;

    //누적요금
    private int total_fee = 0;

    public Transport_Taxi() {
        super();
        this.setNum(u_num);
        u_num++;
        this.setMax_client(4);
        this.standard_fee = 3000;
        this.fee_per_distance = 1000;
        this.standard_distance = 1;
        this.setStatus(Transport.NORAML);
        this.setSpeed(0);
        this.setMax_client(4);
    }





    //주행하기전 기름양 체크
    @Override
    public void start_service() {
        if (this.getFuel() >= 10) {
            this.setStatus(Transport.NORAML);
            System.out.println("주행 시작합니다.");
        } else {
            this.setStatus(Transport.OFF_SERVICE);
            System.out.println("주유량이 부족해 출발못합니다.");
        }
    }


    //승객 탑승
    @Override
    public void take_passenger(int num) {
        if(num>this.getMax_client()){
            System.out.println("최대 승객 수 초과");
        }
    }

    //승객 탑승 -> 오버로딩 택시는 도착지, 도착지까지의 거리
    public void take_passenger(int num, String destination, int destination_distance) {

        if(num>getMax_client() &&this.getStatus().equals(Transport.NORAML)){
            System.out.println("최대 승객 수 초과");
            return;
        }

        this.setStatus(Transport.ON_SERVICE_TAXI);
        this.destination = destination;
        this.destination_distance = destination_distance;
        this.client_inTaxi = num;

        if (destination_distance <= standard_distance) {
            fee = standard_fee;
        } else {
            //추가요금
            int add_fee = (destination_distance - standard_distance) * fee_per_distance;
            this.fee = standard_fee + add_fee;
        }

        System.out.println("탑승 승객수 : " + this.client_inTaxi);
        System.out.println("잔여 승객수 : " + (this.getMax_client() - this.client_inTaxi));
        System.out.println("기본 요금 확인 : " + this.standard_fee);
        System.out.println("목적지 :" + this.destination);
        System.out.println("목적지까지거리 :" + destination_distance + "km");
        System.out.println("지불할 요금 :" + fee);

    }

    //거리당 추가 요금 변경
    public void charge_per_distance(int num) {
        this.fee_per_distance=num;
    }

    //승객 최종결제
    public void taxi_payment(){
        this.total_fee += this.fee;
        this.fee=0;
        System.out.println("현재 주유량 : "+this.getFuel());
        if(this.getFuel()<10){
            System.out.println("상태 : "+this.getStatus());
        }
        System.out.println("누적요금 : "+this.total_fee);
        check_gas();
        this.destination="";
        this.destination_distance=0;
    }

    //주유량 감소 함수
    public void reduce_gas(int gas) {
        this.setFuel(this.getFuel() - gas);
        // System.out.println("기름 "+gas+ "만큼 소비했습니다. ");
        //System.out.println("현재 주유량 : "+this.getFuel());
        if (this.getFuel() < 10) {
            this.setStatus(Transport.Off_SERVICE_TAXI);
            //System.out.println("상태 : " + this.getStatus());
            //System.out.println("***주유가 필요합니다***");
        }
    }

    //승객 하차 후, 기름양 체크해서 taxi 상태 변경
    public void check_gas(){
        if(this.getFuel()<10){
            System.out.println("\n주유량이 부족합니다. 주유해주세요");
            this.setStatus(Transport.Off_SERVICE_TAXI);
        }
        else{
            this.setStatus(Transport.NORAML);
        }
    }

    //현재 택시상태 print해주는 함수
    public void taxi_status() {
        System.out.println("\n택시 고유번호 : " + this.getNum());
        System.out.println("주유량 : " + this.getFuel());
        System.out.println("상태 : " + this.getStatus());
    }






    //    getter &setter
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getDestination_distance() {
        return destination_distance;
    }
    public void setDestination_distance(int destination_distance) {
        this.destination_distance = destination_distance;
    }
    public int getStandard_distance() {
        return standard_distance;
    }
    public void setStandard_distance(int standard_distance) {
        this.standard_distance = standard_distance;
    }
    public int getStandard_fee() {
        return standard_fee;
    }
    public void setStandard_fee(int standard_fee) {
        this.standard_fee = standard_fee;
    }
    public int getFee_per_distance() {
        return fee_per_distance;
    }
    public void setFee_per_distance(int fee_per_distance) {
        this.fee_per_distance = fee_per_distance;
    }
}
