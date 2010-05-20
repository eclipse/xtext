package de.itemis.xtext.antlr.ex.rt;

@Deprecated
public class AntlrGeneratorFragment extends org.eclipse.xtext.generator.parser.antlr.ex.rt.AntlrGeneratorFragment {
	@Override
	protected String getTemplate() {
		return getClass().getSuperclass().getName().replaceAll("\\.", "::");
	}
}
