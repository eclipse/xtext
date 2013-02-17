package org.xpect.tests;

import junit.framework.Assert;

import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.runner.RunWith;
import org.xpect.XpectInjectorProvider;
import org.xpect.XpectJavaModel;
import org.xpect.util.XpectJavaModelFactory;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
@InjectWith(XpectInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractXjmTest {

	@Inject
	private XpectJavaModelFactory factory;

	@Inject
	private TypeReferences typeReferences;

	protected void assertXjm(Class<?> clazz) {
		try {
			XpectJavaModel javaModel = factory.createJavaModel(clazz);
			String expected = clazz.newInstance().toString();
			String actual = javaModel.toString();
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
