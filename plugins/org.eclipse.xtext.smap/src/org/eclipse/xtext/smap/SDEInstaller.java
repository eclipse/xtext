/*
 * Copyright 1999,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.xtext.smap;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

//*********************************************************************
// Installation logic (from Robert Field, JSR-045 spec lead)
public class SDEInstaller {

	private static final String nameSDE = "SourceDebugExtension";

	private byte[] orig;
	private byte[] sdeAttr;
	private byte[] gen;

	private int origPos = 0;
	private int genPos = 0;

	private int sdeIndex;
	private boolean verbose = false;

	public SDEInstaller(byte[] original, byte[] sdeAttr) throws IOException {
		this.sdeAttr = sdeAttr;
		this.orig = original;
		gen = new byte[orig.length + sdeAttr.length + 100];

		// do it
		addSDE();
	}
	
	public byte[] getUpdatedByteCode() {
		byte[] result = new byte[genPos];
		System.arraycopy(gen, 0, result, 0, genPos);
		return result;
	}
	
	protected void addSDE() throws UnsupportedEncodingException, IOException {
		copy(4 + 2 + 2); // magic min/maj version
		int constantPoolCountPos = genPos;
		int constantPoolCount = readU2();
		if (verbose) {
			System.out.println("constant pool count: " + constantPoolCount);
		}
		writeU2(constantPoolCount);

		// copy old constant pool return index of SDE symbol, if found
		sdeIndex = copyConstantPool(constantPoolCount);
		if (sdeIndex < 0) {
			// if "SourceDebugExtension" symbol not there add it
			writeUtf8ForSDE();

			// increment the countantPoolCount
			sdeIndex = constantPoolCount;
			++constantPoolCount;
			randomAccessWriteU2(constantPoolCountPos, constantPoolCount);

			if (verbose) {
				System.out.println("SourceDebugExtension not found, installed at: " + sdeIndex);
			}
		} else {
			if (verbose) {
				System.out.println("SourceDebugExtension found at: " + sdeIndex);
			}
		}
		copy(2 + 2 + 2); // access, this, super
		int interfaceCount = readU2();
		writeU2(interfaceCount);
		if (verbose) {
			System.out.println("interfaceCount: " + interfaceCount);
		}
		copy(interfaceCount * 2);
		copyMembers(); // fields
		copyMembers(); // methods
		int attrCountPos = genPos;
		int attrCount = readU2();
		writeU2(attrCount);
		if (verbose) {
			System.out.println("class attrCount: " + attrCount);
		}
		// copy the class attributes, return true if SDE attr found (not copied)
		if (!copyAttrs(attrCount)) {
			// we will be adding SDE and it isn't already counted
			++attrCount;
			randomAccessWriteU2(attrCountPos, attrCount);
			if (verbose) {
				System.out.println("class attrCount incremented");
			}
		}
		writeAttrForSDE(sdeIndex);
	}

	protected void copyMembers() {
		int count = readU2();
		writeU2(count);
		if (verbose) {
			System.out.println("members count: " + count);
		}
		for (int i = 0; i < count; ++i) {
			copy(6); // access, name, descriptor
			int attrCount = readU2();
			writeU2(attrCount);
			if (verbose) {
				System.out.println("member attr count: " + attrCount);
			}
			copyAttrs(attrCount);
		}
	}

	protected boolean copyAttrs(int attrCount) {
		boolean sdeFound = false;
		for (int i = 0; i < attrCount; ++i) {
			int nameIndex = readU2();
			// don't write old SDE
			if (nameIndex == sdeIndex) {
				sdeFound = true;
				if (verbose) {
					System.out.println("SDE attr found");
				}
			} else {
				writeU2(nameIndex); // name
				int len = readU4();
				writeU4(len);
				copy(len);
				if (verbose) {
					System.out.println("attr len: " + len);
				}
			}
		}
		return sdeFound;
	}

	protected void writeAttrForSDE(int index) {
		writeU2(index);
		writeU4(sdeAttr.length);
		for (int i = 0; i < sdeAttr.length; ++i) {
			writeU1(sdeAttr[i]);
		}
	}

	protected void randomAccessWriteU2(int pos, int val) {
		int savePos = genPos;
		genPos = pos;
		writeU2(val);
		genPos = savePos;
	}

	protected int readU1() {
		return orig[origPos++] & 0xFF;
	}

	protected int readU2() {
		int res = readU1();
		return (res << 8) + readU1();
	}

	protected int readU4() {
		int res = readU2();
		return (res << 16) + readU2();
	}

	protected void writeU1(int val) {
		gen[genPos++] = (byte) val;
	}

	protected void writeU2(int val) {
		writeU1(val >> 8);
		writeU1(val & 0xFF);
	}

	protected void writeU4(int val) {
		writeU2(val >> 16);
		writeU2(val & 0xFFFF);
	}

	protected void copy(int count) {
		for (int i = 0; i < count; ++i) {
			gen[genPos++] = orig[origPos++];
		}
	}

	protected byte[] readBytes(int count) {
		byte[] bytes = new byte[count];
		for (int i = 0; i < count; ++i) {
			bytes[i] = orig[origPos++];
		}
		return bytes;
	}

	protected void writeBytes(byte[] bytes) {
		for (int i = 0; i < bytes.length; ++i) {
			gen[genPos++] = bytes[i];
		}
	}

	protected int copyConstantPool(int constantPoolCount) throws UnsupportedEncodingException, IOException {
		int sdeIndex = -1;
		// copy const pool index zero not in class file
		for (int i = 1; i < constantPoolCount; ++i) {
			int tag = readU1();
			writeU1(tag);
			switch (tag) {
				case 7: // Class
				case 8: // String
				case 16 : // MethodType
					if (verbose) {
						System.out.println(i + " copying 2 bytes");
					}
					copy(2);
					break;
                case 15 : // MethodHandle
                	if (verbose) {
						System.out.println(i + " copying 3 bytes");
					}
                    copy(3);
                    break;
				case 9: // Field
				case 10: // Method
				case 11: // InterfaceMethod
				case 3: // Integer
				case 4: // Float
				case 12: // NameAndType
				case 18 : // InvokeDynamic
					if (verbose) {
						System.out.println(i + " copying 4 bytes");
					}
					copy(4);
					break;
				case 5: // Long
				case 6: // Double
					if (verbose) {
						System.out.println(i + " copying 8 bytes");
					}
					copy(8);
					i++;
					break;
				case 1: // Utf8
					int len = readU2();
					writeU2(len);
					byte[] utf8 = readBytes(len);
					String str = new String(utf8, "UTF-8");
					if (verbose) {
						System.out.println(i + " read class attr -- '" + str + "'");
					}
					if (str.equals(nameSDE)) {
						sdeIndex = i;
					}
					writeBytes(utf8);
					break;
				default:
					throw new IOException("unexpected tag: " + tag);
			}
		}
		return sdeIndex;
	}

	protected void writeUtf8ForSDE() {
		int len = nameSDE.length();
		writeU1(1); // Utf8 tag
		writeU2(len);
		for (int i = 0; i < len; ++i) {
			writeU1(nameSDE.charAt(i));
		}
	}
}