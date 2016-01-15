package org.eclipse.xpect.tests.xjm;

import java.lang.reflect.Constructor;

import org.eclipse.xpect.XpectInjectorProvider;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xpect.util.XpectJavaModelManager;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.runner.RunWith;

@InjectWith(XpectInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractXjmTest {

	protected void assertXjm(Class<?> clazz) {
		try {
			XpectJavaModel javaModel = XpectJavaModelManager.createJavaModel(clazz);
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			String expected = constructor.newInstance().toString();
			String actual = javaModel.toString();
			Assert.assertEquals(expected.trim(), actual.trim());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
