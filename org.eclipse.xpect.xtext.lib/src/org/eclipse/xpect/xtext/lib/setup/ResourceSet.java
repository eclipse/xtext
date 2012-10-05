package org.eclipse.xpect.xtext.lib.setup;

import java.util.List;

import com.google.common.collect.Lists;

public class ResourceSet {
	private List<ISetupFile> files = Lists.newArrayList();

	public void add(ISetupFile file) {
		getFiles().add(file);
	}

	public List<ISetupFile> getFiles() {
		return files;
	}

}
