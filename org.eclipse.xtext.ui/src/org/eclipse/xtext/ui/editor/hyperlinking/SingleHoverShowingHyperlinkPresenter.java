/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hyperlinking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.JFaceTextUtil;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.MultipleHyperlinkPresenter;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;

/**
 * The MultipleHyperLinkPresenter only shows the hyperlink text when more then one hyperlink exists. This is not always desired as some
 * hyperlinks might have special meaning, and without showing the user what the hyperlink does only simple go to declaration, hyperlinks
 * should be treated like that.
 * 
 * Thus this class introduces a protocol for IHyperLinks to make sure their label is shown even if they are the only ones. To do so, the
 * property IHyperLink#getTypeLabel needs to be set to the constant SHOW_ALWAYS.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
public class SingleHoverShowingHyperlinkPresenter implements InvocationHandler {

	private static final Logger log = Logger.getLogger(SingleHoverShowingHyperlinkPresenter.class);

	/**
	 * Constant text needs to set into IHyperLink#getTypeLabel (which doesn't seem to be used otherwise) if a hyperlink's label should be
	 * shown even if it's the only hyperlink.
	 */
	public static final String SHOW_ALWAYS = "SHOW_ALWAYS";

	private final MultipleHyperlinkPresenter delegate;

	private final ReflectExtensions reflect = new ReflectExtensions();

	public SingleHoverShowingHyperlinkPresenter(MultipleHyperlinkPresenter delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().startsWith("showHyperlinks") && (args.length >= 1) && (args[0] instanceof IHyperlink[])) {
			List<IHyperlink> nullsafe = makeNullsafe(Arrays.asList((IHyperlink[]) args[0]));
			if (!nullsafe.isEmpty()) {
				args[0] = nullsafe;
				Object result = method.invoke(delegate, args);
				List<IHyperlink> activeHyperlinks = nullsafe;
				if (activeHyperlinks.size() == 1) {
					IHyperlink singleHyperlink = activeHyperlinks.get(0);
					if (Objects.equals(SHOW_ALWAYS, singleHyperlink.getTypeLabel())) {
						int start = singleHyperlink.getHyperlinkRegion().getOffset();
						int end = start + singleHyperlink.getHyperlinkRegion().getLength();
						reflect.set(delegate, "fSubjectRegion", new Region(start, end - start));
						reflect.set(delegate, "fCursorOffset",
								Integer.valueOf(JFaceTextUtil.getOffsetForCursorLocation(reflect.get(delegate, "fTextViewer"))));
						((AbstractInformationControlManager) reflect.get(delegate, "fManager")).showInformation();
					}
				}
				return result;
			}
			return null; // showHyperlinks returns void 
		}
		return method.invoke(delegate, args);
	}

	/**
	 * @since 2.9
	 */
	protected List<IHyperlink> makeNullsafe(List<IHyperlink> hyperlinks) {
		if (hyperlinks.stream().anyMatch(hyperLink -> (hyperLink == null || hyperLink.getHyperlinkRegion() == null))) {
			List<IHyperlink> nullSafeList = new ArrayList<>();
			hyperlinks.forEach(hyperLink -> {
				if (hyperLink != null && hyperLink.getHyperlinkRegion() != null) {
					nullSafeList.add(hyperLink);
				} else {
					Class<? extends IHyperlink> clazz = null;
					if (hyperLink != null) {
						clazz = hyperLink.getClass();
					}
					String name = null;
					if (clazz != null) {
						name = clazz.getName();
					}

					log.warn("Filtered invalid hyperlink: " + name);
				}
			});
			return nullSafeList;
		}
		return hyperlinks;
	}

}
