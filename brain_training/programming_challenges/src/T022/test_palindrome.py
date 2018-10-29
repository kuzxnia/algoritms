import pytest

from .palindrome import is_palindrome


@pytest.mark.parametrize("input,expected", [
    (0, True),
    ('', True),
    ('aba', True),
    (131, True),
    (123, False),
    ('kacper', False),
    ('1a2a3', False)])
def test_factorial(input, expected):
    assert is_palindrome(input) == expected
