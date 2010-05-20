package de.itemis.xtext.antlr;

@Deprecated
public class XtextAntlrUiGeneratorFragment extends org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment {
	@Override
	protected String getTemplate() {
		return getClass().getSuperclass().getName().replaceAll("\\.", "::");
	}
}
