package org.eclipse.xtend.ide.tests.data.bug348446;

/**
 * A class whose method names collide with keywords. 
 * 
 * @author Jan Koehnlein
 */
public class TestClass {

	public void var() {}
	public void variable() {}

	public void getWhile() {}
	public void getWhileYouCan() {}
}
