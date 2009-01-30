/*
Generated with Xtext
*/
package org.eclipse.xtext;

import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextSemanticModelTransformer;


/**
 * used to register components to be used within the IDE.
 */
public class XtextUIModule extends AbstractXtextUiModule {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.service.DefaultUIModule#getISemanticModelTransformer()
	 */
	@Override
	protected Class<? extends ISemanticModelTransformer> getISemanticModelTransformer() {
		return XtextSemanticModelTransformer.class;
	}

}
