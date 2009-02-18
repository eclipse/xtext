package org.eclipse.xtext.generator.resourceFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.generator.AbstractGeneratorFragment;

public class ResourceFactoryFragment extends AbstractGeneratorFragment {
	private List<String> fileExtensions = new ArrayList<String>();
	
	public void setFileExtensions(String fileExtensions) {
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}
	
	@Override
	protected List<Object> getParameters() {
		return Collections.singletonList((Object) fileExtensions);
	}
	
}
