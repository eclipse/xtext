package org.eclipse.xpect.util;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Maps;

public class ResourceSetsByClassloaderContext {

	private class Ref extends AdapterImpl {
		public ResourceSetsByClassloaderContext getManager() {
			return ResourceSetsByClassloaderContext.this;
		}
	}

	public static XtextResourceSet get(ResourceSet rs, Object context) {
		if (rs instanceof XtextResourceSet) {
			XtextResourceSet xrs = (XtextResourceSet) rs;
			if (context.equals(xrs.getClasspathURIContext()))
				return xrs;
		}
		ResourceSetsByClassloaderContext contexts = getOrCreateAdapter(rs);
		XtextResourceSet result = contexts.getOrCreateResourceSet(context);
		return result;
	}

	private static ResourceSetsByClassloaderContext getOrCreateAdapter(ResourceSet rs) {
		EList<Adapter> adapters = rs.eAdapters();
		Iterator<Adapter> it = adapters.iterator();
		while (it.hasNext()) {
			Adapter a = it.next();
			if (a instanceof Ref)
				return ((Ref) a).getManager();
		}
		ResourceSetsByClassloaderContext x = new ResourceSetsByClassloaderContext();
		adapters.add(x.new Ref());
		if (rs instanceof XtextResourceSet) {
			XtextResourceSet xrs = (XtextResourceSet) rs;
			Object context = xrs.getClasspathURIContext();
			if (context != null)
				x.resourceSets.put(context, xrs);
		}
		return x;
	}

	private final Map<Object, XtextResourceSet> resourceSets = Maps.newHashMap();

	private XtextResourceSet createResourceSet(Object context) {
		XtextResourceSet result = new XtextResourceSet();
		result.eAdapters().add(new Ref());
		resourceSets.put(context, result);
		result.setClasspathURIContext(context);
		return result;
	}

	private XtextResourceSet getOrCreateResourceSet(Object context) {
		XtextResourceSet result = resourceSets.get(context);
		if (result == null)
			result = createResourceSet(context);
		return result;
	}
}
