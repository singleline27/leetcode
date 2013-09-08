/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result = new ArrayList();
        
        if(intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        int i = 0;
        while(i < intervals.size()) {
            if(intervals.get(i).start > newInterval.start || 
                (intervals.get(i).start == newInterval.start && intervals.get(i).end > newInterval.end)) {
                break;
            }
            
            ++i;
        }
        
        intervals.add(i, newInterval);
        
        for(int j = Math.max(i, 1); j < intervals.size(); ++j) {
            Interval last = intervals.get(j - 1);
            Interval curr = intervals.get(j);
            if(last.end >= curr.start) {
                if(last.end >= curr.end) {
                    intervals.set(j, last);
                    intervals.set(j - 1, null);
                } else {
                    curr.start = last.start;
                    intervals.set(j - 1, null);
                }
            } 
        }
        
        
        for(Interval inter : intervals) {
            if(inter != null) {
                result.add(inter);
            }
        }
        
        return result;
        
    }
}