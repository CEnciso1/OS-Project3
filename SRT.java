import java.util.Vector;
import java.util.Arrays;
public class SRT {

    private Job jobs[];
    private int totalTime;
    private int numJobs;
    String[][] graph;
    

    SRT(Job jobs[], int totalTime, int numJobs) {
        this.jobs = jobs;
        this.totalTime = totalTime;
        this.numJobs = numJobs;
        graph = new String[numJobs][totalTime];
        for (int i = 0; i < numJobs; i++) {
            for (int j = 0; j < totalTime; j++) {
                graph[i][j] = " ";
            }
        }
    }

    void schedule() {
        Vector<Job> v = new Vector<>(0);
        //q.add(jobs[0]);

        int jobCount = 0;
        int minTime = 100;
        int shortestIndex = 0;
        Job currentJob = null;
        for (int i = 0; i < totalTime; i++) {

            //add new jobs to vector
            if (jobCount < numJobs && jobs[jobCount].arrivalTime == i) {
                v.add(jobs[jobCount]);
                jobCount++;
            }

            //Iterate trhough vector for shortest job
            for (int j = 0; j < v.size(); j++) {
                if (v.get(j).duration < minTime) {
                    minTime = v.get(j).duration;
                    currentJob = v.get(j);
                    shortestIndex = j;
                }
            }

            System.out.println(currentJob.name + " " + currentJob.duration);
            graph[currentJob.index][i] = currentJob.name;
            currentJob.duration -= 1;
            if (currentJob.duration <= 0) {
                v.remove(currentJob);
                minTime = 100;
                for (int j = 0; j < v.size(); j++) {
                    if (v.get(j).duration < minTime) {
                        minTime = v.get(j).duration;
                        currentJob = v.get(j);
                        shortestIndex = j;
                    }
                }

            }

        }
    }
    
    void print() {
        for (int i = 0; i < numJobs; i++) {
            for (int j = 0; j < totalTime; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
    
}