import socket

target_host = socket.gethostname()
target_port = 9999

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((target_host, target_port))

client.send(b'Hello World!!')

response = client.recv(4096)
client.close()

print(response.decode())
