/*
Copyright (c) 2010, Siemens Corporate Research a Division of Siemens Corporation 
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.siemens.scr.avt.ad.annotation;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;



public class AnnotationAttachment {
	private Blob attachmentObject;
	
	private String name;
	
	private ImageAnnotation referencedAnnotation;
	
	public Blob getAttachmentObject() {
		return attachmentObject;
	}

	public String getName() {
		return name;
	}

	public ImageAnnotation getReferencedAnnotation() {
		return referencedAnnotation;
	}

	public void setAttachmentObject(Blob object) {
		this.attachmentObject = object;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setReferencedAnnotation(ImageAnnotation annotation) {
		this.referencedAnnotation = annotation;
	}

	public InputStream getAttachmentStream() throws SQLException {
		if (getAttachmentObject() == null)
			return null;

		return getAttachmentObject().getBinaryStream();

	}
	
}
