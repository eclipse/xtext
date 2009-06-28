package org.eclipse.xtext.parsetree.formatter;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class XtextFormatterTest extends AbstractGeneratorTest {

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
		ByteArrayOutputStream expected = new ByteArrayOutputStream();
		Map<String, Object> opt = new HashMap<String, Object>();
		opt.put(XtextResource.OPTION_FORMAT, Boolean.TRUE);
		r.save(formatted, opt);
		// System.out.println(EmfFormatter.listToStr(r.getContents()));
		// System.out.println(formatted.toString());

		InputStream in = new BufferedInputStream(new FileInputStream("src/"
				+ path + "/XtextFormatterExpected.xtext"));
		int i;
		while ((i = in.read()) >= 0)
			expected.write(i);
		assertEquals(expected.toString(), formatted.toString());
	}

}
