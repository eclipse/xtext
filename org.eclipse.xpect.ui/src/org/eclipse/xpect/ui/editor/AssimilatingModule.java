package org.eclipse.xpect.ui.editor;

import org.eclipse.xpect.registry.DefaultBinding;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.spi.LinkedKeyBinding;

public class AssimilatingModule implements Module {

	@Inject
	private Injector original;

	@SuppressWarnings("unchecked")
	protected <T> Class<? extends T> getOriginalType(Class<T> type) {
		Binding<T> binding = original.getBinding(type);
		if (binding instanceof LinkedKeyBinding<?>)
			return (Class<? extends T>) ((LinkedKeyBinding<T>) binding).getLinkedKey().getTypeLiteral().getRawType();
		throw new RuntimeException("no binding found for " + type);
	}

	@Override
	public void configure(Binder binder) {
		binder.bind(ISemanticHighlightingCalculator.class).to(SemCalc.class);
		binder.bind(ISemanticHighlightingCalculator.class).annotatedWith(DefaultBinding.class)
				.to(getOriginalType(ISemanticHighlightingCalculator.class));
	}

	public static class SemCalc implements ISemanticHighlightingCalculator {

		@Inject
		@DefaultBinding
		private ISemanticHighlightingCalculator original;

		@Override
		public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
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
