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

import java.util.HashSet;
import java.util.Set;

import com.siemens.scr.avt.ad.dicom.GeneralImage;

public class ImageAnnotation {
	private int PK_ID;

	private String AIM;
	
	private ImageAnnotationDescriptor descriptor;
	
	
	private Set<GeneralImage> referencedImages = new HashSet<GeneralImage>();
	
	public String getAIM() {
		return AIM;
	}

	public int getPK_ID() {
		return PK_ID;
	}

	public ImageAnnotationDescriptor getDescriptor() {
		return descriptor;
	}

	public void setAIM(String aimXML) {
		this.AIM = aimXML;
	}
	
	public void setDescriptor(ImageAnnotationDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	
	public Set<GeneralImage> getReferencedImages() {
		return referencedImages;
	}

	public void setReferencedImages(Set<GeneralImage> referencedImages) {
		this.referencedImages = referencedImages;
	}

}
