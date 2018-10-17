from collections import deque


class Queue:
    def __init__(self, max_size=10):
        self._queue = deque(maxlen=max_size)

    def enqueue(self, item):
        self._queue.append(item)

    def dequeue(self):
        return self._queue.pop()
