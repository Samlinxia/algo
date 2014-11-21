class MaxPointsOnLine {
/**http://codeganker.blogspot.com/2014/03/max-points-on-line-leetcode.html
	case:
		1. Input check.  no points, only one point, which still can be viewed as a line
		2. duplicate points
		3. slant conditions. horizontal, vertical, normal
		4. NumberSamePoint should add to every line start from stPoint. so need to take out separately
		5. 
*/
	public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int count = 1;
        int len = points.length;
        for (int i = 0; i < len - 1; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            Point stPt = points[i];
            int samePt = 0;
            int localMax = 1;
            for (int j = i + 1; j < len; j++) {
                Point curPt = points[j];
                double slant;
                if (stPt.x == curPt.x && stPt.y == curPt.y) {
                    samePt++;
                    continue;
                }  else if (stPt.x == curPt.x) {
                    slant = Double.MAX_VALUE;
                } else if (stPt.y == curPt.y) {
                    slant = 0.0;
                }else {
                    slant = (double)(stPt.y - curPt.y) / (double)(stPt.x - curPt.x);
                }
                
                if (!map.containsKey(slant)) {
                    map.put(slant, 2);
                } else {
                    map.put(slant, map.get(slant) + 1);
                }
                localMax = Math.max(localMax, map.get(slant));
            }
            count = Math.max(count, localMax + samePt);
        }
        
        return count;
    }

}