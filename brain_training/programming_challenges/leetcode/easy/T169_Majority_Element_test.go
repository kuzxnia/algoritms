package easy

import (
	"testing"
)

// simple solution using map
// func majorityElement(nums []int) int {
// 	count := make(map[int]int)

// 	for _, num := range nums {
// 		if _, ok := count[num]; ok {
// 			count[num]++
// 		} else {
// 			count[num] = 1
// 		}
// 	}
// 	maxValue := math.MinInt32
// 	var maxKey int
// 	for key, value := range count {
// 		if value > maxValue {
// 			maxValue = value
// 			maxKey = key
// 		}
// 	}
//   return maxKey
// }

// tuned version of simple solution using map
// func majorityElement(nums []int) int {
// 	m := make(map[int]int)

// 	for _, v := range nums {
// 		m[v]++
// 		if m[v] > len(nums)/2 {
// 			return v
// 		}
// 	}

// 	return 0
// }

// Boyer-Moore Voting Algorithm
// func majorityElement(nums []int) int {
// 	candidate := nums[0]
// 	count := 1
// 	for _, num := range nums[1:] {
// 		if num == candidate {
// 			count++
// 		} else {
// 			count--
// 		}
// 		if count == 0 {
// 			candidate = num
// 			count = 1
// 		}
// 	}
// 	return candidate
// }

// tuned Boyer-Moore Voting Algorithm
func majorityElement(nums []int) int {
	candidate := nums[0]
	count := 1
	for _, num := range nums[1:] {
		if num == candidate {
			count++
		} else {
			count--
		}
		if count == 0 {
			candidate = num
			count = 1
		}
		if count > len(nums)/2 {
			return candidate
		}
	}
	return candidate
}

func TestMajorityElement(t *testing.T) {
	tests := []struct {
		nums     []int
		expected int
	}{
		{[]int{3, 2, 3}, 3},
		{[]int{2, 2, 1, 1, 1, 2, 2}, 2},
	}
	for _, tt := range tests {
		result := majorityElement(tt.nums)
		if result != tt.expected {
			t.Fatalf("expected %v, got %v", tt.expected, result)
		}
	}
}
