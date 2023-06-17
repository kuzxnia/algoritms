package easy

import (
	"testing"
)

func isSubsequence(s string, t string) bool {
  i, j := 0, 0
  for i < len(t) && j < len(s) {
    if s[j] == t[i] {
      j++
    }
    i++
  }
  return j == len(s)
}

func TestIsSubsequence(t *testing.T) {
	tests := []struct {
		s        string
		t        string
		expected bool
	}{
		{"abc", "ahbgdc", true},
		{"axc", "ahbgdc", false},
	}
	for _, tt := range tests {
		result := isSubsequence(tt.s, tt.t)
		if result != tt.expected {
			t.Fatalf("expected %v, got %v", tt.expected, result)
		}
	}
}

