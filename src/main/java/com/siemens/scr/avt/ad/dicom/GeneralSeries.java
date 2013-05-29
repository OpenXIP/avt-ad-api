package com.siemens.scr.avt.ad.dicom;

import java.util.HashSet;
import java.util.Set;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.iod.module.composite.GeneralSeriesModule;


public class GeneralSeries extends GeneralSeriesModule{
	private Set images = new HashSet();
	
	private int PK_ID;

	private GeneralStudy study; 
	
	
	GeneralSeries() {
		super(new BasicDicomObject());
	}

	public GeneralSeries(DicomObject dcmobj) {
		super(dcmobj);
	}
	

	public void addImage(GeneralImage image){
		image.setSeries(this);
		images.add(image);
	}
	
	public Set getImages() {
		return images;
	}
	
	public int getPK_ID() {
		return PK_ID;
	}

	public GeneralStudy getStudy() {
		return study;
	}

	public void setImages(Set images) {
		this.images = images;
	}
	
	public void setStudy(GeneralStudy study) {
		this.study = study;
	}

	
}
