class Solution(object):
    def findPoisonedDuration(self, timeSeries, duration):
        if not timeSeries:
            return 0
        start = timeSeries[0]
        end = start + duration
        total = 0
        for time in timeSeries[1:]:
            if time <= end:
                end = time + duration
            else:
                total += end - start
                start = time
                end = time + duration
        total += end - start
        return total
