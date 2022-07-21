import  java.util.*;
public class Scenario {
    public static  void main(String[] args){
        Scenario scenario = new Scenario();

        scenario.bus_scenario_start();
        scenario.taxi_scenario_start();
    }
    public void bus_scenario_start(){

        //입력 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        //메인에서 전체 버스를 관리하는게 맞을까?
        ArrayList<Integer> bus_identifier = new ArrayList<>();
        //버스 객체를 갖고 있는 Arraylist
        ArrayList<Transport_Bus> bus_list = new ArrayList<>();

        // 버스 고유번호 확인 및 객체 생성하는코드
        make_bus(bus_identifier,bus_list,2);
        // 버스 고유번호 출력
        for(int i = 0 ; i < bus_list.size();i++){
            System.out.println( (i+1) +"번째 버스 고유번호 : "+bus_list.get(i).getNum());
        }
        System.out.println("==========================\n");
        //System.out.print("탑승 승객 수를 입력해주세요 : ");

        //이후 진행 첫번째 버스로 진행
        bus_list.get(0).take_passenger(2);

        System.out.println("==========================\n");
        //주유량 -50감소
        bus_list.get(0).reduce_gas(50);

        //상태 차고지행변경
        bus_list.get(0).change_status(Transport.OFF_SERVICE);

        System.out.println("==========================\n");
        //주유량 +10 증가
        bus_list.get(0).add_gas(10);


        //bus 상태변경  -> 운행중
        System.out.println("==========================\n");
        bus_list.get(0).change_status(Transport.ON_SERVICE);

        //승객 태우기
        bus_list.get(0).take_passenger(45);

        System.out.println("==========================\n");
        bus_list.get(0).take_passenger(5);

        System.out.println("==========================\n");
        bus_list.get(0).reduce_gas(55);


    }

    public void  taxi_scenario_start(){
        ArrayList<Transport_Taxi> taxi_list= new ArrayList<>();
        make_taxi(taxi_list,2);
        //택시 현재상태 나타내기
        for(int i = 0 ; i < taxi_list.size();i++){
           taxi_list.get(i).taxi_status();
        }
        //이후로는 teax_list 첫번째 택시로 진행
        //승객탑승
        System.out.println("==========================\n");
        taxi_list.get(0).take_passenger(2,"서울역",2);

        //주유량 감소 및 정산
        System.out.println("==========================\n");
        taxi_list.get(0).reduce_gas(80);
        taxi_list.get(0).taxi_payment();

        System.out.println("==========================\n");
        taxi_list.get(0).take_passenger(5);

        taxi_list.get(0).take_passenger(3,"구로 디지털단지역",12);
        System.out.println("==========================\n");
        taxi_list.get(0).reduce_gas(20);
        taxi_list.get(0).taxi_payment();

    }

    //버스 객체 생성 함수
    public void make_bus(ArrayList<Integer> identifier, ArrayList<Transport_Bus> bus_list,int num){
        //1000개까지만 가능하고, instance가 많아질수록, 많이 while 문 많이 돌게됨
        // 좋지 않은 방식인것 같아 보류..
        /*
         boolean check_duplicate =false;
        for(int i = 0 ; i<num ; i++){
            while(!check_duplicate){
                double randomValue = Math.random();

                int intValue =(int)(randomValue*1000)+1;
                if(!identifier.contains(intValue)){
                    identifier.add(intValue);
                    check_duplicate=true;
                }
            }
            check_duplicate=false;
        }
        * */

        //고유번호 생성 및 객체 생성
        for(int i = 0 ; i < num;i++){
           if(bus_list.size()==0){
               bus_list.add(new Transport_Bus());
           }
           else{
               //bus_list 가장 마지막에 있는 bus 고유번호 값 +1 로 지정
               Transport_Bus new_bus = new Transport_Bus();
               bus_list.add(new_bus);
           }
        }
    }
    //택시 객체 생성 함수
    public void make_taxi(ArrayList<Transport_Taxi> taxi_list,int num){

        for (int i = 0 ; i <num ; i++){
            taxi_list.add(new Transport_Taxi());
        }
    }
}
