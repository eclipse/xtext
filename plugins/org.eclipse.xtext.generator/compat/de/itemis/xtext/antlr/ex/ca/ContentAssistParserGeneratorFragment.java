package de.itemis.xtext.antlr.ex.ca;

@Deprecated
public class ContentAssistParserGeneratorFragment extends
		org.eclipse.xtext.generator.parser.antlr.ex.ca.ContentAssistParserGeneratorFragment {
	@Override
	protected String getTemplate() {
		return getClass().getSuperclass().getName().replaceAll("\\.", "::");
	}
}
