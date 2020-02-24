import sys
import socket
import getopt
import threading
import subprocess
import argparse


listen = False
command = False
upload = False
execute = ''
target = ''
upload_destination = ''
port = 0


def init_parser():
    parser = argparse.ArgumentParser(description='Basic netcat', argument_default='help')

    optional = parser._action_groups.pop()
    required = parser.add_argument_group('required arguments')

    optional.add_argument('-e', '--execute', help='Executes given file when connect sucessfuly')
    optional.add_argument('-l', '--listen', help='Listening on [host]:[port]')
    optional.add_argument('-c', '--command', help='Init command line')
    optional.add_argument('-u', '--upload', help='Send file when connect sucessfuly in [destination]')

    parser._action_groups.append(optional)

    required.add_argument('-t', '--target_host', help='Host', required=True)
    required.add_argument('-p', '--port', help='Port', required=True)
    return parser


def main():
    global listen
    global port
    global execute
    global command
    global upload_destination
    global target

    parser = init_parser()

    if not len(sys.argv[1:]):
        parser.print_help()
        sys.exit(1)


if __name__ == '__main__':
    main()
