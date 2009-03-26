/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.ui.core.ILocationInFileProvider;
import org.eclipse.xtext.ui.core.wizard.IProjectCreator;
import org.eclipse.xtext.xtext.ui.editor.outline.FilteringXtextOutlinePage;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextSemanticModelTransformer;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;
import org.eclipse.xtext.xtext.ui.XtextLocationInFileProvider;

/**
 * used to register components to be used within the IDE.
 */
public class XtextUiModule extends AbstractXtextUiModule {

	@Override
	public Class<? extends ISemanticModelTransformer> bindISemanticModelTransformer() {
		return XtextSemanticModelTransformer.class;
	}
	
	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return FilteringXtextOutlinePage.class;
	}
	
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return XtextProjectCreator.class;
	}
	
	@Override
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return XtextLocationInFileProvider.class;
	}
	
	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return XtextLabelProvider.class;
	}
	
}
