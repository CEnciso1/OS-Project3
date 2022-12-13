import java.util.LinkedList;
import java.util.Queue;
public class RR {

    private Job jobs[];
    private int totalTime;
    private int numJobs;
    String[][] graph;

    RR(Job jobs[], int totalTime, int numJobs) {
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
    
    public void schedule() {
        Queue<Job> q = new LinkedList<>();
        //q.add(jobs[0]);

        int jobCount = 0;
        Job currentJob = null;
        for (int i = 0; i < totalTime; i++) {

            if (jobCount < numJobs && jobs[jobCount].arrivalTime == i) {
                q.add(jobs[jobCount]);
                //currentJob = jobs[jobCount];
                jobCount++;
                if (currentJob != null && currentJob.duration > 0)
                    q.add(currentJob);
                currentJob = q.poll();
            } else if (!q.isEmpty()) {
                if (currentJob.duration > 0)
                    q.add(currentJob);
                currentJob = q.poll();
            }
            System.out.println(currentJob.name + " " + currentJob.duration);
            graph[currentJob.index][i] = currentJob.name;
            currentJob.duration = currentJob.duration - 1;

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
