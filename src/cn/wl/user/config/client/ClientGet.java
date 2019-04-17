package cn.wl.user.config.client;

import java.util.List;

import org.w3c.dom.Document;

public abstract class ClientGet {
	protected String uri;

	public ClientGet(String uri) {
		this.uri = uri;
	}

	public abstract String getFileAsString(String relativePath);

	public abstract Document getFileAsDom(String relativePath);

	public abstract List<String> getFileAsList(String relativePath);
}
