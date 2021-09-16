import * as Stomp from 'stompjs';

export class StompImpl {
    client: any;
    _connect() {
        var wss = new WebSocket("ws://127.0.0.1:15674/ws");
        this.client = Stomp.over(wss);
        // RabbitMQ SockJS does not support heartbeats so disable them
        this.client.heartbeat.outgoing = 0;
        this.client.heartbeat.incoming = 0;
        this.client.debug = this.onDebug;
        const _this = this;
        this.client.connect('guest', 'guest', function (frame: any) {
            console.log('connected to rabbitmq');
            _this.client.subscribe('/queue/rabbitmq-queue', function (sdkEvent: any) {
                _this.on_connect(sdkEvent);
            });
            //_this.stompClient.reconnect_delay = 2000;
        }, this.onError, '/');
    }

    on_connect(message: any) {
        console.log('message received : ',message.body);
        
    }

    sendMsg(msg: any) {
        this.client.send('/queue/rabbitmq-queue', { "content-type": "application/json","content-encoding": "UTF-8" }, JSON.stringify(msg));
        console.log('message sent to queue : ',msg);
    }
      
    onError(e: any) {
        console.log("STOMP ERROR", e);
    }
      
    onDebug(m: any) {
        console.log("STOMP DEBUG", m);
    }
}