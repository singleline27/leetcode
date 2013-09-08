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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals.size() <= 1) return intervals;
        
        ArrayList<Interval> result = new ArrayList();
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval v1, Interval v2) {
                if(v1.start != v2.start) {
                    return v1.start - v2.start;
                }
                return v1.end - v2.end;
            }
        });
        
        for(int i = 1; i < intervals.size(); ++i) {
            Interval last = intervals.get(i - 1);
            Interval curr = intervals.get(i);
            
            if(last.end >= curr.start) {
                if(last.end >= curr.end) {
                    curr.start = last.start;
                    curr.end = last.end;
                } else {
                    curr.start = last.start;
                }
                intervals.set(i-1, null);
            }
        }
        
        for(Interval inter: intervals) {
            if(inter != null) {
                result.add(inter);
            }
        }
        
        return result;
        
    }
}

NOTE:
1. new Comparator<Interval>()

2. Collections.sort(ArrayList<T>, Comparator<? super T>)

3. ref = arraylist.get(i)

set ref = null doesn't change the elem in arraylist, but ref.value = val does