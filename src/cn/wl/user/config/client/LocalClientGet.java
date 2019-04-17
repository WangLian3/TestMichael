package cn.wl.user.config.client;

import java.util.List;

import org.w3c.dom.Document;

public class LocalClientGet extends ClientGet{

	public LocalClientGet(String uri) {
		super(uri);
	}

	@Override
	public String getFileAsString(String relativePath) {
		return null;
	}

	@Override
	public Document getFileAsDom(String relativePath) {
		return null;
	}

	@Override
	public List<String> getFileAsList(String relativePath) {
		return null;
	}

}
