/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.ui.core.wizard.IProjectCreator;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextSemanticModelTransformer;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

/**
 * used to register components to be used within the IDE.
 */
public class XtextUiModule extends AbstractXtextUiModule {

	@Override
	public Class<? extends ISemanticModelTransformer> bindISemanticModelTransformer() {
		return XtextSemanticModelTransformer.class;
	}
	
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return XtextProjectCreator.class;
	}
	
}
