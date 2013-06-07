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
package com.siemens.scr.avt.ad.dicom;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.TransformerConfigurationException;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.iod.module.composite.GeneralImageModule;
import org.dcm4che2.iod.module.general.SOPCommonModule;
import org.dcm4che2.media.FileMetaInformation;

import com.siemens.scr.avt.ad.annotation.ImageAnnotation;

/**
 * Delegate to circumvent the problem of missing no-arg constructor
 * in the <code>org.dcm4che2.iod</code> package of dcm4che2. Missing 
 * associations are also modeled explicitly to ease mapping.
 * 
 * @author Xiang Li
 *
 */
public class GeneralImage extends GeneralImageModule{
	private Set<ImageAnnotation> annotations = new HashSet<ImageAnnotation>();
	
	private String cachedHeader = null;// created on demand
	
	private String uri;
	
	private java.sql.Blob pixels;
	
	private int PK_ID;

	private GeneralSeries series;
	
	private String sliceThickness;	

	GeneralImage(){
		super(new BasicDicomObject());
	}
	
	public GeneralImage(DicomObject dcmobj) {
		super(dcmobj);
		String sliceThickness = dcmobj.getString(Tag.SliceThickness);
		setSliceThickness(sliceThickness);		
	}

	public Set<ImageAnnotation> getAnnotations() {
		return annotations;
	}
	
	
	FileMetaInformation getFileMetaInformation(){
		return new FileMetaInformation(this.getDicomObject());
	}
	
	//TODO: store full dicom header in xml format
	public String getHeader() throws TransformerConfigurationException, IOException{
		if(cachedHeader == null){
			//cachedHeader = new DicomHeader2XML_WU().convertToXML(this.getDicomObject());
		}
		
		return cachedHeader;
	}
	 	
	public byte[] getPixelAsBytes() throws SQLException{
		return pixels.getBytes(1, (int) pixels.length());
	}
	
	//TODO: store pixel data (full dicom object) in ad
	public java.sql.Blob getPixels() {
		if(pixels == null){
			//pixels = Hibernate.createBlob(this.getPixelData());	
		}
		 
		return pixels;
	}

	public int getPK_ID() {
		return PK_ID;
	}
	
	public GeneralSeries getSeries(){
		return series;
	}

	private SOPCommonModule getSOPCommand(){
			return new SOPCommonModule(this.getDicomObject());
	}
	
	public String getSOPInstanceUID(){
		return getSOPCommand().getSOPInstanceUID();
	}
	
	public void setAnnotations(Set<ImageAnnotation> annotations) {
		this.annotations = annotations;
	}
	
	void setFileMetaInformation(FileMetaInformation fileMetaInformation){
		fileMetaInformation.getDicomObject().copyTo(this.getDicomObject());
	}
	
	
	public void setHeader(String header){
		cachedHeader = header;
	}

	public void setPixels(java.sql.Blob pixels) {
		this.pixels = pixels;
	}

	public void setPixelToDicomObject() throws SQLException{
		this.setPixelData(this.getPixelAsBytes());
	}

	public void setSeries(GeneralSeries series){
		this.series = series;
	}
	
	private void setSOPCommand(SOPCommonModule SOPCommon){
		SOPCommon.getDicomObject().copyTo(this.getDicomObject());
	}
	
	public String getSliceThickness() {
		return sliceThickness;
	}

	public void setSliceThickness(String sliceThickness) {
		this.sliceThickness = sliceThickness;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}
}
