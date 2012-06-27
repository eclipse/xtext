package org.eclipse.xpect.examples.textile;

import org.eclipse.xpect.lib.XpectTestFiles;
import org.eclipse.xpect.lib.Xpect;
import org.eclipse.xpect.lib.XpectRunner;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectTestFiles(fileExtensions = "textile")
public class SimpleTest {

	@Xpect
	public void simple() {
		System.out.println("Hello World");
	}

}
