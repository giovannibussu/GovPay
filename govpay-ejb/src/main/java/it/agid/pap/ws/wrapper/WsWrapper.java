package it.agid.pap.ws.wrapper;

import javax.xml.ws.Service;

public interface WsWrapper<X, Y extends Service> {

	X getService();

}
