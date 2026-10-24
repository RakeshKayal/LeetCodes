class Solution {
      private final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

      
 int startA = convertToDayOfYear(arriveAlice);
        int endA = convertToDayOfYear(leaveAlice);
        int startB = convertToDayOfYear(arriveBob);
        int endB = convertToDayOfYear(leaveBob);

       
        int latestArrival = Math.max(startA, startB);
        int earliestLeave = Math.min(endA, endB);

       
        return Math.max(0, earliestLeave - latestArrival + 1);
    
    }
     private int convertToDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int dayCount = 0;
       
        for (int i = 0; i < month - 1; i++) {
            dayCount += months[i];
        }
        // Add the days of the current month
        return dayCount + day;
    }
}