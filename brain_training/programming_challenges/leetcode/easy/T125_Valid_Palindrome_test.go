package easy

import (
	"strings"
	"testing"
)

func isPalindrome(s string) bool {
	s = strings.ToLower(s)
	i, j := 0, len(s)-1
	for i < j {
		if !isLetter(s[i]) {
			i++
			continue
		}
		if !isLetter(s[j]) {
			j--
			continue
		}
		if s[i] != s[j] {
			return false
		} else {
			i++
			j--
		}
	}
	return true
}

func TestIsPalindrome(t *testing.T) {
	tests := []struct {
		text     string
		expected bool
	}{
		{"A man, a plan, a canal: Panama", true},
		{"race a car", false},
	}
	for _, tt := range tests {
		result := isPalindrome(tt.text)
		if result != tt.expected {
			t.Fatalf("expected %v, got %v", tt.expected, result)
		}
	}
}

func isLetter(ch byte) bool {
	return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || '0' <= ch && ch <= '9'
}
