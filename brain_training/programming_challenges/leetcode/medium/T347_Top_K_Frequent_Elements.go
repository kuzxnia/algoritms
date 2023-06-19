func topKFrequent(nums []int, k int) []int {
    frequences := make(map[int]int)
    unique := []int{}
    for _, val := range nums {
        if _, ok := frequences[val]; !ok {
            unique = append(unique, val)
        }
        frequences[val]++
    }
    sort.Slice(unique, func (i, j int) bool {return frequences[unique[i]] > frequences[unique[j]]})
    return unique[:k]
}
