package easy

import (
	"testing"
)

func maxProfit(prices []int) int {
	profit := 0
	minPrice := prices[0]

	for i := 1; i < len(prices); i++ {
		if prices[i] < minPrice {
			minPrice = prices[i]
		} else if (prices[i] - minPrice) > profit {
			profit = prices[i] - minPrice
		}
	}

	return profit
}

func TestMaxProfit(t *testing.T) {
	tests := []struct {
		nums     []int
		expected int
	}{
		{[]int{7, 1, 5, 3, 6, 4}, 5},
		{[]int{7, 6, 4, 3, 1}, 0},
	}
	for _, tt := range tests {
		result := maxProfit(tt.nums)
		if result != tt.expected {
			t.Fatalf("expected %v, got %v", tt.expected, result)
		}
	}
}
