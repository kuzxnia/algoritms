class Solution():
    def groupAnagrams(self, strs):
        map = {}
        for st in strs:
            key = ''.join(sorted(st))
            if key not in map:
                map[key] = [st]
            else:
                map[key] += [st]
        return list(map.values())
