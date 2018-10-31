import pytest

from .anagram import is_anagram


@pytest.mark.parametrize("input,expected", [
    (('aabbcc', 'ccbaba',), True),
    (('aabbc', 'ccbaba',), False),
    (('', '',), True),
    (('a', 'a',), True),
    (('', 'ccbaba',), False)
])
def test_factorial(input, expected):
    assert is_anagram(input[0], input[1]) == expected
