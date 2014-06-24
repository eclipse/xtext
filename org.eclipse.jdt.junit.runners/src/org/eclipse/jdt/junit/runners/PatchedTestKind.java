package org.eclipse.jdt.junit.runners;

import java.lang.reflect.Field;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.JUnitRuntimeClasspathEntry;
import org.eclipse.jdt.internal.junit.launcher.TestKind;

@SuppressWarnings("restriction")
public class PatchedTestKind extends TestKind {

	private static final String JUNIT4_RUNTIME_PATCH = "org.eclipse.jdt.junit4.runtime.patch";

	private static IConfigurationElement getConfigurationElement(ITestKind delegate) {
		for (Field f : TestKind.class.getDeclaredFields())
			if (IConfigurationElement.class.isAssignableFrom(f.getType())) {
				f.setAccessible(true);
				Object object;
				try {
					object = f.get(delegate);
					if (object instanceof IConfigurationElement)
						return (IConfigurationElement) object;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		throw new IllegalStateException();
	}

	public PatchedTestKind(ITestKind delegate) {
		super(getConfigurationElement(delegate));
	}

	public String getLoaderPluginId() {
		return JUNIT4_RUNTIME_PATCH;
	}

	public String getLoaderClassName() {
		return JUNIT4_RUNTIME_PATCH + ".JUnit4TestLoader";
	}

	@Override
	public JUnitRuntimeClasspathEntry[] getClasspathEntries() {
		JUnitRuntimeClasspathEntry[] entries = super.getClasspathEntries();
		JUnitRuntimeClasspathEntry[] result = new JUnitRuntimeClasspathEntry[entries.length + 1];
		System.arraycopy(entries, 0, result, 0, entries.length);
		result[entries.length] = new JUnitRuntimeClasspathEntry(JUNIT4_RUNTIME_PATCH, null);
		return result;
	}

}
