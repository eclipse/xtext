package org.eclipse.xtend.maven;

import java.util.Iterator;

import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * 
 * @author Moritz Eysholdt
 */
public class MavenProjectAdapter extends AdapterImpl {
	public static MavenProject get(ResourceSet rs) {
		for (Adapter a : rs.eAdapters())
			if (a instanceof MavenProjectAdapter)
				return ((MavenProjectAdapter) a).project;
		throw new RuntimeException("The Maven Project is not registered in the ResourceSet");
	}

	public static void install(ResourceSet rs, MavenProject project) {
		Iterator<Adapter> i = rs.eAdapters().iterator();
		while (i.hasNext())
			if (i.next() instanceof MavenProjectAdapter)
				i.remove();
		rs.eAdapters().add(new MavenProjectAdapter(project));
	}

	private MavenProject project;

	private MavenProjectAdapter(MavenProject project) {
		super();
		this.project = project;
	}
}
