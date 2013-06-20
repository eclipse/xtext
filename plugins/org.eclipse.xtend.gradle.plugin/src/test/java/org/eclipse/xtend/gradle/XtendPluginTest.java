package org.eclipse.xtend.gradle;

import static org.junit.Assert.assertTrue;
import groovy.lang.Closure;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

public class XtendPluginTest {

	@Test
	public void testCompilation() {
		Project project = ProjectBuilder.builder().build();
//		project.apply();

		// assertTrue(project.tasks.hello instanceof GreetingTask);
	}

}
