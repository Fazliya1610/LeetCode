class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loss = new HashMap<>();
        Set<Integer> players = new HashSet<>();
        for(int[] match:matches) {
            int winner = match[0];
            int loser = match[1];
            loss.put(loser, loss.getOrDefault(loser,0)+1);
            players.add(winner);
            players.add(loser);
        }
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for(int player:players) {
            int lostCount = loss.getOrDefault(player, 0);
            if(lostCount==0) {
                zero.add(player);
            }
            else if(lostCount==1) {
                one.add(player);
            }
        }
        Collections.sort(zero);
        Collections.sort(one);
        List<List<Integer>> res = new ArrayList<>();
        res.add(zero);
        res.add(one);
        return res;
    }
}