package org.xpect.xtext.lib.setup.generic;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.xpect.xtext.lib.setup.FileSetupContext;
import org.xpect.xtext.lib.util.URIUtil;

import com.google.common.collect.Lists;

public class Folder implements Resource {

	private List<Resource> children = Lists.newArrayList();

	private final URI local;

	public Folder(String name) {
		this.local = URIUtil.createLocalURI(name);
	}

	public void add(Resource child) {
		children.add(child);
	}

	public List<Resource> getChildren() {
		return children;
	}

	public URI getLocalURI(FileSetupContext ctx) {
		return local;
	}
}
