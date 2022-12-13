import java.util.LinkedList;
import java.util.Queue;
public class FB {
    private Job jobs[];
    private int totalTime;
    private int numJobs;
    String[][] graph;

    FB(Job jobs[], int totalTime, int numJobs) {
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
        Queue<Job> q1 = new LinkedList<>();
        Queue<Job> q2 = new LinkedList<>();
        Queue<Job> q3 = new LinkedList<>();

        int jobCount = 0;
        Job currentJob = null;
        for (int i = 0; i < totalTime; i++) {

            if (jobCount < numJobs && jobs[jobCount].arrivalTime == i) {
                q1.add(jobs[jobCount]);
                jobCount++;
                currentJob = q1.poll();
                System.out.println(currentJob.name + " " + currentJob.duration);
                graph[currentJob.index][i] = currentJob.name;
                currentJob.duration = currentJob.duration - 1;
                if (currentJob.duration > 0)
                    q2.add(currentJob);
            } else {
                if (!q2.isEmpty()) {
                    currentJob = q2.poll();
                    System.out.println(currentJob.name + " " + currentJob.duration);
                    graph[currentJob.index][i] = currentJob.name;
                    currentJob.duration = currentJob.duration - 1;
                    if (currentJob.duration > 0)
                        q3.add(currentJob);
                } else if (!q3.isEmpty()) {
                    currentJob = q3.poll();
                    System.out.println(currentJob.name + " " + currentJob.duration);
                    graph[currentJob.index][i] = currentJob.name;
                    currentJob.duration = currentJob.duration - 1;
                    if (currentJob.duration > 0)
                        q3.add(currentJob);
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
