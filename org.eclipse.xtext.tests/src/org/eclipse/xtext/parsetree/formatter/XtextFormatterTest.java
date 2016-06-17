package org.eclipse.xtext.parsetree.formatter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.formatting.ILineSeparatorInformation;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("deprecation")
public class XtextFormatterTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule() {
					@SuppressWarnings("unused")
					public Class<? extends ILineSeparatorInformation> bindILineSeparatorInformation() {
						return FormatterTestLineSeparatorInformation.class;
					}
				});
			}
		});
		get(FormatterTestLineSeparatorInformation.class).setLineSeparator("\n");
	}

	@Test public void testXtextFormatting() throws IOException {
		String path = getClass().getPackage().getName().replace('.', '/');
		URI u = URI.createURI("classpath:/" + path + "/XtextFormatterMessy.xtext");
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(getClass());
		Resource r = resourceSet.getResource(u, true);
		// System.out.println(r.getWarnings());
		// System.out.println(r.getErrors());
		ByteArrayOutputStream formatted = new ByteArrayOutputStream();
		r.save(formatted, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		// System.out.println(EmfFormatter.listToStr(r.getContents()));
		// System.out.println(formatted.toString());

		URI expectedURI = URI.createURI("classpath:/" + path + "/XtextFormatterExpected.xtext");
		XtextResource expectedResource = (XtextResource) resourceSet.getResource(expectedURI, true);
		String expected = expectedResource.getParseResult().getRootNode().getText();
		assertEquals(expected, formatted.toString());
	}

	public void _testXtextXtext() {
		Serializer serializer = get(Serializer.class);
		IGrammarAccess grammar = get(IGrammarAccess.class);
		SaveOptions opt = SaveOptions.newBuilder().format().getOptions();
		System.out.println(serializer.serialize(grammar.getGrammar(), opt));
	}

}
