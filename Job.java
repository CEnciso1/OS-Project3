public class Job {
    String name;
    int arrivalTime;
    int duration;
    int finishTime;
    int index;

    Job(String name, int arrivalTime, int duration, int index){
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.index = index;
    }
}
