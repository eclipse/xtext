package org.eclipse.xtend.ide.wizards;

import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

import com.google.inject.Inject;

/**
 * @author Robert von Massow - Initial contribution and API
 * @author Holger Schill
 */
public class NewXtendClassWizard extends AbstractNewXtendElementWizard {

	public static final String TITLE = "Xtend Class"; //$NON-NLS-1$

	@Inject
	public NewXtendClassWizard(IImageDescriptorHelper imgHelper, NewXtendClassWizardPage page) {
		super(imgHelper, page, TITLE);
	}
}
