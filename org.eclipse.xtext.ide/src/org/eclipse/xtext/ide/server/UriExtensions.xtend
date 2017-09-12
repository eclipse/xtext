/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.server

import com.google.common.collect.ImmutableList
import com.google.inject.Singleton
import java.io.FileNotFoundException
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.emf.common.util.URI

import static java.nio.file.LinkOption.NOFOLLOW_LINKS

import static extension com.google.common.base.Preconditions.checkNotNull

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
class UriExtensions {

	static val ESCAPED_FILE_SCHEME = URLEncoder.encode("file:", StandardCharsets.UTF_8.name);

	/**
	 * Converts any non-{@code null} arguments, representing a URI as a string, into a EMF based URI where the following
	 * rules apply:
	 * <p>
	 * <ul>
	 * <li>If the argument has a {@code file} scheme:
	 * <ul>
	 * <li>and the {@code host} is not set (e.g.: {@code localhost} can be omitted) then it returns with a EMF URI with the
	 * following form: {@code file:///path/to/resource}.</li>
	 * <li>and the {@code host} is set (e.g.: {@code localhost} can be omitted) then drops the URI host and returns with a 
	 * EMF URI with the following form: {@code file:///path/to/resource}.</li>
	 * <li>if the URI starts with two forward-slashes ({@code file://path/to/resource}), the method will treat it with a URI
	 * with {@code localhost} scheme and will omit it, producing the {@code file:///path/to/resource} result.</li>
	 * </ul>
	 * <li>If the has any other scheme then it will return with EMF URI {@link URI#createURI(String) created} from the
	 * argument.</li>
	 * <li>This method takes care of the encoding and the URI path escaping.</li>
	 * </ul>
	 * </p>
	 */
	def URI toUri(String pathWithScheme) {
		// This will take care of the encoding.
		val uri = URI.createURI(pathWithScheme.checkNotNull('pathWithScheme'));
		if (uri.file) {
			val segments = uri.toSegments;
			val prefix = try {
				Files.isDirectory(Paths.get(uri.toFileString), NOFOLLOW_LINKS);
			} catch (FileNotFoundException e) {
				false;
			}
			return URI.createURI('''file:///«segments.join('/')»«IF prefix»/«ENDIF»''');
		}
		return uri;
	}

	/**
	 * Converts the EMF URI argument into a string path.
	 * <p>
	 * If the argument is a URI with {@link URI#isFile() file} scheme, then the produced result value will always have this
	 * form {@code file:///path/to/resource, otherwise it returns with the string representation
	 * of the argument.
	 */
	def String toPath(URI uri) {
		if (uri.file) {
			val segments = uri.toSegments;
			val path = segments.join('/');
			return '''file:///«path»''';
		}
		return uri.toString;
	}

	/**
	 * Converts the {@code java.net} URI argument into a string path.
	 */
	def String toPath(java.net.URI uri) {
		return URI.createURI(uri.toString).toPath;
	}

	private def toSegments(URI it) {
		val builder = ImmutableList.builder;
		if (!host.nullOrEmpty && host != 'localhost') {
			builder.add(host);
		}
		builder.addAll(segments.drop(segmentsToDrop));
		return builder.build;
	}

	/**
	 * Calculates how many segments should be dropped.
	 * 
	 * <p>
	 * EMF file URI cannot interpret {@code file:///} scheme and will be parsed differently. 
	 * 
	 * <p>
	 * Handles different file URI cases, such as:
	 * <ul>
	 * <li>URI is created as URI#createURI('file://foo'),</li>
	 * <li>URI is created as URI#createURI('file:///foo'),</li>
	 * <li>URI is created as URI#createFileURI('file://foo') and</li>
	 * <li>URI is created as URI#createFileURI('file://foo').</li>
	 * </ul>
	 * Does nothing and returns with 0, when the URI is not a file URI.
	 */
	private def getSegmentsToDrop(URI it) {
		if (scheme === null && file && segments.head == ESCAPED_FILE_SCHEME) {
			var toDrop = 1;
			while (segment(toDrop).nullOrEmpty) {
				toDrop++;
			}
			return toDrop;
		}
		return 0;
	}

}
