package de.itemis.xtext.antlr;

@Deprecated
public class XtextAntlrGeneratorFragment extends org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment {
	@Override
	protected String getTemplate() {
		return getClass().getSuperclass().getName().replaceAll("\\.", "::");
	}
}
