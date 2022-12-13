import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String args[]) {
        Job jobs[] = new Job[100];
        Job[] j1 = new Job[100];
        Job[] j2 = new Job[100];
        Job[] j3 = new Job[100];
        try {
            File jobsData = new File("jobs.txt");
            Scanner fileReader = new Scanner(jobsData);
            int numJobs = 0;
            int totalTime = 0;
            while (fileReader.hasNext()) {
                String name = fileReader.next();
                int arrivalTime = Integer.parseInt(fileReader.next());
                int duration = Integer.parseInt(fileReader.next());
                totalTime += duration;
                Job job = new Job(name, arrivalTime, duration, numJobs);
                jobs[numJobs] = job;
                Job job1 = new Job(name, arrivalTime, duration, numJobs);
                j1[numJobs] = job1;
                Job job2 = new Job(name, arrivalTime, duration, numJobs);
                j2[numJobs] = job2;
                Job job3 = new Job(name, arrivalTime, duration, numJobs);
                j3[numJobs] = job3;
                numJobs++;
                //System.out.println(job.name + " " + job.arrivalTime + " " + job.duration);
            }
            System.out.println("Enter scheduling algorithm type");
            Scanner in = new Scanner(System.in);
            String algoType = in.next();
            SRT srt;
            RR rr;
            FB fb;
            switch(algoType){
                case ("SRT"): 
                srt = new SRT(jobs, totalTime, numJobs);
                srt.schedule();
                System.out.println("SRT");
                srt.print();
                break;
                case ("RR"):
                rr = new RR(jobs, totalTime, numJobs);
                rr.schedule();
                System.out.println("RR");
                rr.print();
                break;
                case ("FB"):
                fb = new FB(jobs, totalTime, numJobs);
                fb.schedule();
                System.out.println("FB");
                fb.print();
                break;
                case("ALL"):
                
                srt = new SRT(j1, totalTime, numJobs);
                srt.schedule();
                System.out.println("SRT");
                srt.print();
                rr = new RR(j2, totalTime, numJobs);
                rr.schedule();
                System.out.println("RR");
                rr.print();
                fb = new FB(j3, totalTime, numJobs);
                fb.schedule();
                System.out.println("FB");
                fb.print();
                break;
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        }
      
    }
    
}
