class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int latestJobIndex = findLatestNonOverlappingJob(jobs, i);

            int includeProfit = jobs[i].profit + (latestJobIndex == -1 ? 0 : dp[latestJobIndex]);
            int excludeProfit = dp[i - 1];

            dp[i] = Math.max(includeProfit, excludeProfit);
        }

        return dp[n - 1];
    }

    private int findLatestNonOverlappingJob(Job[] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid].endTime <= jobs[currentIndex].startTime) {
                if (jobs[mid + 1].endTime <= jobs[currentIndex].startTime) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}