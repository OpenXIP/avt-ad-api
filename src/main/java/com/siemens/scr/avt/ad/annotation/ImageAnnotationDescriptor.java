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


import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ImageAnnotationDescriptor{
	private String AIMVersion;
	
	private String authorName;
	
	private String comment;
	
	private Date dateTime;
	
	private int ID;
	
	private String imageAnnotationType;
	
	private String name;
	
	private String seriesInstanceUID;
	
	private String UID;
	
	private boolean groundTruth;

	private String studyInstanceUID;
	
	private String roleInTrial;
	
	public String getAIMVersion() {
		return AIMVersion;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getComment() {
		return comment;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public int getID() {
		return ID;
	}

	public String getImageAnnotationType() {
		return imageAnnotationType;
	}

	public String getName() {
		return name;
	}

	public String getSeriesInstanceUID() {
		return seriesInstanceUID;
	}

	public String getStudyInstanceUID() {
		return studyInstanceUID;
	}

	public String getUID() {
		return UID;
	}

	public boolean isGroundTruth() {
		return groundTruth;
	}

	public void setAIMVersion(String aimVersion) {
		this.AIMVersion = aimVersion;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setGroundTruth(boolean groundTruth) {
		this.groundTruth = groundTruth;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setImageAnnotationType(String imageAnnotationType) {
		this.imageAnnotationType = imageAnnotationType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSeriesInstanceUID(String seriesInstanceUID) {
		this.seriesInstanceUID = seriesInstanceUID;
	}

	public void setStudyInstanceUID(String studyInstanceUID) {
		this.studyInstanceUID = studyInstanceUID;
	}

	public void setUID(String UID) {
		this.UID = UID;
	}

	@Override
	public boolean equals(Object object){
		return EqualsBuilder.reflectionEquals(this, object);
	}
	
	@Override
	public int hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString(){
		  return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	public String getRoleInTrial(){
		return roleInTrial;
	}
	
	public void setRoleInTrial(String roleInTrial){
		this.roleInTrial = roleInTrial;
	}
}
