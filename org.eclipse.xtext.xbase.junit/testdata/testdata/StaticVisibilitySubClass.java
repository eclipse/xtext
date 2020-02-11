/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("unused")
public class StaticVisibilitySubClass extends StaticVisibilitySuperType
{
  private String getSubPrivateProperty() { return null; }
	private String privateField;
	private void setPrivateProperty(String x) {}
}
