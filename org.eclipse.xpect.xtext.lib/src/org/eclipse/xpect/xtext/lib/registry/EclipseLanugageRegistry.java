package org.eclipse.xpect.xtext.lib.registry;

import java.util.Collection;

public class EclipseLanugageRegistry implements ILanguageInfo.Registry {

	@Override
	public ILanguageInfo getLanguageInfo(String fileExtension) {
		return null;
	}

	@Override
	public Collection<ILanguageInfo> getLanguageInfos() {
		return null;
	}

}
