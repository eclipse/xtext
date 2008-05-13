package org.eclipse.xtext.core.parser;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public abstract class BaseEPackageAccess {
	public static EPackage get(String string) {
		EPackage package1 = EPackage.Registry.INSTANCE.getEPackage(string);
		if (package1 == null)
			throw new IllegalStateException("couldn't load EPackage for URI '"+string+"'");
		return package1;
	}
	
	protected static EPackage loadEcoreFile(ClassLoader loader, String string) {
		InputStream in = loader.getResourceAsStream(string);
		Resource resource = new ResourceSetImpl().createResource(URI.createURI("classpath:/"+string));
		try {
			resource.load(in, null);
		} catch (IOException e) {
			throw new WrappedException(e);
		}
		EList<EObject> contents = resource.getContents();
		if (contents.size()!=1) {
			throw new IllegalStateException("loading classpath:"+string+" : Expected one root element but found "+contents.size());
		}
		return (EPackage) contents.get(0);
	}
}
