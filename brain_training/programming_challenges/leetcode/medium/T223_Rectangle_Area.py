class Solution:
    def computeArea(self, A, B, C, D, E, F, G, H):
        area1, area2 = abs(C - A) * abs(B - D), abs(E - G) * abs(F - H)

        width, height = min(C, G) - max(A, E), min(D, H) - max(B, F)

        overlapped = 0
        if width > 0 and height > 0:
            overlapped = width * height

        return area1 + area2 - overlapped
