package org.xpect.xtext.lib.util;

import org.eclipse.emf.common.util.URI;

import com.google.common.base.Preconditions;

public class URIUtil {
	public static URI createLocalURI(String name) {
		URI uri = URI.createURI(name);
		Preconditions.checkArgument(uri.isRelative());
		Preconditions.checkArgument(!uri.hasFragment());
		Preconditions.checkArgument(!uri.hasQuery());
		return uri;
	}
}
