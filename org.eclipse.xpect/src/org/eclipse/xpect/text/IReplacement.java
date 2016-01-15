package org.eclipse.xpect.text;

/**
 * @author Moritz Eysholdt
 */
public interface IReplacement extends IRegion, IChange {
	String getReplacement();
}
