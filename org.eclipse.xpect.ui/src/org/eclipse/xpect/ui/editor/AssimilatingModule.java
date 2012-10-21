package org.eclipse.xpect.ui.editor;

import org.eclipse.xpect.registry.DefaultBinding;
import org.eclipse.xpect.util.AbstractDelegatingModule;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Binder;
import com.google.inject.Inject;

public class AssimilatingModule extends AbstractDelegatingModule {

	@Override
	public void configure(Binder binder) {
		binder.bind(ISemanticHighlightingCalculator.class).to(SemCalc.class);
		Class<? extends ISemanticHighlightingCalculator> originalType = getOriginalType(ISemanticHighlightingCalculator.class);
		if (originalType != null)
			binder.bind(ISemanticHighlightingCalculator.class).annotatedWith(DefaultBinding.class).to(originalType);
		binder.bind(IResourceValidator.class).to(XpectResourceValidator.class);
		Class<? extends IResourceValidator> originalValidator = getOriginalType(IResourceValidator.class);
		binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class).to(originalValidator);
	}

	public static class SemCalc implements ISemanticHighlightingCalculator {

		@DefaultBinding
		@Inject(optional = true)
		private ISemanticHighlightingCalculator original;

		@Override
		public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
			if (original != null)
				original.provideHighlightingFor(resource, acceptor);
			int length = "XPECT".length();
			for (ILeafNode node : resource.getParseResult().getRootNode().getLeafNodes()) {
				String text = node.getText();
				int match = text.indexOf("XPECT");
				while (match >= 0) {
					acceptor.addPosition(node.getOffset() + match, length, DefaultHighlightingConfiguration.KEYWORD_ID);
					match = text.indexOf("XPECT", match + length);
				}
			}
		}
	}

}
