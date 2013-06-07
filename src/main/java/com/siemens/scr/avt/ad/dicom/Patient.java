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


import java.util.HashSet;
import java.util.Set;

import org.dcm4che2.data.BasicDicomObject;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.iod.module.composite.PatientModule;

public class Patient extends PatientModule{
	private int PK_ID;
	
	private Set studies = new HashSet();


	Patient(){
		super(new BasicDicomObject());
	}


	public Patient(DicomObject dob) {
		super(dob);
	}

	public void addStudy(GeneralStudy study){
		study.setPatient(this);
		studies.add(study);
	}
	
	
	public int getPK_ID() {
		return PK_ID;
	}

	public Set getStudies() {
		return studies;
	}

	
	public void setStudies(Set studies) {
		this.studies = studies;
	}
	
	
}
