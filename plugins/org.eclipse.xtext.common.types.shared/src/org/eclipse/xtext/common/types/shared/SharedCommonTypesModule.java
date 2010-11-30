package org.eclipse.xtext.common.types.shared;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.xtext.ui.JdtHoverProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class SharedCommonTypesModule implements Module {

	public void configure(Binder binder) {
		binder.bind(IEObjectHoverProvider.class).to(JdtHoverProvider.class);
		binder.bind(IResourceServiceProvider.class).to(SharedCommonTypesResourceServiceProvider.class);
		binder.bindConstant().annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).to("java");
	}

}
