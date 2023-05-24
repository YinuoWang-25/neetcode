package priority_queue;

// video: https://www.youtube.com/watch?v=YCD_iYxyXoo&t=432s
public class L621_task_scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int res = (max - 1) * (n + 1) + maxCount;

        return Math.max(res, tasks.length);
    }
}