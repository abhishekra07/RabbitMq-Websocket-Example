import { Component, NgZone, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StompImpl } from './StompImpl';
import { WebSocketAPI } from './WebSocketAPI';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  webSocketAPI!: WebSocketAPI;
  stomp!: StompImpl;
  type!: string;
  status!: string;
  data!: Observable<string>;

  constructor(){}

  ngOnInit() {
    this.webSocketAPI = new WebSocketAPI(new AppComponent());
    this.stomp = new StompImpl();
    this.connect();
    if(this.data){
      this.data.subscribe((val: any) => {
        console.log('data received : ',val);
        
      })
    }
  }

  connect(){
    this.webSocketAPI._connect();
    this.stomp._connect();
  }

  disconnect(){
    this.webSocketAPI._disconnect();
  }

  sendMessage(){
    // this.webSocketAPI._send({deviceStatus: this.status, productType: this.type});
    this.stomp.sendMsg({deviceStatus: this.status, productType: this.type})
  }

  handleMessage(message: any){
    this.data = new Observable(observer => {
      observer.next(message.body);
    })
    this.ngOnInit();
  }

}
