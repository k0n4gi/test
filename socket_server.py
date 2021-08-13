import socketserver
import threading
import connector_predict
import random

class RequestHandler(socketserver.StreamRequestHandler):
        
    def handle(self):

        # get socket request
        socket = self.request

        # show client
        print('Connect with : ' + self.client_address[0])

        # set file name
        num = random.random() * 100000
        file_name = 'C:/Users/user/Desktop/java_img/file_' + str(int(num)) + '.jpg'

        # get image file size from client
        file_size = socket.recv(1024)
        socket.sendall(file_size)
        #print(str(file_size));
        print('set file size : ' + str(file_size))

        # get image file byte stream from client
        # make empty image file
        with open(file_name, 'wb') as image_file:
            data_tmp = b"";
            while True:
                # save image file from client stream
                data = socket.recv(1024)
                image_file.write(data)
                data_tmp += (data)
                if ((data_tmp.__len__())*100 == int(file_size)):
                    # check image file size
                    # print('received file size : {}'.format(data_tmp.__len__())*100)
                    break
        print('received & save image : ' + file_name)

        # tensorflow image classfication
        connector_inst = connector_predict.Connect(file_name)
        label = connector_inst.get_result()
        socket.sendall(label.encode())
        socket.close()

     
if __name__ == '__main__':
    HOST = '127.0.0.2'
    PORT = 7080
    server = socketserver.TCPServer((HOST, PORT), RequestHandler)

    print('Socket is now listening ...')
    server_thread = threading.Thread(target=server.serve_forever())
    server_thread.setDaemon(True)
    server_thread.start()
    