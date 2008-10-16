package de.thesuntoucher.jigg.net;

import java.net.URL;

import de.thesuntoucher.jigg.handler.ResponseHandler;

public interface JiggHttpClient {
	
	public void fetch(URL url, ResponseHandler handler);

}
