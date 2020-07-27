package org.eclipse.xtext.purexbase.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.tests.PureXbaseInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.imports.DefaultImportsConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
public class DefaultImportsConfigurationTest {

	@Inject
	private ParseHelper<Model> parser;
	@Inject
	private DefaultImportsConfiguration defaultImportsConfiguration;

	@Test
	public void testCommentsInImportSection() throws Exception {
		// @formatter:off
		String modelString =
			"// some comment\n" +
			"import java.util.List\n" +
			"/* another\n" +
			" * comment\n" +
			" */\n" +
			"import java.util.Set\n" +
			"\n" +
			"println('Hello World')";
		// @formatter:on
		Model model = parser.parse(modelString);
		assertEquals(0, defaultImportsConfiguration.getImportSectionOffset((XtextResource) model.eResource()));
	}
}