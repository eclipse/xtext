package org.eclipse.xtext.generator.resourceFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * An {@link IGeneratorFragment} to generate an EMF resource factory and its registration.
 *  
 * @author koehnlein - Javadocs
 */
public class ResourceFactoryFragment extends AbstractGeneratorFragment {
	private List<String> fileExtensions = new ArrayList<String>();

	/** 
	 * Sets the fileExtension the generated {@link Resource.Factory} should be registered to.
	 * 
	 * @param fileExtensions
	 */
	public void setFileExtensions(String fileExtensions) {
		if ("".equals(fileExtensions.trim()))
			return;
		String[] split = fileExtensions.split("\\s*,\\s*");
		for (String string : split) {
			this.fileExtensions.add(string);
		}
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.singletonList((Object) getFileExtensions(grammar));
	}

	private List<String> getFileExtensions(Grammar grammar) {
		if (!fileExtensions.isEmpty())
			return fileExtensions;
		return Collections.singletonList(GrammarUtil.getName(grammar).toLowerCase());
	}

}
