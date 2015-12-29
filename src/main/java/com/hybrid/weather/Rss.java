package com.hybrid.weather;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class Rss {
	
	Channel channel ;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	} 
	

}
