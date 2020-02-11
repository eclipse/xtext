/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.Scope;

public class ExternalDependency {
	public static class MavenCoordinates {
		private String groupId;

		private String artifactId;

		private String version;

		public void setShortNotation(String shortNotation) {
			String[] parts = shortNotation.split(":");
			this.groupId = parts[0];
			this.artifactId = parts[1];
			this.version = parts[2];
		}

		private Scope scope = Scope.COMPILE;

		private boolean optional = false;

		@Pure
		public String getGroupId() {
			return this.groupId;
		}

		public void setGroupId(String groupId) {
			this.groupId = groupId;
		}

		@Pure
		public String getArtifactId() {
			return this.artifactId;
		}

		public void setArtifactId(String artifactId) {
			this.artifactId = artifactId;
		}

		@Pure
		public String getVersion() {
			return this.version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		@Pure
		public Scope getScope() {
			return this.scope;
		}

		public void setScope(Scope scope) {
			this.scope = scope;
		}

		@Pure
		public boolean isOptional() {
			return this.optional;
		}

		public void setOptional(boolean optional) {
			this.optional = optional;
		}
	}

	public static class P2Coordinates {
		private String bundleId;

		private String version;

		private Set<String> packages = CollectionLiterals.newHashSet();

		@Pure
		public String getBundleId() {
			return this.bundleId;
		}

		public void setBundleId(String bundleId) {
			this.bundleId = bundleId;
		}

		@Pure
		public String getVersion() {
			return this.version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		@Pure
		public Set<String> getPackages() {
			return this.packages;
		}

		public void setPackages(Set<String> packages) {
			this.packages = packages;
		}
	}

	public static ExternalDependency createXtextDependency(String xtextBundle) {
		ExternalDependency externalDependency = new ExternalDependency();
		externalDependency.p2.bundleId = xtextBundle;
		externalDependency.maven.groupId = "org.eclipse.xtext";
		externalDependency.maven.artifactId = xtextBundle;
		externalDependency.maven.version ="${xtextVersion}";
		return externalDependency;
	}

	public static ExternalDependency createMavenDependency(String shortNotation) {
		ExternalDependency externalDependency = new ExternalDependency();
		externalDependency.maven.setShortNotation(shortNotation);
		return externalDependency;
	}

	public static ExternalDependency createBundleDependency(final String bundleId) {
		ExternalDependency externalDependency = new ExternalDependency();
		externalDependency.p2.bundleId = bundleId;
		return externalDependency;
	}

	private final ExternalDependency.MavenCoordinates maven = new ExternalDependency.MavenCoordinates();

	private final ExternalDependency.P2Coordinates p2 = new ExternalDependency.P2Coordinates();

	public void maven(Procedure1<? super ExternalDependency.MavenCoordinates> config) {
		config.apply(this.maven);
	}

	public void p2(Procedure1<? super ExternalDependency.P2Coordinates> config) {
		config.apply(this.p2);
	}

	@Pure
	public ExternalDependency.MavenCoordinates getMaven() {
		return this.maven;
	}

	@Pure
	public ExternalDependency.P2Coordinates getP2() {
		return this.p2;
	}
}
