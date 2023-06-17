package easy

import (
	"sort"
	"testing"
)

func removeElement(nums []int, val int) int {
	pointer := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != val {
			nums[pointer] = nums[i]
			pointer++
		}
	}
	return pointer
}

func TestRemoveElement(t *testing.T) {
	tests := []struct {
		nums1        []int
		n            int
		expectedNums []int
		expected     int
	}{
		{[]int{3, 2, 2, 3}, 3, []int{2, 2}, 2},
	}
	for _, tt := range tests {
		result := removeElement(tt.nums1, tt.n)
		sort.Ints(tt.nums1)
		for i := 0; i < result; i++ {
			if tt.nums1[i] != tt.expectedNums[i] {
				t.Errorf("errof")
			}
		}
	}
}
