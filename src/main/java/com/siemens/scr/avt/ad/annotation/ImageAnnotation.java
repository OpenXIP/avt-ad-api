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
