/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.releng;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.ice.tar.TarEntry;
import com.ice.tar.TarInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Helper {

	public static void ensureDirExists(String directory) {
		ensureDirExists(new File(directory));
	}

	public static void ensureDirExists(File directory) {
		if (directory.exists()) {
			return;
		}
		else {
			ensureDirExists(directory.getParentFile());
			directory.mkdir();
		}
	}
	
	public static void delete(File file) {
		if (!file.exists())
			return;
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				delete(file2);
			}
		}
		System.out.println("deleting "+file);
		file.delete();
	}

	public static void extract(String fileName, String to) throws Exception {
		if (fileName.endsWith(".zip")) {
			unzip(fileName, to);
		}
		else if (fileName.endsWith(".tar.gz")) {
			unTarGz(fileName, to);
		}
	}

	private static void unTarGz(String fileName, String to) throws Exception {
		GZIPInputStream in = new GZIPInputStream(new FileInputStream(fileName));
		TarInputStream tarIn = new TarInputStream(in);
		TarEntry entry;
		int BUFFER = 2048;
		System.out.println("Unzipping: " + fileName);
		while ((entry = tarIn.getNextEntry()) != null) {
			if (!entry.isDirectory()) {
				System.out.println("Extracting: " + entry.getName());
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				String string = to + entry.getName();
				ensureDirExists(new File(string).getParentFile());
				FileOutputStream fos = new FileOutputStream(string);
				BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = tarIn.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
		}
	}

	private static void unzip(String fileName, String to) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(fileName);
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
		ZipEntry entry;
		int BUFFER = 2048;
		System.out.println("Unzipping: " + fileName);
		while ((entry = zis.getNextEntry()) != null) {
			if (!entry.isDirectory()) {
				System.out.println("Extracting: " + entry);
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				String string = to + entry.getName();
				ensureDirExists(new File(string).getParentFile());
				FileOutputStream fos = new FileOutputStream(string);
				BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
		}
	}

	public static void downloadFile(String targetDir, String downloadURL) throws MalformedURLException, IOException,
			FileNotFoundException {
		URL url = new URL(downloadURL);
		String fileName = getLastSegment(url.getPath());
		File file = new File(targetDir + fileName);
		if (file.exists()) {
			System.out.println(file.getName() + " already exists.");
			return;
		}
		InputStream stream = url.openStream();
		FileOutputStream outputStream = new FileOutputStream(file);
		System.out.println("Downloading " + fileName);
		byte[] buff = new byte[1024 * 64];
		int length = -1;
		while ((length = stream.read(buff)) != -1) {
			System.out.print('.');
			outputStream.write(buff, 0, length);
		}
		outputStream.close();
		stream.close();
		System.out.println("finished.");
	}

	public static String getLastSegment(String url) {
		return url.substring(url.lastIndexOf('/'));
	}

}
