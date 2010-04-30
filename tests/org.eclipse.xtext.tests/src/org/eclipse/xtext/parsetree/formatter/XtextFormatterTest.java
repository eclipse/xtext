package org.eclipse.xtext.parsetree.formatter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.reconstr.SerializerOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public class XtextFormatterTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		XtextStandaloneSetup.doSetup();
		super.setUp();
	}
  
	public void testXtextFormatting() throws IOException {
		String path = getClass().getPackage().getName().replace('.', '/');
		URI u = URI.createURI("classpath:/" + path
				+ "/XtextFormatterMessy.xtext");
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(getClass());
		Resource r = resourceSet.getResource(u, true);
		// System.out.println(r.getWarnings());
		// System.out.println(r.getErrors());
		ByteArrayOutputStream formatted = new ByteArrayOutputStream();
		Map<String, Object> opt = new HashMap<String, Object>();
		opt.put(XtextResource.OPTION_SERIALIZATION_OPTIONS, new SerializerOptions());
		r.save(formatted, opt);
		// System.out.println(EmfFormatter.listToStr(r.getContents()));
		// System.out.println(formatted.toString());

		URI expectedURI = URI.createURI("classpath:/" + path + "/XtextFormatterExpected.xtext");
		XtextResource expectedResource = (XtextResource) resourceSet.getResource(expectedURI, true);
		String expected = expectedResource.getParseResult().getRootNode().serialize();
		assertEquals(expected, formatted.toString());
	}

}
