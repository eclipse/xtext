/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.navigation;

import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.generator.trace.ILocationInResource;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LinkToOriginProvider {
	
	@Inject
	private Provider<LinkToOrigin> hyperlinkProvider;

	public LinkToOrigin createLinkToOrigin(ILocationInResource source, IRegion selectedWord, IMember selectedMember, ICompilationUnit compilationUnitOfSelection, List<LinkToOrigin> alreadyCreatedLinks) {
		LinkToOrigin hyperlink = hyperlinkProvider.get();
		hyperlink.setHyperlinkRegion((IRegion)new Region(selectedWord.getOffset(), selectedWord.getLength()));
		hyperlink.setURI(source.getAbsoluteResourceURI().getURI());
		hyperlink.setMember(selectedMember);
		hyperlink.setHyperlinkText("Open Original Declaration");
		hyperlink.setTypeLabel("Navigate to source artifact");
		return hyperlink;
	}
}
