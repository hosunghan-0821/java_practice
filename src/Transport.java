public abstract class Transport {

    public static final String ON_SERVICE  ="운행";
    public static final String OFF_SERVICE ="차고지";
    public static final String NORAML="일반";
    public static final String Off_SERVICE_TAXI ="주행불가";
    public static final String ON_SERVICE_TAXI = "주행중";
    //고유번호
    private int unique_num=100;
    //주유량
    private int fuel=100;
    //속도
    private int speed;
    //최대승객수
    private int max_client;
    //운행상태
    private String status;
    private int fee;

    // 운행시작
    abstract public void start_service();
    // 승객탑승
    public abstract void take_passenger(int num);
    // 속도변경
    public void change_speed(int num){
        this.speed +=num;
    }
    // 상태변경
    public void change_status(String status){
        this.status=status;
    }


    //getter , setter
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
    public int getNum() {
        return unique_num;
    }
    public void setNum(int num) {
        this.unique_num = num;
    }
    public int getFuel() {
        return fuel;
    }
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMax_client() {
        return max_client;
    }
    public void setMax_client(int max_client) {
        this.max_client = max_client;
    }
}
